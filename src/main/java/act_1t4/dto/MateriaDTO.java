package act_1t4.dto;

public class MateriaDTO {
    private Long id;
    private String nombre;
    private String categoria;
    private Integer semestre;
    private String descripcion;

    public MateriaDTO() {
    }

    public MateriaDTO(Long id, String nombre, String categoria, Integer semestre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.semestre = semestre;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getSemestre() { return semestre; }
    public void setSemestre(Integer semestre) { this.semestre = semestre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
