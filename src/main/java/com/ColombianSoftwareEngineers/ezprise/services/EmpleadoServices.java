package com.ColombianSoftwareEngineers.ezprise.services;

import com.ColombianSoftwareEngineers.ezprise.entities.Empleado;
import com.ColombianSoftwareEngineers.ezprise.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServices {

    private EmpleadoRepository repository;
    public EmpleadoServices(EmpleadoRepository repository) {
        this.repository = repository;
    }
    public List<Empleado> getEmpleadoList(){ return this.repository.findAll();}
    public Empleado createOrUpdateEmpleado(Empleado empleado){ return this.repository.save(empleado);}
    public List<Empleado> createOrUpdateEmpleados(List<Empleado> empleadoList){ return this.repository.saveAll(empleadoList);}
    public Empleado getEmpleadoById(Long id){ return this.repository.findById(id).get();}
    public void deleteEmpleadoById(Long id){ this.repository.deleteById(id);}

}
