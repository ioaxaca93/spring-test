/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.ioaxaca.models;

import com.ioaxaca.ioaxaca.entities.Autor;
import com.ioaxaca.ioaxaca.entities.Libro;
import com.ioaxaca.ioaxaca.entities.Localizacion;

/**
 *
 * @author Israel
 */
public class InfoContend {
    
    private Libro libro;
    private Localizacion localizacion;
    private Integer autor;

    public InfoContend() {
        libro=new Libro();
        localizacion=new Localizacion();
    }
    
    
    
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public Integer getAutor() {
        return autor;
    }

    public void setAutor(Integer autor) {
        this.autor = autor;
    }
    
    
}
