package com.ejemplo.clinica.repository;

import com.ejemplo.clinica.domain.Medico;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("SELECT m, COUNT(c) FROM Medico m LEFT JOIN m.consultas c GROUP BY m")
    List<Object[]> findMedicosConCantidadConsultas();
}
