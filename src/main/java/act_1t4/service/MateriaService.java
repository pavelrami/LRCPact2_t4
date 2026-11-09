package act_1t4.service;

import act_1t4.dto.MateriaDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import org.springframework.stereotype.Service;

@Service
public class MateriaService {
    // Almacenamiento de demostracion: no hay base de datos en esta actividad.
    private final Map<Long, MateriaDTO> materias = new LinkedHashMap<>();
    private long siguienteId = 1;

    public MateriaService() {
        guardar(new MateriaDTO(null, "Programacion web", "Programacion", 7,
            "Desarrollo de aplicaciones web y consumo de APIs."));
        guardar(new MateriaDTO(null, "Gestion de Proyectos de Software", "Gestion", 7,
            "Planeacion, seguimiento y calidad de proyectos de software."));
        guardar(new MateriaDTO(null, "Lenguajes y Automatas II", "Programacion", 7,
            "Procesamiento de lenguajes, gramaticas y compiladores."));
    }

    public synchronized List<MateriaDTO> listar(String categoria) {
        String filtro = categoria == null ? "" : categoria.trim();
        List<MateriaDTO> resultado = new ArrayList<>();
        for (MateriaDTO materia : materias.values()) {
            if (filtro.isEmpty() || materia.getCategoria().equalsIgnoreCase(filtro)) {
                resultado.add(materia);
            }
        }
        return resultado;
    }

    public synchronized MateriaDTO buscarPorId(Long id) {
        return materias.get(id);
    }

    public synchronized MateriaDTO guardar(MateriaDTO entrada) {
        MateriaDTO nueva = new MateriaDTO(
            siguienteId++,
            entrada.getNombre() == null ? "" : entrada.getNombre().trim(),
            entrada.getCategoria() == null ? "" : entrada.getCategoria().trim(),
            entrada.getSemestre(),
            entrada.getDescripcion() == null ? "" : entrada.getDescripcion().trim()
        );
        materias.put(nueva.getId(), nueva);
        return nueva;
    }
}
