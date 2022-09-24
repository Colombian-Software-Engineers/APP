package com.ColombianSoftwareEngineers.ezprise.repositories;

import com.ColombianSoftwareEngineers.ezprise.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
