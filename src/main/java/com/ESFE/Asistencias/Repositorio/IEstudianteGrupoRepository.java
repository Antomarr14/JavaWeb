package com.ESFE.Asistencias.Repositorio;

import com.ESFE.Asistencias.Entidades.EstudianteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteGrupoRepository extends JpaRepository<EstudianteGrupo, Integer> {
    // Ordenar por el atributo 'anio'
    Page<EstudianteGrupo> findByOrderByAnioDesc(Pageable pageable);

    // Alternativamente, puedes ordenar por 'estudiante' o 'grupo', si así lo deseas
    // Page<EstudianteGrupo> findByOrderByEstudianteDesc(Pageable pageable);
    // Page<EstudianteGrupo> findByOrderByGrupoDesc(Pageable pageable);
}
