package models.aspirante;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaDeInteresLaboral {

    private int id;
    private int user_id;
    private int id_type_of_job_profile;
    private int id_professional_area;
     public AreaDeInteresLaboral(int id, int user_id, int id_type_of_job_profile, int id_professional_area){
         this.id = id;
         this.user_id = user_id;
         this.id_type_of_job_profile = id_type_of_job_profile;
         this.id_professional_area = id_professional_area;
     }
    public AreaDeInteresLaboral(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_type_of_job_profile() {
        return id_type_of_job_profile;
    }

    public void setId_type_of_job_profile(int id_type_of_job_profile) {
        this.id_type_of_job_profile = id_type_of_job_profile;
    }

    public int getId_professional_area() {
        return id_professional_area;
    }

    public void setId_professional_area(int id_professional_area) {
        this.id_professional_area = id_professional_area;
    }

    public void updateAreaDeInteres() {
        String sql = "UPDATE areas_de_interes_laborals SET " +
                "user_id = ?, " +
                "id_type_of_job_profile = ?, " +
                "id_professional_area = ? "+
                "WHERE id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql,user_id,id_type_of_job_profile,id_professional_area,id);
        querySelector.actualizar();
        querySelector.Cerrar();
    }


    public void  getAreaDeInteres(int id) {

        String sql = "SELECT * FROM areas_de_interes_laborals WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                this.user_id = resultado.getInt("user_id");
                this.id_type_of_job_profile = resultado.getInt("id_type_of_job_profile");
                this.id_professional_area = resultado.getInt("id_professional_area");
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void createAreaDeInteres(int id_type_of_job_profile, int id_professional_area) {
        String sql = "INSERT INTO areas_de_interes_laborals (user_id, id_type_of_job_profile, id_professional_area) " +
                "VALUES (?, ?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(), id_type_of_job_profile, id_professional_area);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public void actualizarAreaDeInteres(int id, int id_type_of_job_profile, int id_professional_area) {
        String sql = "UPDATE areas_de_interes_laborals SET id_type_of_job_profile = ?, id_professional_area = ? " +
                     "WHERE id = ? AND user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id_type_of_job_profile, id_professional_area, id,
                                         SesionStatus.getInstance().getUser_id());
        querySelector.actualizar();
        querySelector.Cerrar();
    }

}


