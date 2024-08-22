package com.ESFE.Asistencias.Servicios.Interfaces;

import com.ESFE.Asistencias.Entidades.Asistencia;

import java.util.List;
import java.util.Optional;

public interface IAsistenciaServices {
    List<Asistencia> ObtenerTodos();
    Optional<Asistencia> BuscarporId(Integer id);
    Asistencia CreaOeditar(Asistencia asistencia);
    void EliminarPorId(Integer id);
}
