package com.andres.empleos.controller;

import com.andres.empleos.model.Perfil;
import com.andres.empleos.model.Usuario;
import com.andres.empleos.model.Vacante;
import com.andres.empleos.service.IUsuariosService;
import com.andres.empleos.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
    
    @Autowired
    private IVacantesService serviceVacantes;
    
    @Autowired
    private IUsuariosService serviceUsuarios;
    
    @GetMapping("/")
    public String mostrarHome(Model model) {
        return "home";
    }
    
    @GetMapping("/signup")
    public String registrarse(Usuario usuario) {
        return "formRegistro";
    }
    
    @PostMapping("/signup")
    public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
        usuario.setEstatus(1); // Activado por defecto
        usuario.setFechaRegistro(new Date()); // Fecha de Registro, la fecha actual del servidor
        
        // Creamos el Perfil que le asignaremos al usuario nuevo
        Perfil perfil = new Perfil();
        perfil.setId(3); // Perfil USUARIO
        usuario.agregar(perfil);
        
        /**
         * Guardamos el usuario en la base de datos. El Perfil se guarda automaticamente
         */
        serviceUsuarios.guardar(usuario);
        
        attributes.addFlashAttribute("msg", "El registro fue guardado correctamente!");
        
        return "redirect:/usuarios/index";
    }
    
    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        
        return "tabla";
    }
    
    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de comunicaciones");
        vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.0);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }
    
    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        List<String> lista = new LinkedList<String>();
        lista.add("Ingeniero  de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");
        
        model.addAttribute("empleos", lista);
        
        return "listado";
    }
    
    @ModelAttribute
    public void setGenericos(Model model) {
        model.addAttribute("vacantes", serviceVacantes.buscarDestacadas());
    }
    
}
