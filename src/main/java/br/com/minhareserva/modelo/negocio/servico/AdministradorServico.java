package br.com.minhareserva.modelo.negocio.servico;

import br.com.minhareserva.modelo.negocio.excecao.AdministradorException;
import br.com.minhareserva.modelo.negocio.persistencia.entidade.Administrador;
import br.com.minhareserva.modelo.negocio.persistencia.repositorio.AdministradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AdministradorServico {

    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    public boolean consultaExistenciaDeConta(String email, String senha) {
        boolean retorno = false;
        Optional<Administrador> administradorOptional = Optional.ofNullable(administradorRepositorio.buscaAdministradorPorEmailESenha(email, senha));
        if(administradorOptional.isPresent())
            retorno = true;
        return retorno;
    }

    @Transactional(readOnly = false)
    public void cadastrar(Administrador administrador) throws AdministradorException {
        Optional<Administrador> administradorOptional = Optional.ofNullable(administrador);
        administradorOptional.ifPresent(adm -> {
           administradorRepositorio.save(adm);
        });
    }

}