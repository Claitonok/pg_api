package com.pagamento.pg_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagamento.pg_api.model.Credenciais;
import com.pagamento.pg_api.repository.CredenciaisRepository;

@Service
public class CredencialService {

    @Autowired
    private CredenciaisRepository cRepository;

    /**
     *  
     * @return
     */
    public List<Credenciais> obterTodos(){

        List<Credenciais> list = cRepository.findAll();

        if (list.isEmpty()) {
            System.err.println("Nem um dado no banco de dados");
        }
        return list;
    }
}
