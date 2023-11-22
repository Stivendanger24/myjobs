package models.aspirante;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadesInformaticas {

        private int id;
        private String description;

    public HabilidadesInformaticas(){}

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

    public void  getHabilidadesInformaticas(int id) {

        String sql = "SELECT * FROM habilidades_informaticas WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.description = resultado.getString("description");
                System.out.println("ciudad: "+description);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearHabilidadesInformaticas(String description) {
        String sql = "INSERT INTO habilidades_informaticas (user_id, description) " +
                "VALUES (?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(),description);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<HabilidadesInformaticas> obtenerTodasLasHabilidadesInformaticas() {
        List<HabilidadesInformaticas> habilidades = new ArrayList<>();
        String sql = "SELECT * FROM habilidades_informaticas WHERE user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id());
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                HabilidadesInformaticas habilidad = new HabilidadesInformaticas();
                habilidad.setId(resultado.getInt("id"));
                habilidad.setDescription(resultado.getString("description"));
                habilidades.add(habilidad);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return habilidades;
    }

    public void eliminarHabilidadInformatica(int id) {
        String sql = "DELETE FROM habilidades_informaticas " +
                "WHERE user_id = ? AND id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(), id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString() {
        List<HabilidadesInformaticas> habilidades = obtenerTodasLasHabilidadesInformaticas();
        for (HabilidadesInformaticas habilidad : habilidades) {
            System.out.println(habilidad.getId() + " - " + habilidad.getDescription());
        }
        return null;
    }
}
