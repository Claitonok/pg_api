package com.pagamento.pg_api.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagamento.pg_api.service.PagamentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private PagamentoService pagamentoService;

    @PostMapping("/pix")
    public ResponseEntity<?> criarPix(@RequestParam BigDecimal valor,
                                      @RequestParam String email) throws Exception {
            try {
                return ResponseEntity.ok(pagamentoService.criarPix(valor, email));
            } catch (Exception e) {
                return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
            }
    }
}