package com.andres.empleos.controller;

import com.andres.empleos.model.Vacante;
import com.andres.empleos.service.IVacantesService;
import com.andres.empleos.service.VacantesServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
    @Autowired
    private IVacantesService serviceVacantes;
    
    @GetMapping("/create")
    public String crear(){
        return "vacantes/formVacante";
    }
    
    @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre,
                          @RequestParam("descripcion") String descripcion,
                          @RequestParam("categoria") String categoria,
                          @RequestParam("estatus") String estatus,
                          @RequestParam("fecha") String fecha,
                          @RequestParam("destacado") String destacado,
                          @RequestParam("salario") String salario,
                          @RequestParam("archivoImagen") String archivoImagen,
                          @RequestParam("detalles") String detalles){
        return "vacantes/listVacantes";
        
    }
    
    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model){
        System.out.println("Borrando vacante con id: " + idVacante);
        model.addAttribute("id",idVacante);
        return "mensaje";
    }
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model){
        Vacante vacante = serviceVacantes.buscarPorId(idVacante);
        System.out.println("Vacante: " + vacante);
        model.addAttribute("vacante",vacante);
        
        // Buscar los detalles de la vacante en la BD...
        
        return "detalle";
    }
}
