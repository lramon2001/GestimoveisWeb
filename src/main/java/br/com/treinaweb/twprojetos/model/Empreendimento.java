package br.com.treinaweb.twprojetos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import br.com.treinaweb.twprojetos.model.Endereço;

@Entity
public class Empreendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String construtora;

    @Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#.##0,00")
    private Double valorDoImovel;

    @Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#.##0,00")
    private Double comisssao;

    @Column(nullable = false)
    private String tipoDoImovel;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk", nullable = false)
    private Endereço endereco;
    
    @ManyToMany
    @JoinTable(
        name = "empreendimento_cliente",
        joinColumns = @JoinColumn(name = "projeto_id_fk"),
        inverseJoinColumns = @JoinColumn(name="cliente_id_fk")
    )
    private List<Cliente> clientes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConstrutora() {
        return construtora;
    }

    public void setConstrutora(String construtora) {
        this.construtora = construtora;
    }

    public Double getValorDoImovel() {
        return valorDoImovel;
    }

    public void setValorDoImovel(Double valorDoImovel) {
        this.valorDoImovel = valorDoImovel;
    }

    public Double getComisssao() {
        return comisssao;
    }

    public void setComisssao(Double comisssao) {
        this.comisssao = comisssao;
    }

    public String getTipoDoImovel() {
        return tipoDoImovel;
    }

    public void setTipoDoImovel(String tipoDoImovel) {
        this.tipoDoImovel = tipoDoImovel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereço getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereço endereco) {
        this.endereco = endereco;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    
}
