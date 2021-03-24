package br.com.zupfy.services;

import br.com.zupfy.models.Musica;
import br.com.zupfy.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public Musica cadastrarMusica(Musica musica){
        return musicaRepository.save(musica);
    }
}
