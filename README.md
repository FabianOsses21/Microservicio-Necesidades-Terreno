# Donaton - Microservicios Spring Boot

Este paquete incluye los microservicios completos y conectados entre sí:

| Microservicio | Puerto | Base de datos | Endpoint principal |
|---|---:|---|---|
| usuarios-service | 8081 | donaton_usuarios | /api/v1/usuarios |
| donaciones-service | 8082 | donaton_donaciones | /api/v1/donaciones |
| necesidades-terreno-service | 8083 | donaton_necesidades | /api/v1/necesidades |
| logistica-distribucion-service | 8084 | donaton_logistica | /api/v1/distribuciones |
| proyectoEnvio-service | 8085 | donaton_envios | /api/logistica |

## Conexiones entre microservicios

- Donaciones se conecta con Usuarios y Necesidades.
- Necesidades se conecta con Usuarios.
- Logística y Distribución se conecta con Donaciones y con el microservicio de Envios que enviaste.
- Envios quedó conectado de vuelta con Logística y Distribución mediante `/api/logistica/distribucion/{distribucionId}`.

## Antes de ejecutar

1. Crear las bases de datos usando `crear-bases-datos.sql`.
2. Ajusta usuario y contraseña de MySQL en cada `application.properties` si tu clave no es `1234`.
3. Ejecuta cada proyecto con:

```bash
mvn spring-boot:run
```

## Orden recomendado de arranque

1. usuarios-service
2. necesidades-terreno-service
3. donaciones-service
4. proyectoEnvio-service
5. logistica-distribucion-service

## Nota

Cada microservicio tiene su propia base de datos MySQL. Las relaciones entre servicios no se hicieron con foreign keys cruzadas, sino con IDs y llamadas REST, que es lo correcto en una arquitectura de microservicios.
