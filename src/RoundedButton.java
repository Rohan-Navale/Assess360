import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    private int radius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;

        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setBorder(new RoundedBorder(radius));

        setForeground(Color.BLACK); // Set text color
        setBackground(new Color(220, 220, 220)); // Set background color
        setFont(new Font("Raleway", Font.BOLD, 16));
    }

    class RoundedBorder extends AbstractBorder {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(getForeground());
            g2d.setStroke(new BasicStroke(2)); // Set border width
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Create a rounded rectangle shape for the button
            Shape shape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius, radius);
            g2d.draw(shape);
        }
    }
}
