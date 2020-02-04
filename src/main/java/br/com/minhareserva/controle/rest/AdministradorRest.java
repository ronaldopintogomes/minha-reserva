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

@RestController
@NoArgsConstructor
@RequestMapping("/administrador")
public class AdministradorRest {

    @Autowired
    private ClienteServico clienteServico;
    @Autowired
    private AdministradorServico administradorServico;

    @GetMapping("/lista/clientes")
    public List<Cliente> listaClientes() {
        Administrador administrador = new Administrador();
        administrador.setNome("Ronaldo");
        administrador.setSenha("ronaldojava");
        Contato contato = new Contato();
        contato.setEmail("ronaldo.softsystem@gmail.com");
        List<String> celulares = new ArrayList<String>();
        celulares.add("988075552");
        contato.setCelulares(celulares);
        administrador.setContato(contato);
        Endereco endereco = new Endereco();
        endereco.setRua("05");
        endereco.setNumero("08");
        endereco.setBairro("Jardim maua");
        endereco.setCidade("manaus");
        endereco.setEstado("am");
        administrador.setEndereco(endereco);
        try {
            administradorServico.consultaExistenciaDeConta(contato.getEmail(), administrador.getSenha());
            administradorServico.cadastrar(administrador);
        } catch (AdministradorException e) {
            e.getMessage();
        }
        return this.clienteServico.listaDeClientes();
    }
}