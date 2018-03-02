package com.cloud.drore.eboss.operation.service.impl;

import com.cloud.drore.eboos.common.base.BaseServiceImpl;
import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboos.common.entity.operation.po.FinaceSourseDataCommonPo;
import com.cloud.drore.eboos.common.util.DateToStringUtil;
import com.cloud.drore.eboos.common.util.LocalDateAndDateTransformUtil;
import com.cloud.drore.eboos.exception.BusinessException;
import com.cloud.drore.eboss.operation.entity.FinaceSettlementFlagOperation;
import com.cloud.drore.eboss.operation.entity.FinaceSettlementHistoryOperation;
import com.cloud.drore.eboss.operation.entity.FinaceSourseDataOperation;
import com.cloud.drore.eboss.operation.entity.po.*;
import com.cloud.drore.eboss.operation.entity.vo.FinaceSourseDataOperationAndSupplierVo;
import com.cloud.drore.eboss.operation.entity.vo.FundSettlementTotalVo;
import com.cloud.drore.eboss.operation.entity.vo.FundSettlementVo;
import com.cloud.drore.eboss.operation.entity.vo.SupplierSelectHistoryRecenetTimeVo;
import com.cloud.drore.eboss.operation.mapper.DistributorMapper;
import com.cloud.drore.eboss.operation.mapper.FinaceSettlementHistoryMapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/31 12:45 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Service
public class FinaceSettlementHistoryServiceImpl extends BaseServiceImpl {


    @Resource
    FinaceSettlementHistoryMapper finaceSettlementHistoryMapper;
    @Resource
    DistributorMapper distributorMapper;


    @Override
    public MyMapper getMapper() {
        return finaceSettlementHistoryMapper;
    }


