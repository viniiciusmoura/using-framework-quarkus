package org.acme.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Produto extends AbastractEntity{

    public  String nome;

    @ManyToOne
    public Categoria categoria;

    public void setNome(String nome) {
        Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.nome=nome.trim().toUpperCase();
    }
}
