package models.tablasAuxiliares;

import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaProfesional {

    private int id;
    private String description;

    public AreaProfesional(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public AreaProfesional (){}

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

    public AreaProfesional getAreaProfesional(int id) {

        String sql = "SELECT * FROM area_profesionals WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);
        AreaProfesional miarea = null;
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                this.description = resultado.getString("description");
                miarea = new AreaProfesional(id, description);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
        return miarea;
    }

    public List<AreaProfesional> obtenerAreasProfesionales() {
        List<AreaProfesional> areas = new ArrayList<>();
        String sql = "SELECT * FROM area_profesionals";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                AreaProfesional area = new AreaProfesional();
                area.setId(resultado.getInt("id"));
                area.setDescription(resultado.getString("description"));
                areas.add(area);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return areas;
    }

    public String toString() {
        List<AreaProfesional> areas = obtenerAreasProfesionales();
        for (AreaProfesional area : areas) {
            System.out.println("id: "+area.getId());
            System.out.println("descripcion : "+area.getDescription());
        }
        return null;
    }

}
