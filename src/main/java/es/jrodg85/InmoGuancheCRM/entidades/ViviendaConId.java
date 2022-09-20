package es.jrodg85.InmoGuancheCRM.entidades;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import es.jrodg85.realestate.Vivienda;

@Entity
@Table(name = "VIVIENDAS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ViviendaConId extends Vivienda {


  // atributo coleccion de ofertas


  private Collection<OfertaConId> ofertasDeVivienda = new ArrayList<>();


  // getter


  @OneToMany(cascade = CascadeType.ALL, targetEntity = OfertaConId.class, mappedBy = "vivienda")
  public Collection<OfertaConId> getOfertasDeVivienda() {
    return ofertasDeVivienda;
  }


  // setter


  // relacion en ambos sentidos para oferta


  public void addOfertaAlquilerConId(OfertaConId oferta) {
    getOfertasDeVivienda().add(oferta);
    oferta.setVivienda(this);
  }



  public ViviendaConId() {
    super();
  }


  public ViviendaConId(String propietario, String provincia, String ciudad, String direccion,
      int codigoPostal, String idReferenciaCatastral, Double superficie, Integer habitaciones,
      Integer banyos) {
    super(propietario, provincia, ciudad, direccion, codigoPostal, idReferenciaCatastral,
        superficie, habitaciones, banyos);
  }


}

