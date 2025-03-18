# GestorParking: Sistema de Gestión de Estacionamientos

GestorParking es una aplicación Java para la gestión de vehículos y estacionamientos que permite administrar tickets de aparcamiento. Desarrollada utilizando tecnologías JDO (Java Data Objects) y una arquitectura cliente-servidor REST.

## Características

- ✅ Gestión de vehículos con información detallada
- ✅ Administración de estacionamientos 
- ✅ Interfaz gráfica intuitiva para el usuario
- ✅ Base de datos MySQL para almacenamiento persistente
- ✅ API REST para comunicación cliente-servidor
- ✅ Documentación completa con Doxygen

## Requisitos previos

- Java 7 o superior
- Maven 3.x
- MySQL Server

## Instalación y configuración

### Configuración de la base de datos

Cree una base de datos MySQL llamada `parking` y otorgue permisos al usuario por defecto:

```sql
DROP SCHEMA IF EXISTS parking;
CREATE DATABASE parking;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON parking.* TO 'spq'@'localhost';
```

> **Nota**: La configuración por defecto para la base de datos puede ser modificada en el archivo `resources/datanucleus.properties`.

### Preparación del esquema de base de datos

Antes de crear las tablas, es necesario ejecutar el enhance del proyecto:

```bash
mvn datanucleus:enhance
```

Para la creación de las tablas, ejecute:

```bash
mvn compile datanucleus:schema-create
```

### Datos de prueba

Para cargar datos de prueba en la aplicación:

```bash
mvn exec:java -Pdatos
```

## Ejecución

### Iniciar el servidor

El servidor REST se inicia con el comando:

```bash
mvn exec:java
```

Si el servidor arranca correctamente, puede verificarlo accediendo a:
http://localhost:8080/myapp/vehiculos

### Iniciar la aplicación cliente

La aplicación cliente se inicia con:

```bash
mvn exec:java -Pcliente
```

## Pruebas

GestorParking incluye diferentes tipos de pruebas para garantizar la calidad del software:

| Tipo de prueba | Comando |
|----------------|---------|
| Pruebas unitarias | `mvn -Punit test` |
| Pruebas de integración | `mvn -Pperf verify` |
| Pruebas de interfaz gráfica | `mvn -Pgui verify` |
| Todas las pruebas | `mvn -Pfull test` |

## Documentación

Para generar la documentación mediante Doxygen:

```bash
mvn doxygen:report
```

La documentación generada estará disponible en la carpeta `target/site/doxygen`.

## Estructura del proyecto

```
UDParking/
├── src/
│   ├── main/
│   │   ├── java/es/deusto/spq/
│   │   │   ├── gui/         # Interfaces gráficas
│   │   │   ├── jdo/         # Objetos de datos (entidades)
│   │   │   ├── resources/   # Recursos REST
│   │   │   └── util/        # Utilidades
│   │   └── resources/       # Archivos de configuración
│   └── test/                # Pruebas
└── docs/                    # Documentación adicional
```

## Contribuidores

- Jon Ibarreche <jon.ibarreche@opendeusto.es>

## Licencia

Copyright © 2021-2023 Universidad de Deusto
