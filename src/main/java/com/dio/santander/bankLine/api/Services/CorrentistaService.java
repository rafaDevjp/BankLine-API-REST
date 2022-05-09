package com.dio.santander.bankLine.api.Services;

import com.dio.santander.bankLine.api.DTO.NovoCorrentista;
import com.dio.santander.bankLine.api.Model.Conta;
import com.dio.santander.bankLine.api.Model.Correntista;
import com.dio.santander.bankLine.api.Repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {
    @Autowired
    private CorrentistaRepository repository;

    public void save(NovoCorrentista novoCorrentista){
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setName(novoCorrentista.getName());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);
        repository.save(correntista);
    }
}
