package com.cloud.drore.eboos.common.util;


import java.util.Random;

import static net.sourceforge.pinyin4j.format.HanyuPinyinCaseType.UPPERCASE;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 生成各种规则的编码号<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/12 0012 上午 10:23 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class CodingGeneration {
    private static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * @param productType
     * @ClassName: CodingGeneration
     * @Return: java.lang.String
     * @Decription: 获取订单号
     * @CreateDate: Created in 2018/3/13 0013 上午 11:02
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static String getOrderGenerationCodingNum(String productType) {
        StringBuffer generationCodingNum = new StringBuffer();
        //得到首字母
        String substring = productType.substring(0, 1);
        //生成13为时间戳
        long timeMillis = System.currentTimeMillis();
        //生成三位随机数
        String random = generateString(3);
        generationCodingNum.append(substring).append(timeMillis).append(random);
        return generationCodingNum.toString();

    }

    /**
     * @param OrderEventStatus
     * @ClassName: CodingGeneration
     * @Return: java.lang.String
     * @Decription: 获取流水号
     * @CreateDate: Created in 2018/3/13 0013 下午 2:06
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static String getFlowGenerationCodingNum(String OrderEventStatus) {
        StringBuffer generationCodingNum = new StringBuffer();
        //顶单事件生成前缀
        switch (OrderEventStatus) {
            case "ORDER_PAY":
                generationCodingNum.append("01");
                break;
            case "ORDER_REFUND":
                generationCodingNum.append("02");
                break;
            case "ORDER_REFUND_FEE":
                generationCodingNum.append("03");
                break;
            case "ACCOUNT_EVENT_RECHARGE":
                //分销商账户充值生成流水
                generationCodingNum.append("04");
                break;
            case "ACCOUNT_EVENT_SETTLEMENT":
                //分销商账户结算生成流水
                generationCodingNum.append("05");
                break;
            case "ACCOUNT_EVENT_DELETE":
                //分销商账户充值凭证被超级管理员删除生成流水
                generationCodingNum.append("06");
                break;
            default:
                return null;
        }
        //生成13为时间戳
        long timeMillis = System.currentTimeMillis();
        //生成三位随机数
        String random = generateString(3);
        generationCodingNum.append(timeMillis).append(random);
        return generationCodingNum.toString();
    }

    /**
     * @param merchantType
     * @param id           获取商户号
     * @ClassName: CodingGeneration
     * @Return: java.lang.String
     * @Decription:
     * @CreateDate: Created in 2018/3/13 0013 下午 1:17
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static String getMerchantGenerationCodingNum(String merchantType, Long id) {
        StringBuffer generationCodingNum = new StringBuffer();
        //得到首字母
        String[] split = merchantType.split("_");
        String substring = split[1].substring(0, 1);
        generationCodingNum.append(substring);
        //递增序列4位
        if (id > 9999) {
            return null;
        } else {
            for (int i = 0; i < 4 - (id.toString().length()); i++) {
                generationCodingNum.append("0");
            }
            generationCodingNum.append(id.toString());
        }
        return generationCodingNum.toString();

    }

    /**
     * @param PoiType
     * @param merchantName
     * @param id
     * @ClassName: CodingGeneration
     * @Return: java.lang.String
     * @Decription: 获取POI号
     * @CreateDate: Created in 2018/3/13 0013 下午 1:34
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static String getPoiGenerationCodingNum(String PoiType, String merchantName, Long id) {
        StringBuffer generationCodingNum = new StringBuffer();
        if (id > 99) {
            return null;
        }
        //得到首字母
        String substring = PoiType.substring(0, 1);
        //得到五位商户名称
        String fiveNume = getFiveNume(Pinyin4jUtil.getFirstLetters(merchantName, UPPERCASE));
        generationCodingNum.append(substring).append(fiveNume);
        //自增序列2位
        generateIncreasing(generationCodingNum, 2, id);
        return generationCodingNum.toString();

    }

    /**
     * @param poiName
     * @param id
     * @ClassName: CodingGeneration
     * @Return: java.lang.String
     * @Decription: 生成消费点号
     * @CreateDate: Created in 2018/3/13 0013 下午 1:45
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static String getConsumeGenerationCodingNum(String poiName, Long id) {
        StringBuffer generationCodingNum = new StringBuffer();
        if (id > 99) {
            return null;
        }
        //得到五位poi名称
        String fiveNume = getFiveNume(Pinyin4jUtil.getFirstLetters(poiName, UPPERCASE));
        generationCodingNum.append(fiveNume);
        //自增序列2位
        generateIncreasing(generationCodingNum, 2, id);
        return generationCodingNum.toString();
    }

    /**
     * @param productType
     * @param poiName
     * @param id
     * @ClassName: CodingGeneration
     * @Return: java.lang.String
     * @Decription: 获取产品编号
     * @CreateDate: Created in 2018/3/13 0013 下午 1:52
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static String getProductGenerationCodingNum(String productType, String poiName, Long id) {
        StringBuffer generationCodingNum = new StringBuffer();
        if (id > 99) {
            return null;
        }
        //得到首字母
        String substring = productType.substring(0, 1);
        //得到五位poi名称
        String fiveNume = getFiveNume(Pinyin4jUtil.getFirstLetters(poiName, UPPERCASE));
        generationCodingNum.append(substring).append(fiveNume);
        //自增序列2位
        generateIncreasing(generationCodingNum, 2, id);
        return generationCodingNum.toString();
    }


    /**
     * @param str
     * @param intId
     * @param id
     * @ClassName: CodingGeneration
     * @Return: java.lang.String
     * @Decription: 不足的用0补充
     * @CreateDate: Created in 2018/3/13 0013 下午 1:43
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    private static String generateIncreasing(StringBuffer str, int intId, Long id) {
        for (int i = 0; i < intId - (id.toString().length()); i++) {
            str.append("0");
        }
        str.append(id.toString());

        return str.toString();
    }

    /**
     * @param length
     * @ClassName: CodingGeneration
     * @Return: java.lang.String
     * @Decription: 返回一个定长的随机字符串(只包含大小写字母 、 数字)
     * @CreateDate: Created in 2018/3/12 0012 上午 11:31
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    private static String generateString(int length) {

        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }

    /**
     * @param num
     * @ClassName: CodingGeneration
     * @Return: java.lang.String
     * @Decription: 生成订单号里面的分销商名称
     * @CreateDate: Created in 2018/3/12 0012 上午 11:30
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    private static String getFiveNume(String num) {
        String substring;
        if (num.length() >= 5) {
            substring = num.substring(0, 5);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(num);
            for (int i = 0; i < 5 - num.length(); i++) {
                stringBuffer.append("x");
            }
            substring = stringBuffer.toString();
        }
        return substring;
    }

}
