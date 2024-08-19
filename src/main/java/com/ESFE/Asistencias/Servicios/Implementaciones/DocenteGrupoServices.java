package com.ESFE.Asistencias.Servicios.Implementaciones;


import com.ESFE.Asistencias.Entidades.DocenteGrupo;
import com.ESFE.Asistencias.Repositorio.IDocenteGrupoRepository;
import com.ESFE.Asistencias.Servicios.Interfaces.IDocenteGrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class DocenteGrupoServices implements IDocenteGrupoServices {

    @Autowired
    private IDocenteGrupoRepository iDocenteGrupoRepository;
    @Override
    public Page<DocenteGrupo> BuscarTodosPaginados(Pageable pageable) {
        return iDocenteGrupoRepository.findAll(pageable);
    }

    @Override
    public List<DocenteGrupo> ObtenerTodos() {
        return iDocenteGrupoRepository.findAll();
    }

    @Override
    public Optional<DocenteGrupo> BuscarporId(Integer id) {
        return iDocenteGrupoRepository.findById(id);
    }

    @Override
    public DocenteGrupo CreaOeditar(DocenteGrupo docenteGrupo) {
        return iDocenteGrupoRepository.save(docenteGrupo);
    }

    @Override
    public void EliminarPorId(Integer id) {
        iDocenteGrupoRepository.deleteById(id);
    }
}
