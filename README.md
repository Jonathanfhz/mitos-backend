# Mitos - REST API Backend

Backend en desarrollo para una aplicación de conexión entre usuarios basada en relaciones uno a uno.  
El sistema permite gestionar usuarios y solicitudes de conexión entre ellos, simulando un flujo básico de interacción.

Este proyecto está construido como práctica de backend con Spring Boot, centrado en arquitectura limpia y persistencia de datos.

---

## Tecnologías

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (entorno de desarrollo)
- Maven

---

## Arquitectura

El proyecto sigue una arquitectura por capas:

- **Controller** → expone endpoints REST
- **Service** → contiene la lógica de negocio
- **Repository** → acceso a datos con Spring Data JPA
- **Entity** → modelo de base de datos

---

## Módulos del sistema

### User
Gestión de usuarios del sistema.
Permite la creación y consulta de perfiles básicos.

### Relationship
Gestión de solicitudes de conexión entre usuarios.

Actualmente soporta:
- Creación de solicitudes (estado PENDING)
- Relación entre dos usuarios existentes

---

## API REST

### Crear usuario
`POST /users`

---

### Listar usuarios
`GET /users`

---

### Crear solicitud de relación
`POST /relationships/request?user1Id={id}&user2Id={id}`

Ejemplo:
`POST /relationships/request?user1Id=1&user2Id=2`

---

## Estado actual del proyecto

- ✔ Creación de usuarios
- ✔ Listado de usuarios
- ✔ Creación de relaciones (PENDING)
- ✔ Relación entre entidades con JPA (ManyToOne)
- ✔ Base de datos en memoria (H2)
- ✔ API REST funcional probada con Postman

---

## Decisiones técnicas

- Uso de H2 en memoria para acelerar desarrollo y pruebas
- Separación por capas para mantener escalabilidad
- Uso de Spring Data JPA para simplificar persistencia
- Diseño orientado a futuras ampliaciones (estados de relación, autenticación)

---

## Próximas mejoras

- Sistema de aceptación/rechazo de relaciones
- Estados de relación (PENDING / ACCEPTED / REJECTED)
- Prevención de relaciones duplicadas
- Migración a PostgreSQL
- Autenticación con JWT
- Preparación para despliegue en entorno cloud

---

## Objetivo del proyecto

Construir una API REST backend escalable que simule dinámicas reales de conexión entre usuarios, con lógica de relaciones y estados de interacción entre perfiles.