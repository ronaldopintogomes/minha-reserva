package br.com.minhareserva.modelo.negocio.excecao;

/*
 * Criando por Ronaldo p. gomes
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class ContaExistenteException extends RuntimeException {

    public ContaExistenteException() {}
    public ContaExistenteException(String message) {
        super(message);
    }
}