package com.dio.santander.bankLine.api.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Movimentacao {

    private Integer id;
    private LocalDateTime dataHora;
    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;

}
