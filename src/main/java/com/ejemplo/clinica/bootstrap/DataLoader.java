package com.ejemplo.clinica.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ejemplo.clinica.domain.*;
import com.ejemplo.clinica.repository.*;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final PacienteRepository pacienteRepo;
    private final MedicoRepository medicoRepo;
    private final ConsultaRepository consultaRepo;
    private final MedicamentoRepository medicamentoRepo;
    private final HistoriaClinicaRepository historiaRepo;

    public DataLoader(PacienteRepository pacienteRepo, MedicoRepository medicoRepo,
                      ConsultaRepository consultaRepo, MedicamentoRepository medicamentoRepo,
                      HistoriaClinicaRepository historiaRepo) {
        this.pacienteRepo = pacienteRepo;
        this.medicoRepo = medicoRepo;
        this.consultaRepo = consultaRepo;
        this.medicamentoRepo = medicamentoRepo;
        this.historiaRepo = historiaRepo;
    }

    @Override
    public void run(String... args) {
        Medicamento m1 = new Medicamento(); m1.setNombre("Paracetamol"); m1.setPresentacion("500mg");
        Medicamento m2 = new Medicamento(); m2.setNombre("Ibuprofeno"); m2.setPresentacion("400mg");
        Medicamento m3 = new Medicamento(); m3.setNombre("Amoxicilina"); m3.setPresentacion("500mg");
        medicamentoRepo.saveAll(List.of(m1,m2,m3));

        Paciente p1 = new Paciente(); p1.setNombre("Juan Perez"); p1.setEdad(35); p1.setObraSocial("OSDE");
        Paciente p2 = new Paciente(); p2.setNombre("María Gómez"); p2.setEdad(28); p2.setObraSocial("PAMI");
        Paciente p3 = new Paciente(); p3.setNombre("Carlos Ruiz"); p3.setEdad(45); p3.setObraSocial("OSDE");

        p1.getMedicamentos().addAll(List.of(m1,m2));
        p2.getMedicamentos().add(m3);
        p3.getMedicamentos().add(m2);

        pacienteRepo.saveAll(List.of(p1,p2,p3));

        HistoriaClinica h1 = new HistoriaClinica(); h1.setDescripcion("Historia de hipertensión"); h1.setPaciente(p1);
        HistoriaClinica h2 = new HistoriaClinica(); h2.setDescripcion("Alergia a penicilina"); h2.setPaciente(p2);
        historiaRepo.saveAll(List.of(h1,h2));

        Medico med1 = new Medico(); med1.setNombre("Dra. Ana López"); med1.setEspecialidad("Cardiología");
        Medico med2 = new Medico(); med2.setNombre("Dr. Pablo Fernández"); med2.setEspecialidad("Clínica Médica");
        medicoRepo.saveAll(List.of(med1,med2));

        Consulta c1 = new Consulta(); c1.setFecha(LocalDateTime.of(2025,1,10,10,0)); c1.setDiagnostico("Hipertensión descompensada");
        c1.setPaciente(p1); c1.setMedico(med1);

        Consulta c2 = new Consulta(); c2.setFecha(LocalDateTime.of(2025,3,5,14,30)); c2.setDiagnostico("Control rutina");
        c2.setPaciente(p1); c2.setMedico(med2);

        Consulta c3 = new Consulta(); c3.setFecha(LocalDateTime.of(2025,4,20,9,0)); c3.setDiagnostico("Infección respiratoria");
        c3.setPaciente(p2); c3.setMedico(med2);

        Consulta c4 = new Consulta(); c4.setFecha(LocalDateTime.of(2025,5,2,11,0)); c4.setDiagnostico("Dolor articular");
        c4.setPaciente(p3); c4.setMedico(med1);

        consultaRepo.saveAll(List.of(c1,c2,c3,c4));
    }
}
