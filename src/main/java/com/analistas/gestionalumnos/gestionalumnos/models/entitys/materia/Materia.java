/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.agenda.Agenda;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia_alumno.Materia_Alumno;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.profesor.Profesor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matias
 */
@Entity
@Table(name = "materias")
public class Materia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre_materia", length = 25)
    @NotEmpty
    private String nombre_Materia;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materia")
    private List<Agenda> calendarios;

    private void addCalendario(Agenda calendarios) {
        this.calendarios.add(calendarios);
    }

    @ManyToOne
    @JoinColumn(name = "fk_mat_pro", referencedColumnName = "id")
    private Profesor profesor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "materia")
    private List<Materia_Alumno> Materia_Alumno;

    private void addMaterias_Alumnos(Materia_Alumno Materia_Alumno) {
        this.Materia_Alumno.add(Materia_Alumno);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_Materia() {
        return nombre_Materia;
    }

    public void setNombre_Materia(String nombre_Materia) {
        this.nombre_Materia = nombre_Materia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Materia_Alumno> getMateria_Alumno() {
        return Materia_Alumno;
    }

    public void setMateria_Alumno(List<Materia_Alumno> Materia_Alumno) {
        this.Materia_Alumno = Materia_Alumno;
    }

    public List<Agenda> getCalendarios() {
        return calendarios;
    }

    public void setCalendarios(List<Agenda> calendarios) {
        this.calendarios = calendarios;
    }

    @Override
    public String toString() {
        return nombre_Materia;
    }
    
    

}
