package br.com.zupfy.services;

import br.com.zupfy.models.Banda;
import br.com.zupfy.repositories.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandaService {

    @Autowired
    private BandaRepository bandaRepository;

    public Banda adicionarBanda(Banda banda){
        try{
            Banda obj = bandaRepository.save(banda);
            return banda;
        } catch (Exception error){
            throw new RuntimeException("Objeto já cadastrado");
        }
    }

    public List<Banda> retornarTodasAsBandas(){
        return (List<Banda>) bandaRepository.findAll();
    }

    public Banda buscarBandaPeloId(int id){
        Optional<Banda> optionalBanda = bandaRepository.findById(id);

        if(optionalBanda.isPresent()){
            return optionalBanda.get();
        }

        throw new RuntimeException("Banda não encontrada");
    }

    public Banda atualizarBanda(Banda banda){
        if(bandaRepository.existsById(banda.getId())){
            Banda objBanda = adicionarBanda(banda);
            return banda;
        }

        throw new RuntimeException("Banda não encontrada");
    }
}
