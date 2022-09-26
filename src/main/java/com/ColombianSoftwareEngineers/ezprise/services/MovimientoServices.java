package com.ColombianSoftwareEngineers.ezprise.services;

import com.ColombianSoftwareEngineers.ezprise.entities.MovimientoDinero;
import com.ColombianSoftwareEngineers.ezprise.repositories.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServices {
    MovimientoRepository repository;

    public MovimientoServices(MovimientoRepository repository) {
        this.repository = repository;
    }
    public void deleteMovimientos(List<MovimientoDinero> movimientoDineroList){ this.repository.deleteAll(movimientoDineroList);}
    public List<MovimientoDinero> getMovimientoList(){ return this.repository.findAll();}
    public MovimientoDinero createOrUpdateMovimiento(MovimientoDinero movimiento){ return this.repository.save(movimiento);}
    public void deleteMovimientoById(Long id){ this.repository.deleteById(id);}
    public MovimientoDinero getMovimientoById(Long id){ return this.repository.findById(id).get();}
}
