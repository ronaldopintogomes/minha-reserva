package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@ToString(of = {"numero", "rua", "bairro", "cidade", "estado"})
@EqualsAndHashCode(of = {"id", "numero", "rua", "bairro", "cidade", "estado"})
@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
}