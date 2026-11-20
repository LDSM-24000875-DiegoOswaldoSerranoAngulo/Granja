# Granja

API REST para administrar los **animales** y los **granjeros** de una granja.

Permite crear, consultar, actualizar y eliminar registros de ambos recursos, almacenados en una base de datos MySQL.

## Requisitos

- Java 21 (JDK 21).
- MySQL Server 8.0 o superior.
- MySQL Workbench 8.0 o superior.
- Puerto 3306 disponible.
- Spring Boot 4.1.2 (se descarga automáticamente con Maven).
- Maven Wrapper incluido en el proyecto.

## Instalación rápida

1. Clona el repositorio:

   ```bash
   git clone <URL-DEL-REPOSITORIO>
   cd Granja
   ```

2. Crea la base de datos en MySQL:

   ```sql
   CREATE DATABASE granja;
   ```

3. Configura tu usuario y contraseña de MySQL en `src/main/resources/application.properties`.

4. Ejecuta el proyecto:

   En Windows:

   ```bash
   mvnw.cmd spring-boot:run
   ```

   En Linux o macOS:

   ```bash
   ./mvnw spring-boot:run
   ```

Los pasos completos se encuentran en [INSTALACION.md](INSTALACION.md).

## Uso básico

1. Con el proyecto iniciado, abre en el navegador:

   `http://localhost:8080/api/v1/animales`

2. Si la base de datos no contiene registros, debe mostrar una lista vacía:

   ```json
   []
   ```

   Esto indica que el endpoint responde correctamente.

### Endpoints

Animales (`/api/v1/animales`) y granjeros (`/api/v1/granjeros`) cuentan con las siguientes operaciones:

- **GET** `/` lista todos los registros.
- **GET** `/{id}` consulta un registro específico.
- **POST** `/` crea un nuevo registro.
- **PUT** `/{id}` actualiza un registro existente.
- **DELETE** `/{id}` elimina un registro.

Ejemplo para registrar un animal:

```bash
curl -X POST http://localhost:8080/api/v1/animales \
  -H "Content-Type: application/json" \
  -d '{"tipo_animal":"Vaca","peso":450.5,"años":4}'
```

Ejemplo para registrar un granjero:

```bash
curl -X POST http://localhost:8080/api/v1/granjeros \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Juan","pago":2500.0,"rol_trabajo":"Cuidador"}'
```

Para ver cómo usarlo paso a paso, consulta el **Manual sencillo para registrar, consultar y administrar los datos de la Granja** incluido en la documentación del proyecto.
## Tecnologías

- Java 21.
- Spring Boot 4.1.2 (Web MVC, Data JPA y Validation).
- Hibernate.
- MySQL.
- Lombok.
- Maven.

## Estructura

```text
src/main/java/app/utl/granja/
├── Controller/       Reciben las peticiones HTTP
├── Service/          Contienen la lógica de cada recurso
├── Repository/       Acceso a la base de datos
├── Entities/         Animal y Granjero
├── DTOs/             Objetos de transferencia de datos
├── Exception/        Manejo de excepciones
└── GranjaApplication.java

src/main/resources/
└── application.properties
```

La configuración de conexión a MySQL se encuentra en `src/main/resources/application.properties`.

## Autores

Integrantes del equipo:

- [Diego Oswaldo Serrano Angulo]
- [Jose Misael Claudio Roque]
- [Paulo Jahaziel Alcaraz Ramirez]

Grupo: [LDSM41D] — Universidad Tecnológica de León (UTL).