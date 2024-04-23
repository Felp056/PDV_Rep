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
    int id;
    BigDecimal total;
    String observacoes;
    @ManyToOne
    Cliente cliente;
}
