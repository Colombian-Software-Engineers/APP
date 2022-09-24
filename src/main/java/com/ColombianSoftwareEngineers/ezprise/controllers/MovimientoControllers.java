package com.ColombianSoftwareEngineers.ezprise.controllers;

import com.ColombianSoftwareEngineers.ezprise.entities.MovimientoDinero;
import com.ColombianSoftwareEngineers.ezprise.services.EmpresaServices;
import com.ColombianSoftwareEngineers.ezprise.services.MovimientoServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MovimientoControllers {
    MovimientoServices service;
    EmpresaServices  empresaServices;
    public MovimientoControllers(MovimientoServices services, EmpresaServices empresaServices) {
        this.service = services;
        this.empresaServices=empresaServices;
    }

    @PostMapping("/movimientos")
    public RedirectView PostMovimiento(@ModelAttribute MovimientoDinero movimientoDinero){
        this.service.createOrUpdateMovimiento(movimientoDinero);
        return new RedirectView("/empresas/" + movimientoDinero.getEmpresa().getIdEmpresa() + "/movimientos");
    }

    @DeleteMapping("/movimientos/{id}")
    public RedirectView DeleteMovimientoById(@PathVariable Long id) {
        MovimientoDinero movimientoDinero = this.service.getMovimientoById(id);
        this.service.deleteMovimientoById(id);
        return new RedirectView("/empresas/" + movimientoDinero.getEmpresa().getIdEmpresa() + "/movimientos");
    }

}
