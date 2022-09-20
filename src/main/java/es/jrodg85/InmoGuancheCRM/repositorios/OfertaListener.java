package es.jrodg85.InmoGuancheCRM.repositorios;

import javax.persistence.PostPersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import es.jrodg85.InmoGuancheCRM.entidades.OfertaConId;

@Component
public class OfertaListener {

  private Logger logger = LoggerFactory.getLogger(OfertaConId.class);


  // no hago uso de los campos dao ni por tanto del autowired,
  // por lo que de momento lo comento

  // private OfertaDeAlquilerDAO ofertaDeAlquilerDAO;
  // private OfertaDeVentaDAO ofertaDeVentaDAO;

  //
  // @Autowired
  // public void init(OfertaDeAlquilerDAO ofertaDeAlquilerDAO, OfertaDeVentaDAO ofertaDeVentaDAO) {
  // this.ofertaDeAlquilerDAO = ofertaDeAlquilerDAO;
  // this.ofertaDeVentaDAO = ofertaDeVentaDAO;
  // }

  @PostPersist
  public void postPutOferta(OfertaConId ofertaConId) {
    logger.warn("Se ha creado una oferta con id #" + ofertaConId.getIdOferta());
  }


}
