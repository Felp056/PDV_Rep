package br.unipar.programacaointernet.pdv.objetos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class ItensVenda {
    @Id
    int id;
    BigDecimal valor_unitario;
    BigDecimal  valor_total;
    BigDecimal  quantidade;
    @OneToOne
    Produto produto;
    @ManyToOne
    Venda venda;
}
