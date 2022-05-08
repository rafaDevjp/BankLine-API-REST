package com.dio.santander.bankLine.api.Controller;

import java.util.List;

import com.dio.santander.bankLine.api.Model.Correntista;
import com.dio.santander.bankLine.api.Repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }
    @PostMapping
    public void save(@RequestBody Correntista correntista){

    }


}//END_CLASS
