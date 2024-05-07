package br.unipar.programacaointernet.pdv.mapper;

import br.unipar.programacaointernet.pdv.dto.VendaDto;
import br.unipar.programacaointernet.pdv.objetos.Venda;

import java.util.ArrayList;
import java.util.List;

public class vendaMapper {
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
}
