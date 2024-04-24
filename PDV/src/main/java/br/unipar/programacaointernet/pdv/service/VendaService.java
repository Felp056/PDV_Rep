package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.objetos.Venda;
import br.unipar.programacaointernet.pdv.repository.VendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
@Stateless
public class VendaService {

    @Inject
    private VendaRepository repository;

    public List<Venda> listar() {
        return repository.getAll();
    }

    public Venda listarById(Integer id) {
        return repository.getById(id);
    }

    public void cadastrar(Venda venda) {
        repository.insert(venda);
    }

    public void deletar(Venda venda) {
        repository.remove(venda);
    }
}
