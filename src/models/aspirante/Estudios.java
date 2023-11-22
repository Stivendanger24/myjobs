package models.aspirante;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Estudios {

    private int id;
    private String place_of_studies;
    private int id_level_study;
    private int id_professional_area;
    private String degree_obtainded;
    private int date_of_start_year;
    private int date_of_start_mount;
    private int date_of_end_year;
    private int date_of_end_mount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace_of_studies() {
        return place_of_studies;
    }

    public void setPlace_of_studies(String place_of_studies) {
        this.place_of_studies = place_of_studies;
    }

    public int getId_level_study() {
        return id_level_study;
    }

    public void setId_level_study(int id_level_study) {
        this.id_level_study = id_level_study;
    }

    public int getId_professional_area() {
        return id_professional_area;
    }

    public void setId_professional_area(int id_professional_area) {
        this.id_professional_area = id_professional_area;
    }

    public String getDegree_obtainded() {
        return degree_obtainded;
    }

    public void setDegree_obtainded(String degree_obtainded) {
        this.degree_obtainded = degree_obtainded;
    }

    public int getDate_of_start_year() {
        return date_of_start_year;
    }

    public void setDate_of_start_year(int date_of_start_year) {
        this.date_of_start_year = date_of_start_year;
    }

    public int getDate_of_start_mount() {
        return date_of_start_mount;
    }

    public void setDate_of_start_mount(int date_of_start_mount) {
        this.date_of_start_mount = date_of_start_mount;
    }

    public int getDate_of_end_year() {
        return date_of_end_year;
    }

    public void setDate_of_end_year(int date_of_end_year) {
        this.date_of_end_year = date_of_end_year;
    }

    public int getDate_of_end_mount() {
        return date_of_end_mount;
    }

    public void setDate_of_end_mount(int date_of_end_mount) {
        this.date_of_end_mount = date_of_end_mount;
    }

    public void  getEstudios(int id) {

        String sql = "SELECT * FROM estudios WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.place_of_studies = resultado.getString("place_of_studies");
                System.out.println("ilugar de estudios: "+place_of_studies);
                this.id_level_study = resultado.getInt("id_level_study");
                System.out.println("nivel de estudio: "+id_level_study);
                this.id_professional_area = resultado.getInt("id_professional_area");
                System.out.println("area profesional: "+id_professional_area);
                this.degree_obtainded = resultado.getString("degree_obtainded");
                System.out.println("titulo obtenido: "+degree_obtainded);
                this.date_of_start_year = resultado.getInt("date_of_start_year");
                System.out.println("anio de inicio: "+date_of_start_year);
                this.date_of_start_mount = resultado.getInt("date_of_start_mount");
                System.out.println("mes de inicio: "+date_of_start_mount);
                this.date_of_end_year = resultado.getInt("date_of_end_year");
                System.out.println("anio de finalizacion: "+date_of_end_year);
                this.date_of_end_mount = resultado.getInt("date_of_end_mount");
                System.out.println("mes de finalizacion: "+date_of_end_mount);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearEstudio(String place_of_studies, int id_level_study, int id_professional_area, String degree_obtainded, int date_of_start_year, int date_of_start_mount, int date_of_end_year, int date_of_end_mount) {
        String sql = "INSERT INTO estudios (user_id, place_of_studies, id_level_study, id_professional_area, degree_obtainded, date_of_start_year, date_of_start_mount, date_of_end_year, date_of_end_mount) " +
                "VALUES (?, ?, ?, ?, ?, ? ,? ,?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(),place_of_studies,id_level_study,id_professional_area,degree_obtainded,date_of_start_year,date_of_start_mount,date_of_end_year,date_of_end_mount);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<Estudios> obtenerEstudios() {
        List<Estudios> estudios = new ArrayList<>();
        String sql = "SELECT * FROM estudios WHERE user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id());
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                Estudios estudio = new Estudios();
                estudio.setId(resultado.getInt("id"));
                estudio.setPlace_of_studies(resultado.getString("place_of_studies"));
                estudio.setId_level_study(resultado.getInt("id_level_study"));
                estudio.setId_professional_area(resultado.getInt("id_professional_area"));
                estudio.setDegree_obtainded(resultado.getString("degree_obtainded"));
                estudio.setDate_of_start_year(resultado.getInt("date_of_start_year"));
                estudio.setDate_of_start_mount(resultado.getInt("date_of_start_mount"));
                estudio.setDate_of_end_year(resultado.getInt("date_of_end_year"));
                estudio.setDate_of_end_mount(resultado.getInt("date_of_end_mount"));
                estudios.add(estudio);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return estudios;
    }
    public void eliminarEstudios(int id) {
        String sql = "DELETE FROM estudios " +
                "WHERE user_id = ? AND id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(), id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString() {
        List<Estudios> estudios = obtenerEstudios();
        for (Estudios estudio : estudios) {
            System.out.println("id: "+estudio.getId());
            System.out.println("lugar de estudio: "+estudio.getPlace_of_studies());
            System.out.println("nivel de estudios: "+estudio.getId_level_study());
            System.out.println("area profesional: "+estudio.getId_professional_area());
            System.out.println("titulo obtenido: "+estudio.getDegree_obtainded());
            System.out.println("anio de inicio: "+estudio.getDate_of_start_year());
            System.out.println("mes de inicio: "+estudio.getDate_of_start_mount());
            System.out.println("anio fin: "+estudio.getDate_of_end_year());
            System.out.println("mes fin: "+estudio.getDate_of_end_mount());
        }
        return null;
    }


}
