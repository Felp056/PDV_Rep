package br.unipar.programacaointernet.pdv.mapper;

import br.unipar.programacaointernet.pdv.dto.TotalVendaClienteDTO;
import br.unipar.programacaointernet.pdv.dto.VendaDto;
import br.unipar.programacaointernet.pdv.objetos.Cliente;
import br.unipar.programacaointernet.pdv.objetos.Venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendaMapper {

    public static List<VendaDto> toDto(List<Venda> vendas, List<Cliente> clientes) {
        List<VendaDto> lista = new ArrayList<>();

        for (Cliente cliente : clientes) {
            VendaDto dto = new VendaDto();
            dto.setNomeCliente(cliente.getNome());

            int cont = 0;
            for (Venda venda : vendas) {
                if (cliente == venda.getCliente()) {
                    cont++;
                }
            }

            dto.setTotalVendas(cont);

            lista.add(dto);
        }

        return lista;
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
