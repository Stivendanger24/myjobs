package models.tablasAuxiliares;

import models.SesionStatus;
import models.config.SqlQuerySelector;
import models.oferta.LenguajesRequeridos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosAVacantes {

    private int id;
    private int offer_id;

    private int user_id;
    private String date;
    private int id_status_selection_process;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId_status_selection_process() {
        return id_status_selection_process;
    }

    public void setId_status_selection_process(int id_status_selection_process) {
        this.id_status_selection_process = id_status_selection_process;
    }

    public void  getUsuarioAVacante(int id) {

        String sql = "SELECT * FROM usuarios_a_vacantes WHERE id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, id);

        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                this.id = resultado.getInt("id");
                System.out.println("id: "+id);
                this.offer_id = resultado.getInt("offer_id");
                System.out.println("id de la oferta: "+offer_id);
                this.user_id = resultado.getInt("user_id");
                System.out.println("id aspirante: "+user_id);
                this.date = resultado.getString("date");
                System.out.println("fecha de creacion: "+date);
                this.id_status_selection_process = resultado.getInt("id_status_selection_process");
                System.out.println("estado del proceso de seleccion: "+id_status_selection_process);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();
    }

    public void crearUsuarioAVacante(int offer_id, int user_id, int id_status_selection_process) {
        String sql = "INSERT INTO usuarios_a_vacantes (offer_id, user_id, date, id_status_selection_process) " +
                "VALUES (?, ?, ?, ?)";

        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id, user_id, SesionStatus.getInstance().setDate(), id_status_selection_process);
        querySelector.crear();
        querySelector.Cerrar();
    }

    public List<UsuariosAVacantes> obtenerUsuarios(int offer_id) {
        List<UsuariosAVacantes> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios_a_vacantes WHERE offer_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, offer_id);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                UsuariosAVacantes usuario = new UsuariosAVacantes();
                usuario.setId(resultado.getInt("id"));
                usuario.setOffer_id(resultado.getInt("offer_id"));
                usuario.setUser_id(resultado.getInt("user_id"));
                usuario.setDate(resultado.getString("date"));
                usuario.setId_status_selection_process(resultado.getInt("id_status_selection_process"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return usuarios;
    }

    public List<UsuariosAVacantes> obtenerVacantes(int user_id) {
        List<UsuariosAVacantes> vacantes = new ArrayList<>();
        String sql = "SELECT * FROM usuarios_a_vacantes WHERE user_id = ?";
        SqlQuerySelector querySelector = new SqlQuerySelector(sql, user_id);
        try (ResultSet resultado = querySelector.ejecutar()) {
            while (resultado.next()) {
                UsuariosAVacantes vacante = new UsuariosAVacantes();
                vacante.setId(resultado.getInt("id"));
                vacante.setOffer_id(resultado.getInt("offer_id"));
                vacante.setUser_id(resultado.getInt("user_id"));
                vacante.setDate(resultado.getString("date"));
                vacante.setId_status_selection_process(resultado.getInt("id_status_selection_process"));
                vacantes.add(vacante);
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar el resultado: " + e.getMessage());
        }
        querySelector.Cerrar();

        return vacantes;
    }

    public String toStringUsuarios(int offer_id) {
        List<UsuariosAVacantes> Usuarios = obtenerUsuarios(offer_id);
        for (UsuariosAVacantes usuario : Usuarios) {
            System.out.println("id: "+usuario.getId());
            System.out.println("id de la oferta: "+usuario.getOffer_id());
            System.out.println("id del usuario: "+usuario.getUser_id());
            System.out.println("fecha de creacion: "+usuario.getDate());
            System.out.println("id del status del proceso de seleccion: "+usuario.getId_status_selection_process());
        }
        return null;
    }

    public String toStringVacantes(int user_id) {
        List<UsuariosAVacantes> Vacantes = obtenerVacantes(user_id);
        for (UsuariosAVacantes Vacante : Vacantes) {
            System.out.println("id: "+Vacante.getId());
            System.out.println("id de la oferta: "+Vacante.getOffer_id());
            System.out.println("id del usuario: "+Vacante.getUser_id());
            System.out.println("fecha de creacion: "+Vacante.getDate());
            System.out.println("id del status del proceso de seleccion: "+Vacante.getId_status_selection_process());
        }
        return null;
    }

}
