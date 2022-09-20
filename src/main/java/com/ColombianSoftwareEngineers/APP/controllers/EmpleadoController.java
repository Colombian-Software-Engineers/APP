package com.ColombianSoftwareEngineers.APP.controllers;

import com.ColombianSoftwareEngineers.APP.entities.Empleado;
import com.ColombianSoftwareEngineers.APP.services.EmpleadoServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmpleadoController {

    EmpleadoServices service;
    public EmpleadoController(EmpleadoServices services) {
        this.service = services;
    }

    @GetMapping("/empleado")
    public List<Empleado> EmpleadoList(){ return this.service.getEmpleadoList(); }
    @PostMapping("/empleados")
    public RedirectView PostEmpleado(@ModelAttribute Empleado empleado){
        this.service.createOrUpdateEmpleado(empleado);
        return new RedirectView("/empresas/"+empleado.getEmpresa().getIdEmpresa()+"/empleados");
    }

    @PatchMapping("/empleado/{id}")
    public Empleado PatchEmpleadoById(@PathVariable Long id, @RequestBody Empleado empleado){
        Empleado resultado = this.service.getEmpleadoById(id);
        resultado.setNombreEmpleado(empleado.getNombreEmpleado());
        resultado.setCorreoEmpleado(empleado.getCorreoEmpleado());
        resultado.setRolEmpleado(empleado.getRolEmpleado());
        return this.service.createOrUpdateEmpleado(resultado);
    }
    @DeleteMapping("/empleados/{id}")
    public RedirectView DeleteEmpleadoById(@PathVariable Long id){
        Empleado empleado = this.service.getEmpleadoById(id);
        this.service.deleteEmpleadoById(id);
        return new RedirectView("/empresas/" + empleado.getEmpresa().getIdEmpresa() + "/empleados");
    }

}
