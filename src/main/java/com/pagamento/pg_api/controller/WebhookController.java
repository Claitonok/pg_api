package com.pagamento.pg_api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagamento.pg_api.service.PagamentoService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor
public class WebhookController {

    private final PagamentoService service;

    @Value("${mercadopago.webhook.secret}")
    private String secret;

    @PostMapping
    public ResponseEntity<Void> receber(
            @RequestHeader("x-signature") String signature,
            @RequestBody Map<String, Object> body) {

        // Aqui você valida HMAC SHA256 usando seu secret
        // (Em produção usar classe util para validar corretamente)

        if (signature == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String paymentId = body.get("data").toString();

        // Depois consultar API para pegar status real
        service.atualizarStatus(paymentId, "approved");

        return ResponseEntity.ok().build();
    }

    @PostConstruct
    public void test() {
        System.out.println("Webhook Secret: " + secret);
    }
}