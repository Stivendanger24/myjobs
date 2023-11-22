package views.templates.PrincipalPanelView;

import models.SesionStatus;
import views.aspirantes.MenuMiperfil.MenuMiPerfil;
import views.templates.Input;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class PrincipalPanelView {

    JFrame frame = new JFrame("Login");
    private JPanel panelprincipal;
    private JLabel nombreUsuario;
    private JPanel menu;
    private JLabel dashboard;
    private JLabel ofertas;
    private JLabel miPerfil;
    private JLabel logosalir;
    private JLabel salir;
    Color backgroundColor = new Color(3,17,28); // Color personalizado
    Color foreground = new Color(37,117,120); // Color personalizado
    Color defaultForeground = new Color(167,185,212);

    Input input = new Input();
    public PrincipalPanelView () {
        dashboard = input.Label(dashboard,foreground,defaultForeground);
        ofertas = input.Label(ofertas,foreground,defaultForeground);
        miPerfil = input.Label(miPerfil,foreground,defaultForeground);
    }

    public void showAspiranteWindow() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nombreUsuario.setText(SesionStatus.getInstance().getUsername());

        // Crear un borde redondeado
        int cornerRadius = 50;
        Border roundedBorder = new RoundedBorder(backgroundColor, 20, cornerRadius);

        // Crear un borde de margen personalizado
        Border margin = new EmptyBorder(20, 20, 20, -500); // Margen negativo en el lado derecho

        // Combinar el borde redondeado con el borde de margen
        Border compoundBorder = BorderFactory.createCompoundBorder(roundedBorder, margin);

        // Cambiar el color de fondo del panel principal
        panelprincipal.setBackground(backgroundColor);

        // Aplicar el borde compuesto al panel
        menu.setBorder(compoundBorder);

        // Deshabilitar la decoración de la ventana
        frame.setUndecorated(true);

        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        // Calcular el tamaño de la ventana en base a la resolución de la pantalla
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int windowWidth = (int) (screenWidth * 0.8);
        int windowHeight = (int) (screenHeight * 0.8);

        // Ajustar el tamaño de la ventana
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null);


        // Ajustar el tamaño de la ventana
        frame.setSize(980, 604);
        frame.setLocationRelativeTo(null);


        // Establecer la forma redondeada de la ventana
        RoundRectangle2D roundRectangle = new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), cornerRadius, cornerRadius);
        frame.setShape(roundRectangle);

        // Agregar los demás objetos
        frame.add(panelprincipal);

        // Mostrar la ventana
        frame.setVisible(true);

        logosalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                logosalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                logosalir.setForeground(new Color(37,117,120));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logosalir.setCursor(Cursor.getDefaultCursor());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0); // Cerrar la aplicación
            }
        });

        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0); // Cerrar la aplicación
            }
        });

        miPerfil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                MenuMiPerfil menu = new MenuMiPerfil();
                menu.start();
            }
        });

        dashboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                PrincipalPanelView menuPrincipal = new PrincipalPanelView();
                menuPrincipal.showAspiranteWindow();
            }
        });
    }

    private static class RoundedBorder extends AbstractBorder {
        private Color borderColor;
        private int borderWidth;
        private int cornerRadius;

        public RoundedBorder(Color borderColor, int borderWidth, int cornerRadius) {
            this.borderColor = borderColor;
            this.borderWidth = borderWidth;
            this.cornerRadius = cornerRadius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(borderWidth));
            Shape borderShape = new RoundRectangle2D.Double(x, y, width - -20, height - 1, cornerRadius, cornerRadius);
            g2.setColor(borderColor);
            g2.draw(borderShape);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(borderWidth, borderWidth, borderWidth, 0);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(borderWidth, borderWidth, borderWidth, 0);
            return insets;
        }
    }


}