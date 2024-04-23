package br.unipar.programacaointernet.pdv.controller;

import br.unipar.programacaointernet.pdv.objetos.Cliente;
import br.unipar.programacaointernet.pdv.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.lang.annotation.Retention;
import java.rmi.server.RemoteRef;

@Path("/cliente")
public class ClienteController {

    @Inject
    private ClienteService service;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getClientes () {
        return Response.ok(service.listar()).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getClienteById (Integer id) {
        return Response.ok(service.listarById(id)).build();
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response addCliente (Cliente cliente) {
        try {
            service.cadastrar(cliente);
            return Response.status(201)
                    .entity(cliente)
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
    public Response deleteCliente (Cliente cliente) {
        try {
            service.deletar(cliente);
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
