package com.crud.taskschedule.domain.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.crud.taskschedule.domain.enums.RespostaConvite;
import com.crud.taskschedule.domain.model.pk.ConvitePk;

@Entity
@Table(name = "convites") 
public class Convite {

  @EmbeddedId
  private ConvitePk id = new ConvitePk();

  private RespostaConvite resposta;  
}
