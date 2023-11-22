package controllers.extras;

import models.SesionStatus;
import models.tablasAuxiliares.*;

import java.util.List;

public class ExtrasController {

    UsuariosAVacantes usuariosAVacantes = new UsuariosAVacantes();
    EstadoDeProcesoDeSeleccion estadoSeleccion = new EstadoDeProcesoDeSeleccion();
    EstadoDeLaOferta estadoOferta = new EstadoDeLaOferta();
    TipoDeJornada tipoJornadas = new TipoDeJornada();
    AreaProfesional areaProfesional = new AreaProfesional();
    TipoDeIdentificacion identificacion = new TipoDeIdentificacion();
    PerfilDeTrabajo perfilDeTrabajo = new PerfilDeTrabajo();
    NivelDeEstudios estudios = new NivelDeEstudios();

    RespuestasAPreguntasDeSeleccion respuestasSeleccion = new RespuestasAPreguntasDeSeleccion();
    SesionStatus sesionStatus = SesionStatus.getInstance();

    public String traerUnUsuarioAVacante(int id) {
        if (sesionStatus.isLoggedIn()){
            usuariosAVacantes.getUsuarioAVacante(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String CrearUsuarioAVacante(int offer_id, int user_id, int id_status_selection_process) {
        if (sesionStatus.isLoggedIn()){
            usuariosAVacantes.crearUsuarioAVacante(offer_id, user_id, id_status_selection_process);
            return usuariosAVacantes.toStringUsuarios(offer_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerVacantes(int user_id) {
        if (sesionStatus.isLoggedIn()){
            usuariosAVacantes.obtenerVacantes(user_id);
            return usuariosAVacantes.toStringVacantes(user_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUsuarios(int offer_id) {
        if (sesionStatus.isLoggedIn()){
            usuariosAVacantes.obtenerUsuarios(offer_id);
            return usuariosAVacantes.toStringUsuarios(offer_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnEstadoSeleccion(int id) {
        if (sesionStatus.isLoggedIn()){
            estadoSeleccion.getEstado_de_proceso_de_seleccions(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerEstadosSeleccion() {
        if (sesionStatus.isLoggedIn()){
            estadoSeleccion.obtenerEstados_de_proceso_de_seleccions();
            return estadoSeleccion.toString();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnestadoOferta(int id) {
        if (sesionStatus.isLoggedIn()){
            estadoOferta.getEstadoDeLaOferta(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerestadosOfertas() {
        if (sesionStatus.isLoggedIn()){
            estadoOferta.obtenerEstadosDeLasOfertas();
            return estadoOferta.toString();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUntipoJornada(int id) {
        if (sesionStatus.isLoggedIn()){
            tipoJornadas.getTipoDeJornada(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traertipoJornadas() {
        if (sesionStatus.isLoggedIn()){
            tipoJornadas.obtenerTiposDeJornadas();
            return tipoJornadas.toString();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public AreaProfesional traerUnAreaProfesional(int id) {
        if (sesionStatus.isLoggedIn()){
            return areaProfesional.getAreaProfesional(id);
        }else {
            System.out.println("El usuario no está logueado.");
            return null;
        }

    }

    public List<AreaProfesional> traerAreasProfesionales() {
        if (sesionStatus.isLoggedIn()){
            return areaProfesional.obtenerAreasProfesionales();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnaIdentificacion(int id) {
        if (sesionStatus.isLoggedIn()){
            return identificacion.getTipoDeIdentificacion(id);
        }else {
            System.out.println("El usuario no está logueado.");
            return null;
        }
    }

    public List<TipoDeIdentificacion> traerIdentificaciones() {
        if (sesionStatus.isLoggedIn()){
            return identificacion.obtenerTiposDeIdentificaciones();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public PerfilDeTrabajo traerUnPerfilDeTrabajo(int id) {
        if (sesionStatus.isLoggedIn()){
            return perfilDeTrabajo.getPerfilDeTrabajo(id);
        }else {
            System.out.println("El usuario no está logueado.");
            return null;
        }
    }

    public List<PerfilDeTrabajo> traerPerfilesDeTrabajo() {
        if (sesionStatus.isLoggedIn()){
            return perfilDeTrabajo.obtenerPerfilesDeTrabajo();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnNivelestudio(int id) {
        if (sesionStatus.isLoggedIn()){
            estudios.getNivelDeEstudio(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public List<NivelDeEstudios> traerNivelesEstudios() {
        if (sesionStatus.isLoggedIn()){
            return estudios.obtenerNivel_de_estudios();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    /////////////////////////////////////////////////////////////////////

    public String traerUnRespuesta(int id) {
        if (sesionStatus.isLoggedIn()){
            respuestasSeleccion.getRespuestaAPreguntaDeSeleccion(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String CrearRespuesta(int selection_ask_id, String answer) {
        if (sesionStatus.isLoggedIn()){
            respuestasSeleccion.crearRespuestaAPreguntaDeSeleccion(selection_ask_id, answer);
            return respuestasSeleccion.toString(selection_ask_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String editarRespuesta(int id, String answer) {
        if (sesionStatus.isLoggedIn()){
            respuestasSeleccion.actualizarRespuestaAPreguntaDeSeleccion(id, answer);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String eliminarRespuesta(int id){
        if (sesionStatus.isLoggedIn()){
            respuestasSeleccion.eliminarPreguntaDeSeleccion(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerRespuestas(int selection_ask_id) {
        if (sesionStatus.isLoggedIn()){
            respuestasSeleccion.obtenerRespuestas(selection_ask_id);
            return respuestasSeleccion.toString(selection_ask_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

}
