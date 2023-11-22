package models.oferta;
import models.SesionStatus;
import models.aspirante.OtrasHabilidades;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatosBasicosOferta {
    private  int id;
    private String job_offer_tittle;
    private int id_professional_area;
    private String job_offer_content;
    private String id_country;
    private String departament_state;
    private String id_city;
    private int id_work_day; //(tipo_de_jornadas{id})
    private String date_of_publication;
    private int salary;
    private int job_vacancies;
    private int years_of_experience;
    private int id_studies_level; //(nivel_de_estudios {id})
    private int driving_license;
    private int staff_with_disabilities;
    private int id_status_offer; //(estado_de_la_ofertas{id})

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob_offer_tittle() {
        return job_offer_tittle;
    }

    public void setJob_offer_tittle(String job_offer_tittle) {
        this.job_offer_tittle = job_offer_tittle;
    }

    public int getId_professional_area() {
        return id_professional_area;
    }

    public void setId_professional_area(int id_professional_area) {
        this.id_professional_area = id_professional_area;
    }

    public String getJob_offer_content() {
        return job_offer_content;
    }

    public void setJob_offer_content(String job_offer_content) {
        this.job_offer_content = job_offer_content;
    }

    public String getId_country() {
        return id_country;
    }

    public void setId_country(String id_country) {
        this.id_country = id_country;
    }

    public String getDepartament_state() {
        return departament_state;
    }

    public void setDepartament_state(String departament_state) {
        this.departament_state = departament_state;
    }

    public String getId_city() {
        return id_city;
    }

    public void setId_city(String id_city) {
        this.id_city = id_city;
    }

    public int getId_work_day() {
        return id_work_day;
    }

    public void setId_work_day(int id_work_day) {
        this.id_work_day = id_work_day;
    }

    public String getDate_of_publication() {
        return date_of_publication;
    }

    public void setDate_of_publication(String date_of_publication) {
        this.date_of_publication = date_of_publication;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getJob_vacancies() {
        return job_vacancies;
    }

    public void setJob_vacancies(int job_vacancies) {
        this.job_vacancies = job_vacancies;
    }

    public int getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(int years_of_experience) {
        this.years_of_experience = years_of_experience;
    }

    public int getId_studies_level() {
        return id_studies_level;
    }

    public void setId_studies_level(int id_studies_level) {
        this.id_studies_level = id_studies_level;
    }

    public int getDriving_license() {
        return driving_license;
    }

    public void setDriving_license(int driving_license) {
        this.driving_license = driving_license;
    }

    public int getStaff_with_disabilities() {
        return staff_with_disabilities;
    }

    public void setStaff_with_disabilities(int staff_with_disabilities) {
        this.staff_with_disabilities = staff_with_disabilities;
    }

    public int getId_status_offer() {
        return id_status_offer;
    }

    public void setId_status_offer(int id_status_offer) {
        this.id_status_offer = id_status_offer;
    }

    public void  getDatosBasicosOferta(int id) {

        String sql = "SELECT * FROM datos_basicos_ofertas WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.job_offer_tittle = resultado.getString("job_offer_title");
                System.out.println("titulo de la oferta: "+job_offer_tittle);
                this.id_professional_area = resultado.getInt("id_professional_area");
                System.out.println("id del area pforesional: "+id_professional_area);
                this.job_offer_content = resultado.getString("job_offer_content");
                System.out.println("descripcion de la offerta: "+job_offer_content);
                this.id_country = resultado.getString("id_country");
                System.out.println("pais: "+id_country);
                this.departament_state = resultado.getString("departament_state");
                System.out.println("estado o departamento: "+departament_state);
                this.id_city = resultado.getString("id_city");
                System.out.println("ciudad: "+id_city);
                this.id_work_day = resultado.getInt("id_working_day");
                System.out.println("tipo de jornada: "+id_work_day);
                this.date_of_publication = resultado.getString("date_of_publication");;
                System.out.println("tipo de jornada: "+id_work_day);
                this.job_vacancies = resultado.getInt("job_vacancies");
                System.out.println("cantidad de vacantes: "+job_vacancies);
                this.years_of_experience = resultado.getInt("years_of_experence");
                System.out.println("experiencia laboral: "+years_of_experience);
                this.id_studies_level = resultado.getInt("id_level_study");
                System.out.println("nivel de estudios: "+id_studies_level);
                this.driving_license = resultado.getInt("driving_license");
                System.out.println("requiere licencia de conduccion: "+driving_license);
                this.staff_with_disabilities = resultado.getInt("staff_with_disabilities");
                System.out.println("personas con discapacidad: "+staff_with_disabilities);
                this.id_status_offer = resultado.getInt("id_status_offer");
                System.out.println("estado de la oferta: "+id_status_offer);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearBasicosOferta(String job_offer_title, int id_professional_area, String job_offer_content, String id_country, String departament_state, String id_city, int id_work_day, int salary, int job_vacancies, int years_of_experience, int id_studies_level, int driving_license,int staff_with_disabilities, int id_status_offer ) {
        String sql = "INSERT INTO datos_basicos_ofertas (user_company_id, job_offer_title, id_professional_area, job_offer_content,id_country, departament_state, id_city, id_working_day, date_of_publication, salary, job_vacancies, years_of_experence, id_level_study, driving_license, staff_with_disabilities, id_status_offer) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        this.date_of_publication =  SesionStatus.getInstance().setDate();
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(),job_offer_title, id_professional_area, job_offer_content, id_country, departament_state, id_city, id_work_day, date_of_publication, salary, job_vacancies, years_of_experience, id_studies_level, driving_license, staff_with_disabilities, id_status_offer);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<DatosBasicosOferta> obtenerDatosBasicosOferta() {
        List<DatosBasicosOferta> Ofertas = new ArrayList<>();
        String sql = "SELECT * FROM datos_basicos_ofertas WHERE user_company_id  = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id());
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                DatosBasicosOferta DatosBasicosOferta = new DatosBasicosOferta();
                DatosBasicosOferta.setId(resultado.getInt("id"));
                DatosBasicosOferta.setJob_offer_tittle(resultado.getString("job_offer_title"));
                DatosBasicosOferta.setId_professional_area(resultado.getInt("id_professional_area"));
                DatosBasicosOferta.setJob_offer_content(resultado.getString("job_offer_content"));
                DatosBasicosOferta.setId_country(resultado.getString("id_country"));
                DatosBasicosOferta.setDepartament_state(resultado.getString("departament_state"));
                DatosBasicosOferta.setId_city(resultado.getString("id_city"));
                DatosBasicosOferta.setId_work_day(resultado.getInt("id_working_day"));
                DatosBasicosOferta.setDate_of_publication(resultado.getString("date_of_publication"));
                DatosBasicosOferta.setSalary(resultado.getInt("salary"));
                DatosBasicosOferta.setJob_vacancies(resultado.getInt("job_vacancies"));
                DatosBasicosOferta.setYears_of_experience(resultado.getInt("years_of_experence"));
                DatosBasicosOferta.setId_studies_level(resultado.getInt("id_level_study"));
                DatosBasicosOferta.setDriving_license(resultado.getInt("driving_license"));
                DatosBasicosOferta.setStaff_with_disabilities(resultado.getInt("staff_with_disabilities"));
                DatosBasicosOferta.setId_status_offer(resultado.getInt("id_status_offer"));
                Ofertas.add(DatosBasicosOferta);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return Ofertas;
    }

    public void eliminarDatosBasicosOferta(int id) {
        String sql = "DELETE FROM datos_basicos_ofertas " +
                "WHERE user_company_id  = ? AND id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(), id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString() {
        List<DatosBasicosOferta> ofertas = obtenerDatosBasicosOferta();
        for (DatosBasicosOferta oferta : ofertas) {
            System.out.println(oferta.getId() + " - " + oferta.getJob_offer_tittle() + " - " + oferta.getJob_offer_content() + " - " + oferta.getDate_of_publication());
        }
        return null;
    }


}







