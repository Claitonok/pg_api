package com.pagamento.pg_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagamento.pg_api.model.Pagamento;


public interface PagamentoRepository  extends JpaRepository<Pagamento, Long> {

    // Optional<Pagamento> findByPaymentId(String paymentId);
    java.util.Optional<Pagamento> findByPaymentId(String paymentId);

    
}
