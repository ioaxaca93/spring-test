/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.ioaxaca.controllers;

import com.ioaxaca.ioaxaca.bo.LibroBo;
import com.ioaxaca.ioaxaca.dao.LibroDao;
import com.ioaxaca.ioaxaca.entities.Libro;
import com.ioaxaca.ioaxaca.models.InfoContend;
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
public class LibroController {
    
    @Autowired
    private LibroDao libroDao;
    @Autowired
    private LibroBo LibroBo;
    
    @GetMapping("/libros")
    public String home(Model model){
        model.addAttribute("libros",libroDao.findAll());
        return "lista_libros";
    }
    
    @GetMapping("/nuevo_libro")
    public String nuevo(Model model){
        model.addAttribute("info",new InfoContend());
        model.addAttribute("autores", libroDao.findAutores());
        return "add_book";
    }
    
    @PostMapping("/nuevo_libro")
    public String nuevoLibro(Model model,InfoContend info,Integer autor){
        LibroBo.guargarLibroNuevo(info, autor);
        model.addAttribute("libros",libroDao.findAll());
        return "lista_libros";
    }
}
