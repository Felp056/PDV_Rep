package br.unipar.programacaointernet.pdv.controller;

import br.unipar.programacaointernet.pdv.objetos.Produto;
import br.unipar.programacaointernet.pdv.objetos.Venda;
import br.unipar.programacaointernet.pdv.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Produto")
public class ProdutoController {

    @Inject
    private ProdutoService service;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getProduto () {
        return Response.ok(service.listar()).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getProdutoById (Integer id) {
        return Response.ok(service.listarById(id)).build();
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response addProduto (Produto produto) {
        try {
            service.cadastrar(produto);
            return Response.status(201)
                    .entity(produto)
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
    public Response deleteProduto (Produto produto) {
        try {
            service.deletar(produto);
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
