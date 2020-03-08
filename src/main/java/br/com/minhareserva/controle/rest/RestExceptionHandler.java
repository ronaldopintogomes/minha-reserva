package br.com.minhareserva.controle.rest;

import br.com.minhareserva.modelo.negocio.excecao.ContaExistenteException;
import br.com.minhareserva.modelo.negocio.excecao.ExceptionResponse;
import br.com.minhareserva.modelo.negocio.excecao.NaoAutenticadoException;
import br.com.minhareserva.modelo.negocio.excecao.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author Ronaldo p. gomes
 */
@RestController
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class, ContaExistenteException.class, NaoAutenticadoException.class})
    public ResponseEntity<ExceptionResponse> handleResourceCreatedException(RuntimeException exception, WebRequest request) {
        HttpStatus status = httpStatus(exception);
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), request.getDescription(false), status.getReasonPhrase());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, status);
    }

    private HttpStatus httpStatus(RuntimeException rutimeException) {
        if(rutimeException instanceof ResourceNotFoundException)
            return HttpStatus.NOT_FOUND;
        if(rutimeException instanceof ContaExistenteException)
            return HttpStatus.NOT_ACCEPTABLE;
        if(rutimeException instanceof NaoAutenticadoException)
            return HttpStatus.UNAUTHORIZED;
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}