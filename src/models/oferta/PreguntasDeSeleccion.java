package models.oferta;

import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreguntasDeSeleccion {

    private int id;
    private String name;

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

    public void  getPreguntaDeSeleccion(int id) {

        String sql = "SELECT * FROM preguntas_de_seleccions WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.name = resultado.getString("name");
                System.out.println("pregunta: "+name);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearPreguntaDeSeleccion(int offer_id, String pregunta) {
        String sql = "INSERT INTO preguntas_de_seleccions (offer_id, name) " +
                "VALUES (?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id ,pregunta);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<PreguntasDeSeleccion> obtenerPreguntasDeSeleccion(int offer_id) {
        List<PreguntasDeSeleccion> Preguntas = new ArrayList<>();
        String sql = "SELECT * FROM preguntas_de_seleccions WHERE offer_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                PreguntasDeSeleccion Pregunta = new PreguntasDeSeleccion();
                Pregunta.setId(resultado.getInt("id"));
                Pregunta.setName(resultado.getString("name"));
                Preguntas.add(Pregunta);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return Preguntas;
    }
    public void eliminarPreguntaDeSeleccion(int offer_id,int id) {
        String sql = "DELETE FROM preguntas_de_seleccions " +
                "WHERE offer_id = ? AND id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id, id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString(int offer_id) {
        List<PreguntasDeSeleccion> preguntas = obtenerPreguntasDeSeleccion(offer_id);
        for (PreguntasDeSeleccion pregunta : preguntas) {
            System.out.println("id: "+pregunta.getId());
            System.out.println("pregunta: "+pregunta.getName());
        }
        return null;
    }
}
