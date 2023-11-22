package models.tablasAuxiliares;

import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NivelDeEstudios {

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
    public void  getNivelDeEstudio(int id) {

        String sql = "SELECT * FROM nivel_de_estudios WHERE id = ?";
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

    public List<NivelDeEstudios> obtenerNivel_de_estudios() {
        List<NivelDeEstudios> estudios = new ArrayList<>();
        String sql = "SELECT * FROM nivel_de_estudios";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                NivelDeEstudios estudio = new NivelDeEstudios();
                estudio.setId(resultado.getInt("id"));
                estudio.setDescription(resultado.getString("description"));
                estudios.add(estudio);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return estudios;
    }

    public String toString() {
        List<NivelDeEstudios> estudios = obtenerNivel_de_estudios();
        for (NivelDeEstudios estudio : estudios) {
            System.out.println("id: "+estudio.getId());
            System.out.println("descripcion : "+estudio.getDescription());
        }
        return null;
    }

}
