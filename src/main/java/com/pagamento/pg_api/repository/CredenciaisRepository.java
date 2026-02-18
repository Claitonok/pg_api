package com.pagamento.pg_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagamento.pg_api.model.Credenciais;


public interface CredenciaisRepository extends JpaRepository<Credenciais, Integer> {

    
}
 