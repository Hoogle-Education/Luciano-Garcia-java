package com.crud.taskschedule.domain.dto;

import com.crud.taskschedule.domain.model.Usuario;
import com.crud.taskschedule.repository.AgendamentoRepository;
import com.crud.taskschedule.repository.UsuarioRepository;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NovoUsuarioDto {
  private String nome;
  private String email;
}