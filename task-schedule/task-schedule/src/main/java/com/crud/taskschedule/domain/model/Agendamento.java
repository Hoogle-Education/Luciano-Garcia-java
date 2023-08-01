package com.crud.taskschedule.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crud.taskschedule.domain.enums.ModeloEncontro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "agendamentos") // opcional
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    private String titulo; 
    private String link;
    @Enumerated(EnumType.STRING)
    private ModeloEncontro modeloEncontro;
    private String descricao;
    @Column(columnDefinition = "TIMESTAMP")  
    private LocalDateTime inicio;
    @Column(columnDefinition = "TIMESTAMP") 
    private LocalDateTime fim;
    
}