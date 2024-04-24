package br.unipar.programacaointernet.pdv.controller;

import br.unipar.programacaointernet.pdv.objetos.Cliente;
import br.unipar.programacaointernet.pdv.objetos.Venda;
import br.unipar.programacaointernet.pdv.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Vendas")
public class VendaController {

    @Inject
    private VendaService service;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getVenda () {
        return Response.ok(service.listar()).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getVendaById (Integer id) {
        return Response.ok(service.listarById(id)).build();
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response addVenda (Venda venda) {
        try {
            service.cadastrar(venda);
            return Response.status(201)
                    .entity(venda)
                    .build();
        } catch (Exception ex) {
            return Response.status(403)
                    .entity(ex.getMessage())
                    .build();
        }
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response deleteVenda (Venda venda) {
        try {
            service.deletar(venda);
            return Response.status(201)
                    .entity("Cliente deletado com sucesso!")
                    .build();
        } catch (Exception ex) {
            return Response.status(403)
                    .entity(ex.getMessage())
                    .build();
        }
    }

}
