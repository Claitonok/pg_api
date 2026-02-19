package com.pagamento.pg_api.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentId;
    private String email;
    private BigDecimal valor;
    private String status;
    private String tipo; // PIX, CARTAO
    private String metodoPagamento; // BOLETO, DEBITO, CREDITO
    private String linkPagamento;
}
