package es.jrodg85.InmoGuancheCRM.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import es.jrodg85.InmoGuancheCRM.repositorios.OfertaDeVentaListener;
import es.jrodg85.realestate.OfertaDeVentaInterfaz;

@Entity
@EntityListeners(OfertaDeVentaListener.class)
@Access(value = AccessType.FIELD)
@DiscriminatorValue("OFERTA_DE_VENTA")
public class OfertaDeVentaConId extends OfertaConId implements OfertaDeVentaInterfaz {

  // atributos

  private double precioDeVenta;

  // getter overrided

  @Override
  public Double getPrecioDeVenta() {
    return precioDeVenta;
  }



  // setter overrided


  @Override
  public void setPrecioDeVenta(Double precioVenta) {
    this.precioDeVenta = precioVenta;

  }


  // Constructores


  public OfertaDeVentaConId() {}


  public OfertaDeVentaConId(String titulo) {
    super(titulo);
  }

}
