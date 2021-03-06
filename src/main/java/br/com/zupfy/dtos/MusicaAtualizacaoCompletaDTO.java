package br.com.zupfy.dtos;

import br.com.zupfy.models.Musica;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class MusicaAtualizacaoCompletaDTO {

    @NotNull
    @NotBlank
    private String nomeMusica;

    @NotNull
    private LocalTime duracao;

    @NotNull
    private String enderecoMusica;

    public MusicaAtualizacaoCompletaDTO() {
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

    public Musica converterMusicaParaDTO(int id){
        Musica musica = new Musica();
        musica.setId(id);
        musica.setNomeMusica(this.nomeMusica);
        musica.setDuracao(this.duracao);
        musica.setEnderecoMusica(this.enderecoMusica);

        return musica;
    }
}
