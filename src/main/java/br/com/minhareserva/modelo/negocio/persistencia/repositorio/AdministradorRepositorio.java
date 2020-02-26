package br.com.minhareserva.modelo.negocio.persistencia.repositorio;

import br.com.minhareserva.modelo.negocio.persistencia.entidade.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {

    @Query("Select adm From Administrador adm where adm.contato.email =:email and adm.senha =:senha")
    public Administrador buscaAdministradorPorEmailESenha(@Param("email") String email, @Param("senha") String senha);
}