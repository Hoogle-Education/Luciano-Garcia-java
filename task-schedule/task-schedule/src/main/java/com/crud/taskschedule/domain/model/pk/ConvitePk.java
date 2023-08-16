package com.crud.taskschedule.domain.model.pk;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.crud.taskschedule.domain.model.Agendamento;
import com.crud.taskschedule.domain.model.Usuario;

@Embeddable
public class ConvitePk {

  @ManyToOne
  @JoinColumn(name = "host_id")
  private Usuario host;
  
  @ManyToOne
  @JoinColumn(name = "destino_id")
  private Usuario destino;
  
  @ManyToOne
  @JoinColumn(name = "agendamento_id")
  private Agendamento agendamento;

}
