package com.crud.taskschedule.domain.dto;

import java.time.Duration;
import java.time.LocalDateTime;

import com.crud.taskschedule.domain.enums.ModeloEncontro;
import com.crud.taskschedule.domain.model.Agendamento;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AgendamentoDto {
    private Long id; 
    private String titulo; 
    private String link;
    private String modeloEncontro;
    private String descricao;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Duration duracao;

    private String parseTitutlo(String palavra) {
      return palavra.substring(0, 1).toUpperCase() + palavra.substring(1).toLowerCase();
    }

    public AgendamentoDto(Agendamento agendamento) {
      this.id = agendamento.getId();
      this.titulo = agendamento.getTitulo();
      this.link = agendamento.getLink();
      this.modeloEncontro = parseTitutlo(agendamento.getModeloEncontro().toString());
      this.descricao = agendamento.getDescricao();
      this.inicio = agendamento.getInicio();
      this.fim = agendamento.getFim();
      this.duracao = Duration.between(agendamento.getInicio(), agendamento.getFim());
    }
}
