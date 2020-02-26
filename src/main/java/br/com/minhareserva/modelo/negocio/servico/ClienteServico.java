package br.com.minhareserva.modelo.negocio.servico;

import br.com.minhareserva.modelo.negocio.excecao.ContaExistenteException;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Cliente;
import br.com.minhareserva.modelo.negocio.persistencia.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Transactional(readOnly = true)
    public Optional<Cliente> autenticar(String email, String senha) {
        Optional<Cliente> clienteOptional = Optional.ofNullable(clienteRepositorio.buscaClientePorEmailESenha(email, senha));
        return clienteOptional;
    }

    @Transactional(readOnly = false)
    public void cadastraCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> getUsuarios() {
        return this.clienteRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Cliente> getUsuario(Long id) {
        return this.clienteRepositorio.findById(id);
    }

    @Transactional(readOnly = true)
    public boolean existeConta(String email, String senha) {
        if(Optional.ofNullable(clienteRepositorio.buscaClientePorEmailESenha(email, senha)).isPresent())
            return true;
        return false;
    }
}