    /**
     * @param finaceSourseDataOperationList
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Return: void
     * @Decription: 自动结算的时候和分销商的账户进行结算
     * @CreateDate: Created in 2018/2/25 0025 下午 7:11
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public void settlementFundDealer(List<FinaceSourseDataOperation> finaceSourseDataOperationList) {
        Map flagMap = new HashMap();
        //初始值设定
        flagMap.put(1, 0);
        flagMap.put(2, 0);
        List<FinaceSourseDataOperation> collect = finaceSourseDataOperationList.stream().sorted((u1, u2) -> u2.getId().compareTo(u1.getId())).collect(Collectors.toList());
        for (FinaceSourseDataOperation finaceSourseDataOperation : collect) {
            System.out.println(flagMap.get(1).toString());
            if (flagMap.get(1).toString().equals(finaceSourseDataOperation.getDistributorId().toString())) {
                //相等则将该分销商的总额和之前相加存入到2里面
                flagMap.put(2, finaceSourseDataOperation.getTotalAmountSettlementOta().add(new BigDecimal(flagMap.get(2).toString())));
            } else {
                //不相等则对分销商账户进行结算操作，同时清空map重新放入数据
                //查询得到当前分销商账户的余额并进行相减
                BigDecimal bigDecimal = distributorMapper.selectDistributorAccountAmount(finaceSourseDataOperation.getDistributorId());
                distributorMapper.updateDistributorAccountAmount(bigDecimal.subtract(new BigDecimal(flagMap.get(2).toString())), finaceSourseDataOperation.getDistributorId());
                flagMap.clear();
                flagMap.put(1, finaceSourseDataOperation.getDistributorId());
                flagMap.put(2, finaceSourseDataOperation.getTotalAmountSettlementOta());
            }
        }
    }

    /**
     * @param finaceSourseDataOperationList
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Return: com.cloud.drore.eboss.operation.entity.FinaceSettlementHistoryOperation
     * @Decription: 查询订单产品表结束之后得到List<FinaceSourseDataOperation>，需要对所有结算单价进行累加
     * @CreateDate: Created in 2018/2/2 0002 下午 3:55
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public FinaceSettlementHistoryOperation rebuildFinaceSettlementHistoryOperation(List<FinaceSourseDataOperation> finaceSourseDataOperationList) {

        BigDecimal totalAmountShould = new BigDecimal("0");
        BigDecimal totalAmountIncome = new BigDecimal("0");
        //对财务订单报表返回的list的数据里面的应结算字段进行累加
        for (FinaceSourseDataOperation r : finaceSourseDataOperationList) {
            totalAmountShould = totalAmountShould.add(r.getTotalAmountSettlementSupplier());
        }

        //对财务订单报表返回的list的数据里面的收入总额字段进行累加
        for (FinaceSourseDataOperation r : finaceSourseDataOperationList) {
            totalAmountIncome = totalAmountIncome.add(r.getTotalAmountSettlementOta());
        }
        FinaceSettlementHistoryOperation finaceSettlementHistoryOperation = new FinaceSettlementHistoryOperation();
        finaceSettlementHistoryOperation.setTotalAmountShould(totalAmountShould);
        finaceSettlementHistoryOperation.setTotalAmountIncome(totalAmountIncome);
        return finaceSettlementHistoryOperation;
    }


    /**
     * @param supperId
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Return: autoSettlementTime
     * @Decription: 根据供应商的id得到当前结算期数的拼装, 更新供应商结算表的订单历史记录eboss_finace_settlement_flag_time
     * @CreateDate: Created in 2018/1/31 0031 下午 1:44
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public FinaceSettlementHistoryOperation buildStage(Long supperId, Date autoSettlementTime) {
        //通过供应商的id查询自动结算判断是否是首次结算的标识表
        FinaceSettlementFlagOperation finaceSettlementFlagOperation = finaceSettlementHistoryMapper.getCurrentSettlmentYear(supperId);
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter sdfSql = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneId zoneId = ZoneId.systemDefault();
        //返回的对象
        FinaceSettlementHistoryOperation finaceSettlementHistoryOperation = new FinaceSettlementHistoryOperation();
        //如果为空这表示首次进行结算，添加当前年的第一期
        if (null == finaceSettlementFlagOperation || "".equals(finaceSettlementFlagOperation)) {
            String currentYearSettlementStage = sdf.format(LocalDateTime.now()) + "年" + 1 + "期";
            //变更(插入)表结构数据
            finaceSettlementHistoryMapper.insertFinaceSettlementFlagOperation(DateToStringUtil.getStringDate(autoSettlementTime), 1, supperId);
            finaceSettlementHistoryOperation.setSettlementStage(currentYearSettlementStage);
            //第一次结算订单设置的初始值
            LocalDateTime mldt = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
            finaceSettlementHistoryOperation.setSettlementStartTime(Date.from(mldt.atZone(zoneId).toInstant()));
            return finaceSettlementHistoryOperation;
        } else {
            //如果年份一样则期数加一
            // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
            if (sdf.format(finaceSettlementFlagOperation.getAutoSettlementTime().toInstant().atZone(zoneId).toLocalDate()).equals(sdf.format(LocalDateTime.now()))) {
                int currentStage = finaceSettlementFlagOperation.getCurrentYearSettlementStage() + 1;
                //变更(修改)表结构数据
                LocalDateTime format = autoSettlementTime.toInstant().atZone(zoneId).toLocalDateTime();
                //sdfSql.format(format);
                finaceSettlementHistoryMapper.updateFinaceSettlementFlagOperation(sdfSql.format(format), currentStage, supperId);
                finaceSettlementHistoryOperation.setSettlementStage(sdf.format(LocalDateTime.now()) + "年" + currentStage + "期");
                finaceSettlementHistoryOperation.setSettlementStartTime(finaceSettlementFlagOperation.getAutoSettlementTime());
                return finaceSettlementHistoryOperation;
            } else {

                //变更(修改)表结构数据
                finaceSettlementHistoryMapper.updateFinaceSettlementFlagOperation(sdfSql.format(autoSettlementTime.toInstant().atZone(zoneId).toLocalDate()), 1, supperId);
                finaceSettlementHistoryOperation.setSettlementStage(LocalDate.now().plusYears(1).getYear() + "年" + 1 + "期");
                finaceSettlementHistoryOperation.setSettlementStartTime(finaceSettlementFlagOperation.getAutoSettlementTime());
                return finaceSettlementHistoryOperation;
            }
        }

    }


    /**
     * @param page
     * @ClassName: FinaceOperationServiceImpl
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage<com.cloud.drore.eboss.operation.entity.FinaceSettlementHistoryOperation>
     * @Decription: 通过时间来查询结算记录列表信息
     * @CreateDate: Created in 2018/1/31 0031 下午 5:14
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage<FinaceSettlementHistoryOperation> queryFinaceSettlementHistoryByChoice(PagePo<FinaceSettlementHistoryPo> page) {
        FinaceSettlementHistoryPo finaceSettlementHistoryPo = page.getFields();
        //加入当前供应商的id，目前暂时空缺蒙哥凯特
        PageHelper.startPage(page);
        List<FinaceSettlementHistoryOperation> finaceSettlementHistoryOperations = finaceSettlementHistoryMapper.findFinaceSettlementHistoryList(finaceSettlementHistoryPo);
        PageInfo pageinfo = new PageInfo<>(finaceSettlementHistoryOperations);
        return ResultMessage.success(pageinfo);
    }


    /**
     * @param page
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage<com.cloud.drore.eboss.operation.entity.FinaceSettlementHistoryOperation>
     * @Decription: 运营商版本通过供应商id和结算期查询结算记录
     * @CreateDate: Created in 2018/2/7 0007 上午 10:15
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage<FinaceSettlementHistoryOperation> queryFinaceSettlementHistoryOperation(PagePo<FinaceSettlementHistoryOperation> page) {

        FinaceSettlementHistoryOperation finaceSettlementHistoryPo = page.getFields();
        PageHelper.startPage(page);

        Example finaceSourseDataOperationExample = new Example(FinaceSettlementHistoryOperation.class);
        Example.Criteria criteria = finaceSourseDataOperationExample.createCriteria();
        //商id
        criteria.andEqualTo("merchantId", finaceSettlementHistoryPo.getMerchantId());
        //结算期数
        if (StringUtils.isNotEmpty(finaceSettlementHistoryPo.getSettlementStage())) {
            criteria.andEqualTo("settlementStage", finaceSettlementHistoryPo.getSettlementStage());
        }
        PageHelper.startPage(page);
        List<FinaceSettlementHistoryOperation> finaceSettlementHistoryOperations = finaceSettlementHistoryMapper.selectByExample(finaceSourseDataOperationExample);
        PageInfo pageinfo = new PageInfo<>(finaceSettlementHistoryOperations);
        return ResultMessage.success(pageinfo);
    }


    /**
     * @param page
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage<java.util.List                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               <                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               com.cloud.drore.eboss.operation.entity.FinaceSettlementHistoryOperation>>
     * @Decription: 通过供应商id和结算期查询运营商的结算记录
     * @CreateDate: Created in 2018/3/1 0001 下午 2:51
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage<List<FinaceSettlementHistoryOperation>> queryFinaceSettlementHistoryTotalList(PagePo<FinaceSourseOperationTotalPo> page) {
        FinaceSourseOperationTotalPo finaceSourseOperationTotalCommonPo = page.getFields();
        Example finaceSourseDataOperationExample = new Example(FinaceSettlementHistoryOperation.class);
        Example.Criteria criteria = finaceSourseDataOperationExample.createCriteria();
        //结算期
        if (StringUtils.isNotEmpty(finaceSourseOperationTotalCommonPo.getSettlementStage())) {
            criteria.andEqualTo("settlementStage", finaceSourseOperationTotalCommonPo.getSettlementStage());
        }

        criteria.andEqualTo("merchantId", finaceSourseOperationTotalCommonPo.getSupplierId());
        criteria.andEqualTo("isDeleted", 0);
        PageHelper.startPage(page);
        List<FinaceSettlementHistoryOperation> finaceSourseDataOperationsList = finaceSettlementHistoryMapper.selectByExample(finaceSourseDataOperationExample);
        PageInfo pageInfo = new PageInfo<>(finaceSourseDataOperationsList);
        return ResultMessage.success(pageInfo);
    }

    /**
     * @param id
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Return: java.util.List<com.cloud.drore.eboss.operation.entity.FinaceSettlementHistoryOperation>
     * @Decription:
     * @CreateDate: Created in 2018/2/8 0008 上午 10:13
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public List<FinaceSettlementHistoryOperation> queryStageOperationList(Long id) {

        return finaceSettlementHistoryMapper.queryStageOperationList(id);
    }

    /**
     * @param page
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Author: mone xia
     * @Return: java.util.List<com.cloud.drore.eboss.operation.entity.vo.FundSettlementVo>
     * @Decription: 通过供应商的id查询得到运营商版本资金结算数据
     * @CreateDate: Created in 2018/2/15 17:41
     * @Author: <a href="410508961@qq.com">夏凯</a>
     */
    public ResultMessage<List<FundSettlementVo>> queryFundSettlementList(PagePo<FundSettlementPo> page) {
        PageHelper.startPage(page);
        List<FundSettlementVo> fundSettlementVos = finaceSettlementHistoryMapper.queryFundSettlement(page.getFields());
        PageInfo pageInfo = new PageInfo<>(fundSettlementVos);
        return ResultMessage.success(pageInfo);
    }

