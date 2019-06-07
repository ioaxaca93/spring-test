/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.ioaxaca.dao;

import com.ioaxaca.ioaxaca.entities.Autor;
import com.ioaxaca.ioaxaca.entities.Libro;
import com.ioaxaca.ioaxaca.entities.Localizacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Israel
 */
@Repository
public class LibroDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public List<Libro> findAll(){
        return entityManager.createQuery("FROM Libro",Libro.class).getResultList();
    }
    @Transactional
    public Libro findByISBN(String isbn){
        return entityManager.find(Libro.class, isbn);
    }
    
    @Transactional
    public Localizacion buscarLibro(Libro libro){
       return entityManager.find(Localizacion.class, libro.getIsbn());

    }
    
    @Transactional
    public Autor bucarAutor(Integer id){
       return entityManager.find(Autor.class, id);

    }

    public List<Autor> findAutores() {
        return entityManager.createQuery("FROM Autor",Autor.class).getResultList();
    }
    
    @Transactional
    public void saveAutor(Autor autor){
        entityManager.persist(autor);
    }
    
    @Transactional
    public void saveLibro(Libro libro){
        entityManager.persist(libro);
    }
    
    @Transactional
    public void saveLocalizacion(Localizacion localizacion){
        entityManager.persist(localizacion);
    }
    
}
