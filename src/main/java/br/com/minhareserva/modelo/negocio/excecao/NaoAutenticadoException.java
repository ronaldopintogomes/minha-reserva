package br.com.minhareserva.modelo.negocio.excecao;

/*
 * Criando por Ronaldo p. gomes
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class NaoAutenticadoException extends RuntimeException {

    public NaoAutenticadoException() {}
    public NaoAutenticadoException(String message) {
        super(message);
    }
}
