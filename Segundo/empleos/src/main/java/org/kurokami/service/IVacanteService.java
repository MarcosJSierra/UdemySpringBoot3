package org.kurokami.service;

import java.util.List;

import org.kurokami.model.Vacante;

public interface IVacanteService {
    List<Vacante> buscarTodas();
    
    Vacante buscarPorId(Integer id);
}
