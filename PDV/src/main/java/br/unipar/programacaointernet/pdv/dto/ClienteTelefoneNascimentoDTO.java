package br.unipar.programacaointernet.pdv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteTelefoneNascimentoDTO {
    private String nome;
    private String telefone;
    private String data_aniversario;
}
