package br.com.treinaweb.twprojetos.model;

public enum StatusCliente {
    
    AGUARDANDO_CONTATO("AGUARDANDO_CONTATO"),
    SEM_SIMULACAO("SEM_SIMULACAO"),
    EM_SIMULACAO("EM_SIMULACAO"),
    SIMULACAO_PRONTA("SIMULACAO_PRONTA"),
    NEGADO("NEGADO"),
    EM_APROVACAO("EM_APROVACAO"),
    APROVADO("APROVADO"),
    VENDA_CONCLUIDA("VENDA_CONCLUIDA");

    private String descricao; 

    
    private StatusCliente(String descricao) {
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    

    

    

    
}
