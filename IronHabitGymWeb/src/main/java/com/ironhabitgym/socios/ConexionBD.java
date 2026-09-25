package com.ironhabitgym.socios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexión JDBC a la misma base de datos MySQL usada por el backend PHP
 * (iron_habit_database, tabla socios). XAMPP local: root / sin contraseña.
 */
public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/iron_habit_database?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";

    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC de MySQL no encontrado. Verifica WEB-INF/lib.", e);
        }
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
