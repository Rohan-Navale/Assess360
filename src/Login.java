import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
JTextField usn, password;
    Login(){
        setSize(1500,800); // Set the Frame Size
        getContentPane().setBackground(new Color(255,255,255));
        setVisible(true);
        setLocation(0,0);
        setLayout(null);

        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/LoginUiICon.png")); // Load the image
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(733, 518, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(759, 141, 733, 518); // Set the position and size of the JLabel
        add(label);

        ImageIcon LogoIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/Assess360Logo.png")); // Load the image
        Image LogoImage = LogoIcon.getImage();
        Image LogoscaledImage = LogoImage.getScaledInstance(180, 74, Image.SCALE_SMOOTH);
        ImageIcon LogoscaledIcon = new ImageIcon(LogoscaledImage);
        JLabel Logolabel = new JLabel(LogoscaledIcon);
        Logolabel.setBounds(20, 25, 180, 74); // Set the position and size of the JLabel
        add(Logolabel);

        JLabel loginText = new JLabel("Login to Your Account");
        loginText.setBounds(176,260,350,37);
        loginText.setFont(new Font("Outfit",Font.BOLD,30));
        loginText.setForeground(new Color(27,23,28));
        add(loginText);

        RoundedTextField usnField = new RoundedTextField("  USN", 20, 15,2);
        usnField.setBounds(175, 307, 391, 59);
        add(usnField);

        RoundedTextField PasswordField = new RoundedTextField("  Password", 20, 15,2);
        PasswordField.setBounds(175, 380, 391, 59);
        add(PasswordField);


        JPanel panel = new JPanel();
        panel.setBounds(0,0,750,800);
        panel.setBackground(new Color(216, 180, 248));
        add(panel);



    }
    public static void main(String[] args) {
        new Login();
    }
}
