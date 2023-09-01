import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedComboBox extends JComboBox<String> {
    private int radius;

    public RoundedComboBox(String[] items, int radius) {
        super(items);
        this.radius = radius;
        setOpaque(false);
        setFocusable(false);
        setBorder(null);
        setRenderer(new RoundedComboBoxRenderer());
        setBackground(Color.WHITE);
        setFont(new Font("Raleway", Font.BOLD, 18));
    }

    class RoundedComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            label.setFont(new Font("Raleway", Font.BOLD, 18));
            return label;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2d.setColor(getBackground());
        g2d.fill(shape);

        super.paintComponent(g2d);
        g2d.dispose();
    }
}
