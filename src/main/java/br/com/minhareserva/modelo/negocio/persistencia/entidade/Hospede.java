package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import javax.persistence.Table;


@SuppressWarnings("ALL")
@Entity
@JsonTypeName("hospede")
@Table(name = "cliente_hospede")
public class Hospede extends Cliente {

    private static final long serialVersionUID = 1L;

}