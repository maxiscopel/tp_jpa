package com.ejemplo.clinica.repository;

import com.ejemplo.clinica.domain.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {}
