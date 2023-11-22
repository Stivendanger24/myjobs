package views.templates;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.*;
import java.awt.*;

public class CustomTable extends JScrollPane {

    protected JTable table;
    protected DefaultTableModel model;

    public CustomTable(String[] columnTitles, int[] columnWidths) {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Deshabilitar la edición de celdas
            }
        };

        table = new JTable(model);
        TableColumnModel columnModel = table.getColumnModel();

        for (int i = 0; i < columnTitles.length; i++) {
            String title = columnTitles[i];
            model.addColumn(title);
        }

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Obtener la última columna del TableColumnModel
        TableColumn lastColumn = columnModel.getColumn(columnModel.getColumnCount() - 1);

        // Establecer un TableCellRenderer personalizado en la última columna
        lastColumn.setCellRenderer(new IconRenderer());

        // Establecer colores transparentes para la tabla
        table.setBackground(Color.WHITE);
        table.setOpaque(true);

        // Establecer colores transparentes para las líneas de la tabla
        table.setShowGrid(true);
        table.setGridColor(Color.WHITE);
        table.setBorder(null);

        // Establecer borde nulo para cada columna
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setHeaderRenderer(new NullBorderRenderer());
        }

        // Deshabilitar la selección de celdas
        table.setCellSelectionEnabled(false);

        // Ajustar el ancho de las filas
        table.setRowHeight(table.getRowHeight() + 10); // Incremento de 10 píxeles

        // Personalizar la apariencia del JScrollPane
        this.setViewportView(table);
        this.setBorder(null);
        this.setViewportBorder(null);
        this.getViewport().setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createEmptyBorder());

        // Personalizar la apariencia del JScrollPane
        this.setViewportView(table);
    }

    static class IconRenderer extends DefaultTableCellRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            // Cargar el icono personalizado
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("../../resouces/img/iconoEliminar.png"));

            // Obtener la imagen del icono y ajustar su tamaño
            Image originalImage = originalIcon.getImage();
            int desiredIconWidth = 25; // Ancho deseado del icono
            int desiredIconHeight = 25; // Alto deseado del icono
            Image scaledImage = originalImage.getScaledInstance(desiredIconWidth, desiredIconHeight, Image.SCALE_SMOOTH);

            // Crear un nuevo ImageIcon con la imagen escalada
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Crear un JLabel con el icono escalado
            JLabel label = new JLabel(scaledIcon);

            // Establecer la alineación al centro
            label.setHorizontalAlignment(SwingConstants.CENTER);

            // Configurar el fondo de la celda como blanco
            label.setOpaque(true);
            label.setBackground(Color.WHITE);

            // Configurar la apariencia de la celda seleccionada
            if (isSelected) {
                label.setBackground(table.getSelectionBackground());
                label.setForeground(table.getSelectionForeground());
            } else {
                label.setBackground(table.getBackground());
                label.setForeground(table.getForeground());
            }

            return label;
        }

    }
    static class NullBorderRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBorder(null); // Establecer borde nulo
            return this;
        }
    }


    public void addRow(Object[] rowData) {
        model.addRow(rowData);
    }


}
