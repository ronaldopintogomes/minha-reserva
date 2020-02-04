package br.com.minhareserva.controle.rest;

import br.com.minhareserva.modelo.negocio.persistencia.entidade.Hospede;
import br.com.minhareserva.modelo.negocio.servico.ClienteServico;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/hospede")
public class HospedeRest {

    @Autowired
    private ClienteServico clienteServico;
}