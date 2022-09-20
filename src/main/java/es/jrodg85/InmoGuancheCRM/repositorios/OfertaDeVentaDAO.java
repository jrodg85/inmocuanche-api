package es.jrodg85.InmoGuancheCRM.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import es.jrodg85.InmoGuancheCRM.entidades.OfertaDeVentaConId;
import es.jrodg85.InmoGuancheCRM.entidades.ViviendaConId;

@RepositoryRestResource(path = "ofertas_de_venta", itemResourceRel = "oferta_de_venta",
    collectionResourceRel = "ofertas_de_venta")
public interface OfertaDeVentaDAO extends JpaRepository<OfertaDeVentaConId, Long> {


  @RestResource(path = "precioDeVenta")
  List<ViviendaConId> findByPrecioDeVenta(@Param("precioDeVenta") Double nummber);

}
