package br.com.minhareserva.controle.rest;

import br.com.minhareserva.modelo.negocio.excecao.ContaExistenteException;
import br.com.minhareserva.modelo.negocio.excecao.ExceptionResponse;
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

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest re) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), re.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ContaExistenteException.class)
    public ResponseEntity<ExceptionResponse> handleResourceCreatedException(ContaExistenteException ex, WebRequest re) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), re.getDescription(false), HttpStatus.CREATED.getReasonPhrase());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.CREATED);
    }
}