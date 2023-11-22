package models.tablasAuxiliares;

import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDeLaOferta {

    private int id;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public void  getEstadoDeLaOferta(int id) {

        String sql = "SELECT * FROM estado_de_la_ofertas WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.description = resultado.getString("description");
                System.out.println("Descripcion : "+description);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public List<EstadoDeLaOferta> obtenerEstadosDeLasOfertas() {
        List<EstadoDeLaOferta> estadosOfertas = new ArrayList<>();
        String sql = "SELECT * FROM estado_de_la_ofertas";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                EstadoDeLaOferta estadoOferta = new EstadoDeLaOferta();
                estadoOferta.setId(resultado.getInt("id"));
                estadoOferta.setDescription(resultado.getString("description"));
                estadosOfertas.add(estadoOferta);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return estadosOfertas;
    }

    public String toString() {
        List<EstadoDeLaOferta> estadosOfertas = obtenerEstadosDeLasOfertas();
        for (EstadoDeLaOferta estadoOferta : estadosOfertas) {
            estadoOferta.getEstadoDeLaOferta(estadoOferta.getId());
        }
        return null;
    }


}
