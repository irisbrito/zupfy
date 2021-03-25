package br.com.zupfy.services;

import br.com.zupfy.models.Banda;
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

    public Musica atualizarMusica(Musica musica) {
        if (musicaRepository.existsById(musica.getId())) {
            Musica objetoMusica = cadastrarMusica(musica);
            return musica;
        }

        throw new RuntimeException("Musica não encontrada");
    }

    public Musica atualizarParcialMusica(Musica musica){

        Musica objetoMusica  = pesquisarMusicaPeloId(musica.getId());

        if(!objetoMusica.getNomeMusica().equals(musica.getNomeMusica()) && objetoMusica.getNomeMusica() != null ){
            objetoMusica.setNomeMusica(musica.getNomeMusica());
        }

        if(!objetoMusica.getDuracao().equals(musica.getDuracao()) && objetoMusica.getDuracao() != null ){
            objetoMusica.setDuracao(musica.getDuracao());
        }

        if(!objetoMusica.getEnderecoMusica().equals(musica.getEnderecoMusica()) && objetoMusica.getEnderecoMusica() != null ){
            objetoMusica.setEnderecoMusica(musica.getEnderecoMusica());
        }

        return atualizarMusica(objetoMusica);

    }

    public void deletarMusica(int id){
        musicaRepository.deleteById(id);
    }


}
