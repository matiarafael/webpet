package com.webpet.domain;

import com.webpet.util.Criptography;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity {

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String senha;

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = Criptography.encrypt(senha);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = Criptography.encrypt(senha);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + '}';
    }

    @Override
    public void updateParameters(Object entity) {
        Usuario other = (Usuario) entity;
        this.email = other.email;
        this.senha = other.senha;
    }
}
