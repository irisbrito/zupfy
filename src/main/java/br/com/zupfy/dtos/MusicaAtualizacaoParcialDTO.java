package br.com.zupfy.dtos;

import br.com.zupfy.models.Musica;

import java.time.LocalTime;

public class MusicaAtualizacaoParcialDTO {

    private String nomeMusica;
    private LocalTime duracao;
    private String enderecoMusica;

    public MusicaAtualizacaoParcialDTO() {
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
        musica.setEnderecoMusica(this.enderecoMusica);

        return musica;
    }
}
