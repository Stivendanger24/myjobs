package views.templates.aproved;

import views.aspirantes.MenuMiperfil.MenuMiPerfil;
import views.templates.Input;
import views.templates.PanelView.PanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Aproved extends PanelView {
    private JPanel contenido;
    private JButton continuar;

    Input input = new Input();

    public Aproved(){
        input.Button(continuar);

    }

    public void start(){
        //se pintan todos los textfield con bordes redondeados
        super.setHeight(604);
        super.setMenu(contenido);
        super.showAspiranteWindow();
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
                Aproved.super.setFrame(false);
                MenuMiPerfil menu = new MenuMiPerfil();
                menu.start();
            }

        });

    }

}
