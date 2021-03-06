package br.com.zupfy.controllers;

import br.com.zupfy.dtos.CadastroDeMusicaDTO;
import br.com.zupfy.dtos.MusicaAtualizacaoCompletaDTO;
import br.com.zupfy.dtos.MusicaAtualizacaoParcialDTO;
import br.com.zupfy.dtos.MusicaDTO;
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
    public MusicaDTO registrarMusica(@RequestBody @Valid CadastroDeMusicaDTO musicaDTO){
        Musica musica = musicaDTO.converterDTOParaModel();
        Musica objeto = musicaService.salvarNovaMusica(musica);
        return MusicaDTO.converterModelParaDTOComAlbum(objeto);
    }

    @GetMapping("{id}/")
    public MusicaDTO buscarMusicaPeloId(@PathVariable int id){
        Musica musica = musicaService.pesquisarMusicaPeloId(id);
        return MusicaDTO.converterModelParaDTOComAlbum(musica);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Iterable<Musica> listarMusicas(){
        return musicaService.listarMusicas();
    }

    @PutMapping("{id}/")
    public Musica atualizarMusica(@PathVariable int id,
                                  @RequestBody @Valid MusicaAtualizacaoCompletaDTO musicaDTO){
        Musica musica = musicaDTO.converterMusicaParaDTO(id);

        return musicaService.atualizarMusica(musica);
    }

    @PatchMapping("{id}/")
    public Musica atualizarMusicaParcial(@PathVariable int id,
                                  @RequestBody @Valid MusicaAtualizacaoParcialDTO musicaDTO){
        Musica musica = musicaDTO.converterMusicaParaDTO(id);

        return musicaService.atualizarParcialMusica(musica);
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMusica(@PathVariable int id){
        musicaService.deletarMusica(id);
    }
}
