package br.com.minhareserva.controle;

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
public class ClienteControle {

    @Autowired
    private ClienteServico clienteServico;

    @PostMapping("/cliente/login")
    public Cliente login(@RequestBody Cliente cliente) {
        System.out.println(cliente.getContato().getEmail());
        cliente = this.clienteServico.autenticar(cliente.getContato().getEmail(), cliente.getSenha());
        return cliente;
    }

    @GetMapping("/clientes")
    public List<Cliente> listaClientes() {
        return this.clienteServico.listaDeClientes();
    }

    @PutMapping("/cadastro/hospede")
    public void salvarHospede(Hospede hospede) {
        this.clienteServico.cadastrarCliente(hospede);
    }
}