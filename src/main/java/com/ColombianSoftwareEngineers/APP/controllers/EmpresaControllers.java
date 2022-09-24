package com.ColombianSoftwareEngineers.APP.controllers;

import com.ColombianSoftwareEngineers.APP.entities.Empleado;
import com.ColombianSoftwareEngineers.APP.entities.Empresa;
import com.ColombianSoftwareEngineers.APP.entities.User;
import com.ColombianSoftwareEngineers.APP.services.EmpleadoServices;
import com.ColombianSoftwareEngineers.APP.services.EmpresaServices;
import com.ColombianSoftwareEngineers.APP.services.UserServices;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmpresaControllers {
    EmpresaServices service;
    EmpleadoServices empleadoServices;
    UserServices userServices;
    public EmpresaControllers(EmpresaServices services, EmpleadoServices empleadoServices, UserServices userServices) {
        this.service = services;
        this.empleadoServices = empleadoServices;
        this.userServices = userServices;
    }

    @PostMapping("/empresas")
    public RedirectView PostEmpresa(@ModelAttribute Empresa empresa){
        List<Empleado> empleadoList = empresa.getEmpleadoList();
        Empleado lastEmpleado = empleadoList.get(empleadoList.size()-1);
        lastEmpleado.setUser(lastEmpleado.getUser());
        lastEmpleado.setEmpresa(empresa);
        this.service.createOrUpdateEmpresa(empresa);
        this.empleadoServices.createOrUpdateEmpleado(lastEmpleado);
        return new RedirectView("/empresas/" + empresa.getIdEmpresa() + "/movimientos");
    }

    @GetMapping("/empresas")
    public RedirectView GetEmpresa(@AuthenticationPrincipal OidcUser principal){
        User user = this.userServices.getOrCreateUser(principal.getClaims());
        List<Empleado> empleadoList = user.getEmpleadoList();
        if(empleadoList != null  && !empleadoList.isEmpty()){
            Empleado empleado = empleadoList.get(0);
            return new RedirectView("/empresas/" + empleado.getEmpresa().getIdEmpresa() + "/movimientos");
        }
        return new RedirectView("/empresas/new");
    }

//    @PatchMapping("/empresas/{id}")
//    public Empresa PatchEmpresaById(@PathVariable Long id, @RequestBody Empresa empresa){
//        empresa.setIdEmpresa(id);
//        return this.service.createOrUpdateEmpresa(empresa);
//    }
//
//    @DeleteMapping("/empresas/{id}")
//    public String DeleteEmpresaById(@PathVariable Long id){
//        this.service.deleteEmpresaById(id);
//        return "Empresa eliminada";
//    }

}
