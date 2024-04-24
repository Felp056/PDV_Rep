package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.objetos.Produto;
import br.unipar.programacaointernet.pdv.repository.ProdutoRepository;
import jakarta.inject.Inject;

import java.util.List;

public class ProdutoService {

    @Inject
    private ProdutoRepository repository;

    public List<Produto> listar() {
        return repository.getAll();
    }

    public Produto listarById(Integer id) {
        return repository.getById(id);
    }

    public void cadastrar(Produto produto) {
        repository.insert(produto);
    }

    public void deletar(Produto produto) {
        repository.delete(produto);
    }
}