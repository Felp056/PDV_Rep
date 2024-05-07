package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.dto.TotalVendaClienteDTO;
import br.unipar.programacaointernet.pdv.mapper.VendaMapper;
import br.unipar.programacaointernet.pdv.objetos.Cliente;
import br.unipar.programacaointernet.pdv.objetos.Venda;
import br.unipar.programacaointernet.pdv.repository.ClienteRepository;
import br.unipar.programacaointernet.pdv.repository.VendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
@Stateless
public class VendaService {

    @Inject
    private VendaRepository repository;
    @Inject
    private ClienteRepository clienteRepository;

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
    public String GerarRelatorio() { return repository.GerarRelatorioVendas();}

    public List<TotalVendaClienteDTO> totalVendaCliente() {
        List<Cliente> listaClientes = clienteRepository.getAll();
        List<Venda> listaVendas = repository.getAll();

        return VendaMapper.toDTO(listaClientes, listaVendas);
    }
}
