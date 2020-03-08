package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@ToString(of = {"nome", "cnpj"})
@EqualsAndHashCode(of = {"id", "nome", "cnpj"})
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private int cnpj;
    private Contato contato;
    private Endereco endereco;
    @ElementCollection(targetClass = Imagem.class)
    private List<Imagem> imagens;
    private String descricao;
    @ElementCollection(targetClass = Apartamento.class)
    private List<Apartamento> apartamentos;
}