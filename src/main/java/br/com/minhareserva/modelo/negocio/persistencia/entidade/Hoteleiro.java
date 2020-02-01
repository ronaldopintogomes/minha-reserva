package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@JsonTypeName("hoteleiro")
@Table(name = "cliente_hoteleiro")
public class Hoteleiro extends Cliente {

    private static final long serialVersionUID = 1L;
}