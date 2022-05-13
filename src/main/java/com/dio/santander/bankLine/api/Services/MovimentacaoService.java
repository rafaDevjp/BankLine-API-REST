package com.dio.santander.bankLine.api.Services;

import com.dio.santander.bankLine.api.DTO.NovaMovimentacao;
import com.dio.santander.bankLine.api.Model.Correntista;
import com.dio.santander.bankLine.api.Model.Movimentacao;
import com.dio.santander.bankLine.api.Model.MovimentacaoTipo;
import com.dio.santander.bankLine.api.Repository.CorrentistaRepository;
import com.dio.santander.bankLine.api.Repository.MovimentacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovaMovimentacao novaMovimentacao){
        Movimentacao movimentacao = new Movimentacao();

        Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if (correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }
        repository.save(movimentacao);

    }

    public Movimentacao findById(Long id){
        Optional<Movimentacao> obj = repository.findById(id);
        return obj.orElseThrow();
    }


}//END_CLASS
