package com.ESFE.Asistencias.Servicios.Implementaciones;

import com.ESFE.Asistencias.Entidades.Asistencia;
import com.ESFE.Asistencias.Repositorio.IAsistenciaRepository;
import com.ESFE.Asistencias.Servicios.Interfaces.IAsistenciaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServices implements IAsistenciaServices {

    @Autowired
    private IAsistenciaRepository asistenciaRepository;

    @Override
    public List<Asistencia> ObtenerTodos() {
        return asistenciaRepository.findAll();
    }

    @Override
    public Optional<Asistencia> BuscarporId(Integer id) {
        return asistenciaRepository.findById(id);
    }

    @Override
    public Asistencia CreaOeditar(Asistencia asistencia) {
        // Suponiendo que la entidad Asistencia tiene campos para fecha y hora
        // y se desean establecer la fecha y la hora actuales al crear o editar
        asistencia.setFecha(LocalDate.now()); // Establecer la fecha actual
        asistencia.setHoraDeEntrada(LocalTime.now()); // Establecer la hora actual
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public void EliminarPorId(Integer id) {
        asistenciaRepository.deleteById(id);
    }
}
