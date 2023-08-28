import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class RoundedTextField extends JTextField {
    private int radius;

    public RoundedTextField(String placeholder, int columns, int radius, int width) {
        super(placeholder, columns);
        this.radius = radius;
        setForeground(Color.GRAY);
        setFont(new Font("Raleway", Font.BOLD, 22));
        setOpaque(false);
        setBorder(new RoundedBorder(radius, width));

        addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (getText().trim().equals(placeholder.trim())) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (getText().trim().isEmpty()) {
                    setText(placeholder);
                    setForeground(Color.GRAY);
                }
            }
        });
    }

    class RoundedBorder extends AbstractBorder {
        private int radius;
        private int borderWidth;

        public RoundedBorder(int radius, int borderWidth) {
            this.radius = radius;
            this.borderWidth = borderWidth;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(getForeground());
            g2d.setStroke(new BasicStroke(borderWidth)); // Set the desired border width
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}
