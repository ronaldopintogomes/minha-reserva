package br.com.minhareserva.modelo.negocio.persistencia.repositorio;

import br.com.minhareserva.modelo.negocio.persistencia.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    @Query("Select c from Cliente c where c.contato.email = :email and c.senha = :senha")
    public Cliente buscaClientePorEmailESenha(@Param("email") String email, @Param("senha") String senha);
}