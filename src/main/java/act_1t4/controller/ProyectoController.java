package act_1t4.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {

    @GetMapping("/proyecto")
    public Map<String, String> obtenerProyecto() {
        return Map.of(
            "nombre", "LRCPact1_t4",
            "descripcion", "Primera API con Spring Boot",
            "materia", "Programacion web",
            "tecnologia", "Java y Spring Boot"
        );
    }
}