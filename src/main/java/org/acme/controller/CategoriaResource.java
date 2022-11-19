package org.acme.controller;

import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;
import org.acme.model.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Transactional
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        //System.out.println("Excluindo " + id);
        Categoria.deleteById(id);
    }

    @GET
    @Path("{id}")
    public Categoria getById(@PathParam("id") long id) {
        return Categoria.findById(id);
    }

    @Transactional
    @POST
    public void insert(Categoria categoria) {
        Categoria.persist(categoria);
    }

    @Transactional
    @Path("/{id}")
    @PUT
    public void update(@PathParam("id") long id, Categoria categoria) {
//        var categoriaLocalizada =(Categoria) Categoria.findById(id);
//        categoriaLocalizada.descricao = categoria.descricao;
//        categoriaLocalizada.sigla = categoria.sigla;
//        categoriaLocalizada.persist();
        try {
            var em = JpaOperations.INSTANCE.getEntityManager();
            em.merge(categoria);
        }catch (OptimisticLockException e){
            throw  new WebApplicationException("registro alterado po outro usuário",e);
        }
    }

    @GET
    public List<Categoria> getAll(){
        return Categoria.listAll();
    }
}