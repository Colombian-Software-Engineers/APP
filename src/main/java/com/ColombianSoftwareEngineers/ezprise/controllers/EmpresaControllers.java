package com.ColombianSoftwareEngineers.ezprise.controllers;

import com.ColombianSoftwareEngineers.ezprise.entities.Empleado;
import com.ColombianSoftwareEngineers.ezprise.entities.Empresa;
import com.ColombianSoftwareEngineers.ezprise.entities.User;
import com.ColombianSoftwareEngineers.ezprise.services.EmpleadoServices;
import com.ColombianSoftwareEngineers.ezprise.services.EmpresaServices;
import com.ColombianSoftwareEngineers.ezprise.services.MovimientoServices;
import com.ColombianSoftwareEngineers.ezprise.services.UserServices;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmpresaControllers {
    EmpresaServices service;
    EmpleadoServices empleadoServices;
    UserServices userServices;
    MovimientoServices movimientoServices;
    public EmpresaControllers(EmpresaServices services, EmpleadoServices empleadoServices, UserServices userServices, MovimientoServices movimientoServices) {
        this.service = services;
        this.empleadoServices = empleadoServices;
        this.userServices = userServices;
        this.movimientoServices = movimientoServices;
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

    @DeleteMapping("/empresas/{id}")
    public RedirectView DeleteEmpresaById(@PathVariable Long id){
        Empresa empresa = this.service.getEmpresaById(id);
        empresa.deleteEmpresa(this.empleadoServices, this.service, this.movimientoServices );
        return new RedirectView("/empresas");
    }

}
