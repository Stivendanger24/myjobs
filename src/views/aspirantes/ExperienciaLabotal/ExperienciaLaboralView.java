package views.aspirantes.ExperienciaLabotal;

import views.templates.Input;
import views.templates.PanelView.PanelView;

import javax.swing.*;

public class ExperienciaLaboralView extends PanelView {
    private JPanel contenido;
    private JLabel cargo1;
    private JLabel nombreEmpresa1;
    private JLabel funciones1;
    private JLabel mesInicio1;
    private JButton botonAtras;
    private JButton botonEditar;
    private JLabel anioInicio1;
    private JLabel mesFin1;
    private JLabel anioFin1;
    private JLabel cargo2;
    private JLabel nombreEmpresa2;
    private JLabel funciones2;
    private JLabel mesInicio2;
    private JLabel anioInicio2;
    private JLabel mesFin2;
    private JLabel anioFin2;

    Input input = new Input();

    public ExperienciaLaboralView(){
        input.ButtonEditable(botonAtras, "../../resouces/img/botonAzul.png","../../resouces/img/botonAzulHover.png");
        input.Button(botonEditar);
    }

    public void start(){

        //se pintan todos los textfield con bordes redondeados
        super.setHeight(700);
        super.setMenu(contenido);
        super.showAspiranteWindow();

    }
}
