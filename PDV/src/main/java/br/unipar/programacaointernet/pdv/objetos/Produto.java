package br.unipar.programacaointernet.pdv.objetos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column
    String descricao;
    @Column
    BigDecimal valor_unitario;
}
