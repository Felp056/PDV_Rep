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
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column
    BigDecimal valor_unitario;
    @Column
    BigDecimal  valor_total;
    @Column
    BigDecimal  quantidade;
    @ManyToOne
    Produto produto;
    @ManyToOne
    Venda venda;
}
