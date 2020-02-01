package br.com.minhareserva.modelo.negocio.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.minhareserva.modelo.negocio.persistencia.entidade.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    @Transactional(readOnly = true)
    @Query("Select c from Cliente c where c.contato.email = :email and c.senha = :senha")
    public Cliente buscaClientePorEmailESenha(@Param("email") String email, @Param("senha") String senha);
}