package br.com.minhareserva.controle.rest;

import br.com.minhareserva.modelo.negocio.excecao.ContaExistenteException;
import br.com.minhareserva.modelo.negocio.excecao.NaoAutenticadoException;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Cliente;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Contato;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Endereco;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Hospede;
import br.com.minhareserva.modelo.negocio.servico.ClienteServico;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
@RequestMapping("/cliente")
public class ClienteRest {

    @Autowired
    private ClienteServico clienteServico;

    @GetMapping(value = "/login", produces = "application/json")
    public ResponseEntity<Cliente> login(@RequestBody Cliente cliente) {
        Optional<Cliente> clienteAutenticado = clienteServico.autenticar(cliente.getContato().getEmail(), cliente.getSenha());
        if(clienteAutenticado.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(clienteAutenticado.get());
        else
            throw new NaoAutenticadoException("Cliente nao cadastrado");
    }

    @PutMapping("/hospede/cadastro")
    public ResponseEntity<String> cadastraUsuario(@RequestBody Cliente cliente) {
        if(!clienteServico.existeConta(cliente.getContato().getEmail(), cliente.getSenha())) {
            clienteServico.cadastraCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else
            throw new ContaExistenteException("Ja existe uma conta com esse email e senha");
    }


}