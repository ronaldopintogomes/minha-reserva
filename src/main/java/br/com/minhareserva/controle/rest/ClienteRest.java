package br.com.minhareserva.controle.rest;

import br.com.minhareserva.modelo.negocio.excecao.ContaExistenteException;
import br.com.minhareserva.modelo.negocio.excecao.NaoAutenticadoException;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Cliente;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Hotel;
import br.com.minhareserva.modelo.negocio.servico.ClienteServico;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@NoArgsConstructor
@RequestMapping("/cliente")
public class ClienteRest {

    @Autowired
    private ClienteServico clienteServico;

    @PutMapping("/nova/conta")
    public ResponseEntity<String> novaConta(@RequestBody Cliente cliente) {
        if(!clienteServico.existeConta(cliente.getContato().getEmail(), cliente.getSenha())) {
            clienteServico.cadastraCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Conta criada com sucesso!");
        } else
            throw new ContaExistenteException("Ja existe uma conta com esse email e senha");
    }

    @GetMapping(value = "/login", produces = "application/json")
    public ResponseEntity<Cliente> login(@RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteServico.autenticar(cliente.getContato().getEmail(), cliente.getSenha());
        if(clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
        } else
            throw new NaoAutenticadoException("Cliente nao cadastrado");
    }

    @PutMapping("/hoteleiro/adiciona/hotel")
    public ResponseEntity<String> adicionaHotel(@RequestBody Hotel hotel) {

        return ResponseEntity.status(HttpStatus.CREATED).body("Hotel adicionado com sucesso?");
    }
}