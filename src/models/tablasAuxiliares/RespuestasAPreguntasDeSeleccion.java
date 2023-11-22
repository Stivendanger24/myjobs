package models.tablasAuxiliares;

import models.config.SqlQuerySelector;
import models.oferta.DestrezasYConocimientos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RespuestasAPreguntasDeSeleccion {

    private int id;
    private int selection_ask_id;
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSelection_ask_id() {
        return selection_ask_id;
    }

    public void setSelection_ask_id(int selection_ask_id) {
        this.selection_ask_id = selection_ask_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void  getRespuestaAPreguntaDeSeleccion(int id) {

        String sql = "SELECT * FROM respuestas_a_preguntas_de_seleccions WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.selection_ask_id = resultado.getInt("selection_ask_id");
                System.out.println("id de la pregunta de seleccion : "+selection_ask_id);
                this.answer = resultado.getString("answer");
                System.out.println("respuesta : "+answer);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearRespuestaAPreguntaDeSeleccion(int selection_ask_id, String answer) {
        String sql = "INSERT INTO respuestas_a_preguntas_de_seleccions (selection_ask_id, answer) " +
                "VALUES (?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, selection_ask_id ,answer);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public void actualizarRespuestaAPreguntaDeSeleccion(int id, String answer) {
        String sql = "UPDATE respuestas_a_preguntas_de_seleccions SET " +
                "answer  = ? " +
                "WHERE id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, answer, id);
        querySelector.actualizar();
        querySelector.Cerrar();
    }

    public List<RespuestasAPreguntasDeSeleccion> obtenerRespuestas(int selection_ask_id) {
        List<RespuestasAPreguntasDeSeleccion> respuestas = new ArrayList<>();
        String sql = "SELECT * FROM respuestas_a_preguntas_de_seleccions WHERE selection_ask_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, selection_ask_id);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                RespuestasAPreguntasDeSeleccion respuesta = new RespuestasAPreguntasDeSeleccion();
                respuesta.setId(resultado.getInt("id"));
                respuesta.setSelection_ask_id(resultado.getInt("selection_ask_id"));
                respuesta.setAnswer(resultado.getString("answer"));
                respuestas.add(respuesta);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return respuestas;
    }
    public void eliminarPreguntaDeSeleccion(int id) {
        String sql = "DELETE FROM respuestas_a_preguntas_de_seleccions " +
                "WHERE id = ?";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);
        querySelector.eliminar();
        querySelector.Cerrar();
    }

    public String toString(int selection_ask_id) {
        List<RespuestasAPreguntasDeSeleccion> respuestas = obtenerRespuestas(selection_ask_id);
        for (RespuestasAPreguntasDeSeleccion respuesta : respuestas) {
            System.out.println("id : "+respuesta.getId());
            System.out.println("pregunta de seleccion : "+respuesta.getSelection_ask_id());
            System.out.println("respuesta : "+respuesta.getAnswer());
        }
        return null;
    }

}
