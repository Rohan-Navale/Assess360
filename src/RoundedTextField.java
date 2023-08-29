import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RoundedTextField extends JTextField {
    private int radius;
    private String placeholder;

    public RoundedTextField(int columns, int radius, String placeholder) {
        super(columns);
        this.radius = radius;
        this.placeholder = placeholder;

        setBackground(Color.WHITE);
        setCaretColor(Color.BLACK);
        setFont(new Font("Raleway", Font.BOLD, 18));
        setOpaque(false);
        setBorder(new RoundedBorder(radius));

        setText(placeholder);
        setForeground(Color.GRAY);

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(placeholder);
                    setForeground(Color.GRAY);
                }
            }
        });
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
            g2d.setStroke(new BasicStroke(1));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int arc = radius * 2;
            g2d.drawRoundRect(x, y, width - 1, height - 1, arc, arc);
        }
    }
}
