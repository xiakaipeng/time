package com.cloud.drore.eboos.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 得到redisPool<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/15 18:44 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Configuration
public class JedisPoll {

    @Autowired
    RedisProperties redisProperties;

    @Bean
    public JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisProperties.getPool().getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getPool().getMaxWait());


        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisProperties.getHost(), redisProperties.getPort(), redisProperties.getTimeout());

        return jedisPool;
    }
}
