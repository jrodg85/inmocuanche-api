package es.jrodg85.InmoGuancheCRM.entidades;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import es.jrodg85.InmoGuancheCRM.repositorios.OfertaListener;
import es.jrodg85.realestate.Oferta;

@Entity
@EntityListeners(OfertaListener.class)
@Table(name = "OFERTAS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_OFERTA", discriminatorType = DiscriminatorType.STRING)
public class OfertaConId extends Oferta {

  // atributos

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_VIVIENDA", referencedColumnName = "idVivienda")
  private ViviendaConId vivienda;


  // getter


  public ViviendaConId getVivienda() {
    return vivienda;
  }


  // setter


  public void setVivienda(ViviendaConId vivienda) {
    this.vivienda = vivienda;
  }


  // constructores

  public OfertaConId() {}


  public OfertaConId(String tituloOferta) {

  }


}

