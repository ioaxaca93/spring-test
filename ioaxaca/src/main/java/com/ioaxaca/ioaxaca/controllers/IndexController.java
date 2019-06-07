/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.ioaxaca.controllers;

import com.ioaxaca.ioaxaca.dao.LibroDao;
import com.ioaxaca.ioaxaca.entities.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Israel
 */
@Controller
public class IndexController {
    @Autowired
    private LibroDao libroDao;
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("libros",libroDao.findAll());
        model.addAttribute("libro_selectd", new Libro());
        return "index";
    }
    
    @PostMapping("/search")
    public String buscar(Libro libro_selectd,Model model){
        libro_selectd=libroDao.findByISBN(libro_selectd.getIsbn());
        model.addAttribute("libro",libro_selectd);
        model.addAttribute("localizacion", libroDao.buscarLibro(libro_selectd));
        return "detalle";
    }
}
