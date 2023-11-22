package models.empresa;

import models.SesionStatus;
import models.config.SqlQuerySelector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DescripcionDeLaEmpresa {

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
        this.description = description;
    }


    public DescripcionDeLaEmpresa getDescripcionDeLaEmpresa() {

        String sql = "SELECT * FROM descripcion_de_la_empresas WHERE user_company_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id());

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                this.description = resultado.getString("description");
                System.out.println("descripcion: "+description);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return null;
    }

    public void crearDescripcionDeLaEmpresa(String descripcion) {
        String sql = "INSERT INTO descripcion_de_la_empresas (user_company_id, description) " +
                "VALUES (?,?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, SesionStatus.getInstance().getUser_id(), descripcion);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public void actualizarDescripcionDeLaEmpresa(String descricion) {
        String sql = "UPDATE descripcion_de_la_empresas SET description = ?" +
                "WHERE  user_company_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, descricion, SesionStatus.getInstance().getUser_id());
        querySelector.actualizar();
        querySelector.Cerrar();
    }

    public String toString() {
        System.out.println("id: " + id);
        System.out.println("descripcion: " + description);
        return null;
    }

}
