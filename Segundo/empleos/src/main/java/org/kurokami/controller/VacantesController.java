package org.kurokami.controller;

import org.kurokami.model.Vacante;
import org.kurokami.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/vacantes")
@Controller
public class VacantesController {

    @Autowired
    private IVacanteService vacanteService;
    
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") Integer idVacante, Model model){
        Vacante vacante = vacanteService.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
        System.out.println("Vacante: "+ vacante.toString());
        return "detalle";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model){
        System.out.println("Borrando vacante con ID: " + idVacante);
        model.addAttribute("id", idVacante);
        return "mensaje";
    }
}
