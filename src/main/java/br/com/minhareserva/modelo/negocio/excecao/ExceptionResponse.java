package br.com.minhareserva.modelo.negocio.excecao;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;
    private String httpCodeMessage;

    public ExceptionResponse(String message, String details, String httpCodeMessage) {
        super();
        this.timestamp = new Date();
        this.message = message;
        this.details = details;
        this.httpCodeMessage = httpCodeMessage;
    }
}