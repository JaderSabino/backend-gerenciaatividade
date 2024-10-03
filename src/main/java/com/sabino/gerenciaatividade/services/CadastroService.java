package com.sabino.gerenciaatividade.services;

import com.sabino.gerenciaatividade.dto.ClienteDTO;
import com.sabino.gerenciaatividade.entities.ClienteEntity;
import com.sabino.gerenciaatividade.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CadastroService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO cadastrar(ClienteDTO clienteDTO) throws Exception {
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .email(clienteDTO.getEmail())
                .senha(clienteDTO.getSenha())
                .dataDeNascimento(clienteDTO.getDataDeNascimento())
                .nome(clienteDTO.getNome())
                .sobrenome(clienteDTO.getSobrenome())
                .build();
        this.clienteRepository.cadastrar(clienteEntity);
        return clienteDTO;
    }

    public List<ClienteDTO> listar() {
        List<ClienteDTO> listaClientes = new ArrayList<>();
        for (ClienteEntity clienteEntity : this.clienteRepository.listar()) {

            listaClientes.add(ClienteDTO.builder()
                    .email(clienteEntity.getEmail())
                    .senha(clienteEntity.getSenha())
                    .dataDeNascimento(clienteEntity.getDataDeNascimento())
                    .nome(clienteEntity.getNome())
                    .sobrenome(clienteEntity.getSobrenome())
                    .build());

        }
        return listaClientes;
    }

    public ClienteDTO buscarCadastro(String email) throws Exception {
        ClienteEntity clienteEntity = this.clienteRepository.buscarCliente(email);
        ClienteDTO clienteDTO = ClienteDTO.builder()
                .email(clienteEntity.getEmail())
                .senha(clienteEntity.getSenha())
                .dataDeNascimento(clienteEntity.getDataDeNascimento())
                .nome(clienteEntity.getNome())
                .sobrenome(clienteEntity.getSobrenome())
                .build();
        return clienteDTO;
    }

    public ClienteDTO atualizarCadastro(String email, ClienteDTO clienteDTO) throws Exception {
        ClienteEntity clienteEntity = this.clienteRepository.buscarCliente(email);

        clienteEntity.setNome(clienteDTO.getNome());
        clienteEntity.setSobrenome(clienteDTO.getSobrenome());
        clienteEntity.setDataDeNascimento(clienteDTO.getDataDeNascimento());

        return clienteDTO;
    }

    public void excluirCadastro(String email) throws Exception {
        this.clienteRepository.excluirCliente(email);
    }
}
