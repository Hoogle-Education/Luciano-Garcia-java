package com.crud.taskschedule.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.crud.taskschedule.domain.dto.NovoUsuarioDto;
import com.crud.taskschedule.domain.dto.PerfilUsuarioDto;
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
  public ResponseEntity<Page<PerfilUsuarioDto>> pegarTodosUsuarios(
    @PageableDefault(size = 5, sort = {"nome"}) Pageable pagination
  ) {
    var usuarios = usuarioService.pegarTodosUsuarios(pagination);

    if(usuarios.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    return ResponseEntity.ok(usuarios);
  }

  
  @GetMapping("/{id}")
  public ResponseEntity<PerfilUsuarioDto> pegarUsuarioPorId(
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
    @RequestBody NovoUsuarioDto novoUsuario,
    UriComponentsBuilder uriBuilder
  ) {
    var usuarioSalvo =  usuarioService.registrarUsuario(novoUsuario);
    
    var uri = uriBuilder
      .path("/usuarios/{id}")
      .buildAndExpand(usuarioSalvo.getId())
      .toUri();

    return ResponseEntity.created(uri).build();
  }

}