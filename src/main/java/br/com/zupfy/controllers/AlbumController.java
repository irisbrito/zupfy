package br.com.zupfy.controllers;

import br.com.zupfy.dtos.AlbumMusicasDetailDTO;
import br.com.zupfy.models.Album;
import br.com.zupfy.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("albuns/")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @PostMapping
    public Album salvarAlbum(@RequestBody @Valid Album album){
       return albumService.salvarAlbum(album);
    }

    @GetMapping("{id}/")
    public AlbumMusicasDetailDTO pesquisarAlbumPorId(@PathVariable int id){
        Album album = albumService.buscarPorId(id);

        return AlbumMusicasDetailDTO.converterModelParaDTO(album);
    }

}
