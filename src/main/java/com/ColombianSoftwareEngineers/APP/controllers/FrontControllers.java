package com.ColombianSoftwareEngineers.APP.controllers;

import com.ColombianSoftwareEngineers.APP.entities.*;
import com.ColombianSoftwareEngineers.APP.services.EmpleadoServices;
import com.ColombianSoftwareEngineers.APP.services.EmpresaServices;
import com.ColombianSoftwareEngineers.APP.services.UserServices;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class FrontControllers {
    EmpresaServices empresaServices;
    UserServices userServices;
    EmpleadoServices empleadoServices;
    public FrontControllers(UserServices userServices, EmpresaServices service, EmpleadoServices empleadoServices) {
        this.empresaServices = service;
        this.userServices = userServices;
        this.empleadoServices = empleadoServices;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            User user = this.userServices.getOrCreateUser(principal.getClaims());
        }
        return "index";
    }

    @GetMapping("/empresas/{id}/movimientos")
    public String EmpresasMovimientos(Model model, @AuthenticationPrincipal OidcUser principal, @PathVariable Long id) {
        User user = this.userServices.getOrCreateUser(principal.getClaims());
        Empresa empresa = this.empresaServices.getEmpresaById(id);
        List<Empresa> empresaList = user.getEmpleadosEmpresaList();
        if(empresaList.contains(empresa)){
            model.addAttribute("empresa", empresa);
            model.addAttribute("empresas", empresaList);
            model.addAttribute("movimientos", empresa.getMovimientoDineroList());

            Empleado empleado = user.getEmpleadoByEmpresa(empresa).get();
            if(empleado.getRolEmpleado() == RolEmpleado.ADMIN){
                return "movimientosAdmin";
            }
            else {
                return "movimientosOperario";
            }
        }
        return "";
    }

    @GetMapping("/empresas/{id}/empleados")
    public String EmpresasEmpleados(Model model, @AuthenticationPrincipal OidcUser principal, @PathVariable Long id) {
        User user = this.userServices.getOrCreateUser(principal.getClaims());
        Empresa empresa = this.empresaServices.getEmpresaById(id);
        List<Empresa> empresaList = user.getEmpleadosEmpresaList();
        if(empresaList.contains(empresa)){
            model.addAttribute("empresa", empresa);
            model.addAttribute("empresas", empresaList);
            model.addAttribute("empleados", empresa.getEmpleadoList());

            Empleado empleado = user.getEmpleadoByEmpresa(empresa).get();
            if(empleado.getRolEmpleado() == RolEmpleado.ADMIN){
                return "empleadosAdmin";
            }
            else {
                return "empleadosOperario";
            }
        }
        return "";
    }

    @GetMapping("/empresas/new")
    public String NuevaEmpresa(Model model, @AuthenticationPrincipal OidcUser principal) {
        User user = this.userServices.getOrCreateUser(principal.getClaims());
        Empresa empresa = new Empresa();

        Empleado empleado = user.toEmpleado();
        empleado.setRolEmpleado(RolEmpleado.ADMIN);
        empleado.setEmpresa(empresa);
        empleado.setUser(user);

        model.addAttribute("empresa", empresa);
        model.addAttribute("empleados", empresa.getEmpleadoList());
        return "new-empresa";
    }

    @GetMapping("/empresas/{id}/movimientos/new")
    public String NuevoMovimiento(Model model, @AuthenticationPrincipal OidcUser principal, @PathVariable Long id) {
        User user = this.userServices.getOrCreateUser(principal.getClaims());
        Empresa empresa = this.empresaServices.getEmpresaById(id);
        MovimientoDinero movimientoDinero = new MovimientoDinero();

        Optional<Empleado> empleado= user.getEmpleadoByEmpresa(empresa);
        movimientoDinero.setEmpleado(empleado.get());
        movimientoDinero.setEmpresa(empresa);

        model.addAttribute("movimiento", movimientoDinero);
        return "new-movimiento";
    }

    @GetMapping("/empresas/{id}/empleados/new")
    public String NuevoEmpleado(Model model, @AuthenticationPrincipal OidcUser principal, @PathVariable Long id) {
        User user = this.userServices.getOrCreateUser(principal.getClaims());
        Empresa empresa = this.empresaServices.getEmpresaById(id);
        Empleado empleado = new Empleado();
        empleado.setEmpresa(empresa);

        model.addAttribute("empleado", empleado);
        return "new-empleado";
    }
}
