/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.dao.materia;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Matias
 */
public interface IMateriaDao extends JpaRepository<Materia, Integer>{
    
}

