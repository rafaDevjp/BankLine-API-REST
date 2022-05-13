package com.dio.santander.bankLine.api.Controller;


import com.dio.santander.bankLine.api.DTO.NovoUserAuth;
import com.dio.santander.bankLine.api.Model.UserAuthentication;
import com.dio.santander.bankLine.api.Repository.UserAuthRepository;
import com.dio.santander.bankLine.api.Services.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userAuth")
public class UserAuthController {



    @Autowired
    private  UserAuthRepository repository;
    @Autowired
    private UserAuthService service;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping
    public ResponseEntity<List<UserAuthentication>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public void save(@RequestBody NovoUserAuth novoUserAuth){
        service.save(novoUserAuth);

    }

    @GetMapping("/validasenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String userName, @RequestParam String senha){

        Optional<UserAuthentication> optional = repository.findByUserName(userName);
        if (optional.isEmpty()){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        UserAuthentication usuario = optional.get();
        boolean valid = encoder.matches(senha, usuario.getUserPassword());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);


    }

}//CLASS_END
