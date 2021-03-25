package br.com.zupfy.controllers;

import br.com.zupfy.dtos.MusicaAtualizacaoCompletaDTO;
import br.com.zupfy.models.Banda;
import br.com.zupfy.models.Musica;
import br.com.zupfy.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping("{id}/")
    public Musica buscarMusicaPeloId(@PathVariable int id){
        return musicaService.pesquisarMusicaPeloId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Iterable<Musica> listarMusicas(){
        return musicaService.listarMusicas();
    }

    @PutMapping("{id}/")
    public Musica atualizarMusica(@PathVariable int id, @RequestBody @Valid MusicaAtualizacaoCompletaDTO musicaDTO){
        Musica musica = musicaDTO.converterMusicaParaDTO(id);

        return musicaService.atualizarMusica(musica);
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMusica(@PathVariable int id){
        musicaService.deletarMusica(id);
    }
}
