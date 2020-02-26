package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private String numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String Estado;
}