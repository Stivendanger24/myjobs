package views.aspirantes.RegistrarDatos;

import controllers.aspirante.AspiranteController;
import controllers.extras.ExtrasController;
import models.aspirante.AreaDeInteresLaboral;
import models.aspirante.AreasDeInteresesLaborales;
import models.oferta.TiposDePerfilProfesional;
import models.tablasAuxiliares.AreaProfesional;
import models.tablasAuxiliares.NivelDeEstudios;
import models.tablasAuxiliares.PerfilDeTrabajo;
import views.templates.*;
import views.templates.CustomScrollBarUI;
import views.templates.PanelView.PanelView;
import views.templates.aproved.Aproved;
import views.templates.reject.RejectView;

import javax.sound.sampled.AudioSystem;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TercelPanel extends PanelView {

    private JPanel contenido;
    private JPanel barraestado;
    private JButton buttonareas;
    private JTable pruebas;
    private JComboBox mesInicio;
    private JComboBox anoinicio;
    private JComboBox mesFin;
    private JComboBox anoFin;
    private JComboBox tipoperfilprofesional;
    private JComboBox area;
    private JButton atrasButton;
    private JButton guardarYContinuarButton;
    private JComboBox areaprofesional;
    private JTextField lugarestudios;
    private JComboBox nivelestudios;
    private JTextField titulobtenido;
    private JScrollPane scrollPane;

    private Map<String, Object> formulario;
    Input input = new Input();
    ExtrasController extras = new ExtrasController();
    AspiranteController aspirante = new AspiranteController();
    Aproved aprovado = new Aproved();

    public TercelPanel() {
        // Inicializar el mapa formulario
        formulario = new HashMap<>();
        formulario.put("mesinicio",input.list(mesInicio));
        formulario.put("mesfin",input.list(mesFin));
        formulario.put("anoinicio",input.list(anoinicio));
        formulario.put("aniofin",input.list(anoFin));
        formulario.put("tipoperfilprofesional",input.list(tipoperfilprofesional));
        formulario.put("area",input.list(area));
        formulario.put("areaprofesional",input.list(areaprofesional));
        formulario.put("nivelestudios",input.list(nivelestudios));
        formulario.put("lugarestudios", new TextPrompt("ejem: bogota", input.Text(lugarestudios)));
        formulario.put("titulobtenido", new TextPrompt("ejem: ing en sistemas", input.Text(titulobtenido)));
        input.ButtonEditable(atrasButton, "../../resouces/img/botonAzul.png","../../resouces/img/botonAzulHover.png");
        input.Button(guardarYContinuarButton);
        input.ButtonEditableSmall(buttonareas, "../../resouces/img/botonAzulSmall.png","../../resouces/img/botonAzulSmallHover.png");

        //se llaman a las listas para que se inicialicen
        CrearListaMes();
        CrearListaAno();

        //evento de mause para enviar toda la informacion al controlador
        buttonareas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Item miperfil = (Item) tipoperfilprofesional.getSelectedItem();
                int miperfilid = miperfil.getId();

                Item miarea = (Item) area.getSelectedItem();
                int miareaid = miarea.getId();

                boolean response = aspirante.crearAreaDeInteresLaboral(miperfilid,miareaid);

                if(response == true){
                    tablaAreaDeInteresLaboral();
                }
            }
        });
        guardarYContinuarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                //se trae el id de la lista
                Item nivelEstudio = (Item) nivelestudios.getSelectedItem();
                int nivelEstudioId = nivelEstudio.getId();

                Item areaDeProfesion = (Item) areaprofesional.getSelectedItem();
                int areaProfesionalId = areaDeProfesion.getId();

                boolean response = aspirante.crearEstudio(
                        lugarestudios.getText(),
                        nivelEstudioId,
                        areaProfesionalId,
                        titulobtenido.getText(),
                        Integer.parseInt((String) anoinicio.getSelectedItem()),
                        Integer.parseInt((String) mesInicio.getSelectedItem()),
                        Integer.parseInt((String) anoFin.getSelectedItem()),
                        Integer.parseInt((String) mesFin.getSelectedItem())
                );
                if(response == true){
                    TercelPanel.super.setFrame(false);
                    Aproved aprovado = new Aproved();
                    aprovado.start();
                }else{
                    RejectView mensaje = new RejectView("por favor completa los campos");
                    mensaje.showRejectWindow();
                }

            }
        });
    }

    public void start() {
        super.setHeight(700);
        super.setMenu(contenido);
        setBastardises(barra);
        super.showAspiranteWindow();
    }

    public void CrearListaMes() {
        for (int i = 1; i <= 12; i++) {
            mesInicio.addItem(String.valueOf(i));
            mesFin.addItem(String.valueOf(i));
        }
    }

    public void CrearListaAno() {
        int currentYear = Year.now().getValue();
        for (int i = currentYear; i >= 1900; i--) {
            anoinicio.addItem(String.valueOf(i));
            anoFin.addItem(String.valueOf(i));
        }
    }


    public void CrearListaNivelEstudios() {
        for (NivelDeEstudios estudio : extras.traerNivelesEstudios()) {
            nivelestudios.addItem(new Item(estudio.getId(), estudio.getDescription()));
        }
    }

    public void CrearListaAreaLaboral() {
        for (AreaProfesional miarea : extras.traerAreasProfesionales()) {
            area.addItem(new Item(miarea.getId(), miarea.getDescription()));
            areaprofesional.addItem(new Item(miarea.getId(), miarea.getDescription()));
        }
    }

    public void CrearListaTipoPerfilProfesional() {
        for ( PerfilDeTrabajo tipo : extras.traerPerfilesDeTrabajo())
            tipoperfilprofesional.addItem(new Item(tipo.getId(), tipo.getDescription()));
    }

    // Crear una instancia de la clase personalizada de JPanel con una imagen de fondo
    String imagePath = getClass().getResource("../../../resouces/img/barraprogreso3.png").getPath();
    BackgroundPanel barra = new BackgroundPanel(imagePath);

    public void setBastardises(BackgroundPanel insert) {
        barra.setOpaque(false);
        barra.setPreferredSize(new Dimension(640, 110)); // Establecer el tamaño deseado
        // Establecer el administrador de diseño en el panel barraestado
        barraestado.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        this.barraestado.add(barra);
    }

    public void tablaAreaDeInteresLaboral() {

        CustomTable customTable = new CustomTable(new String[]{"perfil profesional", "area", "accion"}, new int[] {130, 100, 50});

        List<AreaDeInteresLaboral> areas = aspirante.traerAreasDeInteresLaboral();
        if (areas != null) {
            for (AreaDeInteresLaboral area : areas) {
                  PerfilDeTrabajo perfil = extras.traerUnPerfilDeTrabajo(area.getId_type_of_job_profile());
                AreaProfesional miarea = extras.traerUnAreaProfesional(area.getId_professional_area());
                  customTable.addRow(new Object[]{perfil.getDescription(), miarea.getDescription(), "x"});
            }
        }

        // Personalizar la apariencia del JScrollPane
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.setViewportView(customTable);
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

