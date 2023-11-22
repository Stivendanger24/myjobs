package models.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conn;


    public Conexion() {
        try {
            // Paso 1: Cargar el driver JDBC.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Paso 2: Establecer la conexión con la base de datos.
            String usuario = "myjobs";
            String password = "desarrollo2022";
            String url = "jdbc:mysql://localhost:3306/myjobs";
            conn = DriverManager.getConnection(url, usuario, password);

            // Paso 3: Mostrar mensaje de conexión exitosa.
            System.out.println("Conexión realizada.");

        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
            System.exit(0); // Cerrar la aplicación
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver JDBC: " + e.getMessage());
            System.exit(0); // Cerrar la aplicación
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void cerrarConexion() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
