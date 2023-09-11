import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

class RoundedPanel extends JPanel {
    private int cornerRadius = 50;

    public RoundedPanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded border
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius, cornerRadius));

        g2d.dispose();
    }
}
