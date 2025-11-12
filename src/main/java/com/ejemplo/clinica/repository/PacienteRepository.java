package com.ejemplo.clinica.repository;

import com.ejemplo.clinica.domain.Paciente;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByEdadGreaterThan(int edad);
    List<Paciente> findByObraSocial(String obraSocial);

    @Query("SELECT AVG(p.edad) FROM Paciente p")
    Double getPromedioEdad();

    @Query("SELECT p.medicamentos FROM Paciente p WHERE p.id = :id")
    List<Object> findMedicamentosByPacienteId(Long id);
}
