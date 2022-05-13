package com.dio.santander.bankLine.api.Controller;

import java.util.List;

import com.dio.santander.bankLine.api.DTO.NovoCorrentista;
import com.dio.santander.bankLine.api.Model.Correntista;
import com.dio.santander.bankLine.api.Repository.CorrentistaRepository;
import com.dio.santander.bankLine.api.Services.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista){
        service.save(correntista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Correntista> findByID(@PathVariable Long id ){
            Correntista obj = service.findById(id);
            return ResponseEntity.ok().body(obj);
    }


}//END_CLASS
