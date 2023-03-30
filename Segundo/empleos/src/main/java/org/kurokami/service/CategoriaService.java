package org.kurokami.service;

import java.util.ArrayList;
import java.util.List;

import org.kurokami.model.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService {

    private List<Categoria> categorias = new ArrayList<>();

    @Override
    public void guardar(Categoria categoria) {
        categorias.add(categoria);
    }

    @Override
    public List<Categoria> buscarTodas() {
        return categorias;
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        for(Categoria categoria : categorias){
            if(categoria.getId().equals(idCategoria)){
                return categoria;
            }
        }
        return null;
    }
    
}
