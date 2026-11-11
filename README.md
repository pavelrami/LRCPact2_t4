# LRCPact2_t4 — Spring MVC, Thymeleaf, DTOs y Manejo de Peticiones

## Descripción

Proyecto desarrollado para la Actividad 2 de la materia de Programación Web.

Esta aplicación amplía los conocimientos adquiridos en la Actividad 1 mediante la implementación del patrón MVC (Modelo-Vista-Controlador), utilizando Spring Boot y Thymeleaf para crear páginas HTML dinámicas.

Se desarrolló un catálogo académico de materias que permite visualizar registros, consultar detalles, filtrar por categoría y registrar nuevas materias mediante formularios HTML.

También se implementó un endpoint REST que permite enviar información en formato JSON desde Postman.

El proyecto fue desplegado en Microsoft Azure de manera independiente a la Actividad 1.

## Tecnologías utilizadas

- Java 21 (versión objetivo de compilación)
- Spring Boot 4.1.2
- Spring MVC
- Thymeleaf
- Maven
- HTML5
- CSS3
- JSON
- Postman
- Git y GitHub
- Microsoft Azure
- Ubuntu 24.04

## Estructura del proyecto

```text
lrcpact2-t4/
├── src/
│   └── main/
│       ├── java/
│       │   └── act_1t4/
│       │       ├── Lrcpact1T4Application.java
│       │       ├── controller/
│       │       │   ├── ProyectoController.java
│       │       │   ├── MateriasController.java
│       │       │   ├── MateriaMvcController.java
│       │       │   └── MateriaApiController.java
│       │       ├── dto/
│       │       │   └── MateriaDTO.java
│       │       └── service/
│       │           └── MateriaService.java
│       └── resources/
│           ├── templates/
│           │   ├── materias.html
│           │   ├── formulario.html
│           │   └── detalle.html
│           ├── static/
│           │   └── css/
│           │       └── estilos.css
│           └── application.properties
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

El proyecto conserva algunos nombres de clases y paquetes de la Actividad 1 porque fue desarrollado a partir de una copia independiente del proyecto original.

## Patrón MVC

La aplicación implementa el patrón Modelo-Vista-Controlador para separar las responsabilidades.

### Modelo

Se implementó la clase `MateriaDTO`, utilizada para representar y transportar información de las materias.

El servicio `MateriaService` concentra las operaciones relacionadas con la consulta y registro de materias.

### Vista

Las interfaces se construyeron con Thymeleaf y HTML.

Se desarrollaron tres plantillas:

- `materias.html`: presenta el listado de materias.
- `formulario.html`: permite registrar nuevas materias.
- `detalle.html`: muestra la información individual de una materia.

### Controlador

`MateriaMvcController` recibe las peticiones HTTP, solicita la información correspondiente al servicio y la envía a las vistas mediante el objeto `Model`.

También se implementó `MateriaApiController` para recibir información JSON mediante peticiones REST.

## Funcionalidades

### 1. Listado dinámico de materias

La aplicación muestra un catálogo de materias utilizando Thymeleaf.

La instrucción `th:each` permite recorrer los elementos recibidos desde el controlador y generar una fila HTML por cada materia.

**Endpoint:**

`GET /mvc/materias`

### 2. Formulario de registro

Se desarrolló un formulario HTML que permite capturar la información de una nueva materia.

El formulario utiliza `@ModelAttribute` para asociar automáticamente los datos enviados con un objeto `MateriaDTO`.

**Endpoints:**

- `GET /mvc/materias/nuevo`
- `POST /mvc/materias/guardar`

### 3. Filtrado por categoría

Se implementó `@RequestParam` para recibir un parámetro de consulta desde la URL y filtrar las materias.

**Ejemplo:**

`GET /mvc/materias?categoria=Programacion`

### 4. Consulta de detalles

Se utilizó `@PathVariable` para recuperar el identificador de una materia desde la URL.

**Ejemplo:**

`GET /mvc/materias/1`

### 5. Registro mediante API REST

Se implementó un controlador REST con `@RequestBody` para recibir información JSON enviada desde Postman.

**Endpoint:**

`POST /api/materias`

Ejemplo de petición:

```json
{
  "nombre": "Ingeniería de Software",
  "categoria": "Programacion",
  "semestre": 7,
  "descripcion": "Análisis, diseño y desarrollo de sistemas de software."
}
```

## Endpoints del proyecto

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/mvc/materias` | Listar materias |
| GET | `/mvc/materias/nuevo` | Mostrar formulario |
| POST | `/mvc/materias/guardar` | Registrar materia desde HTML |
| GET | `/mvc/materias?categoria=Programacion` | Filtrar materias |
| GET | `/mvc/materias/{id}` | Consultar detalle |
| POST | `/api/materias` | Registrar materia mediante JSON |

