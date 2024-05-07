package br.unipar.programacaointernet.pdv.mapper;

import br.unipar.programacaointernet.pdv.dto.ClienteTelefoneNascimentoDTO;
import br.unipar.programacaointernet.pdv.objetos.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {
    public static List<ClienteTelefoneNascimentoDTO> toDTO(List<Cliente> listCliente) {
        List<ClienteTelefoneNascimentoDTO> listaClienteTelefoneNascimento = new ArrayList<>();

        for (Cliente cliente : listCliente) {
            ClienteTelefoneNascimentoDTO dto = new ClienteTelefoneNascimentoDTO();
            dto.setNome(cliente.getNome());
            dto.setTelefone(cliente.getTelefone());

            String[] arrOfString = cliente.getDataNascimento().split("/");
            dto.setData_aniversario(arrOfString[0]+"/"+arrOfString[1]);

            listaClienteTelefoneNascimento.add(dto);
        }
        return listaClienteTelefoneNascimento;
    }
}
