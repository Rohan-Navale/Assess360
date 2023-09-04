import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    private Color bgColor;
    private Color textColor;

    public RoundedButton(String text, Color bgColor, Color textColor) {
        super(text);
        this.bgColor = bgColor;
        this.textColor = textColor;
        setupButton();
    }

    private void setupButton() {
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setForeground(textColor);
        setFont(new Font("Raleway", Font.BOLD, 12));
        setBorderPainted(false);
        setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
        setVerticalAlignment(SwingConstants.CENTER);
        setMargin(new Insets(10, 20, 10, 20));

        // Add mouse listener to change colors on hover and click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.WHITE); // Change text color on hover
                setBackground(bgColor.darker()); // Darken button color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(textColor); // Reset text color on exit
                setBackground(bgColor); // Reset button color on exit
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D.Float roundRect = new RoundRectangle2D.Float(
                0, 0, getWidth() - 1, getHeight() - 1, 35, 44);

        g2.setColor(getBackground());
        g2.fill(roundRect);

        super.paintComponent(g2);
        g2.dispose();
    }
}
