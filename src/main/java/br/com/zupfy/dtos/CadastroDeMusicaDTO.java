package br.com.zupfy.dtos;

import br.com.zupfy.models.Banda;
import br.com.zupfy.models.Musica;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class CadastroDeMusicaDTO {

    @NotBlank
    private String nomeMusica;
    @NotNull
    private LocalTime duracao;
    @NotBlank
    private String enderecoMusica;
    @NotNull(message = "Id da banda é obrigatório")
    private int bandaid;

    public CadastroDeMusicaDTO() {
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
    }

    public String getEnderecoMusica() {
        return enderecoMusica;
    }

    public void setEnderecoMusica(String enderecoMusica) {
        this.enderecoMusica = enderecoMusica;
    }

    public int getBandaid() {
        return bandaid;
    }

    public void setBandaid(int bandaid) {
        this.bandaid = bandaid;
    }

    public Musica converterDTOParaModel(){
        Musica musica = new Musica();
        musica.setNomeMusica(this.nomeMusica);
        musica.setDuracao(this.duracao);
        musica.setEnderecoMusica(this.enderecoMusica);

        Banda banda = new Banda();
        banda.setId(this.bandaid);
        musica.setBanda(banda);

        return musica;
    }
}
