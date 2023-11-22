package views.aspirantes.RegistrarDatos;

import controllers.aspirante.AspiranteController;
import controllers.extras.ExtrasController;
import models.tablasAuxiliares.TipoDeIdentificacion;
import views.templates.Input;
import views.templates.Item;
import views.templates.PanelView.PanelView;
import views.templates.TextPrompt;
import views.templates.aproved.Aproved;
import views.templates.reject.RejectView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class PrimerPanel extends PanelView {
    private JPanel contenido;// contenedores que organizan los botones
    private JPanel barraestado;
    private JTextField numeroidentificacion; //capturar la entrada de texto del usuario
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
    private JComboBox sexo;//listas de opciones al usuario y permite al usuario seleccionar una de ellas.
    private JComboBox disponibilidadViajar;
    private JComboBox estadoCivil;
    private JTextField facebook;
    private JTextField instagram;
    private JComboBox tipoidentificacion;
    private JButton guardarContinuarButton;
    private Map<String, Object> formulario;
    Input input = new Input();
    ExtrasController extras = new ExtrasController();
    AspiranteController aspiranteController = new AspiranteController();
    public PrimerPanel(){
        // Inicializar el mapa formulario
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
        formulario.put("sexo", sexo = input.list(sexo));
        formulario.put("facebook", new TextPrompt("@facebook", input.Text(facebook)));
        formulario.put("instagram", new TextPrompt("@instagram", input.Text(instagram)));
        formulario.put("guardarContinuarButton", input.Button(guardarContinuarButton));

        //se inicializan los metodos que traen las listas de datos tanto de la base de datos como de parametros especiales
        CrearListaDia();
        CrearListaMes();
        CrearListaAno();
        CrearListasexo();
        CrearListaEstadoCivil();
        CrearDisponibilidadViajar();

        //se validan que los campos tengan el texto correcto gracias a la clase Input
        input.inputOnlyNumbers(numeroidentificacion);
        input.validateEmails(correo1);
        input.validateEmails(correo2);
        input.inputOnlyNumbers(telefono1);
        input.inputOnlyNumbers(telefono2);

        //evento de mause para enviar toda la informacion al controlador
        guardarContinuarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Item identificacionseleccionada = (Item) tipoidentificacion.getSelectedItem();
                int selectedId = identificacionseleccionada.getId();
                Item viaja = (Item) disponibilidadViajar.getSelectedItem();
                int viajaid = viaja.getId();

                boolean response =  aspiranteController.CrearInformacionBasica(
                        numeroidentificacion.getText(),
                        Integer.toString(selectedId),
                        nombres.getText(),
                        apellidos.getText(),
                        correo1.getText(),
                        correo2.getText(),
                        direccion.getText(),
                        pais.getText(),
                        estadomunicipio.getText(),
                        ciudad.getText(),
                        telefono1.getText(),
                        telefono2.getText(),
                        (String) ano.getSelectedItem(),
                        (String) mes.getSelectedItem(),
                        (String) dia.getSelectedItem(),
                        (String) sexo.getSelectedItem(),
                        (String) estadoCivil.getSelectedItem(),
                        facebook.getText(),
                        instagram.getText(),
                        String.valueOf(viajaid)
                );
                if(response == true){
                    RegistrarTodosDatos nuevoUsuario = new RegistrarTodosDatos();
                    PrimerPanel.super.setFrame(false);
                    nuevoUsuario.getSegundoPanel();
                    nuevoUsuario.getSegundoPanel().start();
                }else{
                    RejectView mensaje = new RejectView("por favor completa los campos");
                    mensaje.showRejectWindow();
                }
            }
        });

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

    //en start se inicializa todos los metodos y de ultimas presenta el template
   public void start(){
       //se pintan todos los textfield con bordes redondeados
        super.setHeight(700);
        super.setMenu(contenido);
       setBastardises(barra);
        super.showAspiranteWindow();

    }



    // Crear una instancia de la clase personalizada de JPanel con una imagen de fondo
    String imagePath = getClass().getResource("../../../resouces/img/barraprogreso.png").getPath();
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
