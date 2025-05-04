# 📩 Sistema de Gestión de Registros y Notificaciones vía Correo Electrónico

Proyecto backend desarrollado en Java con Spring Boot que permite gestionar registros de nuevos usuarios desde una **Landing Page**, enviando notificaciones automáticas por **correo electrónico** al administrador.

## 🛠 Tecnologías utilizadas

- ✅ **Java 17**
- ✅ **Spring Boot**
- ✅ **Spring Web (RESTful API)**
- ✅ **Lombok**
- ✅ **JavaMailSender**
- ✅ **Railway (despliegue)**
- ✅ **Google Apps (para gestión de correo)**

## 🚀 Funcionalidades

- Recepción de datos desde una landing page (nombre, apellido, correo, número).
- Envío automático de correos electrónicos al administrador con los datos del nuevo usuario registrado.
- Arquitectura RESTful limpia y mantenible.
- Proyecto desplegado en Railway para pruebas y demostraciones.

## 📬 Flujo del sistema

1. El usuario se registra desde una Landing Page.
2. El frontend consume el endpoint del backend.
3. El backend procesa la solicitud y envía un correo al administrador con los datos del nuevo registro.

## 📦 Instalación y ejecución local

1. Clona el repositorio:
   ```bash
   git clone https://github.com/LuisOrihuela08/control-usuariosAPI.git
   cd control-usuariosAPI

2. Configurar tu archivo .env con las credenciales de acuerdo al archivo yml del proyecto
   ```bash
   MAIL_HOST=smtp.gmail.com
   MAIL_PORT=587
   MAIL_USERNAME=tu_correo@gmail.com
   MAIL_PASSWORD=tu_contraseña_app

3. Ejecutar el proyecto
   ```bash
   ./mvnw spring-boot:run

4. Frontend (Landing Page) de prueba para la API
   ```bash
   https://github.com/LuisOrihuela08/control-usuarios-frontend.git

## 👨‍💻 Autor
Luis Orihuela Orozco | 
Backend Developer - 2024
