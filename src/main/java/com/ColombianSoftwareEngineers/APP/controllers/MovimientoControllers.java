package com.ColombianSoftwareEngineers.APP.controllers;

import com.ColombianSoftwareEngineers.APP.entities.Empresa;
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

    @GetMapping("/empresas/{id}/movimientos")
    public List<MovimientoDinero> MovimientoList(@PathVariable Long id){ return this.service.getMovimientoList(); }
    @PostMapping("/movimiento")
    public MovimientoDinero PostMovimiento(@RequestBody MovimientoDinero movimiento){ return this.service.createOrUpdateMovimiento(movimiento);}

    @GetMapping("/movimiento/{id}")
    public MovimientoDinero MovimientoById(@PathVariable Long id){ return this.service.getMovimientoById(id); }
    @PatchMapping("/movimiento/{id}")
    public MovimientoDinero PatchMovimientoById(@PathVariable Long id, @RequestBody MovimientoDinero movimiento){
        MovimientoDinero resultado = this.service.getMovimientoById(id);
        resultado.setMontoMovimiento(movimiento.getMontoMovimiento());
        resultado.setConceptoMovimiento(movimiento.getConceptoMovimiento());
        resultado.setUsuarioMovimiento(movimiento.getUsuarioMovimiento());
        return this.service.createOrUpdateMovimiento(resultado);
    }
    @DeleteMapping("/movimiento/{id}")
    public String DeleteMovimientoById(@PathVariable Long id){
        this.service.deleteMovimientoById(id);
        return "Movimiento eliminado";
    }
}
