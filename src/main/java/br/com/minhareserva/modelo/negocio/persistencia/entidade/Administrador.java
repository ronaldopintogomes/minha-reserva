package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@EqualsAndHashCode(of ={"id", "nome"})
public class Administrador implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;
}