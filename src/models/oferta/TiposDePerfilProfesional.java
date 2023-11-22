package models.oferta;

import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiposDePerfilProfesional {
    private int id;
    private int id_type_of_job_profile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_type_of_job_profile() {
        return this.id_type_of_job_profile;
    }

    public void setId_type_of_job_profile(int id_type_of_job_profile) {
        this.id_type_of_job_profile = id_type_of_job_profile;
    }

    public void  getTipoDePerfilProfesional(int id) {

        String sql = "SELECT * FROM tipo_de_perfil_profesionals WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.id_type_of_job_profile = resultado.getInt("id_type_of_job_profile");
                System.out.println("tipo de perfil profesional: "+id_type_of_job_profile );
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }
    public List<TiposDePerfilProfesional> obtenerPerfiles(int offer_id) {
        List<TiposDePerfilProfesional> perfiles = new ArrayList<>();
        String sql = "SELECT * FROM tipo_de_perfil_profesionals WHERE offer_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                TiposDePerfilProfesional perfil = new TiposDePerfilProfesional();
                perfil.setId(resultado.getInt("id"));
                perfil.setId_type_of_job_profile(resultado.getInt("id_type_of_job_profile"));
                perfiles.add(perfil);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return perfiles;
    }
    public void crearTipoDePerfilProfesional(int offer_id, int id_perfil) {
        String sql = "INSERT INTO tipo_de_perfil_profesionals (offer_id, id_type_of_job_profile ) " +
                "VALUES (?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id ,id_perfil);
        querySelector.crear();
        querySelector.Cerrar();
    }
    public void eliminarTipoDePerfilProfesional(int id) {
        String sql = "DELETE FROM tipo_de_perfil_profesionals " +
                "WHERE id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }
    public void actualizarTipoDePerfilProfesional(int id_type_of_job_profile, int offer_id) {
        String sql = "UPDATE tipo_de_perfil_profesionals SET " +
                "id_type_of_job_profile  = ?, " +
                "WHERE offer_id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id_type_of_job_profile, offer_id);
        querySelector.actualizar();
        querySelector.Cerrar();
    }

    public String toString(int offer_id) {
        List<TiposDePerfilProfesional> perfiles = obtenerPerfiles(offer_id);
        for (TiposDePerfilProfesional perfil : perfiles) {
            System.out.println("id: "+perfil.getId());
            System.out.println("tipo de perfil de trabajo: "+perfil.getId_type_of_job_profile());
        }
        return null;
    }
}
