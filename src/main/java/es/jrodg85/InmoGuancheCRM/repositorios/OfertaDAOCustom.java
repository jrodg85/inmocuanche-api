package es.jrodg85.InmoGuancheCRM.repositorios;

import java.util.Set;
import es.jrodg85.InmoGuancheCRM.entidades.OfertaDeAlquilerConId;
import es.jrodg85.InmoGuancheCRM.entidades.OfertaDeVentaConId;

public interface OfertaDAOCustom {

  Set<OfertaDeAlquilerConId> getOfertasDeAlquilerConPrecioPartidoSuperficieCuyoMaximoValorEs(
      double consultaDeValorMaximoDePrecioAlquilerSuperficie);

  Set<OfertaDeVentaConId> getOfertasDeVentaConPrecioPartidoSuperficieCuyoMaximoValorEs(
      double consultaDeValorMaximoDePrecioVentaSuperficie);


}
