package com.example.whatsapp.configuration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
@Data
@Validated
@ConfigurationProperties(prefix = "com.whatsapp.twilio")
public class TwilioConfigurationProperties {

    @NotBlank
    @Pattern(regexp = "^AC[0-9a-fA-F]{32}$")
    private String accountSid;

    @NotBlank
    private String authToken;

    @NotBlank
    private String phoneNumber;

    // standard setters and getters
}
