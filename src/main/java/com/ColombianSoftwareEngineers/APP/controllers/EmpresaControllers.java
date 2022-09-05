package com.ColombianSoftwareEngineers.APP.controllers;

import com.ColombianSoftwareEngineers.APP.entities.Empresa;
import com.ColombianSoftwareEngineers.APP.services.EmpresaServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaControllers {
    EmpresaServices service;
    public EmpresaControllers(EmpresaServices services) {
        this.service = services;
    }

    @GetMapping("/empresas")
    public List<Empresa> EmpresaList(){ return this.service.getEmpresaList(); }
    @PostMapping("/empresas")
    public Empresa PostEmpresa(@RequestBody Empresa empresa){ return this.service.createOrUpdateEmpresa(empresa);}

    @GetMapping("/empresas/{id}")
    public Empresa EmpresaById(@PathVariable Long id){ return this.service.getEmpresaById(id); }
    @PatchMapping("/empresas/{id}")
    public Empresa PatchEmpresaById(@PathVariable Long id, @RequestBody Empresa empresa){
        empresa.setIdEmpresa(id);
        return this.service.createOrUpdateEmpresa(empresa);
    }
    @DeleteMapping("/empresas/{id}")
    public String DeleteEmpresaById(@PathVariable Long id){
        this.service.deleteEmpresaById(id);
        return "Empresa eliminada";
    }

}
