package br.unipar.programacaointernet.pdv.controller;

import br.unipar.programacaointernet.pdv.objetos.ItensVenda;
import br.unipar.programacaointernet.pdv.objetos.Venda;
import br.unipar.programacaointernet.pdv.service.ItensVendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ItensVenda")
public class ItensVendaController {
    @Inject
    private ItensVendaService service;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getItensVenda () {
        return Response.ok(service.listar()).build();
    }

    @GET
    @Path("/id")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getItensVendaById (Integer id) {
        return Response.ok(service.listarById(id)).build();
    }

    @POST
    @Path("/add")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response addItensVenda (ItensVenda itensVenda) {
        try {
            service.cadastrar(itensVenda);
            return Response.status(201)
                    .entity(itensVenda)
                    .build();
        } catch (Exception ex) {
            return Response.status(403)
                    .entity(ex.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/del")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response deleteItensVenda (ItensVenda itensVenda) {
        try {
            service.deletar(itensVenda);
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
