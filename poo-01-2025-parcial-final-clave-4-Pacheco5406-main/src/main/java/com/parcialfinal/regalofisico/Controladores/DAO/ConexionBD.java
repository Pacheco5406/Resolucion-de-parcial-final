package com.parcialfinal.regalofisico.Controladores.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Singleton para gestionar la conexión a la base de datos SQL Server.
 */
public class ConexionBD {

    // URL de conexión al servidor SQL Server
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=RegalosFDB;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";

    // Instancia única de la conexión activa
    private static Connection connection;

    // Instancia única de la clase ConexionBD (patrón Singleton)
    private static ConexionBD instancia;

    /**
     * Constructor privado.
     * Se ejecuta solo una vez para crear la conexión inicial.
     * Evita la instanciación directa desde otras clases.
     */
    private ConexionBD() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene la instancia única de la clase ConexionBD.
     * Si aún no existe, la crea.
     *
     * @return instancia de ConexionBD
     */
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    /**
     * Devuelve la conexión activa.
     * Si está cerrada o no existe, se crea una nueva.
     *
     * @return conexión activa a la base de datos
     */
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Método de prueba para verificar si la conexión a la base de datos es correcta.
     * Imprime en consola el resultado.
     */
    public static void testConexion() {
        Connection conn = ConexionBD.getInstancia().getConnection();
        try {
            if (conn != null && !conn.isClosed()) {
                System.out.println("¡Conexión exitosa a SQL Server!");
            } else {
                System.out.println(" No se pudo conectar a la base de datos.");
            }
        } catch (Exception e) {
            System.out.println(" Error al intentar conectar con la base de datos:");
            e.printStackTrace();
        }
    }

}
