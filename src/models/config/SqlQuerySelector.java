package models.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlQuerySelector {
    private final Conexion conexion = new Conexion();
    private final String sql;
    private final Object[] variables;

    public SqlQuerySelector(String sql, Object... variables) {
        this.sql = sql;
        this.variables = variables;
    }

    public ResultSet ejecutar() {
        ResultSet resultado = null;
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i = 0; i < variables.length; i++) {
                stmt.setObject(i + 1, variables[i]);
            }
            resultado = stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return resultado;
    }

    public int actualizar() {
        int filasAfectadas = 0;
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i = 0; i < variables.length; i++) {
                stmt.setObject(i + 1, variables[i]);
            }
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return filasAfectadas;
    }

    public int crear() {
        int filasAfectadas = 0;
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i = 0; i < variables.length; i++) {
                stmt.setObject(i + 1, variables[i]);
            }
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return filasAfectadas;
    }

    public int eliminar() {
        int filasAfectadas = 0;
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i = 0; i < variables.length; i++) {
                stmt.setObject(i + 1, variables[i]);
            }
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return filasAfectadas;
    }


    public void Cerrar(){
        conexion.cerrarConexion();
    }

}
