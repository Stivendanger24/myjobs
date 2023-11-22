package models.oferta;

import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestrezasYConocimientos {
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


    public void  getDestreza(int id) {

        String sql = "SELECT * FROM destrezas_y_conocimientos WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.name = resultado.getString("name");
                System.out.println("destrezas: "+name);
                this.level = resultado.getString("level");
                System.out.println("nivel: "+level);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearDestreza(int offer_id, String destreza, String nivel) {
        String sql = "INSERT INTO destrezas_y_conocimientos (offer_id, name, level) " +
                "VALUES (?, ?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id ,destreza, nivel);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<DestrezasYConocimientos> obtenerDestrezas(int offer_id) {
        List<DestrezasYConocimientos> Destrezas = new ArrayList<>();
        String sql = "SELECT * FROM destrezas_y_conocimientos WHERE offer_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                DestrezasYConocimientos Destreza = new DestrezasYConocimientos();
                Destreza.setId(resultado.getInt("id"));
                Destreza.setName(resultado.getString("name"));
                Destreza.setLevel(resultado.getString("level"));
                Destrezas.add(Destreza);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return Destrezas;
    }
    public void eliminarDestreza(int offer_id,int id) {
        String sql = "DELETE FROM destrezas_y_conocimientos " +
                "WHERE offer_id = ? AND id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id, id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString(int offer_id) {
        List<DestrezasYConocimientos> destrezas = obtenerDestrezas(offer_id);
        for (DestrezasYConocimientos destreza : destrezas) {
            System.out.println("id: "+destreza.getId());
            System.out.println("destreza: "+destreza.getName());
            System.out.println("nivel requerido: "+destreza.getLevel());
        }
        return null;
    }
}

