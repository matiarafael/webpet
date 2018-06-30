package com.webpet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "pais")
public class Pais extends AbstractEntity {

    @Column(length = 100, nullable = false, unique = true)
    private String nome;

    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void updateParameters(Object entity) {
        Pais outro = (Pais) entity;
        this.nome = outro.nome;
    }

}
