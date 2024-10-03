package com.sabino.gerenciaatividade.controllers;

import com.sabino.gerenciaatividade.dto.ClienteDTO;
import com.sabino.gerenciaatividade.services.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    public ClienteDTO cadastrar(@Validated @RequestBody ClienteDTO clienteDTO) throws Exception {
        return this.cadastroService.cadastrar(clienteDTO);
    }

    @GetMapping("/listar")
    public List<ClienteDTO> listarClientes() {
        return this.cadastroService.listar();
    }

    @GetMapping("/{email}")
    public ClienteDTO buscarCadastro(@PathVariable("email") String email) throws Exception {
        return this.cadastroService.buscarCadastro(email);
    }

    @PutMapping("/{email}")
    public ClienteDTO atualizarCadastro(@PathVariable("email") String email, @Validated @RequestBody ClienteDTO clienteDTO) throws Exception {
        return this.cadastroService.atualizarCadastro(email, clienteDTO);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> excluirCadastro(@PathVariable("email") String email) throws Exception {
        this.cadastroService.excluirCadastro(email);
        return new ResponseEntity<>("Cadastro excluído com sucesso!", HttpStatus.OK);
    }

}
