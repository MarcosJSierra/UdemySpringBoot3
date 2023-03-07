package org.kurokami.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.kurokami.model.Vacante;
import org.kurokami.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private IVacanteService vacanteService;

    @GetMapping("/listado")
    public String mostrarLista(Model model){
        List<String> lista = new LinkedList<>();
        lista.add("Ingeniero en Sistemas");
        lista.add("Auxiliar de contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");
        model.addAttribute("empleos", lista);
        return "listado";
    }


    @GetMapping("/")
    public String mostrarHome(Model model){
        List<Vacante> lista = vacanteService.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "home";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle( Model model){
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de comunicaciones");
        vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.00);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }


    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = vacanteService.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }
}
