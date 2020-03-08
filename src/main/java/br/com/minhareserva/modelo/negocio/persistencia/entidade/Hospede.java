package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@JsonTypeName("hospede")
@Table(name = "cliente_hospede")
public class Hospede extends Cliente {

}