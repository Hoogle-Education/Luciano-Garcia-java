package com.crud.taskschedule.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.taskschedule.domain.dto.AgendamentoDto;
import com.crud.taskschedule.domain.model.Agendamento;
import com.crud.taskschedule.repository.AgendamentoRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

  @NonNull
  private AgendamentoRepository agendamentoRepository;

  public List<AgendamentoDto> pegarTodos() {
    return agendamentoRepository.findAll()
      .stream()
      .map(AgendamentoDto::new)
      .collect(Collectors.toList());
  }
  
}
