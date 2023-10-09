package com.gireesh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;


//@Configuration

public class ShoppingCartProperties {
    String failureCode;
    String failureMessage;
    String successCode;
    String successMessage;

    public String getMessage() {
        return  failureCode+failureMessage+successCode+successMessage;
    }
}
