import javax.swing.*;
import java.awt.*;

public class resetone extends JFrame {
    resetone(){
        setSize(1500,800); // Set the Frame Size
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLocation(0,0);
        setLayout(null);

        ImageIcon LogoIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png")); // Load the image
        Image LogoImage = LogoIcon.getImage();
        Image LogoscaledImage = LogoImage.getScaledInstance(180, 74, Image.SCALE_SMOOTH);
        ImageIcon LogoscaledIcon = new ImageIcon(LogoscaledImage);
        JLabel Logolabel = new JLabel(LogoscaledIcon);
        Logolabel.setBounds(20, 25, 180, 74); // Set the position and size of the JLabel
        add(Logolabel);

        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/reset.png")); // Load the image
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(609, 624, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(62, 150, 609, 624); // Set the position and size of the JLabel
        add(label);
    }

    public static void main(String[] args){
        new resetone();
    }
}
