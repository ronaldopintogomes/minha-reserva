package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private int cnpj;
    private Endereco endereco;
    @ElementCollection(targetClass = Imagem.class)
    private List<Imagem> imagens;
}