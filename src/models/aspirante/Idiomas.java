package models.aspirante;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Idiomas {


    private int id;
    private String language;
    private String nivel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void  getIdioma(int id) {

        String sql = "SELECT * FROM idiomas WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.language = resultado.getString("language");
                System.out.println("lenguaje: "+language);
                this.nivel = resultado.getString("level");
                System.out.println("nivel de fluidez: "+nivel);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearIdioma(String language, String nivel) {
        String sql = "INSERT INTO idiomas (user_id, language, level) " +
                "VALUES (?, ?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(),language,nivel);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<Idiomas> obtenerIdiomas() {
        List<Idiomas> idiomas = new ArrayList<>();
        String sql = "SELECT * FROM idiomas WHERE user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id());
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                Idiomas idioma = new Idiomas();
                idioma.setId(resultado.getInt("id"));
                idioma.setLanguage(resultado.getString("language"));
                idioma.setNivel(resultado.getString("level"));
                idiomas.add(idioma);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return idiomas;
    }
    public void eliminarIdioma(int id) {
        String sql = "DELETE FROM idiomas " +
                "WHERE user_id = ? AND id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(), id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString() {
        List<Idiomas> idiomas = obtenerIdiomas();
        for (Idiomas idioma : idiomas) {
            System.out.println("id: "+idioma.getId());
            System.out.println("lenguaje: "+idioma.getLanguage());
            System.out.println("nivel de fluides: "+idioma.getNivel());
        }
        return null;
    }


}
