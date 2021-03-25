package br.com.zupfy.dtos;

import br.com.zupfy.models.Banda;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BandaAtualizacaoCompletaDTO {

    @NotBlank
    @NotNull
    private String nome;

    @NotNull
    @Min(1000)
    private int nascimento;

    public BandaAtualizacaoCompletaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNascimento() {
        return nascimento;
    }

    public void setNascimento(int nascimento) {
        this.nascimento = nascimento;
    }

    public Banda converterDTOParaBanda(int id){
        Banda banda = new Banda();
        banda.setId(id);
        banda.setNome(this.nome);
        banda.setNascimento(this.nascimento);

        return banda;
    }
}
