package br.unipar.programacaointernet.pdv.objetos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente {
    @Id
    int id;
    String nome;
    String telefone;
}
