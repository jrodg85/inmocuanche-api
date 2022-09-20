package es.jrodg85.InmoGuancheCRM.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import es.jrodg85.InmoGuancheCRM.entidades.OfertaConId;


@RepositoryRestResource(path = "ofertas", itemResourceRel = "oferta",
    collectionResourceRel = "ofertas")
public interface OfertaDAO extends JpaRepository<OfertaConId, Long>, OfertaDAOCustom {


}
