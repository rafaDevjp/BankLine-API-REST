package com.dio.santander.bankLine.api.Model;

import lombok.Data;


@Data
public class Correntista {

    private Integer id;
    private String cpf;
    private String  name;
    private Conta conta;

}
