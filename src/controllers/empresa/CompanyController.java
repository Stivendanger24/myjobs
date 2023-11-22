package controllers.empresa;

import models.SesionStatus;
import models.empresa.DescripcionDeLaEmpresa;
import models.empresa.InformacionBasicaDeEmpresa;

public class CompanyController {

    InformacionBasicaDeEmpresa infobasicaEmpresa = new InformacionBasicaDeEmpresa();
    DescripcionDeLaEmpresa DescripcionEmpresa = new DescripcionDeLaEmpresa();
    SesionStatus sesionStatus = SesionStatus.getInstance();

    public String traerInformacionBasicaDeEmpresa() {
        if (sesionStatus.isLoggedIn()){
            infobasicaEmpresa.getInformacionBasicaDeEmpresa();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String CrearInformacionBasicaDeEmpresa(int type_identification, String company_name, String email, String email2, String adress, String id_country, String state, String id_city, String phone1, String phone2, String facebook, String instagram) {
        if (sesionStatus.isLoggedIn() && sesionStatus.getId_roll() == "empresa"){
            infobasicaEmpresa.crearInformacionBasicaDeEmpresa(type_identification, company_name, email, email2, adress, id_country, state, id_city, phone1, phone2, facebook, instagram);
            return traerInformacionBasicaDeEmpresa();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String ActualizarInformacionBasicaDeEmpresa(int type_identification, String company_name, String email, String email2, String adress, String id_country, String state, String id_city, String phone1, String phone2, String facebook, String instagram){
        if (sesionStatus.isLoggedIn()){
            infobasicaEmpresa.actualizarInformacionBasicaDeEmpresa(type_identification, company_name, email, email2, adress, id_country, state, id_city, phone1, phone2, facebook, instagram);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String traerDescripcionEmpresa() {
        if (sesionStatus.isLoggedIn()){
            DescripcionEmpresa.getDescripcionDeLaEmpresa();
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String CrearDescripcionEmpresa(String descripcion) {
        if (sesionStatus.isLoggedIn()){
            DescripcionEmpresa.crearDescripcionDeLaEmpresa(descripcion);
            return traerDescripcionEmpresa();
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

    public String ActualizarDescripcionEmpresa(String descripcion){
        if (sesionStatus.isLoggedIn()){
            DescripcionEmpresa.actualizarDescripcionDeLaEmpresa(descripcion);
            return null;
        }else {
            System.out.println("El usuario no está logueado.");
        }
        return null;
    }

}
