package br.com.zupfy.dtos;

import br.com.zupfy.models.Musica;

import java.time.LocalTime;

public class MusicaDTO {

    private int id;
    private String nomeMusica;
    private LocalTime duracao;
    private String enderecoMusica;

    private BandaDTO banda;

    private AlbumResumeDTO album;


    public MusicaDTO() {
    }

    public BandaDTO getBanda() {
        return banda;
    }

    public void setBanda(BandaDTO banda) {
        this.banda = banda;
    }

    public AlbumResumeDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumResumeDTO album) {
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static MusicaDTO converterModelParaDTO(Musica musica){
        MusicaDTO musicaDTO = new MusicaDTO();

        musicaDTO.setNomeMusica(musica.getNomeMusica());
        musicaDTO.setEnderecoMusica(musica.getEnderecoMusica());
        musicaDTO.setDuracao(musica.getDuracao());
        musicaDTO.setId(musica.getId());
        musicaDTO.setBanda(BandaDTO.converterModelParaDTO(musica.getBanda()));
        // musicaDTO.setAlbum(AlbumResumeDTO.converterModelParaDTO(musica.getAlbum()));

        return musicaDTO;

    }

    public static MusicaDTO converterModelParaDTOComAlbum(Musica musica){
        MusicaDTO musicaDTO = new MusicaDTO();

        musicaDTO.setNomeMusica(musica.getNomeMusica());
        musicaDTO.setEnderecoMusica(musica.getEnderecoMusica());
        musicaDTO.setDuracao(musica.getDuracao());
        musicaDTO.setId(musica.getId());
        musicaDTO.setBanda(BandaDTO.converterModelParaDTO(musica.getBanda()));
        musicaDTO.setAlbum(AlbumResumeDTO.converterModelParaDTO(musica.getAlbum()));

        return musicaDTO;

    }
}

