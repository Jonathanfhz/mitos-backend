# Mitos - API REST Backend 

Este repositorio contiene el desarrollo del **backend** para una aplicación de conexión y dinámicas sentimentales en pareja. El sistema está diseñado bajo una arquitectura limpia por capas (Controlador, Servicio, Repositorio) para gestionar usuarios, estados de relación y flujos de interacción de forma segura y eficiente.

## Tecnologías Utilizadas

* **Lenguaje:** Java
* **Framework:** Spring Boot (Spring Web, Spring Data JPA)
* **Base de Datos:** PostgreSQL
* **Gestor de Dependencias:** Maven

## Arquitectura y Módulos Principales

El proyecto está estructurado de forma modular para garantizar la escalabilidad:

*`com.mitos.user`: Gestión de perfiles de usuario, registros y datos esenciales.
 `com.mitos.relationship`: Control del estado de las relaciones (pendientes, activas, histórico) y lógica de conexión entre usuarios.

## Próximas Implementaciones

* Integración de seguridad y autenticación con JWT (JSON Web Tokens).
* Desarrollo de la API de dinámicas, retos cotidianos y preguntas para parejas.
* Despliegue del entorno y conexión con el Frontend.