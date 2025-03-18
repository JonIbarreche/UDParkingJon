# ParkingManager: Professional Parking Management System

ParkingManager is a Java application for vehicle and parking management that allows efficient administration of parking tickets. Developed using JDO (Java Data Objects) technologies and a REST client-server architecture.

## Features

- ✅ Detailed vehicle information management
- ✅ Comprehensive parking space administration
- ✅ Intuitive graphical user interface
- ✅ MySQL database for persistent storage
- ✅ REST API for client-server communication
- ✅ Complete documentation with Doxygen

## Prerequisites

- Java 7 or higher
- Maven 3.x
- MySQL Server

## Installation and Configuration

### Database Setup

Create a MySQL database called `parking` and grant permissions to the default user:

```sql
DROP SCHEMA IF EXISTS parking;
CREATE DATABASE parking;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON parking.* TO 'spq'@'localhost';
```

> **Note**: Default database configuration can be modified in the `resources/datanucleus.properties` file.

### Database Schema Preparation

Before creating the tables, it's necessary to enhance the project:

```bash
mvn datanucleus:enhance
```

To create the tables, execute:

```bash
mvn compile datanucleus:schema-create
```

### Test Data

To load test data into the application:

```bash
mvn exec:java -Pdatos
```

## Execution

### Starting the Server

The REST server is started with the command:

```bash
mvn exec:java
```

If the server starts correctly, you can verify it by accessing:
http://localhost:8080/myapp/vehiculos

### Starting the Client Application

The client application is started with:

```bash
mvn exec:java -Pcliente
```

## Testing

ParkingManager includes different types of tests to ensure software quality:

| Test Type | Command |
|----------------|---------|
| Unit tests | `mvn -Punit test` |
| Integration tests | `mvn -Pperf verify` |
| GUI tests | `mvn -Pgui verify` |
| All tests | `mvn -Pfull test` |

## Documentation

To generate documentation using Doxygen:

```bash
mvn doxygen:report
```

The generated documentation will be available in the `target/site/doxygen` folder.

## Project Structure

```
ParkingManager/
├── src/
│   ├── main/
│   │   ├── java/es/deusto/spq/
│   │   │   ├── gui/         # Graphical interfaces
│   │   │   ├── jdo/         # Data objects (entities)
│   │   │   ├── resources/   # REST resources
│   │   │   └── util/        # Utilities
│   │   └── resources/       # Configuration files
│   └── test/                # Tests
└── docs/                    # Additional documentation
```

## Contributors

- Jon Ibarreche <jon.ibarreche@opendeusto.es>

## License

Copyright © 2021 Jon Ibarreche - All rights reserved
