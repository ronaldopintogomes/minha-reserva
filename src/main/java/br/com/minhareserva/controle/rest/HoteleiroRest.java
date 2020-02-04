package br.com.minhareserva.controle.rest;

import br.com.minhareserva.modelo.negocio.persistencia.entidade.Hotel;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/hoteleiro")
public class HoteleiroRest {

    @PutMapping("/cadastro/hotel")
    public void cadastrarHotel(@RequestBody Hotel hotel) {

    }

    @GetMapping("/hoteis")
    public List<Hotel> getHoteis() {
        List<Hotel> lista =null;
        return lista;
    }
}