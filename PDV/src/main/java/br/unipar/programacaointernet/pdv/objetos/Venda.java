package br.unipar.programacaointernet.pdv.objetos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import br.unipar.programacaointernet.pdv.objetos.Cliente;
import java.math.BigDecimal;
import java.nio.MappedByteBuffer;

@Getter
@Setter
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column
    BigDecimal total;
    @Column
    String observacoes;
    @ManyToOne
    Cliente cliente;
}