    /**
     * @param
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Author: mone xia
     * @Return: com.cloud.drore.eboss.operation.entity.vo.FundSettlementTotalVo
     * @Decription: 资金结算三个平台收入
     * @CreateDate: Created in 2018/2/15 19:05
     * @Author: <a href="410508961@qq.com">夏凯</a>
     */
    public FundSettlementTotalVo queryFundSettlementFundSettlementTotalVo() {
        return finaceSettlementHistoryMapper.queryFundSettlementTotalData();
    }

    /**
     * @param page
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage<java.util.List                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               <                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               com.cloud.drore.eboss.operation.entity.vo.FinaceSourseDataOperationAndSupplierVo>>
     * @Decription:
     * @CreateDate: Created in 2018/3/1 0001 下午 2:51
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage<List<FinaceSourseDataOperationAndSupplierVo>> queryFinaceSettlementOperationTotalList(PagePo<FinaceSourseDataOperationPo> page) throws BusinessException {

        judgeParametersIsNull(page.getFields().getSupplierId());
        judgeParametersIsNull(page.getFields().getSettlementEndTime());
        judgeParametersIsNull(page.getFields().getSettlementStartTime());
        PageHelper.startPage(page);
        List<FinaceSourseDataOperationAndSupplierVo> finaceSourseDataDealerVos = finaceSettlementHistoryMapper.queryFundSettlementFormOperation(page);
        PageInfo pageInfo = new PageInfo<>(finaceSourseDataDealerVos);
        return ResultMessage.success(pageInfo);
    }

    /**
     * @param param
     * @ClassName: FinaceFormOperationServiceImpl
     * @Return: void
     * @Decription: 校验参数是否为空
     * @CreateDate: Created in 2018/2/10 0010 下午 5:25
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public void judgeParametersIsNull(Object param) throws BusinessException {

        if (null == param || "".equals(param)) {
            throw new BusinessException("缺少必须要上传的参数！");
        }
    }


    /**
     * @param id
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Return: com.cloud.drore.eboos.common.entity.dealer.EarliestOrderTimeVo
     * @Decription: 通过供应商id获取是否存在结算按钮
     * @CreateDate: Created in 2018/2/28 0028 下午 7:20
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public Boolean queryEarliestOrderFlag(Long id) {
        //通过供应商id判断是否有点击过自动结算
        SupplierSelectHistoryRecenetTimeVo supplierSettlementCount = finaceSettlementHistoryMapper.querySupplierSettlementCount(id);
        if (supplierSettlementCount.getSupplierSettlementFlag() > 0) {
            return false;
        }
        return true;
    }
  /*  @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;*/

    /**
     * @param str
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Return: void
     * @Decription: 添加定时任务, cron类型写法
     * @CreateDate: Created in 2018/3/2 0002 下午 1:43
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public void addJob(String str) {
        //定时任务可执行的
        ScheduleApplication dynamicScheduleTaskSecond = new ScheduleApplication();
        dynamicScheduleTaskSecond.startCron1(str);
    }

    /**
     * @param str
     * @ClassName: FinaceSettlementHistoryServiceImpl
     * @Return: void
     * @Decription: 添加定时任务, 精确到毫秒的写法 Timer
     * @CreateDate: Created in 2018/3/2 0002 下午 1:48
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public void addTimeTaskNoneCron(String str) {
        // 一天的毫秒数
        long daySpan =  24 * 60 * 60 * 1000;
        // 首次运行时间，可以设定为准点的15:33:30运行
        Date startTime = new Date();
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                // 要执行的代码
                System.err.println("xxxxxxxxxs ");
                System.out.println("我在测试");
            }
        };
        // 以每24小时执行一次
        t.scheduleAtFixedRate(task, startTime, daySpan);
    }
}
