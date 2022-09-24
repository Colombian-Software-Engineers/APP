package com.ColombianSoftwareEngineers.APP.controllers;

import com.ColombianSoftwareEngineers.APP.entities.Empleado;
import com.ColombianSoftwareEngineers.APP.entities.User;
import com.ColombianSoftwareEngineers.APP.services.EmpleadoServices;
import com.ColombianSoftwareEngineers.APP.services.UserServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmpleadoController {

    @GetMapping("/empleado")
    public List<Empleado> EmpleadoList(){ return this.service.getEmpleadoList(); }
    @PostMapping("/empleados")
    public RedirectView PostEmpleado(@ModelAttribute Empleado empleado){
        User user = this.userServices.findByEmailUser(empleado.getCorreoEmpleado());
        if(user != null){
            empleado.setUser(user);
        }
        this.service.createOrUpdateEmpleado(empleado);
        return new RedirectView("/empresas/"+empleado.getEmpresa().getIdEmpresa()+"/empleados");
    }
    @DeleteMapping("/empleados/{id}")
    public RedirectView DeleteEmpleadoById(@PathVariable Long id){
        Empleado empleado = this.service.getEmpleadoById(id);
        this.service.deleteEmpleadoById(id);
        return new RedirectView("/empresas/" + empleado.getEmpresa().getIdEmpresa() + "/empleados");
    }
}
