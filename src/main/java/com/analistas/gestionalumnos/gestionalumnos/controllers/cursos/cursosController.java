/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.cursos;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.services.curso.ICursoService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Matias
 */
@Controller
@SessionAttributes("curso")
public class cursosController {
    
    @Autowired
    ICursoService servCurso;
    
    //BM Curso
    @PostMapping("/secciones/formulario_curso")
    public String Guardar_Curso(@Valid Curso curso) {
        servCurso.save(curso);
        return "redirect:/secciones/cursos";
    }

    @GetMapping({"/secciones/formulario_curso/{id}"})
    public String Editar_Curso(@PathVariable(value = "id") int id, Map m) {
        Curso curso = new Curso();
        curso = servCurso.buscarPorId(id);

        m.put("division", curso.getDivision());
        m.put("curso", curso);

        return "/secciones/formulario_curso";
    }
    
}
