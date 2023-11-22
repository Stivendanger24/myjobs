package views.templates;

import models.SesionStatus;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Input {

    private Color backgroundColor = new Color(195,195,195); // Color personalizado

    public JTextField Text(JTextField input) {
        input.setOpaque(false);
        input.setBorder(new RoundBorder(backgroundColor, 1, 15));
        input.setForeground(new Color(68, 70, 70)); // Establecer el color de letra RGBA

        // Establecer el espacio entre el borde y el texto
        int borderThickness = 6; // Grosor del borde
        int padding = 5; // Espacio deseado
        Border paddingBorder = new EmptyBorder(padding, padding + borderThickness, padding, padding + borderThickness);
        Border compoundBorder = new CompoundBorder(input.getBorder(), paddingBorder);
        input.setBorder(compoundBorder);
        return input;
    }

    public JTextArea TextArea(JTextArea textArea) {
        textArea.setOpaque(false);
        textArea.setBorder(new RoundBorder(backgroundColor, 1, 15));
        textArea.setForeground(new Color(68, 70, 70)); // Establecer el color de letra RGBA

        // Establecer el espacio entre el borde y el texto
        int borderThickness = 6; // Grosor del borde
        int padding = 5; // Espacio deseado
        Border paddingBorder = new EmptyBorder(padding, padding + borderThickness, padding, padding + borderThickness);
        Border compoundBorder = new CompoundBorder(textArea.getBorder(), paddingBorder);
        textArea.setBorder(compoundBorder);

        // Permitir el salto de línea automático
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }

    public JButton Button(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(button.getFont().deriveFont(Font.BOLD)); // Establecer el tipo de letra a negrita

        // Obtener el tamaño actual del botón
        int width = button.getWidth();
        int height = button.getHeight();

        // Obtener la imagen de fondo
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("../../resouces/img/botonNaranja.png"));

        // Crear un nuevo icono con la imagen redimensionada
        ImageIcon resizedBackgroundIcon = new ImageIcon(backgroundIcon.getImage());

        // Establecer el icono redimensionado como fondo del botón
        button.setIcon(resizedBackgroundIcon);

        // Ajustar el texto al centro vertical y horizontalmente
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        // Obtener el margen actual del botón
        Insets margin = button.getMargin();

        // Ajustar el margen vertical sin afectar los márgenes laterales
        int verticalMargin = (height - button.getPreferredSize().height) / 2;
        button.setMargin(new Insets(verticalMargin, margin.left, verticalMargin, margin.right));


        // Ajustar el tamaño preferido del botón
        button.setPreferredSize(new Dimension(170, 50));

        // Cambiar el color de letra al pasar el mouse por encima del botón
        Color defaultColor = button.getForeground();
        Color hoverColor = Color.white; // Cambia aquí al color deseado

        ImageIcon defaultIcon = (ImageIcon) button.getIcon();
        ImageIcon hoverIcon = new ImageIcon(getClass().getResource("../../resouces/img/botonNaranjaHover.png")); // Cambia aquí a la ruta del nuevo ícono


        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(hoverColor);
                button.setIcon(hoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(defaultColor);
                button.setIcon(defaultIcon);
            }
        });

        return button;
    }

    public JButton ButtonEditable(JButton button, String imgUrl, String imgUrlHover) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(button.getFont().deriveFont(Font.BOLD)); // Establecer el tipo de letra a negrita

        // Obtener el tamaño actual del botón
        int width = button.getWidth();
        int height = button.getHeight();

        // Obtener la imagen de fondo
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource(imgUrl));

        // Crear un nuevo icono con la imagen redimensionada
        ImageIcon resizedBackgroundIcon = new ImageIcon(backgroundIcon.getImage());

        // Establecer el icono redimensionado como fondo del botón
        button.setIcon(resizedBackgroundIcon);

        // Ajustar el texto al centro vertical y horizontalmente
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        // Obtener el margen actual del botón
        Insets margin = button.getMargin();

        // Ajustar el margen vertical sin afectar los márgenes laterales
        int verticalMargin = (height - button.getPreferredSize().height) / 2;
        button.setMargin(new Insets(verticalMargin, margin.left, verticalMargin, margin.right));


        // Ajustar el tamaño preferido del botón
        button.setPreferredSize(new Dimension(170, 50));

        // Cambiar el color de letra al pasar el mouse por encima del botón
        Color defaultColor = button.getForeground();
        Color hoverColor = Color.white; // Cambia aquí al color deseado

        ImageIcon defaultIcon = (ImageIcon) button.getIcon();
        ImageIcon hoverIcon = new ImageIcon(getClass().getResource(imgUrlHover)); // Cambia aquí a la ruta del nuevo ícono


        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(hoverColor);
                button.setIcon(hoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(defaultColor);
                button.setIcon(defaultIcon);
            }
        });

        return button;
    }
    public JButton ButtonEditableSmall(JButton button, String imgUrl, String imgUrlHover) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(button.getFont().deriveFont(Font.BOLD)); // Establecer el tipo de letra a negrita

        // Obtener el tamaño actual del botón
        int width = button.getWidth();
        int height = button.getHeight();

        // Obtener la imagen de fondo
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource(imgUrl));

        // Crear un nuevo icono con la imagen redimensionada
        ImageIcon resizedBackgroundIcon = new ImageIcon(backgroundIcon.getImage());

        // Establecer el icono redimensionado como fondo del botón
        button.setIcon(resizedBackgroundIcon);

        // Ajustar el texto al centro vertical y horizontalmente
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        // Obtener el margen actual del botón
        Insets margin = button.getMargin();

        // Ajustar el margen vertical sin afectar los márgenes laterales
        int verticalMargin = (height - button.getPreferredSize().height) / 2;
        button.setMargin(new Insets(verticalMargin, margin.left, verticalMargin, margin.right));


        // Ajustar el tamaño preferido del botón
        button.setPreferredSize(new Dimension(140, 30));

        // Cambiar el color de letra al pasar el mouse por encima del botón
        Color defaultColor = button.getForeground();
        Color hoverColor = Color.white; // Cambia aquí al color deseado

        ImageIcon defaultIcon = (ImageIcon) button.getIcon();
        ImageIcon hoverIcon = new ImageIcon(getClass().getResource(imgUrlHover)); // Cambia aquí a la ruta del nuevo ícono


        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(hoverColor);
                button.setIcon(hoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(defaultColor);
                button.setIcon(defaultIcon);
            }
        });

        return button;
    }

    public JComboBox<String> list(JComboBox<String> list) {
        list.setOpaque(false);
        list.setBorder(new RoundBorder(backgroundColor, 1, 15));
        list.setForeground(new Color(68, 70, 70)); // Establecer el color de letra RGBA
        list.setBackground(Color.WHITE);

        // Establecer el espacio entre el borde y el texto
        int borderThickness = 6; // Grosor del borde
        int padding = 5; // Espacio deseado
        Border paddingBorder = new EmptyBorder(padding, padding + borderThickness, padding, padding + borderThickness);
        Border compoundBorder = new CompoundBorder(new RoundBorder(backgroundColor, 1, 15), paddingBorder);
        list.setBorder(compoundBorder);

        // Establecer estilo para el seleccionador
        list.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setIcon(new ImageIcon(getClass().getResource("../../resouces/img/arrow.png")));
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }

            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup popup = (BasicComboPopup) super.createPopup();
                popup.setBorder(compoundBorder);
                popup.getList().setOpaque(false);
                popup.getList().setForeground(new Color(68, 70, 70)); // Establecer el color de letra RGBA
                popup.getList().setBackground(Color.WHITE);

                JScrollPane scroller = (JScrollPane) popup.getComponent(0);
                scroller.getVerticalScrollBar().setUI(new ModernScrollBarUI());

                return popup;
            }
        });

        return list;
    }

    public <color> JLabel Label(JLabel label, color foreground, color defaultForeground) {

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                label.setForeground((Color) foreground);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setCursor(Cursor.getDefaultCursor());
                label.setForeground((Color) defaultForeground);
            }
        });

        return label;
    };
    private static class RoundBorder extends AbstractBorder {
        private Color color;
        private int thickness;
        private int cornerRadius;

        public RoundBorder(Color color, int thickness, int cornerRadius) {
            this.color = color;
            this.thickness = thickness;
            this.cornerRadius = cornerRadius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(color);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(thickness));
            g2d.drawRoundRect(x, y, width - 1, height - 1, cornerRadius, cornerRadius);
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness, thickness, thickness, thickness);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = thickness;
            return insets;
        }
    }

    public void inputOnlyNumbers(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignorar el carácter no numérico
                }
            }
        });
    }

    public void validateEmails(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String email = textField.getText();
                String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
                boolean isValidEmail = email.matches(emailRegex);
                if (isValidEmail) {
                    textField.setForeground(Color.BLACK); // Establecer color de texto original
                } else {
                    textField.setForeground(Color.RED); // Establecer color de texto rojo
                }
            }
        });
    }
}