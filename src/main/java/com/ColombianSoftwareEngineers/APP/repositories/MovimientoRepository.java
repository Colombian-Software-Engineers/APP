package com.ColombianSoftwareEngineers.APP.repositories;

import com.ColombianSoftwareEngineers.APP.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoDinero, Long> {
}
