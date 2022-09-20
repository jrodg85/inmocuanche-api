package es.jrodg85.InmoGuancheCRM.repositorios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import es.jrodg85.InmoGuancheCRM.entidades.OfertaDeAlquilerConId;
import es.jrodg85.InmoGuancheCRM.entidades.OfertaDeVentaConId;



@Transactional(readOnly = true)
public class OfertaDAOImpl implements OfertaDAOCustom {


  @PersistenceContext
  EntityManager entityManager;

  OfertaDeAlquilerDAO ofertaDeAlquilerDAO;
  OfertaDeVentaDAO ofertaDeVentaDAO;


  @Autowired
  public OfertaDAOImpl(@Lazy OfertaDeAlquilerDAO ofertaDeAlquilerDAO,
      @Lazy OfertaDeVentaDAO ofertaDeVentaDAO) {
    this.ofertaDeAlquilerDAO = ofertaDeAlquilerDAO;
    this.ofertaDeVentaDAO = ofertaDeVentaDAO;
  }


  @Override
  public Set<OfertaDeAlquilerConId> getOfertasDeAlquilerConPrecioPartidoSuperficieCuyoMaximoValorEs(
      double consultaDeValorMaximoDePrecioAlquilerSuperficie) {
    // me cojo todas las ofertas de alquiler
    List<OfertaDeAlquilerConId> todasLasofertasDeAlquiler = ofertaDeAlquilerDAO.findAll();
    // me creo un set vacio que va a ser el resultado
    Set<OfertaDeAlquilerConId> resultadoOfertaDeAlquilerConIds =
        new HashSet<OfertaDeAlquilerConId>();
    // por cada una de las ofertas de alquiler de todas las ofertas de alquiler que hay
    for (OfertaDeAlquilerConId cadaofertaDeAlquiler : todasLasofertasDeAlquiler) {
      // declaro previamente el valor de precio por m2 de cada oferta
      // si el precio de cada oferta de alquiler mensual partido por la superficie de la vivienda
      // asociada a cada oferta de alquiler es menor que el dato que entrego
      double calcularPAM2decadaOferta = cadaofertaDeAlquiler.getPrecioAlquilerMensual()
          / cadaofertaDeAlquiler.getVivienda().getSuperficie();
      if (calcularPAM2decadaOferta <= consultaDeValorMaximoDePrecioAlquilerSuperficie) {
        // me añades esa oferta de alquiler al resultado de ofertas de alquiler
        resultadoOfertaDeAlquilerConIds.add(cadaofertaDeAlquiler);
      }
    }
    return resultadoOfertaDeAlquilerConIds;
  }


  @Override
  public Set<OfertaDeVentaConId> getOfertasDeVentaConPrecioPartidoSuperficieCuyoMaximoValorEs(
      double consultaDeValorMaximoDePrecioVentaSuperficie) {
    // me cojo todas las ofertas de alquiler
    List<OfertaDeVentaConId> todasLasofertasDeVenta = ofertaDeVentaDAO.findAll();
    // me creo un set vacio que va a ser el resultado
    Set<OfertaDeVentaConId> resultadoOfertaDeVentaConIds = new HashSet<OfertaDeVentaConId>();
    // por cada una de las ofertas de alquiler de todas las ofertas de alquiler que hay
    for (OfertaDeVentaConId cadaofertaDeVenta : todasLasofertasDeVenta) {
      // declaro previamente el valor de precio por m2 de cada oferta
      // si el precio de cada oferta de alquiler mensual partido por la superficie de la vivienda
      // asociada a cada oferta de alquiler es menor que el dato que entrego
      double calcularPVM2decadaOferta =
          cadaofertaDeVenta.getPrecioDeVenta() / cadaofertaDeVenta.getVivienda().getSuperficie();
      if (calcularPVM2decadaOferta <= consultaDeValorMaximoDePrecioVentaSuperficie) {
        // me añades esa oferta de alquiler al resultado de ofertas de alquiler
        resultadoOfertaDeVentaConIds.add(cadaofertaDeVenta);
      }
    }
    return resultadoOfertaDeVentaConIds;
  }


}

