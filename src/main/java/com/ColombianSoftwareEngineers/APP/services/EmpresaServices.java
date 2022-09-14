package com.ColombianSoftwareEngineers.APP.services;

import com.ColombianSoftwareEngineers.APP.entities.Empleado;
import com.ColombianSoftwareEngineers.APP.entities.Empresa;
import com.ColombianSoftwareEngineers.APP.entities.RolEmpleado;
import com.ColombianSoftwareEngineers.APP.entities.User;
import com.ColombianSoftwareEngineers.APP.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.List;

@Service
public class EmpresaServices {
    private EmpresaRepository repository;
    private EmpleadoServices empleadoServices;
    public EmpresaServices(EmpresaRepository repository, EmpleadoServices empleadoServices) {
        this.repository = repository;
        this.empleadoServices = empleadoServices;
    }

    public List<Empresa> getEmpresaList(){ return this.repository.findAll();}
    public Empresa createOrUpdateEmpresa(Empresa empresa){
        return this.repository.save(empresa);
    }
    public Empresa getEmpresaById(Long id){ return this.repository.findById(id).get();}
    public void deleteEmpresaById(Long id){ this.repository.deleteById(id);}
}
