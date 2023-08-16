package com.crud.taskschedule.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crud.taskschedule.domain.dto.NovoUsuarioDto;
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

  public Page<PerfilUsuarioDto> pegarTodosUsuarios(Pageable pagination) {    
    return usuarioRepository.findAll(pagination).map(PerfilUsuarioDto::new);
  }
  
  public PerfilUsuarioDto pegarUsuarioPorId(Long id) {
    var buscaUsuario = usuarioRepository.findById(id);

    if(buscaUsuario.isEmpty()) {
      return null;
    }

    var usuario = buscaUsuario.get();
    return new PerfilUsuarioDto(usuario);
  }

  public PerfilUsuarioDto registrarUsuario(NovoUsuarioDto novoUsuario) {

    var isEmailAlreadyRegistered = usuarioRepository
      .findAll()
      .stream()
      .anyMatch((usuario) -> usuario
        .getEmail()
        .equalsIgnoreCase(novoUsuario.getEmail())
      );

    if(isEmailAlreadyRegistered) {
      return null;
    }

    var usuario = toUsuario(novoUsuario);
    var usuarioSalvo = usuarioRepository.save(usuario);
    return new PerfilUsuarioDto(usuarioSalvo);
  }

  private Usuario toUsuario(NovoUsuarioDto novoUsuario) {
    var usuario = new Usuario();
    usuario.setNome(novoUsuario.getNome());
    usuario.setEmail(novoUsuario.getEmail());
    return usuario;
  }
}