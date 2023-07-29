package com.crud.taskschedule.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.crud.taskschedule.domain.dto.PerfilUsuarioDto;
import com.crud.taskschedule.domain.model.Usuario;
import com.crud.taskschedule.repository.UsuarioRepository;
import com.crud.taskschedule.service.UsuarioService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {
 
  @NonNull
  private UsuarioService usuarioService;
  
  @GetMapping
  public ResponseEntity<List<PerfilUsuarioDto>> pegarTodosUsuarios() {
    var usuarios = usuarioService.pegarTodosUsuarios();

    if(usuarios.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    return ResponseEntity.ok(usuarios);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> pegarUsuarioPorId(
    @PathVariable Long id
  ) {
    var usuario = usuarioService.pegarUsuarioPorId(id);

    if(usuario == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.ok(usuario);
  }


  // /usuarios?id=1 - 204 no content
  // /usuarios/1 - 404 not found

  @PostMapping
  @Transactional
  public ResponseEntity<?> cadastrarUsuario(
    @RequestBody Usuario usuario,
    UriComponentsBuilder uriBuilder
  ) {
    var usuarioSalvo =  usuarioService.registrarUsuario(usuario);
    
    var uri = uriBuilder
      .path("/usuarios/{id}")
      .buildAndExpand(usuarioSalvo.getId())
      .toUri();

    return ResponseEntity.created(uri).build();
  }

}