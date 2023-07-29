package com.crud.taskschedule.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.crud.taskschedule.domain.dto.PerfilUsuarioDto;
import com.crud.taskschedule.domain.model.Usuario;
import com.crud.taskschedule.repository.UsuarioRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

  @NonNull
  private UsuarioRepository usuarioRepository;

  public List<PerfilUsuarioDto> pegarTodosUsuarios() {
    return usuarioRepository
            .findAll()
            .stream()
            .map(PerfilUsuarioDto::new)
            .toList();
  }
  
  public Usuario pegarUsuarioPorId(Long id) {
    var buscaUsuario = usuarioRepository.findById(id);

    if(buscaUsuario.isEmpty()) {
      return null;
    }

    var usuario = buscaUsuario.get();
    return usuario;
  }

  public Usuario registrarUsuario(Usuario paraRegistrar) {

    var isEmailAlreadyRegistered = usuarioRepository
      .findAll()
      .stream()
      .anyMatch((usuario) -> usuario
        .getEmail()
        .equalsIgnoreCase(paraRegistrar.getEmail())
      );

    if(isEmailAlreadyRegistered) {
      return null;
    }

    var usuarioSalvo = usuarioRepository.save(paraRegistrar);
    return usuarioSalvo;
  }
}