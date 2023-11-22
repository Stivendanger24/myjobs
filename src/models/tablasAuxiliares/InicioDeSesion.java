package models.tablasAuxiliares;

import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InicioDeSesion {

    private int id, register;
    private String name, email, email_verified_at, password, id_roll, url_profile_photo_path, url_profile_background,
                   remember_token, created_at, updated_at;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRegister() {
        return register;
    }

    public String getId_roll() {
        return id_roll;
    }

    public void createUser(String name, String email, String password, String id_roll) {
        int register = 0;
        String sql = "INSERT INTO users (" +
                "name, " +
                "email, " +
                "password, " +
                "id_roll," +
                "register" +
                ") VALUES (?, ?, ?, ?, ?)";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, name, email, password, id_roll, register );
        querySelector.crear();
        querySelector.Cerrar();
    }

    public boolean checkCredentials(String username, String password) {

        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, username, password);

        try (ResultSet resultado = querySelector.ejecutar()) {
            if (resultado.next()) {
                this.id = resultado.getInt("id");
                this.name = resultado.getString("name");
                this.email = resultado.getString("email");
                this.email_verified_at = resultado.getString("email_verified_at");
                this.password = resultado.getString("password");
                this.id_roll = resultado.getString("id_roll");
                this.url_profile_photo_path = resultado.getString("url_profile_photo_path");
                this.url_profile_background = resultado.getString("url_profile_background");
                this.register = resultado.getInt("register");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
        return false;
    }

    public boolean checkExist(String email) {

        String sql = "SELECT * FROM users WHERE email = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, email);

        try (ResultSet resultado = querySelector.ejecutar()) {
            if (resultado.next()) {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
        return true;
    }
}
