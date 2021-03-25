package br.com.zupfy.services;

import br.com.zupfy.models.Musica;
import br.com.zupfy.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public Musica cadastrarMusica(Musica musica){
        return musicaRepository.save(musica);
    }

    public Musica pesquisarMusicaPeloId(Integer id){
        Optional<Musica> optionalMusica = musicaRepository.findById(id);

        if(optionalMusica.isPresent()){
            return optionalMusica.get();
        }

        throw new RuntimeException("Música não existe");
    }

    public Iterable<Musica> listarMusicas(){
        return musicaRepository.findAll();
    }

    public void deletarMusica(int id){
        musicaRepository.deleteById(id);
    }


}
