package br.com.minhareserva.modelo.negocio.persistencia.entidade;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@JsonTypeName("administrador")
@Table(name = "cliente_administrador")
public class Administrador extends Cliente {

    private static final long serialVersionUID = 1L;
}