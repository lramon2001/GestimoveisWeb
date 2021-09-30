package br.com.treinaweb.twprojetos.model;

public enum EstadoCivil {

    SOLTEIRO("SOLTEIRO"),
    CASADO("CASADO"),
    SEPARADO("OUTRO"),
    DIVORCIADO("DIVORCIADO"),
    VIUVO("VIUVO");

    private String descricao;

    private EstadoCivil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    


}
