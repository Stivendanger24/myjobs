package models.tablasAuxiliares;

import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerfilDeTrabajo {

    private int id;
    private String description;
    public  PerfilDeTrabajo(){}
    public PerfilDeTrabajo(int perfilId, String description) {
        this.id = perfilId;
        this.description = description;
    }


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

    public PerfilDeTrabajo getPerfilDeTrabajo(int id) {
        String sql = "SELECT * FROM perfil_de_trabajos WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        PerfilDeTrabajo perfilDeTrabajo = null;

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                int perfilId = resultado.getInt("id");
                String description = resultado.getString("description");
                perfilDeTrabajo = new PerfilDeTrabajo(perfilId, description);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }

        querySelector.Cerrar();

        return perfilDeTrabajo;
    }

    public List<PerfilDeTrabajo> obtenerPerfilesDeTrabajo() {
        List<PerfilDeTrabajo> perfiles = new ArrayList<>();
        String sql = "SELECT * FROM perfil_de_trabajos";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                PerfilDeTrabajo perfil = new PerfilDeTrabajo();
                perfil.setId(resultado.getInt("id"));
                perfil.setDescription(resultado.getString("description"));
                perfiles.add(perfil);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return perfiles;
    }

    public String toString() {
        List<PerfilDeTrabajo> perfiles = obtenerPerfilesDeTrabajo();
        for (PerfilDeTrabajo perfil : perfiles) {
            System.out.println("id: "+perfil.getId());
            System.out.println("descripcion : "+perfil.getDescription());
        }
        return null;
    }

}
