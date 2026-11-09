package act_1t4.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MateriasController {

    @GetMapping("/materias")
    public List<Map<String, Object>> listarMaterias() {
        return List.of(
            Map.of(
                "id", 1,
                "nombre", "Programacion Web",
                "semestre", 7
            ),
            Map.of(
                "id", 2,
                "nombre", "Gestion de Proyectos de Software",
                "semestre", 7
            ),
            Map.of(
                "id", 3,
                "nombre", "Lenguajes y Automatas II",
                "semestre", 7
            )
        );
    }

    @GetMapping("/saludo")
    public String saludar() {
        return "Hola, esta es mi primera API con Spring Boot - LRCP";
    }
}