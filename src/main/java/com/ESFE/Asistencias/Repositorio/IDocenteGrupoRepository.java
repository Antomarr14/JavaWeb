package com.ESFE.Asistencias.Repositorio;

import com.ESFE.Asistencias.Entidades.DocenteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteGrupoRepository extends JpaRepository<DocenteGrupo, Integer> {
    // Ordenar por el atributo 'anio'
    Page<DocenteGrupo> findByOrderByAnioDesc(Pageable pageable);

    // Alternativamente, puedes ordenar por 'docente' o 'grupo', si así lo deseas
    // Page<DocenteGrupo> findByOrderByDocenteDesc(Pageable pageable);
    // Page<DocenteGrupo> findByOrderByGrupoDesc(Pageable pageable);
}
