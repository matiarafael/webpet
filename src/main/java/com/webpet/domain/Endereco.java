package com.webpet.domain;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "endereco")
public class Endereco extends AbstractEntity {

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private BigInteger numero;

    @Column(length = 10, nullable = false)
    private String cep;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

    @ManyToOne
    private Cidade cidade;
    
    public Endereco() {
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public void updateParameters(Object entity) {
        Endereco outro = (Endereco) entity;
        this.logradouro = outro.logradouro;
        this.numero = outro.numero;
        this.cep = outro.cep;
        this.tipoEndereco = outro.tipoEndereco;
        this.cidade = outro.cidade;
    }

}
