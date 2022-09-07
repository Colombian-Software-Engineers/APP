package com.ColombianSoftwareEngineers.APP.controllers;

import com.ColombianSoftwareEngineers.APP.entities.MovimientoDinero;
import com.ColombianSoftwareEngineers.APP.services.EmpresaServices;
import com.ColombianSoftwareEngineers.APP.services.MovimientoServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoControllers {
    MovimientoServices service;
    EmpresaServices  empresaServices;
    public MovimientoControllers(MovimientoServices services, EmpresaServices empresaServices) {
        this.service = services;
        this.empresaServices=empresaServices;
    }

    @GetMapping("/empresas/{idEmp}/movimientos")
    public List<MovimientoDinero> MovimientoList(@PathVariable Long idEmp){
        return this.empresaServices.getEmpresaById(idEmp).getMovimientoDineroList();
    }

    @PostMapping("/empresas/{idEmp}/movimientos")
    public MovimientoDinero PostMovimiento(@PathVariable Long idEmp, @RequestBody MovimientoDinero movimiento){
        movimiento.setEmpresa(this.empresaServices.getEmpresaById(idEmp));
        return this.service.createOrUpdateMovimiento(movimiento);
    }

    @PatchMapping("/empresas/{idEmp}/movimiento/{id}")
    public MovimientoDinero PatchMovimientoById(@PathVariable Long idEmp, @PathVariable Long id, @RequestBody MovimientoDinero movimiento){
        movimiento.setIdMovimiento(id);
        movimiento.setEmpresa(this.empresaServices.getEmpresaById(idEmp));
        return this.service.createOrUpdateMovimiento(movimiento);
    }
    @DeleteMapping("/empresas/{idEmp}/movimientos/{id}")
    public String DeleteMovimientoById(@PathVariable Long idEmp, @PathVariable Long id){
        List<MovimientoDinero> listaMovimientos = this.empresaServices.getEmpresaById(idEmp).getMovimientoDineroList();
        if(listaMovimientos.contains(this.service.getMovimientoById(id))){
            this.service.deleteMovimientoById(id);
            return "Movimiento eliminado";
        }
        else{
            return "Movimiento no encontrado";
        }
    }
}
