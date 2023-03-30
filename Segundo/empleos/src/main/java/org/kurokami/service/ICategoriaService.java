package org.kurokami.service;

import java.util.List;

import org.kurokami.model.Categoria;

public interface ICategoriaService {

    void guardar(Categoria categoria);

    List<Categoria> buscarTodas();

    Categoria buscarPorId(Integer idCategoria);

}
