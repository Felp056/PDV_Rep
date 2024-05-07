package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.dto.ProdutoDescricaoValorDTO;
import br.unipar.programacaointernet.pdv.mapper.ProdutoMapper;
import br.unipar.programacaointernet.pdv.objetos.Produto;
import br.unipar.programacaointernet.pdv.repository.ProdutoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
@Stateless
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

    public List<ProdutoDescricaoValorDTO> listarProdutoDescricao() {
        List<Produto> produtoList = repository.getAll();

        return ProdutoMapper.toDTO(produtoList);
    }
}
