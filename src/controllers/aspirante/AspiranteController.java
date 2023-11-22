package controllers.aspirante;

import models.SesionStatus;
import models.aspirante.*;
import views.aspirantes.RegistrarDatos.RegistrarTodosDatos;

import java.util.List;

public class AspiranteController {
    InformacionBasicaAspirante onfoBasica = new InformacionBasicaAspirante();
    AreasDeInteresesLaborales areasDeInteres = new AreasDeInteresesLaborales();
    CiudadesDeInteresATrabajar ciudadInteres = new CiudadesDeInteresATrabajar();
    HabilidadesInformaticas habilidadesInform = new HabilidadesInformaticas();
    ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral();
    OtrasHabilidades otrasHabilidades = new OtrasHabilidades();
    PerfilProfesional perfilProfesional = new PerfilProfesional();
    Estudios estudios = new Estudios();
    Idiomas idiomas = new Idiomas();
    SesionStatus sesionStatus = SesionStatus.getInstance();

    private boolean isAnyEmpty(String... values) {
        for (String value : values) {
            if (value == null || value.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumeric(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }


    public boolean CrearInformacionBasica(String number_identification, String id_type_identification, String first_name, String last_name, String email, String email2,
                                         String adress, String id_country, String state, String id_city, String phone1, String phone2, String year, String mount, String day, String gender,
                                         String marital_status, String facebook, String instagram, String availability_travel) {
        //validar si el usuario esta logeado
        if (sesionStatus.isLoggedIn()) {
            // Validar campos en blanco
            if (isAnyEmpty(number_identification, id_type_identification, first_name, last_name, email, adress, id_country,
                    id_city, phone1, year, mount, day, gender, marital_status, availability_travel)) {
                System.out.println("Todos los campos son requeridos");
                return false;
            }

            // Validar tipo de dato número de identificación
            if (!isNumeric(number_identification)) {
                System.out.println("El número de identificación debe ser un valor numérico");
                // o lanzar una excepción, por ejemplo:
                System.out.println("El número de identificación debe ser un valor numérico");
                return false;
            }

            // Validar formato de correo electrónico
            if (!isValidEmail(email) || !isValidEmail(email2)) {
                System.out.println("El formato de correo electrónico es inválido");
                return false;
            }
            onfoBasica.createAspirante(number_identification, id_type_identification, first_name, last_name, email, email2,
                    adress, id_country, state, id_city, phone1, phone2, year, mount, day, gender,
                    marital_status, facebook, instagram, availability_travel);

            return true;
        }else{
            System.out.println("El usuario no está logueado.");
            return false;
        }
    }

    public InformacionBasicaAspirante traerInformacionBasica() {
        if (sesionStatus.isLoggedIn()){
          return onfoBasica.getAspirante(SesionStatus.getInstance().getUser_id());

        }else {
            System.out.println("El usuario no está logueado.");
            return null;
        }
    }

     public String ActualizarInformacion(int number_identification, int id_type_identification, String first_name,
                                  String last_name, String email, String email2, String adress, int id_country, String state,
                                  String id_city, String phone1, String phone2, int year, int mount, int day, String gender,
                                  String marital_status, String facebook, String instagram, int availability_travel){
         if (sesionStatus.isLoggedIn()){
             onfoBasica.actualizarAspirante(number_identification, id_type_identification, first_name,
                     last_name, email, email2, adress,id_country, state, id_city, phone1, phone2, year, mount, day, gender,
                     marital_status, facebook, instagram, availability_travel);
             return null;
         }else {
             System.out.println("El usuario no está logueado.");
         }
         return null;
     }
///////////////////////////////////////////////////////////////////////////////////////////////////
    public List<AreaDeInteresLaboral> traerAreasDeInteresLaboral(){
        if (sesionStatus.isLoggedIn()){
            return areasDeInteres.getAll();
        }else {
            System.out.println("El usuario no está logueado.");
            return null;
        }
    }

    public String traerUnAreaDeInteresLaboral(int id){
        if (sesionStatus.isLoggedIn()){
            areasDeInteres.getAreaDeInteres(id);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public boolean crearAreaDeInteresLaboral(int id_type_of_job_profile, int id_professional_area){
        if (sesionStatus.isLoggedIn()){
            areasDeInteres.createAreaDeInteres(id_type_of_job_profile,id_professional_area);
            areasDeInteres.toString();
            return true;
        }else {
            System.out.println("El usuario no está logueado.");
            return false;
        }
    }

    public String actualizarAreaDeInteresLaboral(int id, int id_type_of_job_profile, int id_professional_area){
        if (sesionStatus.isLoggedIn()){
            areasDeInteres.actualizarAreaDeInteres(id, id_type_of_job_profile, id_professional_area);
            areasDeInteres.toString();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnaHabilidadInformatica(int id){
        if (sesionStatus.isLoggedIn()){
            habilidadesInform.getHabilidadesInformaticas(id);
        return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerHabilidadesInformaticas(){
        if (sesionStatus.isLoggedIn()){
            habilidadesInform.obtenerTodasLasHabilidadesInformaticas();
            habilidadesInform.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String crearHabilidadesInformaticasr(String description){
        if (sesionStatus.isLoggedIn()){
            habilidadesInform.crearHabilidadesInformaticas(description);
            habilidadesInform.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String eliminarHabilidadInformatica(int id){
        if (sesionStatus.isLoggedIn()){
            habilidadesInform.eliminarHabilidadInformatica(id);
            habilidadesInform.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnaCiudadDeInteres(int id){
        if (sesionStatus.isLoggedIn()){
            ciudadInteres.getCiudadDeInteresATrabajar(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerCiudadesDeInteresTrabajar(){
        if (sesionStatus.isLoggedIn()){
            ciudadInteres.obtenerTodasLasCiudadesDeInteresATrabajar();
            ciudadInteres.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String crearCiudadesDeInteresTrabajar(String id_city){
        if (sesionStatus.isLoggedIn()){
            ciudadInteres.crearCiudadDeInteresATrabajar(id_city);
            ciudadInteres.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String eliminarCiudadesDeInteresTrabajar(int id){
        if (sesionStatus.isLoggedIn()){
            ciudadInteres.eliminarCiudadDeInteresATrabajar(id);
            ciudadInteres.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerOtraHabilidad(int id){
        if (sesionStatus.isLoggedIn()){
            otrasHabilidades.getOtrasHabilidades(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerOtrasHabilidades(){
        if (sesionStatus.isLoggedIn()){
            otrasHabilidades.obtenerOtrasHabilidades();
            otrasHabilidades.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String crearOtrasHabilidades(String description){
        if (sesionStatus.isLoggedIn()){
            otrasHabilidades.crearOtrasHabilidades(description);
            otrasHabilidades.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String eliminarOtrasHabilidades(int id){
        if (sesionStatus.isLoggedIn()){
            otrasHabilidades.eliminarOtrasHabilidades(id);
            ciudadInteres.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerPerfilProfesional(){
        if (sesionStatus.isLoggedIn()){
            perfilProfesional.getPerfilProfesional();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public int crearPerfilProfesional(int id_type_of_job_profile){
        if (sesionStatus.isLoggedIn()){
            perfilProfesional.crearPerfilProfesional(id_type_of_job_profile);
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return id_type_of_job_profile;
    }

    public String editarPerfilProfesional(int id_type_of_job_profile){
        if (sesionStatus.isLoggedIn()){
            perfilProfesional.editarPerfilProfesional(id_type_of_job_profile);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnaExperienciaLaboral(int id){
        if (sesionStatus.isLoggedIn()){
            experienciaLaboral.getExperienciaLaboral(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public List<ExperienciaLaboral> traerExperienciasLaborales(){
        if (sesionStatus.isLoggedIn()){
            return experienciaLaboral.obtenerExperienciasLaborales();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public boolean crearExperienciasLaborales(String work_position, int id_professional_area, String company_name, String functions, int date_of_start_year, int date_of_start_mount, int date_of_end_year, int date_of_end_mount) {
        if (sesionStatus.isLoggedIn()) {
            if (work_position.isEmpty() || company_name.isEmpty() || functions.isEmpty()) {
                System.out.println("Por favor, comple" + "te todos los campos.");
                return false;
            }

            // Validar tipo de dato para los campos numéricos
            if (date_of_start_year <= 0 || date_of_start_mount <= 0 || date_of_end_year <= 0 || date_of_end_mount <= 0) {
                System.out.println("Los campos de fecha deben ser números positivos.");
                return false;
            }


            experienciaLaboral.crearExperienciaLaboral(work_position, id_professional_area, company_name, functions, date_of_start_year, date_of_start_mount, date_of_end_year, date_of_end_mount);
            experienciaLaboral.toString();
            return true;
        } else {
            System.out.println("El usuario no está logueado.");
            return false;
        }
    }


    public String eliminarExperienciaLaboral(int id){
        if (sesionStatus.isLoggedIn()){
            experienciaLaboral.eliminarExperienciaLaboral(id);
            experienciaLaboral.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerUnEstudio(int id){
        if (sesionStatus.isLoggedIn()){
            estudios.getEstudios(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerEstudios(){
        if (sesionStatus.isLoggedIn()){
            estudios.obtenerEstudios();
            estudios.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public boolean crearEstudio(String place_of_studies, int id_level_study, int id_professional_area, String degree_obtainded, int date_of_start_year, int date_of_start_mount, int date_of_end_year, int date_of_end_mount) {
        if (sesionStatus.isLoggedIn()) {
            if (place_of_studies.isEmpty() || degree_obtainded.isEmpty()) {
                System.out.println("Todos los campos son requeridos.");
                return false;
            }

            estudios.crearEstudio(place_of_studies, id_level_study, id_professional_area, degree_obtainded, date_of_start_year, date_of_start_mount, date_of_end_year, date_of_end_mount);
            estudios.toString();
            return true;
        } else {
            System.out.println("El usuario no está logueado.");
            return false;
        }
    }


    public String eliminarEstudio(int id){
        if (sesionStatus.isLoggedIn()){
            estudios.eliminarEstudios(id);
            estudios.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerIdioma(int id){
        if (sesionStatus.isLoggedIn()){
            idiomas.getIdioma(id);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerIdiomas(){
        if (sesionStatus.isLoggedIn()){
            idiomas.obtenerIdiomas();
            idiomas.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String crearIdiomas(String lenguaje, String nivel){
        if (sesionStatus.isLoggedIn()){
            idiomas.crearIdioma(lenguaje, nivel);
            idiomas.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String eliminarIdioma(int id){
        if (sesionStatus.isLoggedIn()){
            idiomas.eliminarIdioma(id);
            idiomas.toString();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }
}


