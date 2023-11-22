package models.empresa;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InformacionBasicaDeEmpresa {

    private int number_identification;
    private int type_identification;
    private String company_name;
    private int user_company_id;
    private String email;
    private String email2;
    private String adress;
    private String id_country;
    private String state;
    private String id_city;
    private String phone1;
    private String phone2;
    private String facebook;
    private String instagram;

    public int getNumber_identification() {
        return number_identification;
    }

    public void setNumber_identification(int number_identification) {
        this.number_identification = number_identification;
    }

    public int getType_identification() {
        return type_identification;
    }

    public void setType_identification(int type_identification) {
        this.type_identification = type_identification;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getUser_company_id() {
        return user_company_id;
    }

    public void setUser_company_id(int user_company_id) {
        this.user_company_id = user_company_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getId_country() {
        return id_country;
    }

    public void setId_country(String id_country) {
        this.id_country = id_country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId_city() {
        return id_city;
    }

    public void setId_city(String id_city) {
        this.id_city = id_city;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public InformacionBasicaDeEmpresa getInformacionBasicaDeEmpresa() {

        String sql = "SELECT * FROM informacion_basica_de_empresas WHERE user_company_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id());

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.type_identification = resultado.getInt("id_type_identification");
                System.out.println("tipo de identificacion: "+type_identification);
                this.company_name = resultado.getString("company_name");
                System.out.println("razon social: "+company_name);
                this.email = resultado.getString("email");
                System.out.println("correo 1: "+email);
                this.email2 = resultado.getString("email2");
                System.out.println("correo 2: "+email2);
                this.adress = resultado.getString("adress");
                System.out.println("direccion: "+adress);
                this.id_country = resultado.getString("id_country");
                System.out.println("pais: "+id_country);
                this.state = resultado.getString("state");
                System.out.println("estado: "+state);
                this.id_city = resultado.getString("id_city");
                System.out.println("ciudad: "+id_city);
                this.phone1 = resultado.getString("phone1");
                System.out.println("telefono 1: "+phone1);
                this.phone2 = resultado.getString("phone2");
                System.out.println("telefono 2: "+phone2);
                this.facebook = resultado.getString("facebook");
                System.out.println("facebook: "+facebook);
                this.instagram = resultado.getString("instagram");
                System.out.println("instagram: "+instagram);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return null;
    }

    public void crearInformacionBasicaDeEmpresa(int type_identification, String company_name, String email, String email2, String adress, String id_country, String state, String id_city, String phone1, String phone2, String facebook, String instagram) {
        String sql = "INSERT INTO informacion_basica_de_empresas (id_type_identification, company_name, user_company_id, email, email2, adress, id_country, state, id_city, phone1, phone2, facebook, instagram) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, type_identification, company_name,SesionStatus.getInstance().getUser_id(), email, email2, adress, id_country, state, id_city, phone1, phone2, facebook, instagram);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public void actualizarInformacionBasicaDeEmpresa(int type_identification, String company_name, String email, String email2, String adress, String id_country, String state, String id_city, String phone1, String phone2, String facebook, String instagram) {
        String sql = "UPDATE informacion_basica_de_empresas SET id_type_identification = ?, company_name = ?, email = ?, email2 = ?, adress = ?, id_country = ?, state = ?, id_city = ?, phone1 = ?, phone2 = ?, facebook = ?, instagram = ?" +
                "WHERE  user_company_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, type_identification, company_name, email, email2, adress, id_country, state, id_city, phone1, phone2, facebook, instagram ,SesionStatus.getInstance().getUser_id());
        querySelector.actualizar();
        querySelector.Cerrar();
    }

    public String toString() {
        System.out.println("tipo de identificacion: " + type_identification);
        System.out.println("email 1: " + email);
        System.out.println("email 2: " + email2);
        System.out.println("direccion: " + adress);
        System.out.println("pais: " +id_country);
        System.out.println("estado: " + state);
        System.out.println("ciudad: " + id_city);
        System.out.println("telefono 1: " + phone1);
        System.out.println("telefono 2: " + phone2);
        System.out.println("facebook: " + facebook);
        System.out.println("instagram: " + instagram);
        return null;
    }
}
