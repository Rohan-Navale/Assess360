import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundedComboBoxRenderer extends DefaultListCellRenderer {
    private int radius;

    public RoundedComboBoxRenderer(int radius) {
        this.radius = radius;
        setOpaque(false);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setBorder(new EmptyBorder(5, 10, 5, 10));
        label.setFont(new Font("Raleway", Font.BOLD, 18));
        label.setOpaque(true);
        return label;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, width - 1, height - 1, radius, radius);
        super.paintComponent(g2d);
        g2d.dispose();
    }
}
