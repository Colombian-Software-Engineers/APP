package com.ColombianSoftwareEngineers.APP.services;

import com.ColombianSoftwareEngineers.APP.entities.Empresa;
import com.ColombianSoftwareEngineers.APP.entities.MovimientoDinero;
import com.ColombianSoftwareEngineers.APP.repositories.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServices {
    MovimientoRepository repository;

    public MovimientoServices(MovimientoRepository repository) {
        this.repository = repository;
    }

    public List<MovimientoDinero> getMovimientoList(){ return this.repository.findAll();}
    public MovimientoDinero createOrUpdateMovimiento(MovimientoDinero movimiento){ return this.repository.save(movimiento);}
    public void deleteMovimientoById(Long id){ this.repository.deleteById(id);}
    public MovimientoDinero getMovimientoById(Long id){ return this.repository.findById(id).get();}
}
