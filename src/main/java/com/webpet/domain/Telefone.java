package com.webpet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "telefone")
public class Telefone extends AbstractEntity {

    @Column(length = 12, nullable = false)
    private String numero;

    @Column(length = 2, nullable = false)
    private String ddd;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

    public Telefone() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    @Override
    public void updateParameters(Object entity) {
        Telefone outro = (Telefone) entity;
        this.numero = outro.numero;
        this.ddd = outro.ddd;
        this.tipoTelefone = outro.tipoTelefone;
    }

}
