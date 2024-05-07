package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.dto.ClienteTelefoneNascimentoDTO;
import br.unipar.programacaointernet.pdv.mapper.ClienteMapper;
import br.unipar.programacaointernet.pdv.objetos.Cliente;
import br.unipar.programacaointernet.pdv.repository.ClienteRepository;
import br.unipar.programacaointernet.pdv.repository.VendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
@Stateless
public class ClienteService {

    @Inject
    private ClienteRepository repository;
    private VendaRepository vendaRepository;

    public List<Cliente> listar() {
        return repository.getAll();
    }

    public Cliente listarById(Integer id) {
        return repository.getById(id);
    }

    public List<ClienteTelefoneNascimentoDTO> listarClienteTelefoneAniversario() {
        List<Cliente> clienteList = repository.getAll();
        return ClienteMapper.toDTO(clienteList);
    }

    public void cadastrar(Cliente cliente) {
        repository.insert(cliente);
    }

    public void deletar(Cliente cliente) {
        repository.remove(cliente);
    }

    public void atualizar(Cliente cliente) {
        repository.update(cliente);
    }
}

