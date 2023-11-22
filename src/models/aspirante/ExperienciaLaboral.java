package models.aspirante;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExperienciaLaboral {

    private int id;
    private String work_position;
    private int id_professional_area;
    private String company_name;
    private String functions;
    private int date_of_start_year;
    private int date_of_start_mount;
    private int date_of_end_year;
    private int date_of_end_mount;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setWork_position(String work_position) {
        this.work_position = work_position;
    }

    public String getWork_position() {
        return work_position;
    }

    public void setId_professional_area(int id_professional_area) {
        this.id_professional_area = id_professional_area;
    }

    public int getId_professional_area() {
        return id_professional_area;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getFunctions() {
        return functions;
    }

    public void setDate_of_start_year(int date_of_start_year) {
        this.date_of_start_year = date_of_start_year;
    }

    public int getDate_of_start_year() {
        return date_of_start_year;
    }

    public void setDate_of_start_mount(int date_of_start_mount) {
        this.date_of_start_mount = date_of_start_mount;
    }

    public int getDate_of_start_mount() {
        return date_of_start_mount;
    }

    public void setDate_of_end_year(int date_of_end_year) {
        this.date_of_end_year = date_of_end_year;
    }

    public int getDate_of_end_year() {
        return date_of_end_year;
    }

    public void setDate_of_end_mount(int date_of_end_mount) {
        this.date_of_end_mount = date_of_end_mount;
    }

    public int getDate_of_end_mount() {
        return date_of_end_mount;
    }

    public void  getExperienciaLaboral(int id) {

        String sql = "SELECT * FROM experiencia_laborals WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.work_position = resultado.getString("work_position");
                System.out.println("cargo de trabajo: "+work_position);
                this.id_professional_area = resultado.getInt("id_professional_area");
                System.out.println("area profesional: "+id_professional_area);
                this.company_name = resultado.getString("company_name");
                System.out.println("nombre de la compañia: "+company_name);
                this.functions = resultado.getString("functions");
                System.out.println("funciones del cargo: "+functions);
                this.date_of_start_year = resultado.getInt("date_of_start_year");
                System.out.println("anio de inicio: "+date_of_start_year);
                this.date_of_start_mount = resultado.getInt("date_of_start_mount");
                System.out.println("mes de inicio: "+date_of_start_mount);
                this.date_of_end_year = resultado.getInt("date_of_end_year");
                System.out.println("anio de fin del cargo: "+date_of_end_year);
                this.date_of_end_mount = resultado.getInt("date_of_end_mount");
                System.out.println("mes de fin del cargo: "+date_of_end_mount);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearExperienciaLaboral(String work_position, int id_professional_area, String company_name, String functions, int date_of_start_year, int date_of_start_mount, int date_of_end_year, int date_of_end_mount) {
        String sql = "INSERT INTO experiencia_laborals (user_id, work_position, id_professional_area, company_name, functions, date_of_start_year, date_of_start_mount, date_of_end_year, date_of_end_mount) " +
                "VALUES (?, ?, ?, ?, ?, ? ,? ,?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(),work_position,id_professional_area,company_name,functions,date_of_start_year,date_of_start_mount,date_of_end_year,date_of_end_mount);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<ExperienciaLaboral> obtenerExperienciasLaborales() {
        List<ExperienciaLaboral> ExperienciaLaboral = new ArrayList<>();
        String sql = "SELECT * FROM experiencia_laborals WHERE user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id());
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                ExperienciaLaboral unaExperienciaLaboral = new ExperienciaLaboral();
                unaExperienciaLaboral.setId(resultado.getInt("id"));
                unaExperienciaLaboral.setWork_position(resultado.getString("work_position"));
                unaExperienciaLaboral.setId_professional_area(resultado.getInt("id_professional_area"));
                unaExperienciaLaboral.setCompany_name(resultado.getString("company_name"));
                unaExperienciaLaboral.setFunctions(resultado.getString("functions"));
                unaExperienciaLaboral.setDate_of_start_year(resultado.getInt("date_of_start_year"));
                unaExperienciaLaboral.setDate_of_start_mount(resultado.getInt("date_of_start_mount"));
                unaExperienciaLaboral.setDate_of_end_year(resultado.getInt("date_of_end_year"));
                unaExperienciaLaboral.setDate_of_end_mount(resultado.getInt("date_of_end_mount"));
                ExperienciaLaboral.add(unaExperienciaLaboral);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return ExperienciaLaboral;
    }
    public void eliminarExperienciaLaboral(int id) {
        String sql = "DELETE FROM experiencia_laborals " +
                "WHERE user_id = ? AND id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(), id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString() {
        List<ExperienciaLaboral> experiencias = obtenerExperienciasLaborales();
        for (ExperienciaLaboral experiencia : experiencias) {
            System.out.println("id: "+experiencia.getId());
            System.out.println("cargo: "+experiencia.getWork_position());
            System.out.println("nombre de la empresa: "+experiencia.getCompany_name());
            System.out.println("funciones: "+experiencia.getFunctions());
            System.out.println("area del cargo: "+experiencia.getId_professional_area());
            System.out.println("anio de inicio: "+experiencia.getDate_of_start_year());
            System.out.println("mes de inicio: "+experiencia.getDate_of_start_mount());
            System.out.println("anio fin: "+experiencia.getDate_of_end_year());
            System.out.println("mes fin: "+experiencia.getDate_of_end_mount());
        }
        return null;
    }
}
