package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.objetos.Cliente;
import br.unipar.programacaointernet.pdv.repository.ClienteRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
@Stateless
public class ClienteService {

    @Inject
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.getAll();
    }

    public Cliente listarById(Integer id) {
        return repository.getById(id);
    }

    public void cadastrar(Cliente cliente) {
        repository.insert(cliente);
    }

    public void deletar(Cliente cliente) {
        repository.remove(cliente);
    }
}

