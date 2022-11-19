package org.acme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Entity
public class Produto extends AbastractEntity{
    @Version
    @Column(columnDefinition = "int default 0")
    public long version =0L;

    public String nome;

    @ManyToOne
    public Categoria categoria;


}
