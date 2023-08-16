package com.crud.taskschedule.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.crud.taskschedule.domain.enums.ModeloEncontro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "agendamento") // opcional
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
    
    @OneToOne(mappedBy = "origem")
    private Usuario host; // 1

    @OneToMany(mappedBy = "id.agendamento")
    private Set<Convite> convites = new HashSet<>();
}