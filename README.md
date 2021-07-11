# UDParkingJon
UDParking

## PASOS PARA EJECUTAR
*WINDOWS*

Crear una base de datos llamada parking y dar permisos al usuario por defecto

    DROP SCHEMA parking;
    CREATE DATABASE parking;
    CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
    GRANT ALL ON parking.* TO 'spq'@'localhost';

La configuración por defecto para la base de datos y los usuarios puede ser actualizada en el fichero resources/datanucleus.properties.

===================================================================================


CREACION DE LAS TABLAS

---

Antes de crear las tablas es necesario ejecutar el Enchance del proyecto

    mvn datanucleus:enhance

Para la creación de las tablas se debe ejecutar el comando de maven

    mvn compile datanucleus:schema-create

DATOS DE PRUEBA

---

Se pueden introducir datos de prueba en la aplicación utilizando el comando de maven

    mvn exec::java -Pdatos

INICIO DEL SERVIDOR

---

El servidor REST de la aplicación se lanza utilizando el comando

    mvn exec::java

Si el servidor ha sido iniciado correctamente se pueden obtener los datos de prueba accediendo con el navegador a la URL http://localhost:8080/myapp/vehiculos.


INICIO DE LA APLICACION CLIENTE

---

La aplicación cliente puede iniciarse usando el comando

    mvn exec::java -Pcliente
  
==================================================================================

## TESTS

Para comprobar los teses unitarios

    mvn -Punit test
    
Para comprobar los teses de integracion

    mvn -Pperf verify
    
Para comprobar los teses de la ventana

    mvn -Pgui verify
    
Para comprobar los todos los teses

    mvn -Pfull test
    
===================================================================================

DOCUMENTACIÓN

Para generar la documentación mediante Doxyfile
    
    mvn doxygen:report
    
 ---

## Contributors

- Jon Ibarreche <jon.ibarreche@opendeusto.es>
---
