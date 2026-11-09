package act_1t4.controller;

import act_1t4.dto.MateriaDTO;
import act_1t4.service.MateriaService;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/materias")
public class MateriaApiController {
    private final MateriaService servicio;

    public MateriaApiController(MateriaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public java.util.List<MateriaDTO> listar() {
        return servicio.listar("");
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> ver(@PathVariable("id") Long id) {
        MateriaDTO materia = servicio.buscarPorId(id);
        return materia == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(materia);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody MateriaDTO materia) {
        if (materia.getNombre() == null || materia.getNombre().isBlank() ||
            materia.getCategoria() == null || materia.getCategoria().isBlank() ||
            materia.getSemestre() == null || materia.getSemestre() < 1) {
            return ResponseEntity.badRequest().body(Map.of("error", "Nombre, categoria y semestre valido son obligatorios"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardar(materia));
    }
}
