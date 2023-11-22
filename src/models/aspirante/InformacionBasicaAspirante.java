package models.aspirante;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InformacionBasicaAspirante {

    private int number_identification, id_type_identification, user_id, year, mount, day, availability_travel;
    private String first_name, last_name, email, email2, adress, state, gender, marital_status, facebook, instagram, id_country, id_city, phone1, phone2;

    public InformacionBasicaAspirante(int number_identification, int id_type_identification, int user_id, String first_name,
                                      String last_name, String email, String email2, String adress, String id_country, String state,
                                      String id_city, String phone1, String phone2, int year, int mount, int day, String gender, String marital_status,
                                      String facebook, String instagram, int availability_travel) {


        this.number_identification = number_identification;
        this.id_type_identification = id_type_identification;
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.email2 = email2;
        this.adress = adress;
        this.id_country = id_country;
        this.state = state;
        this.id_city = id_city;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.year = year;
        this.mount = mount;
        this.day = day;
        this.gender = gender;
        this.marital_status = marital_status;
        this.facebook = facebook;
        this.instagram = instagram;
        this.availability_travel = availability_travel;
    }

    public InformacionBasicaAspirante() {
    }

    public int getNumber_identification() {
        return number_identification;
    }

    public void setNumber_identification(int number_identification) {
        this.number_identification = number_identification;
    }

    public int getId_type_identification() {
        return id_type_identification;
    }

    public void setId_type_identification(int id_type_identification) {
        this.id_type_identification = id_type_identification;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
        return this.id_city;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMount() {
        return this.mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
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

    public int getAvailability_travel() {
        return availability_travel;
    }

    public void setAvailability_travel(int availability_travel) {
        this.availability_travel = availability_travel;
    }
    public InformacionBasicaAspirante getAspirante(int user_id) {
        InformacionBasicaAspirante aspirante = null;

        String sql = "SELECT * FROM informacion_basica_de_aspirantes WHERE user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, user_id);

        try (ResultSet resultant = querySelector.ejecutar()) {
            if (resultant.next()) {
                aspirante = new InformacionBasicaAspirante();
                aspirante.setNumber_identification(resultant.getInt("number_identification"));
                aspirante.setId_type_identification(resultant.getInt("id_type_identification"));
                aspirante.setUser_id(resultant.getInt("user_id"));
                aspirante.setFirst_name(resultant.getString("first_name"));
                aspirante.setLast_name(resultant.getString("last_name"));
                aspirante.setEmail(resultant.getString("email1"));
                aspirante.setEmail2(resultant.getString("email2"));
                aspirante.setAdress(resultant.getString("address"));
                aspirante.setId_country(resultant.getString("id_country"));
                aspirante.setId_city(resultant.getString("id_city"));
                aspirante.setState(resultant.getString("state"));
                aspirante.setPhone1(resultant.getString("phone1"));
                aspirante.setPhone2(resultant.getString("phone2"));
                aspirante.setYear(resultant.getInt("year"));
                aspirante.setMount(resultant.getInt("month"));
                aspirante.setDay(resultant.getInt("day"));
                aspirante.setGender(resultant.getString("gender"));
                aspirante.setMarital_status(resultant.getString("marital_status"));
                aspirante.setFacebook(resultant.getString("facebook"));
                aspirante.setInstagram(resultant.getString("instagram"));
                aspirante.setAvailability_travel(resultant.getInt("availability_travel"));
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return aspirante;
    }

    public void actualizarAspirante(int number_identification, int id_type_identification, String first_name,
                                    String last_name, String email, String email2, String adress, int id_country, String state,
                                    String id_city, String phone1, String phone2, int year, int mount, int day, String gender,
                                    String marital_status, String facebook, String instagram, int availability_travel) {
        String sql = "UPDATE informacion_basica_de_aspirantes SET " +
                "number_identification = ?, " +
                "id_type_identification = ?, " +
                "first_name = ?, " +
                "last_name = ?, " +
                "email1 = ?, " +
                "email2 = ?, " +
                "adress = ?, " +
                "id_country = ?, " +
                "state = ?, " +
                "id_city = ?, " +
                "phone1 = ?, " +
                "phone2 = ?, " +
                "year = ?, " +
                "mount = ?, " +
                "day = ?, " +
                "gender = ?, " +
                "marital_status = ?, " +
                "facebook = ?, " +
                "instagram = ?, " +
                "availability_travel = ? " +
                "WHERE user_id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(
                sql, number_identification, id_type_identification, first_name, last_name, email, email2, adress,
                id_country, state, id_city, phone1, phone2, year, mount, day, gender, marital_status, facebook, instagram, availability_travel, SesionStatus.getInstance().getUser_id());

        querySelector.actualizar();
        querySelector.Cerrar();
    }

    public void createAspirante(String number_identification, String id_type_identification, String first_name, String last_name, String email, String email2, String adress,
                                String id_country, String state, String id_city, String phone1, String phone2, String year, String mount, String day, String gender, String marital_status, String facebook, String instagram, String availability_travel) {
        String sql = "INSERT INTO informacion_basica_de_aspirantes (" +
                "number_identification, " +
                "id_type_identification, " +
                "user_id, " +
                "first_name, " +
                "last_name, " +
                "email1, " +
                "email2, " +
                "adress, " +
                "id_country, " +
                "state, " +
                "id_city, " +
                "phone1, " +
                "phone2, " +
                "year, " +
                "mount, " +
                "day, " +
                "gender, " +
                "marital_status, " +
                "facebook, " +
                "instagram, " +
                "availability_travel) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(
                sql, number_identification, id_type_identification, SesionStatus.getInstance().getUser_id(), first_name, last_name, email, email2, adress,
                id_country, state, id_city, phone1, phone2, year, mount, day, gender, marital_status, facebook, instagram,
                availability_travel);

        querySelector.crear();
        querySelector.Cerrar();
    }


    public String toString() {
        System.out.println("id: " + user_id);
        System.out.println("Nombre: " + first_name);
        System.out.println("apellido: " + last_name);
        System.out.println("numero de identificacion: " + number_identification);
        System.out.println("ciudad: " + id_city);
        return super.toString();
    }
}
