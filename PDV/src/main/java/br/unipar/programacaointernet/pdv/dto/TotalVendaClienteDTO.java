package br.unipar.programacaointernet.pdv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TotalVendaClienteDTO {
    private BigDecimal total_vendas;
    private String nome_cliente;
}
