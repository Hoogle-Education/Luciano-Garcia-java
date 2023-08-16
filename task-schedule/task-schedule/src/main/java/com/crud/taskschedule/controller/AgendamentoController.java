package com.crud.taskschedule.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.taskschedule.domain.dto.AgendamentoDto;
import com.crud.taskschedule.service.AgendamentoService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamentos")
public class AgendamentoController {
  
  @NonNull
  private AgendamentoService agendamentoService;

  @GetMapping
  public ResponseEntity<List<AgendamentoDto>> pegarTodosOsAgendamentos() {
    
    var agendamentos = agendamentoService.pegarTodos();

    if(agendamentos.isEmpty()) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(agendamentos);
  }

}