Además, el proyecto conserva los endpoints REST originales de la Actividad 1.

## Conceptos implementados

### @Controller

Permite desarrollar controladores que devuelven vistas HTML procesadas por Thymeleaf.

### @RestController

Permite desarrollar controladores que devuelven directamente información en el cuerpo de la respuesta HTTP.

### @ModelAttribute

Asocia los datos enviados mediante un formulario HTML con los atributos de un objeto Java.

### @RequestBody

Convierte la información recibida en el cuerpo de una petición HTTP, como JSON, en un objeto Java.

### @RequestParam

Recupera valores enviados mediante parámetros de consulta en una URL.

### @PathVariable

Recupera valores que forman parte de la ruta de una petición.

### @Value

Permite obtener propiedades definidas en `application.properties`.

En el proyecto se utiliza para acceder a una propiedad relacionada con el nombre de la aplicación.

### DTO

Un Data Transfer Object es una clase que permite transportar datos entre distintas capas de una aplicación.

En este proyecto se utiliza `MateriaDTO`, que representa los atributos de una materia académica.

## Persistencia de datos

Para esta actividad se utilizó almacenamiento temporal en memoria mediante una colección de Java.

Esto permite registrar y consultar materias durante la ejecución de la aplicación, pero los registros agregados no se conservan después de reiniciar Spring Boot.

La implementación de persistencia con una base de datos real corresponde a la Actividad 3.

## Ejecución local

Dentro de la carpeta principal del proyecto, ejecutar:

```bash
./mvnw.cmd spring-boot:run
```

La aplicación se inicia localmente en el puerto 8080.

Abrir:

http://localhost:8080/mvc/materias

Formulario:

http://localhost:8080/mvc/materias/nuevo

Filtro:

http://localhost:8080/mvc/materias?categoria=Programacion

Detalle:

http://localhost:8080/mvc/materias/1

## Compilación

Para generar el archivo JAR:

```bash
./mvnw.cmd clean package
```

Archivo generado:

`target/lrcpact2-t4-0.0.1-SNAPSHOT.jar`

## Despliegue en Microsoft Azure

La Actividad 2 fue desplegada en una máquina virtual Ubuntu 24.04 de Microsoft Azure.

El proyecto utiliza el puerto 8083 para evitar conflictos con la Actividad 1, que utiliza el puerto 8081.

**Servidor:** `65.52.8.72`

**Directorio del proyecto:** `/home/azureuser/springboot-lrcp-act2/`

**Puerto:** `8083`

Comando de ejecución utilizado:

```bash
nohup java -Xms48m -Xmx192m -jar app.jar --server.port=8083 > spring.log 2>&1 < /dev/null &
```

### Enlaces públicos

- [Catálogo de materias](http://65.52.8.72:8083/mvc/materias)
- [Formulario de registro](http://65.52.8.72:8083/mvc/materias/nuevo)
- [Filtro por categoría](http://65.52.8.72:8083/mvc/materias?categoria=Programacion)
- [Detalle de materia](http://65.52.8.72:8083/mvc/materias/1)

**Actividad 1 funcionando en su puerto original:**

http://65.52.8.72:8081/proyecto

## Evidencias de funcionamiento

### Listado con Thymeleaf y th:each

![Listado de materias](docs/capturas/01-lista.png)

### Formulario con @ModelAttribute

![Formulario de registro](docs/capturas/02-formulario.png)

### Filtrado con @RequestParam

![Filtro por categoría](docs/capturas/03-filtro.png)

### Detalle con @PathVariable

![Detalle de materia](docs/capturas/04-detalle.png)

### Petición JSON con Postman

![Prueba de Postman](docs/capturas/05-postman.png)

### Despliegue en Azure

![Aplicaciones funcionando en Azure](docs/capturas/06-azure.png)

## Resultados

Con esta actividad se logró comprender e implementar el patrón MVC utilizando Spring Boot y Thymeleaf.

Se desarrollaron vistas HTML dinámicas, formularios para registrar materias, mecanismos de consulta y filtrado, y un endpoint REST para recibir información JSON.

También se comprendieron las diferencias entre `@ModelAttribute` y `@RequestBody`, así como las funciones de `@RequestParam`, `@PathVariable` y `@Value`.

Finalmente, la aplicación se desplegó de manera independiente en Azure, conservando el funcionamiento de la Actividad 1.

## Autor

**León Ramírez Carlos Pavel**

Ingeniería en Sistemas Computacionales

Materia: Programación Web

Actividad 2 — Spring MVC, Vistas con Thymeleaf, DTOs y Manejo de Peticiones