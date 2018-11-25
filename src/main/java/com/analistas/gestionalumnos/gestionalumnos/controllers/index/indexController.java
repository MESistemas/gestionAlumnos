/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.index;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author matia
 */
@Controller
public class indexController {
    
    private Date calendario;
    
    @GetMapping({"/","/index"})
    public String indexController(Map m){
        
        calendario = new Date();
        SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formateo.format(calendario);
        
        m.put("fecha", fecha);
        
        return "/index";
    }
    
}


