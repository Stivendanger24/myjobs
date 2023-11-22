package views.templates;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class TextPrompt extends JLabel implements FocusListener, DocumentListener {
    private static final long serialVersionUID = 1L;

    public enum Show {
        ALWAYS, FOCUS_GAINED, FOCUS_LOST;
    }

    private JTextComponent component;
    private Document document;

    private Show show;
    private boolean showPromptOnce;
    private int focusLost;

    public TextPrompt(String text, JTextField component) {
        this(text, component, Show.ALWAYS);
    }

    public TextPrompt(String text, JTextComponent component, Show show) {
        this.component = component;
        setShow(show);
        document = component.getDocument();

        setText(text);
        setFont(component.getFont());
        setForeground(Color.LIGHT_GRAY);
        setHorizontalAlignment(JLabel.LEADING);

        component.addFocusListener(this);
        document.addDocumentListener(this);

        component.setLayout(new BorderLayout());
        component.add(this);

        // Agregar MouseListener al componente padre del componente de texto
        component.getParent().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                component.requestFocusInWindow();
                component.setEditable(true); // Habilitar la edición del componente de texto
            }
        });

        checkForPrompt();
    }

    public TextPrompt(String text, JTextArea component) {
        this(text, component, Show.ALWAYS);
    }

    public void changeAlpha(float alpha) {
        int red = 0x8B;
        int green = 0x8F;
        int blue = 0xA8;

        changeAlpha(red, green, blue, alpha);
    }

    public void changeAlpha(int red, int green, int blue, float alpha) {
        alpha = alpha > 1.0f ? 1.0f : alpha < 0.0f ? 0.0f : alpha;

        int alphaInt = (int) (alpha * 255);
        Color colorWithAlpha = new Color(red, green, blue, alphaInt);
        super.setForeground(colorWithAlpha);
    }

    public void changeStyle(int style) {
        setFont(getFont().deriveFont(style));
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public boolean getShowPromptOnce() {
        return showPromptOnce;
    }

    public void setShowPromptOnce(boolean showPromptOnce) {
        this.showPromptOnce = showPromptOnce;
    }

    private void checkForPrompt() {
        if (document.getLength() > 0) {
            setVisible(false);
            return;
        }

        if (showPromptOnce && focusLost > 0) {
            setVisible(false);
            return;
        }

        if (component.hasFocus()) {
            if (show == Show.ALWAYS || show == Show.FOCUS_GAINED)
                setVisible(true);
            else
                setVisible(false);
        } else {
            if (show == Show.ALWAYS || show == Show.FOCUS_LOST)
                setVisible(true);
            else
                setVisible(false);
        }
    }


    public void focusGained(FocusEvent e) {
        checkForPrompt();
    }

    public void focusLost(FocusEvent e) {
        focusLost++;
        SwingUtilities.invokeLater(this::checkForPrompt);
    }

    public void insertUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    public void removeUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    public void changedUpdate(DocumentEvent e) {
    }
}
