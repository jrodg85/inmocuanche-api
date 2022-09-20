package es.jrodg85.InmoGuancheCRM.rest;

import java.util.Set;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import es.jrodg85.InmoGuancheCRM.entidades.OfertaDeAlquilerConId;
import es.jrodg85.InmoGuancheCRM.entidades.OfertaDeVentaConId;
import es.jrodg85.InmoGuancheCRM.repositorios.OfertaDAO;

@RepositoryRestController
public class OfertaController {

  private OfertaDAO ofertaDAO;

  public OfertaController(OfertaDAO ofertaDAO) {
    this.ofertaDAO = ofertaDAO;

  }


  @GetMapping("/ofertas_de_alquiler/search/alquilerpersonalizado")
  @ResponseBody
  public CollectionModel<PersistentEntityResource> getOfertasDeAlquilerConPrecioPartidoSuperficieCuyoMaximoValorEs(
      @RequestParam("consultaDeValorMaximoDePrecioAlquilerSuperficie") Double consultaDeValorMaximoDePrecioAlquilerSuperficie,
      PersistentEntityResourceAssembler assembler) {

    Set<OfertaDeAlquilerConId> ofertasDeAlquiler =
        ofertaDAO.getOfertasDeAlquilerConPrecioPartidoSuperficieCuyoMaximoValorEs(
            consultaDeValorMaximoDePrecioAlquilerSuperficie);


    return assembler.toCollectionModel(ofertasDeAlquiler);
  }


  @GetMapping("/ofertas_de_venta/search/ventapersonalizado")
  @ResponseBody
  public CollectionModel<PersistentEntityResource> getOfertasDeVentaConPrecioPartidoSuperficieCuyoMaximoValorEs(
      @RequestParam("consultaDeValorMaximoDePrecioVentaSuperficie") Double consultaDeValorMaximoDePrecioVentaSuperficie,
      PersistentEntityResourceAssembler assembler) {

    Set<OfertaDeVentaConId> ofertasDeVenta =
        ofertaDAO.getOfertasDeVentaConPrecioPartidoSuperficieCuyoMaximoValorEs(
            consultaDeValorMaximoDePrecioVentaSuperficie);


    return assembler.toCollectionModel(ofertasDeVenta);
  }


}

