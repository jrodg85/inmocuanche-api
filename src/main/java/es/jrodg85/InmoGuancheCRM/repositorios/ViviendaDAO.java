package es.jrodg85.InmoGuancheCRM.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import es.jrodg85.InmoGuancheCRM.entidades.ViviendaConId;

@RepositoryRestResource(path = "viviendas", itemResourceRel = "vivienda",
    collectionResourceRel = "viviendas")
public interface ViviendaDAO extends JpaRepository<ViviendaConId, Long> {


  @RestResource(path = "ciudad")
  List<ViviendaConId> findByCiudad(@Param("provincia") String txt);


  @RestResource(path = "provincia")
  List<ViviendaConId> findByProvincia(@Param("provincia") String txt);


  @RestResource(path = "superficie")
  List<ViviendaConId> findBySuperficie(@Param("superficie") Double txt);

}
