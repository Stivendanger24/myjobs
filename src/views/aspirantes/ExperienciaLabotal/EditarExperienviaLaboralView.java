package views.aspirantes.ExperienciaLabotal;

import controllers.aspirante.AspiranteController;
import controllers.extras.ExtrasController;
import models.tablasAuxiliares.AreaProfesional;
import views.aspirantes.RegistrarDatos.SegundoPanel;
import views.templates.Input;
import views.templates.Item;
import views.templates.PanelView.PanelView;
import views.templates.TextPrompt;

import javax.swing.*;
import java.awt.*;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class EditarExperienviaLaboralView extends PanelView {
    private JPanel contenido;
    private JPanel barraestado;
    private JTextField cargo;
    private JTextField nombreEmpresa;
    private JTextArea funciones;
    private JComboBox mesFin;
    private JComboBox anoFin;
    private JComboBox mesInicio;
    private JComboBox anoinicio;
    private JComboBox areaProfesional;
    private JTextArea funciones2;
    private JTextField cargo2;
    private JTextField nombreEmpresa2;
    private JComboBox mesInicio2;
    private JComboBox mesFin2;
    private JComboBox anoFin2;
    private JComboBox areaProfesional2;
    private JButton atrasButton;
    private JButton guardarYContinuarButton;
    private JComboBox anioInicio2;

    private Map<String, Object> formulario;
    Input input = new Input();

    ExtrasController extras = new ExtrasController();

    public EditarExperienviaLaboralView (){
        // Inicializar el mapa formulario
        formulario = new HashMap<>();
        formulario.put("cargo", new TextPrompt("ejem: aux contable", input.Text(cargo)));
        formulario.put("nombreEmpresa", new TextPrompt("ejem: mi empresa sas", input.Text(nombreEmpresa)));
        formulario.put("funciones", new TextPrompt("ejem: contabilizar, administrar y archivas facturacion electronica", input.TextArea(funciones)));
        formulario.put("mesInicio",input.list(mesInicio));
        formulario.put("anioInicio",input.list(anoinicio));
        formulario.put("mesFin",input.list(mesFin));
        formulario.put("anoFin",input.list(anoFin));
        formulario.put("areaProfesional",input.list(areaProfesional));
        formulario.put("cargo2", new TextPrompt("ejem: aux contable", input.Text(cargo2)));
        formulario.put("nombreEmpresa2", new TextPrompt("ejem: cualquier empresa sas", input.Text(nombreEmpresa2)));
        formulario.put("funciones2", new TextPrompt("ejem: analista de sistemas", input.TextArea(funciones2)));
        formulario.put("mesInicio",input.list(mesInicio2));
        formulario.put("anioInicio",input.list(anioInicio2));
        formulario.put("mesFin",input.list(mesFin2));
        formulario.put("anoFin",input.list(anoFin2));
        formulario.put("areaProfesional",input.list(areaProfesional2));
        input.ButtonEditable(atrasButton, "../../resouces/img/botonAzul.png","../../resouces/img/botonAzulHover.png");
        input.Button(guardarYContinuarButton);
        CrearListaMes();
        CrearListaAno();

    }

    public void start(){
        super.setHeight(700);
        super.setMenu(contenido);
        super.showAspiranteWindow();
    }

    public void CrearListaMes() {
        for (int i = 1; i <= 12; i++) {
            mesInicio.addItem(String.valueOf(i));
            mesFin.addItem(String.valueOf(i));
            mesInicio2.addItem(String.valueOf(i));
            mesFin2.addItem(String.valueOf(i));
        }
    }

    public void CrearListaAno() {
        int currentYear = Year.now().getValue();
        for (int i = currentYear; i >= 1900; i--) {
            anoinicio.addItem(String.valueOf(i));
            anoFin.addItem(String.valueOf(i));
            anioInicio2.addItem(String.valueOf(i));
            anoFin2.addItem(String.valueOf(i));
        }
    }

    public void CrearListaAreaProfesional() {
        for (AreaProfesional area : extras.traerAreasProfesionales()) {
            areaProfesional.addItem(new Item(area.getId(), area.getDescription()));
            areaProfesional2.addItem(new Item(area.getId(), area.getDescription()));
        }
    }


    private static class BackgroundPanel extends JPanel {

        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            super();
            backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar la imagen de fondo en la parte posterior del panel
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, -25, getWidth(), getHeight(), null);
            }
        }
    }
}
