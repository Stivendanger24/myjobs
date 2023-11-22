package models.aspirante;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadesDeInteresATrabajar {

    private int id;
    private String id_city;

    CiudadesDeInteresATrabajar(int id, String id_city){
        this.id = id;
        this.id_city = id_city;
    }

    public CiudadesDeInteresATrabajar(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_city() {
        return id_city;
    }

    public void setId_city(String id_city) {
        this.id_city = id_city;
    }

    public void  getCiudadDeInteresATrabajar(int id) {

        String sql = "SELECT * FROM ciudades_de_interes_a_trabajars WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.id_city = resultado.getString("id_city");
                System.out.println("ciudad: "+id_city);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearCiudadDeInteresATrabajar(String id_city) {
        String sql = "INSERT INTO ciudades_de_interes_a_trabajars (user_id, id_city) " +
                "VALUES (?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(),id_city);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<CiudadesDeInteresATrabajar> obtenerTodasLasCiudadesDeInteresATrabajar() {
        List<CiudadesDeInteresATrabajar> ciudades = new ArrayList<>();
        String sql = "SELECT * FROM ciudades_de_interes_a_trabajars WHERE user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id());
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                CiudadesDeInteresATrabajar ciudad = new CiudadesDeInteresATrabajar();
                ciudad.setId(resultado.getInt("id"));
                ciudad.setId_city(resultado.getString("id_city"));
                ciudades.add(ciudad);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return ciudades;
    }

    public void eliminarCiudadDeInteresATrabajar(int id) {
        String sql = "DELETE FROM ciudades_de_interes_a_trabajars " +
                "WHERE user_id = ? AND id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(), id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString() {
        List<CiudadesDeInteresATrabajar> ciudades = obtenerTodasLasCiudadesDeInteresATrabajar();
        for (CiudadesDeInteresATrabajar ciudad : ciudades) {
            System.out.println(ciudad.getId() + " - " + ciudad.getId_city());
        }
        return null;
    }


}
