package com.younggam.morethanchat.config;

import com.younggam.morethanchat.dto.paymentService.ImPortInfoDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
    @Bean
    @ConfigurationProperties(prefix = "import")
    public ImPortInfoDto imPortInfoDto() {
        return new ImPortInfoDto();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setReadTimeout(2000)
                .setConnectTimeout(2000)
                .build();
    }
}
