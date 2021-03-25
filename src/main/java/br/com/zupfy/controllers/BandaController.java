package br.com.zupfy.controllers;

import br.com.zupfy.models.Banda;
import br.com.zupfy.services.BandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bandas/")
public class BandaController {

    @Autowired
    private BandaService bandaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Banda registrarBanda(@RequestBody Banda banda){
        return bandaService.adicionarBanda(banda);
    }

    @GetMapping
    public List<Banda> listarBandas(){
        return bandaService.retornarTodasAsBandas();
    }

    @GetMapping("{id}/")
    public Banda buscarBandaPeloId(@PathVariable int id){
        return bandaService.buscarBandaPeloId(id);
    }
}
