package com.cloud.drore.eboos.common.util;


import org.springframework.boot.autoconfigure.klock.annotation.Klock;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import javax.annotation.Resource;
import java.math.BigDecimal;
import static org.springframework.boot.autoconfigure.klock.model.LockType.Fair;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/23 0023 上午 11:18 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Component
public class RedisKeysClockUtil {

    @Resource
    JedisPoll jedisPoll;

    /**
     * @param key
     * @param money
     * @param flag
     * @ClassName: RedisKeysClockUtil
     * @Return: java.math.BigDecimal
     * @Decription: 根据key值，金额变动值，变动类型得到变动之后的资金池金额
     * @CreateDate: Created in 2018/3/23 0023 下午 2:32
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    @Klock(keys = {"{#key}"}, lockType = Fair, waitTime = 10)
    //true 加  false 减
    public BigDecimal  cashPoolChange(String key, BigDecimal money, Boolean flag) {
        JedisPool jedisPool = jedisPoll.redisPoolFactory();
        Jedis orderJedis = jedisPool.getResource();
        String beginMoney = orderJedis.get(key).toString();
        if (flag) {
            //退款，充值
            BigDecimal endMoney = new BigDecimal(beginMoney).add(money);
            orderJedis.set(key, endMoney.toString());
            return endMoney;
        } else {
            //下单
            BigDecimal endMoney = new BigDecimal(beginMoney).subtract(money);
            orderJedis.set(key, endMoney.toString());
            return endMoney;
        }
    }

    /**
     * @param key
     * @param count
     * @param flag
     * @ClassName: RedisKeysClockUtil
     * @Return: java.lang.Integer
     * @Decription: 根据key值，库存变动值，变动类型得到变动之后的库存
     * @CreateDate: Created in 2018/3/23 0023 下午 2:35
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    @Klock(keys = {"{#key}"}, lockType = Fair, waitTime = 10)
    public Integer stockChange(String key, Integer count, Boolean flag) {
        //true 加  false 减
        JedisPool jedisPool = jedisPoll.redisPoolFactory();
        Jedis orderJedis = jedisPool.getResource();
        String beginCount = orderJedis.get(key).toString();
        if (flag) {
            // 退订
            Integer endCount = Integer.parseInt(beginCount) + count;
            orderJedis.set(key, endCount.toString());
            return Integer.parseInt(beginCount) + count;
        } else {
            //下单
            Integer endCount = Integer.parseInt(beginCount) - count;
            orderJedis.set(key, endCount.toString());
            return endCount;
        }
    }
}
