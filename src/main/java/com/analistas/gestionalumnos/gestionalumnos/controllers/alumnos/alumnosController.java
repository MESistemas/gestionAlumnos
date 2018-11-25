/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.alumnos;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.alumno.Alumno;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.services.alumno.IAlumnoService;
import com.analistas.gestionalumnos.gestionalumnos.services.curso.ICursoService;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author matia
 */
@Controller
@SessionAttributes("alumno")
public class alumnosController {

    @Autowired
    ICursoService servCurso;

    @Autowired
    IAlumnoService servAlumno;

    //Me permite guardar el curso actual en el que estoy agregando/modificando/borrando alumno
    private Curso curso;

    private SimpleDateFormat formateador;

    @GetMapping({"/secciones/cursos"})
    public String Elegir_Curso(Map<String, Object> m) {

        List<Curso> listado = servCurso.buscarTodo();

        m.put("cursos", listado);

        return "/secciones/cursos";
    }

    @RequestMapping(value = "/secciones/alumnos/{curso}", method = RequestMethod.GET)
    public String Listar_Por_Curso(Map<String, Object> m, @PathVariable("curso") Curso curso) {
        List<Alumno> listado = servAlumno.buscarPorCurso(curso);

        this.curso = curso;

        m.put("alumnos", listado);
        m.put("curso", curso.getId());
        m.put("nombreCurso", curso);

        return "/secciones/alumnos";
    }

    @GetMapping("/secciones/busqueda_alumno_por_dni")
    public String Buscar_Alumno_Por_Dni(@RequestParam(name = "dni", required = false) String dni, Map m) {

        List<Alumno> listado = servAlumno.buscarPorDni(dni, curso);
       
            
            
            
            m.put("alumnos", listado);
            m.put("curso", curso.getId());
            m.put("nombreCurso", curso);
        

        return "/secciones/alumnos";
    }

    //ABM Alumno
    @GetMapping("/secciones/formulario_alumno")
    public String Agregar_Alumno(Map m, @RequestParam(name = "genero", required = false) String genero) {

        Alumno alumno = new Alumno();

        m.put("alumno", alumno);
        m.put("curso", curso);

        return "/secciones/formulario_alumno";
    }

    @PostMapping("/secciones/formulario_alumno")
    public String Guardar_Alumno(@Valid Alumno alumno, BindingResult result, Map m) {

        m.put("curso", curso);

        if (result.hasErrors()) {

            return "/secciones/formulario_alumno";

        }

        alumno.setCurso(curso);
        servAlumno.save(alumno);
        return "redirect:/secciones/alumnos/" + curso.getId();
    }

    @GetMapping({"/secciones/formulario_alumno/{id}"})
    public String Editar_Alumno(@PathVariable(value = "id") int id, Map m) {
        Alumno alumno = new Alumno();
        alumno.setCurso(curso);
        alumno = servAlumno.buscarPorId(id);

        m.put("alumno", alumno);
        m.put("curso", curso);

        return "/secciones/formulario_alumno";
    }

}
