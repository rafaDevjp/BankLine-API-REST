package com.dio.santander.bankLine.api.DTO;

import com.dio.santander.bankLine.api.Model.MovimentacaoTipo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovaMovimentacao {

    private String descricao;

    private Double valor;

    private MovimentacaoTipo tipo;

    private Integer idConta;

}
