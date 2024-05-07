package br.unipar.programacaointernet.pdv.mapper;

import br.unipar.programacaointernet.pdv.dto.ProdutoDescricaoValorDTO;
import br.unipar.programacaointernet.pdv.objetos.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapper {
    public static List<ProdutoDescricaoValorDTO> toDTO(List<Produto> produtoList) {
        List<ProdutoDescricaoValorDTO> dtoList = new ArrayList<>();
        for (Produto produto : produtoList) {
            ProdutoDescricaoValorDTO dto =
                    new ProdutoDescricaoValorDTO();
            dto.setDescricao(produto.getDescricao());
            dto.setValor_unitario(produto.getValor_unitario());

            dtoList.add(dto);
        }
        return dtoList;
    }
}
