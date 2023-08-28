import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    Login(){
        setSize(1500,800); // Set the Frame Size
        getContentPane().setBackground(new Color(255,255,255));
        setVisible(true);
        setLocation(0,0);
        setLayout(null);

        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/LoginUiICon.png")); // Load the image
        Image originalImage = originalIcon.getImage(); // Get the original image
// Scale the original image to your preferred size
        int width = 733; // Preferred width
        int height = 518; // Preferred height
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
// Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
// Create a JLabel and set the scaled ImageIcon to it
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(759, 141, width, height); // Set the position and size of the JLabel
        add(label);




        JPanel panel = new JPanel();
        panel.setBounds(0,0,750,800);
        panel.setBackground(new Color(216, 180, 248));
        add(panel);



    }
    public static void main(String[] args) {
        new Login();
    }
}
