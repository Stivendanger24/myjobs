package models.aspirante;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerfilProfesional {

    private int id;
    private int id_type_of_job_profile;

    public PerfilProfesional(){}

    public int getId() {
        return id;
    }

    public int getId_type_of_job_profile() {
        return id_type_of_job_profile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_type_of_job_profile(int id_type_of_job_profile) {
        this.id_type_of_job_profile = id_type_of_job_profile;
    }

    public void  getPerfilProfesional() {

        String sql = "SELECT * FROM perfil_profesionals WHERE user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id());

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.id_type_of_job_profile = resultado.getInt("id_type_of_job_profile");
                System.out.println("id tipo de perfil profesional: "+id_type_of_job_profile);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }
    public void crearPerfilProfesional(int id_type_of_job_profile) {
        getPerfilProfesional();
        if (this.id != 0) {
            System.out.println("El perfil profesional ya está creado");
            return;
        }

        String sql = "INSERT INTO perfil_profesionals (user_id, id_type_of_job_profile) " +
                "VALUES (?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(), id_type_of_job_profile);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public void editarPerfilProfesional(int id_type_of_job_profile) {
        getPerfilProfesional();
        if (this.id == 0) {
            System.out.println("El perfil profesional no existe");
            return;
        }

        String sql = "UPDATE perfil_profesionals SET id_type_of_job_profile = ? WHERE user_id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id_type_of_job_profile, SesionStatus.getInstance().getUser_id());
        querySelector.actualizar();
        querySelector.Cerrar();

    }
}
