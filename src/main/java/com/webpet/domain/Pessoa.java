package com.webpet.domain;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author fernando
 */
@MappedSuperclass
public abstract class Pessoa extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String nome;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;
    
    @OneToOne
    private Usuario usuario;
    
    @ManyToMany
    @JoinTable(name = "pessoa_endereco", 
            joinColumns = 
                    @JoinColumn(name = "pessoa_id", referencedColumnName = "id"), 
            inverseJoinColumns = 
                    @JoinColumn(name = "endereco_id", referencedColumnName = "id"))
    private Set<Endereco> enderecos;
    
    @ManyToMany
    @JoinTable(name = "pessoa_telefone", 
            joinColumns = 
                    @JoinColumn(name = "pessoa_id", referencedColumnName = "id"),
            inverseJoinColumns = 
                    @JoinColumn(name = "telefone_id", referencedColumnName = "id"))
    private Set<Telefone> telefones;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }
}
