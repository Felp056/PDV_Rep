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
    int id;
    String descricao;
    BigDecimal valor_unitario;
}
