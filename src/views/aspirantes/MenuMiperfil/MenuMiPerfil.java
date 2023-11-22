package views.aspirantes.MenuMiperfil;

import views.templates.PanelView.PanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuMiPerfil extends PanelView {
    private JPanel contenido;
    private JLabel seccionbasica;
    private JLabel seccionacercadeti;
    private JLabel seccionadjuntos;
    private JLabel seccionexperiencialaboral;

    public void start(){
        //se pintan todos los textfield con bordes redondeados
        super.setHeight(600);
        super.setMenu(contenido);
        super.showAspiranteWindow();

        // Establecer el cursor de los JLabel a mano (Cursor.HAND_CURSOR) cuando el mouse pase sobre ellos
        seccionbasica.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                seccionbasica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                seccionbasica.setCursor(Cursor.getDefaultCursor());
            }
        });

        seccionacercadeti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                seccionacercadeti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                seccionacercadeti.setCursor(Cursor.getDefaultCursor());
            }
        });

        seccionadjuntos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                seccionadjuntos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                seccionadjuntos.setCursor(Cursor.getDefaultCursor());
            }
        });

        seccionexperiencialaboral.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                seccionexperiencialaboral.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                seccionexperiencialaboral.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    }


