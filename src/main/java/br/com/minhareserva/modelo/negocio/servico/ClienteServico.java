package br.com.minhareserva.modelo.negocio.servico;

import br.com.minhareserva.modelo.negocio.persistencia.entidade.Cliente;
import br.com.minhareserva.modelo.negocio.persistencia.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Cliente autenticar(String email, String senha) throws NullPointerException {
        return this.clienteRepositorio.buscaClientePorEmailESenha(email, senha);
    }

    @Transactional
    public void cadastrarCliente(Cliente cliente) {

    }

    public List<Cliente> listaDeClientes() {
        return this.clienteRepositorio.findAll();
    }
}
