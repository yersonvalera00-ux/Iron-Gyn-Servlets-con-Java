# Evidencia GA7-220501096-AA2-EV02: Módulos de software codificados y probados

## 📌 Datos del Aprendiz y Proyecto
* **Aprendiz:** Yerson Valera
* **Programa:** Análisis y Desarrollo de Software (ADSO)
* **Código de Evidencia:** GA7-220501096-AA2-EV02
* **Nombre del Proyecto:** Iron Habit Gym Web (`IronHabitGymWeb`)
* **Módulo Codificado:** Módulo de Gestión de Socios (CRUD con Servlets, JSP y MySQL)

* **Repositorio: https://github.com/yersonvalera00-ux/Iron-Gyn-Servlets-con-Java.git

## 🚀 Descripción del Proyecto
Este módulo permite realizar la gestión integral (Crear, Leer, Actualizar y Eliminar) de los socios del gimnasio Iron Habit Gym. Implementa una arquitectura Java Web clásica basada en el patrón MVC (Modelo-Vista-Controlador), separando la lógica de acceso a datos (DAO), el controlador (Servlet) y la presentación (JSP).

## 🛠️ Tecnologías Utilizadas
* Lenguaje: Java (JDK 11 / 17)

* Tecnología Web: Java Servlets & JavaServer Pages (JSP)

* Librerías / Elementos JSP: JSTL (JavaServer Pages Standard Tag Library) y Expression Language (EL ${...})

* Servidor de Aplicaciones: Apache Tomcat 9.0 / 10.0

* Base de Datos: MySQL / MariaDB

* Conector BD: MySQL Connector/J (JDBC Driver)

* IDE Recomendado: Eclipse IDE for Enterprise Java and Web Developers

* Control de Versiones: Git & GitHub

## 💻 2. Instrucciones para Importar y Ejecutar en Eclipse
Importar el proyecto:

Abre Eclipse IDE.

Ve a File -> Import... -> General -> Existing Projects into Workspace.

Selecciona la carpeta del proyecto IronHabitGymWeb y haz clic en Finish.

Configurar el servidor Apache Tomcat:

En la pestaña Servers de Eclipse, añade un servidor Apache Tomcat (v9.0 o v10.0).

Haz clic derecho sobre el proyecto IronHabitGymWeb -> Properties -> Targeted Runtimes y asegúrate de marcar tu servidor Tomcat.

Verificar el conector JDBC:

Asegúrate de que el archivo .jar de MySQL Connector esté presente en la carpeta WebContent/WEB-INF/lib/ o src/main/webapp/WEB-INF/lib/.

Desplegar y Ejecutar:

Haz clic derecho sobre el proyecto IronHabitGymWeb -> Run As -> Run on Server.

Selecciona el servidor Tomcat configurado y presiona Finish.

Acceso a la Aplicación:
Abre tu navegador web e ingresa a la siguiente URL:

* **[link](http://localhost:8080/IronHabitGymWeb/socios?accion=listar) http://localhost:8080/IronHabitGymWeb/socios?accion=listar
