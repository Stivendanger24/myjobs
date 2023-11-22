package views.aspirantes.DatosBasicos;

import controllers.aspirante.AspiranteController;
import controllers.extras.ExtrasController;
import models.aspirante.InformacionBasicaAspirante;
import views.templates.Input;
import views.templates.PanelView.PanelView;

import javax.swing.*;

public class DatosBasicos extends PanelView {
    private JPanel contenido;
    private JButton botonEditar;
    private JLabel NumeroIdefinticacion;
    private JLabel tipoIdentificacion;
    private JLabel Nombres;
    private JLabel apellidos;
    private JLabel correo1;
    private JLabel correo2;
    private JLabel direccion;
    private JLabel pais;
    private JLabel estadoMunicipio;
    private JLabel ciudad;
    private JLabel telefono1;
    private JLabel telefono2;
    private JLabel datosNacimiento;
    private JLabel sexo;
    private JLabel estadoCivil;
    private JLabel facebook;
    private JLabel instagram;
    private JLabel disponibilidadViajar;
    private JButton botonAtras;

    Input input = new Input();
    AspiranteController myaspirante = new AspiranteController();
    ExtrasController extras = new ExtrasController();

    public DatosBasicos ()
    {
        InformacionBasicaAspirante aspirante = myaspirante.traerInformacionBasica();
        input.ButtonEditable(botonAtras, "../../resouces/img/botonAzul.png","../../resouces/img/botonAzulHover.png");
        input.Button(botonEditar);
        NumeroIdefinticacion.setText(String.valueOf(aspirante.getNumber_identification()));
        tipoIdentificacion.setText(extras.traerUnaIdentificacion(aspirante.getId_type_identification()));
        Nombres.setText(aspirante.getFirst_name());
        apellidos.setText(aspirante.getLast_name());
        correo1.setText(aspirante.getEmail());
        correo2.setText(aspirante.getEmail2());
        direccion.setText(aspirante.getAdress());
        pais.setText(aspirante.getId_country());
        estadoMunicipio.setText(aspirante.getState());
        ciudad.setText(aspirante.getId_city());
        telefono1.setText(aspirante.getPhone1());
        telefono2.setText(aspirante.getPhone2());
        datosNacimiento.setText(String.valueOf(aspirante.getDay()));
        sexo.setText(aspirante.getGender());
        estadoCivil.setText(aspirante.getMarital_status());
        facebook.setText(aspirante.getFacebook());
        instagram.setText(aspirante.getInstagram());
        disponibilidadViajar.setText(String.valueOf(aspirante.getAvailability_travel()));
        aspirante.toString();




    }

    public void start(){

        //se pintan todos los textfield con bordes redondeados
        super.setHeight(700);
        super.setMenu(contenido);
        super.showAspiranteWindow();

    }
}
