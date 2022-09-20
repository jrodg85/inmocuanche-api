package es.jrodg85.InmoGuancheCRM.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import es.jrodg85.InmoGuancheCRM.entidades.OfertaDeAlquilerConId;
import es.jrodg85.InmoGuancheCRM.entidades.ViviendaConId;

@RepositoryRestResource(path = "ofertas_de_alquiler", itemResourceRel = "oferta_de_alquiler",
    collectionResourceRel = "ofertas_de_alquiler")
public interface OfertaDeAlquilerDAO extends JpaRepository<OfertaDeAlquilerConId, Long> {


  @RestResource(path = "precioAlquilerMensual")
  List<ViviendaConId> findByPrecioAlquilerMensual(@Param("precioAlquilerMensual") Double number);


}
