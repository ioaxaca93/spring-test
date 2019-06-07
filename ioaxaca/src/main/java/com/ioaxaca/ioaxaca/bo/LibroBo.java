/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.ioaxaca.bo;

import com.ioaxaca.ioaxaca.dao.LibroDao;
import com.ioaxaca.ioaxaca.entities.Autor;
import com.ioaxaca.ioaxaca.models.InfoContend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Israel
 */
@Service
public class LibroBo {
    @Autowired
    private LibroDao libroDao;
    
    public void guargarLibroNuevo(InfoContend info,Integer id){
        Autor autor = libroDao.bucarAutor(id);
        info.getLibro().setAutor(autor);
        libroDao.saveLibro(info.getLibro());
        info.getLocalizacion().setIsbn(info.getLibro().getIsbn());
        libroDao.saveLocalizacion(info.getLocalizacion());
    }
}
