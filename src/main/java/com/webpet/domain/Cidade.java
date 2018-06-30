package com.webpet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "cidade")
public class Cidade extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String nome;

    @ManyToOne
    private Estado estado;

    public Cidade() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public void updateParameters(Object entity) {
        Cidade outro = (Cidade) entity;
        this.nome = outro.nome;
        this.estado = outro.estado;
    }
}
