package views.templates;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class CustomScrollBarUI extends BasicScrollBarUI {

    private final Dimension zeroDimension = new Dimension(100, 50);

    private ImageIcon createImageIcon(String path) {
        URL imageUrl = getClass().getResource(path);
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } else {
            System.err.println("Could not find image: " + path);
            return null;
        }
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        JButton button = new JButton();
        button.setBorder(null);
        button.setBackground(Color.WHITE);
        button.setPreferredSize(zeroDimension);
        button.setMinimumSize(zeroDimension);
        button.setMaximumSize(zeroDimension);
        button.setIcon(createImageIcon("../../resouces/img/arrowUp.png"));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JScrollBar scrollBar = CustomScrollBarUI.this.scrollbar;
                scrollBar.setValue(scrollBar.getValue() - scrollBar.getUnitIncrement() * 10);
            }
        });
        return button;
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        JButton button = new JButton();
        button.setPreferredSize(zeroDimension);
        button.setMinimumSize(zeroDimension);
        button.setMaximumSize(zeroDimension);
        button.setIcon(createImageIcon("../../resouces/img/arrow.png"));
        button.setBorder(null);
        button.setBackground(Color.WHITE);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JScrollBar scrollBar = CustomScrollBarUI.this.scrollbar;
                scrollBar.setValue(scrollBar.getValue() + scrollBar.getUnitIncrement() * 10);
            }
        });
        return button;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(Color.WHITE);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        return zeroDimension;
    }

    @Override
    protected Dimension getMaximumThumbSize() {
        return zeroDimension;
    }

}
