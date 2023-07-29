package com.crud.taskschedule.domain.dto;

import com.crud.taskschedule.domain.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PerfilUsuarioDto {
    private Long id;
    private String nome;

    public PerfilUsuarioDto(Usuario usuario) {
      this.id = usuario.getId();
      this.nome = usuario.getNome();
    }
}
