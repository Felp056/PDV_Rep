package br.unipar.programacaointernet.pdv.objetos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import br.unipar.programacaointernet.pdv.objetos.Cliente;
import java.math.BigDecimal;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "venda", orphanRemoval = true,
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    private List<ItensVenda> itens = new ArrayList<>();
}
