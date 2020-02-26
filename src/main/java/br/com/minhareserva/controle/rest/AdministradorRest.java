package br.com.minhareserva.controle.rest;

import br.com.minhareserva.modelo.negocio.excecao.ResourceNotFoundException;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Cliente;
import br.com.minhareserva.modelo.negocio.servico.AdministradorServico;
import br.com.minhareserva.modelo.negocio.servico.ClienteServico;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
@RequestMapping("/administrador")
public class AdministradorRest {

    @Autowired
    private ClienteServico clienteServico;
    @Autowired
    private AdministradorServico administradorServico;

    @GetMapping(value = "/lista/usuarios", produces = "application/json")
    public @ResponseBody List<Cliente> getUsuarios() {
        Optional<List<Cliente>> listaOptional = Optional.ofNullable(this.clienteServico.getUsuarios());
        if(!listaOptional.isPresent())
            throw new ResourceNotFoundException("Lista de usuarios vazia");
        else
            return listaOptional.get();
    }

    @GetMapping(value="/busca/usuario/{id}", produces = "application/json")
    public @ResponseBody
    Cliente getUsuario(@PathVariable("id") Long id) {
        Optional<Cliente> optionalUsuario = clienteServico.getUsuario(id);
        if(!optionalUsuario.isPresent())
            throw new ResourceNotFoundException("Usuario nao encontrado");
        return optionalUsuario.get();
    }
}