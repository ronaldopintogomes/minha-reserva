package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;
}