/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.ioaxaca.controllers;

import com.ioaxaca.ioaxaca.dao.LibroDao;
import com.ioaxaca.ioaxaca.entities.Autor;
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
public class AutoresController {
    
    @Autowired
    private LibroDao libroDao;
    
    @GetMapping("/autores")
    public String autores(Model model){
        model.addAttribute("autores", libroDao.findAutores());
        return "autores";
    }
    
    @GetMapping("/add_autor")
    public String addAutores(Model model){
        model.addAttribute("autor", new Autor());
        return "add_autor";
    }
    
    @PostMapping("/add_autor")
    public String addAutor(Autor autor,Model model){
        libroDao.saveAutor(autor);
        model.addAttribute("autores", libroDao.findAutores());
        return "autores";
    }
}
