package com.ejemplo.clinica.repository;

import com.ejemplo.clinica.domain.Consulta;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByMedicoId(Long medicoId);

    @Query("SELECT c.diagnostico, c.paciente.nombre FROM Consulta c")
    List<Object[]> findDiagnosticoYNombrePaciente();
}
