package br.unipar.programacaointernet.pdv.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDescricaoValorDTO {
    private String descricao;
    private BigDecimal valor_unitario;
}
