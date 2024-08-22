package com.example.whatsapp.configuration;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(TwilioConfigurationProperties.class)
public class TwilioInitializer implements ApplicationRunner {

    @Autowired
    private final TwilioConfigurationProperties twilioConfigurationProperties;

    public TwilioInitializer(TwilioConfigurationProperties twilioConfigurationProperties) {
        this.twilioConfigurationProperties = twilioConfigurationProperties;
    }

    @Override
    public void run(ApplicationArguments args) {
        String accountSid = twilioConfigurationProperties.getAccountSid();
        String authToken = twilioConfigurationProperties.getAuthToken();
        Twilio.init(accountSid, authToken);
    }

}
