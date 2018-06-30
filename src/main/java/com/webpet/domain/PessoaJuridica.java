package com.webpet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "pessoajuridica")
public class PessoaJuridica extends Pessoa {

    @Column(length = 20, nullable = false, unique = true)
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void updateParameters(Object entity) {
        PessoaJuridica outro = (PessoaJuridica) entity;
        this.cnpj = outro.cnpj;
    }

}
