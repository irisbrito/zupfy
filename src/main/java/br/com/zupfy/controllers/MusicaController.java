package br.com.zupfy.controllers;

import br.com.zupfy.models.Musica;
import br.com.zupfy.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("musicas/")
public class MusicaController {

    @Autowired
    MusicaService musicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Musica cadastrarMusica(@RequestBody Musica musica){
        return musicaService.cadastrarMusica(musica);
    }
}
