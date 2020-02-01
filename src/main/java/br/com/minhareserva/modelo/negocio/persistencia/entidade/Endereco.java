package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    @Getter @Setter
    private String numero;
    @Getter @Setter
    private String rua;
    @Getter @Setter
    private String bairro;
    @Getter @Setter
    private String cidade;
    @Getter @Setter
    private String Estado;
}