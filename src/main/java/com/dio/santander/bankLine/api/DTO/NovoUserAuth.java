package com.dio.santander.bankLine.api.DTO;

import lombok.Data;

import javax.persistence.Column;

@Data
public class NovoUserAuth {

    private String userName;

    private String userEmail;

    private String userPassword;
}
