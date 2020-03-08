package br.com.minhareserva.modelo.negocio.persistencia.entidade;

/*
 * Criando por Ronaldo p. gomes
 */

import br.com.minhareserva.modelo.negocio.enumeracao.ApartamentoCategoria;
import br.com.minhareserva.modelo.negocio.enumeracao.ApartamentoStatusEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString(of = {"numero", "andar"})
@EqualsAndHashCode(of = {"id", "numero", "andar"})
@Entity
public class Apartamento implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private int numero;
    private int andar;
    @ElementCollection(targetClass = Imagem.class)
    private List<Imagem> imagens;
    @Enumerated(value = EnumType.STRING)
    private ApartamentoStatusEnum status;
    @Enumerated(value = EnumType.STRING)
    private ApartamentoCategoria categoria;
}