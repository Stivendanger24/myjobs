package views.aspirantes.RegistrarDatos;

import controllers.aspirante.AspiranteController;
import controllers.extras.ExtrasController;
import models.tablasAuxiliares.AreaProfesional;
import views.templates.Input;
import views.templates.Item;
import views.templates.PanelView.PanelView;
import views.templates.TextPrompt;
import views.templates.reject.RejectView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class SegundoPanel extends PanelView {

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

    AspiranteController aspiranteController = new AspiranteController();

    public SegundoPanel(){
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

        //evento de mause para enviar toda la informacion al controlador
        guardarYContinuarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Item areaprofesion = (Item) areaProfesional.getSelectedItem();
                int profesionid1 = areaprofesion.getId();

               //segunda experiencia laboral
                Item areaprofesion2 = (Item) areaProfesional2.getSelectedItem();
                int profesionid2 = areaprofesion2.getId();

                boolean response = aspiranteController.crearExperienciasLaborales(
                        cargo.getText(),
                        profesionid1,
                        nombreEmpresa.getText(),
                        funciones.getText(),
                        Integer.parseInt((String) anoinicio.getSelectedItem()),
                        Integer.parseInt((String) mesInicio.getSelectedItem()),
                        Integer.parseInt((String) anoFin.getSelectedItem()),
                        Integer.parseInt((String)  mesFin.getSelectedItem())
                );
                boolean response2 = aspiranteController.crearExperienciasLaborales(
                        cargo2.getText(),
                        profesionid2,
                        nombreEmpresa2.getText(),
                        funciones2.getText(),
                        Integer.parseInt((String) anioInicio2.getSelectedItem()),
                        Integer.parseInt((String) mesInicio2.getSelectedItem()),
                        Integer.parseInt((String) anoFin2.getSelectedItem()),
                        Integer.parseInt((String) mesFin2.getSelectedItem())
                );

                if(response == true && response2 == true){
                    RegistrarTodosDatos nuevoUsuario = new RegistrarTodosDatos();
                    SegundoPanel.super.setFrame(false);
                    nuevoUsuario.getTercelPanel().start();
                }else {
                    RejectView mensaje = new RejectView("por favor completa los campos");
                    mensaje.showRejectWindow();
                }
            }
        });
    }

    public void start(){
        super.setHeight(700);
        super.setMenu(contenido);
        setBastardises(barra);
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


    // Crear una instancia de la clase personalizada de JPanel con una imagen de fondo
    String imagePath = getClass().getResource("../../../resouces/img/barraprogreso2.png").getPath();
    BackgroundPanel barra = new BackgroundPanel(imagePath);

    public void setBastardises(BackgroundPanel insert) {
        barra.setOpaque(false);
        barra.setPreferredSize(new Dimension(640, 110)); // Establecer el tamaño deseado
        // Establecer el administrador de diseño en el panel barraestado
        barraestado.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        this.barraestado.add(barra);
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
