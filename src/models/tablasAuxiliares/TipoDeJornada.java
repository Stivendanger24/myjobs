package models.tablasAuxiliares;

import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDeJornada {

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

    public void  getTipoDeJornada(int id) {

        String sql = "SELECT * FROM tipo_de_jornadas WHERE id = ?";
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

    public List<TipoDeJornada> obtenerTiposDeJornadas() {
        List<TipoDeJornada> jornadas = new ArrayList<>();
        String sql = "SELECT * FROM tipo_de_jornadas";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                TipoDeJornada jornada = new TipoDeJornada();
                jornada.setId(resultado.getInt("id"));
                jornada.setDescription(resultado.getString("description"));
                jornadas.add(jornada);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return jornadas;
    }

    public String toString() {
        List<TipoDeJornada> jornadas = obtenerTiposDeJornadas();
        for (TipoDeJornada jornada : jornadas) {
            System.out.println("id: "+jornada.getId());
            System.out.println("descripcion : "+jornada.getDescription());
        }
        return null;
    }

}
