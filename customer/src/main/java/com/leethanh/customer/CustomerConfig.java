package com.leethanh.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    @Bean
    @LoadBalanced // use the load balancer to distribute the traffics to other clients
    public RestTemplate restTemplate() // restTemplate is like feign client but in the older version : to conduct the api of
                                        //other services
    {
        return new RestTemplate();
    }
}
