package com.cloud.drore.eboss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: wcy
 * @Description:
 * @Date: Created in 2017/12/27 13:40
 * @Modified By:
 */
@MapperScan(basePackages = {"com.cloud.drore.eboss.operation.mapper"})
@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
public class EbossOperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbossOperationApplication.class, args);
    }
}