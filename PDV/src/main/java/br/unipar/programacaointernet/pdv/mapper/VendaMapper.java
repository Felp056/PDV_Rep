package br.unipar.programacaointernet.pdv.mapper;

import br.unipar.programacaointernet.pdv.dto.TotalVendaClienteDTO;
import br.unipar.programacaointernet.pdv.dto.VendaDto;
import br.unipar.programacaointernet.pdv.objetos.Cliente;
import br.unipar.programacaointernet.pdv.objetos.Venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendaMapper {
    public List<VendaDto> toDto(List<Venda> vendas)
    {
        List<VendaDto> vendaDtos = new ArrayList<>();
        for (Venda venda : vendas){
            VendaDto vendaDto = new VendaDto();
            vendaDto.setNomeCliente(venda.getCliente().getNome());
            vendaDto.setTotalVendas(venda.getTotal());
        }
        return vendaDtos;
    }

    public static List<TotalVendaClienteDTO> toDTO(List<Cliente> clientes, List<Venda> vendas){
        List<TotalVendaClienteDTO> lista = new ArrayList<>();
        for (Cliente cliente : clientes) {
            TotalVendaClienteDTO dto = new TotalVendaClienteDTO();
            dto.setNome_cliente(cliente.getNome());
            dto.setTotal_vendas(somaTotal(cliente, vendas));

            lista.add(dto);
        }

        return lista;
    }

    private static BigDecimal somaTotal(Cliente cliente, List<Venda> vendas) {
        BigDecimal total = new BigDecimal("0");
        for (Venda venda : vendas) {
            if (cliente == venda.getCliente()) {
                total = total.add(venda.getTotal());
            }
        }
        return total;
    }
}
