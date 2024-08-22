package com.example.sms;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SmsController {

    @Value("${Twilio.account_sid}")
    private String account_sid;

    @Value("${Twilio.auth_token}")
    private String auth;

    @Value("${Twilio.phone_number}")
    private String phoneNumber;

    @PostMapping("/sms/{number}")
    public ResponseEntity sendSms(@PathVariable(value = "number") String number) throws Exception {
        Twilio.init(account_sid, auth);

        try {
            Message message = Message.creator(
                            new PhoneNumber(number),
                            new PhoneNumber(phoneNumber),
                            "SMS para confirmação do agendamento, Realizado com sucesso!")
                    .create();
            return ResponseEntity.ok().body("SMS Enviado!");
        } catch (ApiException e) {
            return new ResponseEntity("Erro ao realizar integração com o Twillio",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
