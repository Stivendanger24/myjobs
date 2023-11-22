package models.oferta;

import models.SesionStatus;
import models.aspirante.Idiomas;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LenguajesRequeridos {
     private int id;
    private String name;
    private String level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void  getLenguaje(int id) {

        String sql = "SELECT * FROM lenguajes_requeridos WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.name = resultado.getString("name");
                System.out.println("lenguaje: "+name);
                this.level = resultado.getString("level");
                System.out.println("nivel de fluidez: "+level);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearLenguaje(int offer_id, String idioma, String nivel) {
        String sql = "INSERT INTO lenguajes_requeridos (offer_id, name, level) " +
                "VALUES (?, ?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id ,idioma, nivel);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<LenguajesRequeridos> obtenerLenguaje(int offer_id) {
        List<LenguajesRequeridos> Lenguajes = new ArrayList<>();
        String sql = "SELECT * FROM lenguajes_requeridos WHERE offer_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                LenguajesRequeridos Lenguaje = new LenguajesRequeridos();
                Lenguaje.setId(resultado.getInt("id"));
                Lenguaje.setName(resultado.getString("name"));
                Lenguaje.setLevel(resultado.getString("level"));
                Lenguajes.add(Lenguaje);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return Lenguajes;
    }
    public void eliminarLenguaje(int offer_id,int id) {
        String sql = "DELETE FROM lenguajes_requeridos " +
                "WHERE offer_id = ? AND id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id, id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString(int offer_id) {
        List<LenguajesRequeridos> lenguajes = obtenerLenguaje(offer_id);
        for (LenguajesRequeridos lenguaje : lenguajes) {
            System.out.println("id: "+lenguaje.getId());
            System.out.println("idioma: "+lenguaje.getName());
            System.out.println("nivel de fluides: "+lenguaje.getLevel());
        }
        return null;
    }

}
