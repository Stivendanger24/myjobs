package models.aspirante;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OtrasHabilidades {

    private int id;
    private String description;

    public OtrasHabilidades(){}

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void  getOtrasHabilidades(int id) {

        String sql = "SELECT * FROM otras_habilidades WHERE id = ?";
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

    public void crearOtrasHabilidades(String description) {
        String sql = "INSERT INTO otras_habilidades (user_id, description) " +
                "VALUES (?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(),description);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<OtrasHabilidades> obtenerOtrasHabilidades() {
        List<OtrasHabilidades> otrasHabilidades = new ArrayList<>();
        String sql = "SELECT * FROM otras_habilidades WHERE user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id());
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                OtrasHabilidades otraHabilidad = new OtrasHabilidades();
                otraHabilidad.setId(resultado.getInt("id"));
                otraHabilidad.setDescription(resultado.getString("description"));
                otrasHabilidades.add(otraHabilidad);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return otrasHabilidades;
    }

    public void eliminarOtrasHabilidades(int id) {
        String sql = "DELETE FROM otras_habilidades " +
                "WHERE user_id = ? AND id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(), id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString() {
        List<OtrasHabilidades> otrasHabilidades = obtenerOtrasHabilidades();
        for (OtrasHabilidades otraHabilidad : otrasHabilidades) {
            System.out.println(otraHabilidad.getId() + " - " + otraHabilidad.getDescription());
        }
        return null;
    }

}
