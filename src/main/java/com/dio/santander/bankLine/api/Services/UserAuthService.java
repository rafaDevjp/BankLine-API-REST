package com.dio.santander.bankLine.api.Services;


import com.dio.santander.bankLine.api.DTO.NovoUserAuth;

import com.dio.santander.bankLine.api.Model.UserAuthentication;
import com.dio.santander.bankLine.api.Repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAuthService {

    @Autowired
    private UserAuthRepository repository;
    @Autowired
    private PasswordEncoder encoder;



    public void save(NovoUserAuth novoUserAuth) {

        UserAuthentication userAuthentication = new UserAuthentication();
        //
        userAuthentication.setUserName(novoUserAuth.getUserName());
        userAuthentication.setUserEmail(novoUserAuth.getUserEmail());
        userAuthentication.setUserPassword(encoder.encode(novoUserAuth.getUserPassword()));

        //Salvando os dados
        repository.save(userAuthentication);
    }


}
