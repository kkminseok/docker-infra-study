package org.example.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class EurekaClientConfig {

    private final DiscoveryClient discoveryClient;

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    서비스 인스턴스를 직접 호출하는건 문제가 있음.
//    public String getServiceUrl(String serviceName) {
//        List<String> services = discoveryClient.getServices();
//        System.out.println("services");
//        services.stream().forEach(System.out::println);
//
//        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
//        if (instances != null && !instances.isEmpty()) {
//            return instances.get(0).getUri().toString();
//        }
//        return null;
//    }


}
