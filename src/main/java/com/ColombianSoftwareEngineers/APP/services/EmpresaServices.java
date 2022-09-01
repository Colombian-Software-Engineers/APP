package com.ColombianSoftwareEngineers.APP.services;

import com.ColombianSoftwareEngineers.APP.entities.Empresa;
import com.ColombianSoftwareEngineers.APP.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServices {
    private EmpresaRepository repository;
    public EmpresaServices(EmpresaRepository repository) {
        this.repository = repository;
    }

    public List<Empresa> getEmpresaList(){ return this.repository.findAll();}
    public Empresa createOrUpdateEmpresa(Empresa empresa){ return this.repository.save(empresa);}
    public Empresa getEmpresaById(Long id){ return this.repository.findById(id).get();}
    public void deleteEmpresaById(Long id){ this.repository.deleteById(id);}
}
