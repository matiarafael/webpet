package com.webpet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "pessoafisica")
public class PessoaFisica extends Pessoa {

    @Column(length = 15, nullable = false, unique = true)
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public void updateParameters(Object entity) {
        PessoaFisica outro = (PessoaFisica) entity;
        this.cpf = outro.cpf;
    }
    
}
