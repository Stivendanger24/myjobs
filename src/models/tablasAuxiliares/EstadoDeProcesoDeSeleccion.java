package models.tablasAuxiliares;

import models.config.SqlQuerySelector;
import models.oferta.PreguntasDeSeleccion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDeProcesoDeSeleccion {

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

    public void  getEstado_de_proceso_de_seleccions(int id) {

        String sql = "SELECT * FROM estado_de_proceso_de_seleccions WHERE id = ?";
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
    }

    public List<EstadoDeProcesoDeSeleccion> obtenerEstados_de_proceso_de_seleccions() {
        List<EstadoDeProcesoDeSeleccion> estados = new ArrayList<>();
        String sql = "SELECT * FROM estado_de_proceso_de_seleccions";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                EstadoDeProcesoDeSeleccion estado = new EstadoDeProcesoDeSeleccion();
                estado.setId(resultado.getInt("id"));
                estado.setDescription(resultado.getString("description"));
                estados.add(estado);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return estados;
    }

    public String toString() {
        List<EstadoDeProcesoDeSeleccion> estados = obtenerEstados_de_proceso_de_seleccions();
        for (EstadoDeProcesoDeSeleccion estado : estados) {
            System.out.println("id: "+estado.getId());
            System.out.println("descripcion : "+estado.getDescription());
        }
        return null;
    }

}
