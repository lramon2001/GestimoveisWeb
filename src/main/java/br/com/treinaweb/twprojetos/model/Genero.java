package br.com.treinaweb.twprojetos.model;

public enum Genero {
    MASCULINO("MASCULINO"),
    FEMININO("FEMININO"),
    OUTRO("OUTRO");

    private String descricao;


    
    private Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
}
