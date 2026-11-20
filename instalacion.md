#  Guía de Instalación y Configuración

Sigue estas instrucciones paso a paso para clonar, configurar y ejecutar el proyecto en un entorno local.

---

##  Requisitos Previos

Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas en tu equipo:

1. **Java Development Kit (JDK) 21:** Indispensable para compilar y ejecutar el proyecto. Puedes verificar tu versión ejecutando `java -version` en tu terminal (CMD) se recomienda el de Oracle.
2. **Servidor MySQL (8.0 o superior):** Recuerda, es mas intuitivo utilizar My SQL server si instalas  MySQL Workbench (8.0 o superior).
3. **IDE Recomendado:** IntelliJ IDEA 2024.1.7 (Community) o Visual Studio Code con el paquete de extensiones de Java (preferentemente IntelliJ IDEA para este programa).
4. **Cliente HTTP:** Debes instalar Postman para probar los endpoints.

---

## ️ Paso 1: Configuración de la Base de Datos

1. Inicia tu servicio local de **MySQL**.
2. Crea la base de datos ejecutando la siguiente sentencia en tu gestor SQL(**nota esto es importante ya que el programa no crea la base de datos  automaticamente**): 
   ```sql
   CREATE DATABASE granja;
   
   ```
3. 

---

##  Paso 2: Configuración del Proyecto en IntelliJ IDEA

1. **Obtener el código:** Descarga o clona el repositorio en tu computadora. *(Nota: Si transfieres el proyecto manualmente, asegúrate de no copiar las carpetas ocultas `.idea` ni `target`)*.
2. **Abrir como proyecto Maven:**
    * Abre IntelliJ IDEA y haz clic en **Open**.
    * Navega hasta la carpeta del proyecto, selecciona directamente el archivo **`pom.xml`** y haz clic en **OK**.
    * Cuando el editor lo solicite, selecciona **Open as Project**.
3.  **Si clonas el codigo:** Para clonar el codigo necesitas abrir el programa IntelliJ IDEA 2024.1.7, En la pantalla de bienvenida ve a Get from VCS (o en el menú superior: Git > Clone...). Pega la URL del repositorio de GitHub y haz clic en Clone.
    * Esta es la URL: https://github.com/LDSM-24000875-DiegoOswaldoSerranoAngulo/Granja.git
4.**Configurar credenciales de MySQL:**
    * Dirígete a `src/main/resources/application.properties` (asegúrate de que el archivo esté codificado en **UTF-8**).
    * Ajusta los parámetros de conexión según tu entorno local:

```properties
# Puerto del servidor (puedes usar 8080 u 8081 si el primero está ocupado)
server.port=8081

# Credenciales de Base de Datos MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/ejemplo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=tu_contraseña_aqui
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

---
**Nota:** Recuerda crear tu base de datos y poner el nombre de granja en aplication.properties. Justo donde diga ejemplo.
##  Paso 3: Compilación y Ejecución

### Opción A: Desde IntelliJ IDEA
1. Abre la clase principal `GranjaApplication.java`.
2. Haz clic en el botón **Run (Play verde)** en la barra superior.
3. Verifica en la consola inferior que aparezca el mensaje: `Started CrudApplication in X seconds`.

### Opción B: Desde la Terminal (Maven Wrapper)
Si prefieres compilar y ejecutar desde la consola dentro de la raíz del proyecto(puedes hacerlo desde el mismo IntelliJ IDEA en la parte inferior izquierda):

```bash
# En Windows (PowerShell o CMD)
.\mvnw clean install -DskipTests
.\mvnw spring-boot:run
```

---

##  Solución de Problemas Comunes

* **Error `Port 8080/8081 was already in use`:** Cambia el valor de `server.port` en `application.properties` a otro puerto libre (ej. `8082`) o libera el puerto desde CMD como administrador usando `netstat -ano | findstr :8081` y `taskkill /PID <numero> /F`.
* **Error de codificación (`MalformedInputException`):** Asegúrate de que `application.properties` no contenga acentos ni caracteres especiales (como la letra `ñ`) y esté guardado en formato **UTF-8**.
* **Error al ejecutar desde GranjaApplication:** puedes usar la terminal, asegurate de que el prompt diga al final `Granja>` para poder utilizar el comando `.\mvnw spring-boot:run` 