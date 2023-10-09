package com.gireesh.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "")
@Getter
@Setter
public class ShoppingCartProperties {
    String failureCode;
    String failureMessage;
    String successCode;
    String successMessage;
    @Value("${success.code}")
    String success1;

    public String getMessage1() {
        return  getFailureMessage()+failureMessage+successCode+successMessage+success1;
    }
}
