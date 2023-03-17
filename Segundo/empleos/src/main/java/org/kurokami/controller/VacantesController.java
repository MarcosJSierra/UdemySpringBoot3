package org.kurokami.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.kurokami.model.Vacante;
import org.kurokami.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/vacantes")
@Controller
public class VacantesController {

    @Autowired
    private IVacanteService vacanteService;

    @GetMapping("/index")
    public String mostrarIndex(Model model){

        List<Vacante> vacantes = vacanteService.buscarTodas();
        model.addAttribute("vacantes", vacantes);

        return "vacantes/listVacantes";
    }
    
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

    @GetMapping("/create")
    public String crear(Vacante vacante){
        System.out.println("oie zi");
        return "vacantes/formVacante";
    }

    // @PostMapping("/save")
    // public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam("estatus") String estatus,
    //     @RequestParam("fecha") String fecha, @RequestParam("destacado") int destacado, @RequestParam("salario") double salario, @RequestParam("detalles") String detalles){
        
    //         System.out.println("Nombre: " + nombre);
    //         System.out.println("Fecha: " + fecha);
    //         System.out.println("Descripcion: " + descripcion);
    //         System.out.println("Estatus: " + estatus);
    //         System.out.println("Destacado: " + destacado);
    //         System.out.println("Salario: " + salario);
    //         System.out.println("Detalles: " + detalles);


    //     return "vacantes/listVacantes";
    // }
     @PostMapping("/save")
    public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            for(ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }
        
        vacanteService.guardar(vacante);
        attributes.addFlashAttribute("msg", "Registro Guardado");
        return "redirect:/vacantes/index";
    }

    @InitBinder
    public void InitBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
