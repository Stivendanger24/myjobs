package models.tablasAuxiliares;

import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDeIdentificacion {

    private int id;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTipoDeIdentificacion(int id) {

        String sql = "SELECT * FROM tipo_de_identificacions WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.description = resultado.getString("description");
                System.out.println("Descripcion : "+description);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
        return description;
    }

    public List<TipoDeIdentificacion> obtenerTiposDeIdentificaciones() {
        List<TipoDeIdentificacion> identificaciones = new ArrayList<>();
        String sql = "SELECT * FROM tipo_de_identificacions";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                TipoDeIdentificacion identificacion = new TipoDeIdentificacion();
                identificacion.setId(resultado.getInt("id"));
                identificacion.setDescription(resultado.getString("description"));
                identificaciones.add(identificacion);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return identificaciones;
    }

    public String toString() {
        return description;
    }

}
