package org.kurokami.controller;


import java.util.List;

import org.kurokami.model.Categoria;
import org.kurokami.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
    
    @Autowired
    ICategoriaService categoriaService;

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String mostrarIndex(Model model) {
        List<Categoria> categorias = categoriaService.buscarTodas();
        model.addAttribute("categorias", categorias);
        System.out.println(categorias.toString());
        return "categorias/listCategorias";
    }    

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String crear(Categoria categoria, Model model){
        return "categorias/formCategoria";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String guardar(Categoria categoria, RedirectAttributes attributes, BindingResult result){
        if(result.hasErrors()){
            return "vacantes/formVacante";
        }
        System.out.println(categoria);
        categoriaService.guardar(categoria);
        attributes.addFlashAttribute("msg", "Registro Guardado");
        
        return "redirect:/categorias/index";
    }
}
