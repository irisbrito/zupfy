package br.com.zupfy.services;

import br.com.zupfy.models.Banda;
import br.com.zupfy.repositories.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class BandaService {

    @Autowired
    private BandaRepository bandaRepository;

    public Banda adicionarBanda(Banda banda){
        try{
            Banda obj = bandaRepository.save(banda);
            return banda;
        } catch (Exception error){
            throw new RuntimeException();
        }
    }
}
