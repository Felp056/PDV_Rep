package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.objetos.ItensVenda;
import br.unipar.programacaointernet.pdv.repository.ItensVendaRepository;
import jakarta.inject.Inject;

import java.util.List;

public class ItensVendaService {

    @Inject
    private ItensVendaRepository repository;

    public List<ItensVenda> listar() {
        return repository.getAll();
    }

    public ItensVenda listarById(Integer id) {
        return repository.findById(id);
    }

    public void cadastrar(ItensVenda itensVenda) {
        repository.insert(itensVenda);
    }

    public void deletar(ItensVenda itensVenda) {
        repository.remove(itensVenda);
    }
}
