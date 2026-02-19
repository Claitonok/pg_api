package com.pagamento.pg_api.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.resources.payment.Payment;
import com.pagamento.pg_api.model.Pagamento;
import com.pagamento.pg_api.repository.PagamentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagamentoService {
    
     private final PagamentoRepository repository;

    public Map<String, Object> criarPix(BigDecimal valor, String email) throws Exception {

        PaymentClient client = new PaymentClient();

        PaymentCreateRequest request =
                PaymentCreateRequest.builder()
                        .transactionAmount(valor)
                        .description("Pagamento via PIX")
                        .paymentMethodId("pix")
                        .payer(
                                PaymentPayerRequest.builder()
                                        .email(email)
                                        .build()
                        )
                        .build();

        Payment payment = client.create(request);

        Pagamento entidade = new Pagamento();
        entidade.setPaymentId(payment.getId().toString());
        entidade.setEmail(email);
        entidade.setValor(valor);
        entidade.setStatus(payment.getStatus());
        entidade.setTipo("PIX");

        repository.save(entidade);

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("qr_code", payment.getPointOfInteraction().getTransactionData().getQrCode());
        resposta.put("qr_code_base64", payment.getPointOfInteraction().getTransactionData().getQrCodeBase64());

        return resposta;
    }

    public void atualizarStatus(String paymentId, String status) {
        Pagamento pagamento = repository.findByPaymentId(paymentId).orElseThrow();
        pagamento.setStatus(status);
        repository.save(pagamento);
    }
}

