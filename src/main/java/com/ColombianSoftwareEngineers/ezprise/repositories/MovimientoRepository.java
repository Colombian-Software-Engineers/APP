package com.ColombianSoftwareEngineers.ezprise.repositories;

import com.ColombianSoftwareEngineers.ezprise.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoDinero, Long> {
}
