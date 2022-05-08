package com.dio.santander.bankLine.api.Model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "tab_correntista")
public class Correntista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(length = 60)
    private String  name;

    @Embedded
    private Conta conta;

}
