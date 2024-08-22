package com.example.whatsapp.controller;

import com.example.whatsapp.service.SendWhatsappMessageNotification;
import com.twilio.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhatsappController {

    @Autowired
    private SendWhatsappMessageNotification sendWhatsappMessageNotification;

    @PostMapping("/whatsapp")
    public ResponseEntity sendWhatsappMessage() {

        try {
            this.sendWhatsappMessageNotification.dispatchNewArticleNotification();
            return ResponseEntity.ok().body("Mensagem de whatsapp enviada com sucesso!");
        } catch (ApiException e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
