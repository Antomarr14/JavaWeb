package com.ESFE.Asistencias.Repositorio;

import com.ESFE.Asistencias.Entidades.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsistenciaRepository extends JpaRepository<Asistencia, Integer> {
}
