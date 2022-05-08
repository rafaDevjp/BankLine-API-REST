package com.dio.santander.bankLine.api.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Conta {

    @Column(name="conta_numero")
    private Long numero;

    @Column(name = "conta_saldo")
    private Double saldo;
}
