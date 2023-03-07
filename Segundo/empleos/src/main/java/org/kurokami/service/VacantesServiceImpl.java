package org.kurokami.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.kurokami.model.Vacante;
import org.springframework.stereotype.Service;

@Service
public class VacantesServiceImpl implements IVacanteService {
    private List<Vacante> lista;

    public VacantesServiceImpl() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<Vacante>();
        try {
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil");
            vacante1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal");
            vacante1.setFecha(simpleDateFormat.parse("09-02-2019"));
            vacante1.setSalario(8500.00);
            vacante1.setDestacado(1);
            vacante1.setImage("empresa1.png");

            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador Publico");
            vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia titulado.");
            vacante2.setFecha(simpleDateFormat.parse("08-02-2019"));
            vacante2.setSalario(12000.00);
            vacante2.setDestacado(0);

            vacante2.setImage("empresa2.png");

            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Electrico");
            vacante3.setDescripcion(
                    "Empres internacional solicita Ingeniero mecánico para mantenimiento de la instalación eléctrica");
            vacante3.setFecha(simpleDateFormat.parse("10-02-2019"));
            vacante3.setSalario(10500.00);
            vacante3.setDestacado(0);

            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador Grafico");
            vacante4.setDescripcion("Solicitamos Diseǹador Gráfico titulado para diseñar publicdad de la empresa.");
            vacante4.setFecha(simpleDateFormat.parse("11-02-2019"));
            vacante4.setSalario(7500.00);
            vacante4.setDestacado(1);
            vacante4.setImage("empresa3.png");

            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vacante> buscarTodas() {
        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer id){
        for (Vacante vacante : lista) {
            if(vacante.getId() == id){
                return vacante;
            }
        }
        return null;
    }
}
