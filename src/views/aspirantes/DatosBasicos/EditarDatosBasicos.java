package views.aspirantes.DatosBasicos;

import controllers.aspirante.AspiranteController;
import controllers.extras.ExtrasController;
import models.tablasAuxiliares.TipoDeIdentificacion;
import views.templates.Input;
import views.templates.Item;
import views.templates.PanelView.PanelView;
import views.templates.TextPrompt;

import javax.swing.*;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class EditarDatosBasicos extends PanelView {
    private JPanel contenido;
    private JTextField numeroidentificacion;
    private JTextField nombres;
    private JTextField apellidos;
    private JTextField correo1;
    private JTextField correo2;
    private JTextField direccion;
    private JTextField pais;
    private JTextField estadomunicipio;
    private JTextField ciudad;
    private JTextField telefono1;
    private JTextField telefono2;
    private JComboBox dia;
    private JComboBox mes;
    private JComboBox ano;
    private JComboBox sexo;
    private JComboBox disponibilidadViajar;
    private JComboBox estadoCivil;
    private JTextField facebook;
    private JTextField instagram;
    private JComboBox tipoidentificacion;
    private JButton botonAtras;
    private JButton guardarContinuarButton;
    private Map<String, Object> formulario;
    Input input = new Input();
    ExtrasController extras = new ExtrasController();
    AspiranteController a = new AspiranteController();

    public EditarDatosBasicos(){

        formulario = new HashMap<>();
        formulario.put("numeroidentificacion", new TextPrompt("ejem: 1026209098", input.Text(numeroidentificacion)));
        formulario.put("tipoidentificacion", input.list(tipoidentificacion));
        formulario.put("nombres", new TextPrompt("ejem: eduard steven", input.Text(nombres)));
        formulario.put("apellidos", new TextPrompt("ejem: garzon pineda", input.Text(apellidos)));
        formulario.put("correo1", new TextPrompt("ejem: correo@email.com", input.Text(correo1)));
        formulario.put("correo2", new TextPrompt("ejem: correo@email.com", input.Text(correo2)));
        formulario.put("direccion", new TextPrompt("ejem: street 12 avenida", input.Text(direccion)));
        formulario.put("pais", new TextPrompt("ejem: mi pais", input.Text(pais)));
        formulario.put("estadomunicipio", new TextPrompt("seleccione su estado", input.Text(estadomunicipio)));
        formulario.put("ciudad", new TextPrompt("seleccione su ciudad", input.Text(ciudad)));
        formulario.put("telefono1", new TextPrompt("ejem: 3103333333", input.Text(telefono1)));
        formulario.put("telefono2", new TextPrompt("ejem: 3125555555", input.Text(telefono2)));
        formulario.put("dia", input.list(dia));
        formulario.put("mes", input.list(mes));
        formulario.put("ano", input.list(ano));
        formulario.put("disponibilidadViajar", input.list(disponibilidadViajar));
        formulario.put("estadoCivil", input.list(estadoCivil));
        CrearListaDia();
        CrearListaMes();
        CrearListaAno();
        CrearListasexo();
        CrearListaEstadoCivil();
        CrearDisponibilidadViajar();
        formulario.put("sexo", sexo = input.list(sexo));
        formulario.put("facebook", new TextPrompt("@facebook", input.Text(facebook)));
        formulario.put("instagram", new TextPrompt("@instagram", input.Text(instagram)));
        input.ButtonEditable(botonAtras, "../../resouces/img/botonAzul.png","../../resouces/img/botonAzulHover.png");
        input.Button(guardarContinuarButton);

    }

    public JComboBox CrearListaDia() {
        for (int i = 1; i <= 31; i++) {
            dia.addItem(String.valueOf(i));
        }
        return dia;
    }

    public void CrearListaMes() {
        for (int i = 1; i <= 12; i++) {
            mes.addItem(String.valueOf(i));
        }
    }

    public void CrearListaAno() {
        int currentYear = Year.now().getValue();
        for (int i = currentYear; i >= 1900; i--) {
            ano.addItem(String.valueOf(i));
        }
    }

    public void CrearListasexo() {
        sexo.addItem("Masculino");
        sexo.addItem("Femenino");
    }

    public void CrearDisponibilidadViajar() {
        disponibilidadViajar.addItem(new Item(0,"Si" ));
        disponibilidadViajar.addItem(new Item(1,"No" ));
    }

    public void CrearListaEstadoCivil() {
        estadoCivil.addItem("Soltero/a");
        estadoCivil.addItem("Casado/a");
        estadoCivil.addItem("Divorciado/a");
        estadoCivil.addItem("Viudo/a");
    }

    public void CrearListaTipoidentificacion() {
        for (TipoDeIdentificacion identificacion : extras.traerIdentificaciones()) {
            tipoidentificacion.addItem(new Item(identificacion.getId(), identificacion.getDescription()));
        }
    }

    public void start(){

        //se pintan todos los textfield con bordes redondeados
        super.setHeight(700);
        super.setMenu(contenido);
        super.showAspiranteWindow();

    }

}
