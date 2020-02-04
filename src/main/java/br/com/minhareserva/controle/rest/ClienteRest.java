package br.com.minhareserva.controle.rest;

import br.com.minhareserva.modelo.negocio.persistencia.entidade.Cliente;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Hospede;
import br.com.minhareserva.modelo.negocio.servico.ClienteServico;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/")
public class ClienteRest {

    @Autowired
    private ClienteServico clienteServico;

    @PostMapping("/cliente/login")
    public Cliente login(@RequestBody Cliente cliente) {
        cliente = this.clienteServico.autenticar(cliente.getContato().getEmail(), cliente.getSenha());
        return cliente;
    }

    @PutMapping("/cadastro/cliente")
    public <T extends Cliente> void salvarCliente(@RequestBody T cliente) {
        this.clienteServico.cadastrarCliente(cliente);
    }
}