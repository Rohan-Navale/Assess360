import javax.swing.*;
import java.awt.*;

public class alert  extends JFrame{

    alert(){
        setSize(1500, 800); // Set the Frame Size
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLocation(0, 0);
        setLayout(null);

        ImageIcon LogoIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png")); // Load the image
        Image LogoImage = LogoIcon.getImage();
        Image LogoscaledImage = LogoImage.getScaledInstance(180, 74, Image.SCALE_SMOOTH);
        ImageIcon LogoscaledIcon = new ImageIcon(LogoscaledImage);
        JLabel Logolabel = new JLabel(LogoscaledIcon);
        Logolabel.setBounds(20, 25, 180, 74); // Set the position and size of the JLabel
        add(Logolabel);

        RoundedPanel panel = new RoundedPanel();
        panel.setBounds(241, 105, 1018, 568);
        panel.setBackground(new Color(202, 237, 255));
        add(panel);

    }
    public static void main(String[] args) {
        new alert();
    }
}
