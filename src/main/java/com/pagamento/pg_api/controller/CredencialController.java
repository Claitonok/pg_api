package com.pagamento.pg_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagamento.pg_api.model.Credenciais;
import com.pagamento.pg_api.service.CredencialService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
@RequestMapping("/api/pagamento")
public class CredencialController {

    @Autowired
    private CredencialService credencialService;

    /**
     * 
     * @return Todos os dados
     */
    @GetMapping
    public ResponseEntity<List<Credenciais>> ObterTodos() {

        try {
            return new ResponseEntity<>(credencialService.obterTodos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
