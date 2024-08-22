package com.ESFE.Asistencias.Controladores;

import com.ESFE.Asistencias.Entidades.Asistencia;
import com.ESFE.Asistencias.Entidades.Estudiante;
import com.ESFE.Asistencias.Entidades.Grupo;
import com.ESFE.Asistencias.Servicios.Interfaces.IAsistenciaServices;
import com.ESFE.Asistencias.Servicios.Interfaces.IEstudianteServices;
import com.ESFE.Asistencias.Servicios.Interfaces.IGrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    private IAsistenciaServices asistenciaServices;

    @Autowired
    private IEstudianteServices estudianteServices;

    @Autowired
    private IGrupoServices grupoServices;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("asistencia", new Asistencia());
        return "Asistencia/login";
    }

    @PostMapping("/registrar")
    public String registrarAsistencia(@RequestParam("grupoId") Integer grupoId,
                                      @RequestParam("email") String email,
                                      @RequestParam("pin") String pin,
                                      Model model) {
        try {
            Estudiante estudiante = estudianteServices.BuscarPorEmailYpin(email, pin);
            Grupo grupo = grupoServices.BuscarporId(grupoId).orElse(null);

            if (estudiante != null && grupo != null) {
                Asistencia asistencia = new Asistencia();
                asistencia.setEstudiante(estudiante); // Establecer estudiante
                asistencia.setGrupo(grupo); // Establecer grupo
                asistencia.setFecha(LocalDate.now()); // Establecer la fecha actual
                asistencia.setHoraDeEntrada(LocalTime.now()); // Establecer la hora actual
                asistenciaServices.CreaOeditar(asistencia);
                model.addAttribute("msg", "Asistencia registrada correctamente");
                return "asistencia/confirmacion";
            } else {
                model.addAttribute("error", "Credenciales incorrectas o grupo no encontrado");
                return "asistencia/login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar la asistencia: " + e.getMessage());
            return "asistencia/login";
        }
    }
}
