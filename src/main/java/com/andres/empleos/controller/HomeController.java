package com.andres.empleos.controller;

import com.andres.empleos.model.Vacante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.SimpleTimeZone;

@Controller
public class HomeController {
    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = getVacantes();
        model.addAttribute("vacantes",lista);
        
        return "tabla";
    }
    
    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de Comunicaciones");
        vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.00);
        model.addAttribute("vacante",vacante);
        return "detalle";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model){
        List<String> lista = new LinkedList<>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");

        model.addAttribute("empleos", lista);

        return "listado";
    }

    @GetMapping("/")
    public String mostrarHome(Model model){
        /*
        model.addAttribute("mensaje","Bienvenidos a Empleos App");
        model.addAttribute("fecha", new Date());
        */

        String nombre = "Auxiliar de Contabilidad";
        Date fechaPublicacion = new Date();
        double salario = 9000.0;
        boolean vigente = true;

        model.addAttribute("nombre",nombre);
        model.addAttribute("fecha",fechaPublicacion);
        model.addAttribute("salario",salario);
        model.addAttribute("vigente",vigente);

        return "home";
    }

    /**
     * Método que regresa una lista de objetos de tipo Vacante
     * @return
     */
    private List<Vacante> getVacantes() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacante> lista = new LinkedList<Vacante>();
        try{
            //Oferta de Trabajo 1
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil"); //Titulo de la vacante
            vacante1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal.");
            vacante1.setFecha(sdf.parse("08-02-2019"));
            vacante1.setSalario(8500.0);

            //Oferta de Trabajo 2
            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador Público");
            vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia titulado.");
            vacante2.setFecha(sdf.parse("09-02-2019"));
            vacante2.setSalario(12000.0);

            //Oferta de Trabajo 3
            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Electrico");
            vacante3.setDescripcion("Empresa internacional solicita ingeniero mecánico para mantenimiento de la instalación eléctrica.");
            vacante3.setFecha(sdf.parse("10-02-2019"));
            vacante3.setSalario(8500.0);

            //Oferta de Trabajo 4
            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador Gráfico"); //Titulo de la vacante
            vacante4.setDescripcion("Solicitamos Diseñador Gráfico tituado para diseñar publicidad de la empresa");
            vacante4.setFecha(sdf.parse("11-02-2019"));
            vacante4.setSalario(7500.0);

            /**
             * Agregamos los 4 objetos de tipo vacante a la lista...
             */
            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch (ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}
