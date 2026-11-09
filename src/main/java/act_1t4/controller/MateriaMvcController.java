package act_1t4.controller;

import act_1t4.dto.MateriaDTO;
import act_1t4.service.MateriaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/mvc/materias")
public class MateriaMvcController {
    private final MateriaService servicio;

    @Value("${app.nombre}")
    private String nombreProyecto;

    public MateriaMvcController(MateriaService servicio) {
        this.servicio = servicio;
    }

    @ModelAttribute("appNombre")
    public String nombreProyectoParaVista() {
        return nombreProyecto;
    }

    @GetMapping
    public String listar(@RequestParam(name = "categoria", defaultValue = "") String categoria, Model model) {
        model.addAttribute("materias", servicio.listar(categoria));
        model.addAttribute("categoriaActual", categoria);
        return "materias";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("materia", new MateriaDTO());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarDesdeFormulario(@ModelAttribute("materia") MateriaDTO materia) {
        MateriaDTO guardada = servicio.guardar(materia);
        return "redirect:/mvc/materias/" + guardada.getId();
    }

    @GetMapping("/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        MateriaDTO materia = servicio.buscarPorId(id);
        if (materia == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Materia no encontrada");
        }
        model.addAttribute("materia", materia);
        return "detalle";
    }
}
