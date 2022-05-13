package com.dio.santander.bankLine.api.Repository;

import com.dio.santander.bankLine.api.Model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
