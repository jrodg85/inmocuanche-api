package es.jrodg85.InmoGuancheCRM.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import es.jrodg85.InmoGuancheCRM.repositorios.OfertaDeAlquilerListener;
import es.jrodg85.realestate.OfertaDeAlquilerInterfaz;

@Entity
@EntityListeners(OfertaDeAlquilerListener.class)
@Access(value = AccessType.FIELD)
@DiscriminatorValue("OFERTA_DE_ALQUILER")
public class OfertaDeAlquilerConId extends OfertaConId implements OfertaDeAlquilerInterfaz {

  // atributos

  private double precioAlquilerMensual;
  private int mesesFianza;


  // getter overrided


  @Override
  public Integer getMesesFianza() {
    return mesesFianza;
  }


  @Override
  public Double getPrecioAlquilerMensual() {
    return precioAlquilerMensual;
  }



  // setter overrided


  @Override
  public void setMesesFianza(Integer mesesFianza) {
    this.mesesFianza = mesesFianza;
  }


  @Override
  public void setPrecioAlquilerMensual(Double precioAlquilerMensual) {
    this.precioAlquilerMensual = precioAlquilerMensual;
  }


  // constructores

  public OfertaDeAlquilerConId() {}

  public OfertaDeAlquilerConId(String titulo) {
    super(titulo);
  }

}
