package com.dio.santander.bankLine.api.Controller;


import com.dio.santander.bankLine.api.DTO.NovaMovimentacao;
import com.dio.santander.bankLine.api.Model.Movimentacao;
import com.dio.santander.bankLine.api.Repository.MovimentacaoRepository;
import com.dio.santander.bankLine.api.Services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    //
    @Autowired
    private MovimentacaoRepository repository;

    //
    @Autowired
    private MovimentacaoService service;

    //
    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    //
    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao){
            service.save(movimentacao);
    }

    //
    @GetMapping(value="/{id}")
    public ResponseEntity<Movimentacao>findById(@PathVariable Long id ){
        Movimentacao obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
