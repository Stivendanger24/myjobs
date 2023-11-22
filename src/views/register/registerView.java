package views.register;

import controllers.auth.SingUpController;
import views.LoginView;
import views.templates.Input;
import views.templates.TextPrompt;
import views.templates.reject.RejectView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;


public class registerView {
    JFrame frame = new JFrame("Login");
    private JPanel loginpanel;
    private JPanel panelinputs;
    private JTextField usuario;
    private JPasswordField password;
    private JPanel pabelBotton;
    private JLabel ingresar;
    private JPanel paneltext1;
    private JPanel paneltext2;
    private JLabel cerrar;
    private JTextField nombre;
    private JComboBox roll;
    private JLabel iniciarSesion;
    Input input = new Input();


    public void showLoginWindow() {

        SingUpController singUpController = new SingUpController();
        Input input = new Input();
        LoginView iniciarSesionLink = new LoginView();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel interior
        loginpanel.setOpaque(false);
        panelinputs.setOpaque(false);
        pabelBotton.setOpaque(false);
        paneltext1.setOpaque(false);
        paneltext2.setOpaque(false);
        input.validateEmails(usuario);
        input.list(roll);
        CrearListRoll();

        //insercion en lista de roles en roll


        // Crear un borde vacío para establecer el color del borde en transparente
        Border emptyBorder = BorderFactory.createEmptyBorder();

        // Establecer el borde y el margen interno del JTextField
        nombre.setBorder(BorderFactory.createCompoundBorder(
                emptyBorder,
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // ajusta los valores del margen según sea necesario
        ));


        usuario.setBorder(BorderFactory.createCompoundBorder(
                emptyBorder,
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // ajusta los valores del margen según sea necesario
        ));

        password.setBorder(BorderFactory.createCompoundBorder(
                emptyBorder,
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // ajusta los valores del margen según sea necesario
        ));


        // Establecer la clase personalizada de renderizado del fondo para los JTextFields



        ingresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ingresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ingresar.setCursor(Cursor.getDefaultCursor());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean registrar = singUpController.register(nombre.getText(),usuario.getText(),password.getText(), (String) roll.getSelectedItem());
                if (registrar == true){
                    frame.setVisible(false);
                }else {
                    RejectView mensaje = new RejectView("error al ingresar");
                    mensaje.showRejectWindow();
                }
            }

        });

        cerrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cerrar.setForeground(new Color(255,125,10));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cerrar.setCursor(Cursor.getDefaultCursor());
                cerrar.setForeground(new Color(167,185,212));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0); // Cerrar la aplicación
            }

        });

        iniciarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                iniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                iniciarSesion.setForeground(new Color(255,125,10));            }

            @Override
            public void mouseExited(MouseEvent e) {
                iniciarSesion.setCursor(Cursor.getDefaultCursor());
                iniciarSesion.setForeground(new Color(167,185,212));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                iniciarSesionLink.showLoginWindow();
                frame.setVisible(false);
            }
        });

        //estos son los inputs
        TextPrompt name = new TextPrompt("Ingrese su nombre",nombre );
        TextPrompt user = new TextPrompt("E - mail", usuario);
        TextPrompt contraseña = new TextPrompt("Password",password );


        // Deshabilitar la decoración de la ventana
        frame.setUndecorated(true);

        // Crear una instancia de la clase personalizada de JPanel con una imagen de fondo
        String imagePath = getClass().getResource("../../resouces/img/fondoLogin.jpg").getPath();
        registerView.BackgroundPanel principalpanel = new registerView.BackgroundPanel(imagePath);

        // Agregar el panel personalizado al JFrame
        frame.add(principalpanel);

        // Ajustar el tamaño de la ventana
        frame.setSize(980, 604);
        frame.setLocationRelativeTo(null);
        RoundRectangle2D roundRectangle = new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 30, 30);
        frame.setShape(roundRectangle);

        //agregamos el panel con los elementos a principalpanel

        principalpanel.add(loginpanel);

        // Mostrar la ventana
        frame.setVisible(true);
    }

    public void CrearListRoll() {
        roll.addItem("aspirante");
        roll.addItem("empresa");
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
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
            }
        }
    }

    class RoundedTextFieldUI extends BasicTextFieldUI {

        private boolean isRound = false;

        public void setRound(boolean round) {
            isRound = round;
        }

        @Override
        protected void paintBackground(Graphics g) {
            if (isRound) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(getComponent().getBackground());
                g2d.fillRoundRect(0, 0, getComponent().getWidth() - 1, getComponent().getHeight() - 1, 20, 20);
            } else {
                super.paintBackground(g);
            }
        }

        @Override
        protected void paintSafely(Graphics g) {
            isRound = true;
            super.paintSafely(g);
            isRound = false;
        }
    }
}
