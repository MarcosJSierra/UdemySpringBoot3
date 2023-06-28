package org.kurokami.service;

import java.util.ArrayList;
import java.util.List;

import org.kurokami.model.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService {

    private List<Categoria> categorias = new ArrayList<>();

    public CategoriaService(){
        var opcion = new Categoria();
        opcion.setDescripcion("Contabilidad");
        opcion.setId(1);
        opcion.setNombre("Contabilidad");
        categorias.add(opcion);

        opcion = new Categoria();
        opcion.setDescripcion("Ventas");
        opcion.setId(2);
        opcion.setNombre("Ventas");
        categorias.add(opcion);

        opcion = new Categoria();
        opcion.setDescripcion("Comunicaciones");
        opcion.setId(3);
        opcion.setNombre("Comunicaciones");
        categorias.add(opcion);

        opcion = new Categoria();
        opcion.setDescripcion("Arquitectura");
        opcion.setId(4);
        opcion.setNombre("Arquitectura");
        categorias.add(opcion);
    }

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
