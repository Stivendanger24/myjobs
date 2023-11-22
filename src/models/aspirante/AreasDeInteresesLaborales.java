package models.aspirante;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreasDeInteresesLaborales {
    List<AreaDeInteresLaboral> areas;
    AreaDeInteresLaboral areaDeseada = new AreaDeInteresLaboral();
    SesionStatus sesionStatus = SesionStatus.getInstance();

    public AreasDeInteresesLaborales() {
        this.areas = getAll();
    }

    public List<AreaDeInteresLaboral> getAll() {
        List<AreaDeInteresLaboral> areas = new ArrayList<>();

        String sql = "SELECT * FROM areas_de_interes_laborals WHERE user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, sesionStatus.getUser_id());

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                int id = resultado.getInt("id");
                int user_id = resultado.getInt("user_id");
                int id_type_of_job_profile = resultado.getInt("id_type_of_job_profile");
                int id_professional_area = resultado.getInt("id_professional_area");
                AreaDeInteresLaboral area = new AreaDeInteresLaboral(id, user_id, id_type_of_job_profile, id_professional_area);
                areas.add(area);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return areas;
    }


        public AreaDeInteresLaboral getAreaDeInteres(int id){
            for (AreaDeInteresLaboral area : areas) {
                if (area.getId() == id) {
                    areaDeseada = area;
                    break;
                }
            }
        if (areaDeseada != null) {
            areaDeseada.getAreaDeInteres(id);
            // Hacer algo con el objeto encontrado, por ejemplo imprimir sus atributos
            System.out.println("ID: " + areaDeseada.getId());
            System.out.println("ID de tipo de perfil laboral: " + areaDeseada.getId_type_of_job_profile());
            System.out.println("ID de área profesional: " + areaDeseada.getId_professional_area());
        } else {
            System.out.println("No se encontró un objeto de área de interés laboral con el ID deseado");
        }
        return areaDeseada;
    }

    public AreaDeInteresLaboral createAreaDeInteres(int id_type_of_job_profile, int id_professional_area){
        areaDeseada.createAreaDeInteres(id_type_of_job_profile,id_professional_area);
        return null;
    }

    public AreaDeInteresLaboral actualizarAreaDeInteres(int id, int id_type_of_job_profile, int id_professional_area){
        areaDeseada.actualizarAreaDeInteres(id, id_type_of_job_profile, id_professional_area);
        return null;
    }


    public String toString() {
        List<AreaDeInteresLaboral> areas = getAll();
        StringBuilder sb = new StringBuilder();
        for (AreaDeInteresLaboral area : areas) {
            sb.append("id: ").append(area.getId())
                    .append(", id tipo de perfil: ").append(area.getId_type_of_job_profile())
                    .append(", id tipo de area profesional: ").append(area.getId_professional_area())
                    .append("\n");
        };
        System.out.println(sb);
        return sb.toString();
    }




}
