package br.com.zupfy.dtos;

import br.com.zupfy.models.Album;
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
    private int bandaId;
    @NotNull
    private AlbumDTO album;

    private int albumId;

    private String nomeAlbum;

    private int anoLancamento;

    public CadastroDeMusicaDTO() {
    }

    public int getBandaId() {
        return bandaId;
    }

    public void setBandaId(int bandaId) {
        this.bandaId = bandaId;
    }

    public AlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
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
        return bandaId;
    }

    public void setBandaid(int bandaId) {
        this.bandaId = bandaId;
    }

    public Musica converterDTOParaModel(){
        Musica musica = new Musica();
        musica.setNomeMusica(this.nomeMusica);
        musica.setDuracao(this.duracao);
        musica.setEnderecoMusica(this.enderecoMusica);

        Banda banda = new Banda();
        banda.setId(this.bandaId);
        musica.setBanda(banda);

        musica.setAlbum(this.album.converterDTOParaModel());

        /*Album album = new Album();
        album.setId(this.albumId);
        album.setNome(this.nomeAlbum);
        album.setAnoLancamento(this.anoLancamento);
        musica.setAlbum(album);
*/
        return musica;
    }
}
