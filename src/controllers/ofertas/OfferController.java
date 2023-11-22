package controllers.ofertas;

import models.SesionStatus;
import models.oferta.*;

public class OfferController {

    DatosBasicosOferta datosBasicosOferta = new DatosBasicosOferta();
    LenguajesRequeridos lenguajes = new LenguajesRequeridos();
    DestrezasYConocimientos destrezas = new DestrezasYConocimientos();
    PreguntasDeSeleccion preguntas = new PreguntasDeSeleccion();
    TiposDePerfilProfesional Perfil = new TiposDePerfilProfesional();
    SesionStatus sesionStatus = SesionStatus.getInstance();

    public String traerDatosBasicosUnaOferta(int id) {
        if (sesionStatus.isLoggedIn()){
            datosBasicosOferta.getDatosBasicosOferta(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String CreardatosBasicosOferta(String job_offer_title, int id_professional_area, String job_offer_content, String id_country, String departament_state, String id_city, int id_work_day, int salary, int job_vacancies, int years_of_experience, int id_studies_level, int driving_license,int staff_with_disabilities, int id_status_offer) {
        if (sesionStatus.isLoggedIn()){
            datosBasicosOferta.crearBasicosOferta(job_offer_title, id_professional_area, job_offer_content, id_country, departament_state, id_city, id_work_day, salary, job_vacancies, years_of_experience, id_studies_level, driving_license, staff_with_disabilities, id_status_offer);
            return datosBasicosOferta.toString();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerdatosBasicosOfertas() {
        if (sesionStatus.isLoggedIn()){
            datosBasicosOferta.obtenerDatosBasicosOferta();
            return datosBasicosOferta.toString();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String eliminarBasicosOfertas(int id){
        if (sesionStatus.isLoggedIn()){
            datosBasicosOferta.eliminarDatosBasicosOferta(id);
            datosBasicosOferta.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnlenguaje(int id) {
        if (sesionStatus.isLoggedIn()){
            lenguajes.getLenguaje(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String Crearlenguaje(int offer_id, String idioma, String nivel) {
        if (sesionStatus.isLoggedIn()){
            lenguajes.crearLenguaje(offer_id, idioma, nivel);
            return lenguajes.toString();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerlenguajes(int offer_id) {
        if (sesionStatus.isLoggedIn()){
            lenguajes.obtenerLenguaje(offer_id);
            return lenguajes.toString(offer_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String eliminarlenguajes(int offer_id, int id){
        if (sesionStatus.isLoggedIn()){
            lenguajes.eliminarLenguaje(offer_id, id);
            lenguajes.toString(offer_id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnadestreza(int id) {
        if (sesionStatus.isLoggedIn()){
            destrezas.getDestreza(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String Creardestreza(int offer_id, String destreza, String nivel) {
        if (sesionStatus.isLoggedIn()){
            destrezas.crearDestreza(offer_id, destreza, nivel);
            return destrezas.toString(offer_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerdestrezas(int offer_id) {
        if (sesionStatus.isLoggedIn()){
            destrezas.obtenerDestrezas(offer_id);
            return destrezas.toString(offer_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String eliminardestreza(int offer_id, int id){
        if (sesionStatus.isLoggedIn()){
            destrezas.eliminarDestreza(offer_id, id);
            destrezas.toString(offer_id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnaPregunta(int id) {
        if (sesionStatus.isLoggedIn()){
            preguntas.getPreguntaDeSeleccion(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String Crearpregunta(int offer_id, String pregunta) {
        if (sesionStatus.isLoggedIn()){
            preguntas.crearPreguntaDeSeleccion(offer_id, pregunta);
            return preguntas.toString(offer_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerpreguntas(int offer_id) {
        if (sesionStatus.isLoggedIn()){
            preguntas.obtenerPreguntasDeSeleccion(offer_id);
            return preguntas.toString(offer_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String eliminarpreguntas(int offer_id, int id){
        if (sesionStatus.isLoggedIn()){
            preguntas.eliminarPreguntaDeSeleccion(offer_id, id);
            preguntas.toString(offer_id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnPerfil(int id) {
        if (sesionStatus.isLoggedIn()){
            Perfil.getTipoDePerfilProfesional(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String CrearPerfil(int offer_id, int id_perfil) {
        if (sesionStatus.isLoggedIn()){
            Perfil.crearTipoDePerfilProfesional(offer_id, id_perfil);
            return Perfil.toString(offer_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String editarPerfil(int id_type_of_job_profile, int offer_id) {
        if (sesionStatus.isLoggedIn()){
            Perfil.actualizarTipoDePerfilProfesional(id_type_of_job_profile,offer_id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String eliminarPerfil(int id){
        if (sesionStatus.isLoggedIn()){
            Perfil.eliminarTipoDePerfilProfesional(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerPerfiles(int offer_id) {
        if (sesionStatus.isLoggedIn()){
            Perfil.obtenerPerfiles(offer_id);
            return Perfil.toString(offer_id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }
}
