/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.agenda;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.agenda.Agenda;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.services.agenda.IAgendaService;
import com.analistas.gestionalumnos.gestionalumnos.services.materia.IMateriaService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.text.SimpleDateFormat;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Matias
 */
@Controller
@SessionAttributes("agenda")
public class agendasController {

    @Autowired
    IAgendaService servAgenda;

    @Autowired
    IMateriaService servMateria;

    private Materia materia;

    private SimpleDateFormat formateador;

    private Agenda agenda;

    @GetMapping({"secciones/agendas/{materia}"})
    public String Ver_Agenda_de_Materia_Elegida(Map m, @PathVariable("materia") Materia materia) {

        List<Agenda> listado = servAgenda.buscarPorMateria(materia);

        this.materia = materia;

        m.put("agendas", listado);

        m.put("materia", materia);

        return "secciones/agendas";
    }

    //A Evento (Calendario de Materia)
    @GetMapping("/secciones/formulario_agenda")
    public String Agregar_Agenda(Map m) {

        m.put("materia", materia);

        Agenda agenda = new Agenda();

        m.put("agenda", agenda);

        return "/secciones/formulario_agenda";

    }

    //BM Evento (Calendario de Materia)
    @PostMapping("/secciones/formulario_agenda")
    public String Guardar_Agenda(@Valid Agenda agenda, BindingResult result, Map m) {
        m.put("materia", materia);
        
        if(result.hasErrors()){
            
           
            return "/secciones/formulario_agenda";
            
        }

        agenda.setMateria(materia);
        servAgenda.save(agenda);
        return "redirect:/secciones/agendas/" + materia.getId();
    }

    @GetMapping({"/secciones/formulario_agenda/{id}"})
    public String Editar_Agenda(@PathVariable(value = "id") int id, Map m) {
        Agenda agenda = new Agenda();
        agenda.setMateria(materia);
        agenda = servAgenda.buscarPorId(id);

        m.put("agenda", agenda);
        m.put("materia", materia);

        return "/secciones/formulario_agenda";
    }

}
