package com.sabino.gerenciaatividade.repositories;

import com.sabino.gerenciaatividade.entities.ClienteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteRepository {
    List<ClienteEntity> listaClientes = new ArrayList<>();

    public void cadastrar(ClienteEntity clienteEntity) throws Exception {
        for (ClienteEntity cliente : this.listaClientes) {
            if (clienteEntity.getEmail().equals(cliente.getEmail())) {
                throw new Exception("Cliente já cadastrado!");
            }
        }

        this.listaClientes.add(clienteEntity);
    }

    public List<ClienteEntity> listar() {
        return this.listaClientes;
    }

    public ClienteEntity buscarCliente(String email) throws Exception {
        ClienteEntity clienteEntityEncontrado = null;

        for (ClienteEntity clienteEntity : this.listaClientes) {
            if (clienteEntity.getEmail().equals(email)) {
                clienteEntityEncontrado = clienteEntity;
            }
        }

        if (clienteEntityEncontrado == null) {
            throw new Exception("Cliente não cadastrado!");
        }

        return clienteEntityEncontrado;
    }

    public void atualizar(ClienteEntity clienteEntity) {
        for (ClienteEntity cliente : this.listaClientes) {
            if (cliente.getEmail().equals(clienteEntity.getEmail())) {
                cliente = clienteEntity;
                break;
            }
        }
    }

    public void excluirCliente(String email) throws Exception {
        int indiceCliente = -1;

        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getEmail().equals(email)) {
                indiceCliente = i;
            }
        }

        if (indiceCliente < 0) {
            throw new Exception("Cliente não cadastrado!");
        }

        this.listaClientes.remove(indiceCliente);
    }
}
