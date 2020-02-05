package br.com.minhareserva.controle.rest;

import br.com.minhareserva.modelo.negocio.excecao.AdministradorException;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Administrador;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Cliente;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Contato;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Endereco;
import br.com.minhareserva.modelo.negocio.servico.AdministradorServico;
import br.com.minhareserva.modelo.negocio.servico.ClienteServico;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping("/lista/administradores")
    private List<Administrador> listaAdministradores() {
        return administradorServico.listaDeAdministradores().get();
    }

    @GetMapping("/lista/clientes")
    public List<Cliente> listaClientes() {
        return this.clienteServico.listaDeClientes();
    }
}