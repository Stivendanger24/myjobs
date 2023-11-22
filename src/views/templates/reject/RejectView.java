package views.templates.reject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class RejectView {

    private JFrame frame;
    private JPanel contenido;
    private JButton continuar;
    private JLabel mimensaje;
    private JLabel espacio;

    public RejectView(String mensaje) {
        frame = new JFrame("Rechazar");
        contenido = new JPanel();
        continuar = new JButton("Continuar");
        mimensaje.setText(mensaje);

        // Configurar propiedades de estilo
        contenido.setBackground(new Color(13,34,51)); // Fondo blanco
        contenido.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Borde vacío con margen de 20 píxeles

        mimensaje.setFont(new Font("Arial", Font.PLAIN, 18)); // Fuente Arial, tamaño 18
        mimensaje.setHorizontalAlignment(SwingConstants.CENTER); // Alinear texto al centro

        continuar.setBackground(new Color(255, 125, 10)); // Fondo naranja
        continuar.setForeground(Color.WHITE); // Texto blanco
        continuar.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente Arial, negrita, tamaño 16
        continuar.setFocusPainted(false); // Eliminar efecto de enfoque
        continuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cambiar cursor al pasar sobre el botón

        // Agregar el botón al panel de contenido
        contenido.add(espacio);
        contenido.add(mimensaje);
        contenido.add(continuar);

        // Configurar el panel de contenido en el JFrame
        frame.setContentPane(contenido);

        // Deshabilitar la decoración de la ventana
        frame.setUndecorated(true);

        // Ajustar el tamaño de la ventana
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        RoundRectangle2D roundRectangle = new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 20, 20);
        frame.setShape(roundRectangle);

        // Manejar el evento de clic en el botón "Continuar"
        continuar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // Agrega aquí la lógica para el evento de clic en el botón "Continuar"
            }
        });
    }

    public void showRejectWindow() {
        frame.setVisible(true);
        continuar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                continuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                continuar.setCursor(Cursor.getDefaultCursor());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
            }

        });
    }

}
