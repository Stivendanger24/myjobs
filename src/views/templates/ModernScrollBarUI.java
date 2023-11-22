package views.templates;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ModernScrollBarUI extends BasicScrollBarUI {
    private Color trackColor = new Color(230, 230, 230);
    private Color thumbColor = new Color(180, 180, 180);
    private Color thumbHoverColor = new Color(150, 150, 150);
    private Color thumbPressedColor = new Color(120, 120, 120);
    private Color thumbBorderColor = new Color(150, 150, 150);

    @Override
    protected void configureScrollBarColors() {
        this.trackColor = new Color(255, 255, 255);
        this.thumbColor = new Color(180, 180, 180);
        this.thumbHoverColor = new Color(150, 150, 150);
        this.thumbPressedColor = new Color(120, 120, 120);
        this.thumbBorderColor = new Color(150, 150, 150);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createEmptyButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createEmptyButton();
    }

    private JButton createEmptyButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        return button;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(trackColor);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        JScrollBar scrollbar = (JScrollBar) c;
        if (isDragging) {
            g2d.setColor(thumbPressedColor);
        } else if (isThumbRollover()) {
            g2d.setColor(thumbHoverColor);
        } else {
            g2d.setColor(thumbColor);
        }

        int thumbWidth = thumbBounds.width -12;
        int thumbHeight = thumbBounds.height - 2; // Reduce la altura del deslizador
        int thumbX = thumbBounds.x;
        int thumbY = thumbBounds.y + 6; // Desplaza el deslizador hacia abajo
        int thumbMargin = 2; // Margen entre el deslizador y el borde del JScrollPane

        // Ajustar la posición y el tamaño del deslizador
        thumbX += thumbMargin;
        thumbWidth -= 2 * thumbMargin;



        g2d.setColor(thumbBorderColor);
        g2d.drawRoundRect(thumbX, thumbY, thumbWidth, thumbHeight, 10, 10);

        g2d.dispose();
    }
}
