package com.example.whatsapp.service;

import com.example.whatsapp.configuration.TwilioConfigurationProperties;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendWhatsappMessageNotification {

    @Autowired
    TwilioConfigurationProperties twilioConfigurationProperties;

    public void dispatchNewArticleNotification() {

        Twilio.init(twilioConfigurationProperties.getAccountSid(), twilioConfigurationProperties.getAuthToken());
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+5511949663258"),
                        new com.twilio.type.PhoneNumber("whatsapp:+" + twilioConfigurationProperties.getPhoneNumber()),
                        "Olá, seu agendamento foi realizado com sucesso, Qualquer dúvida pode entrar em contato conosco através desse chat!")

                .create();

        System.out.println(message.getSid());
    }
}
