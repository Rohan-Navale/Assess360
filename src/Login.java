import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
JTextField usn, password;
JButton Login, Register;
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

        ImageIcon LogoIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png")); // Load the image
        Image LogoImage = LogoIcon.getImage();
        Image LogoscaledImage = LogoImage.getScaledInstance(180, 74, Image.SCALE_SMOOTH);
        ImageIcon LogoscaledIcon = new ImageIcon(LogoscaledImage);
        JLabel Logolabel = new JLabel(LogoscaledIcon);
        Logolabel.setBounds(20, 25, 180, 74); // Set the position and size of the JLabel
        add(Logolabel);

        JLabel loginText = new JLabel("Login to Your Account");
        loginText.setBounds(176,260,350,37);
        loginText.setFont(new Font("Outfit",Font.BOLD,26));
        loginText.setForeground(new Color(27,23,28));
        add(loginText);

        ImageIcon UserIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/useer.png")); // Load the image
        Image UserImage = UserIcon.getImage();
        Image UserscaledImage = UserImage.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        ImageIcon UserscaledIcon = new ImageIcon(UserscaledImage);
        JLabel Userlabel = new JLabel(UserscaledIcon);
        Userlabel.setBounds(135, 318, 23, 23); // Set the position and size of the JLabel
        add(Userlabel);

        RoundedTextField usnField = new RoundedTextField(20, 15, "  USN");
        usnField.setBounds(175, 307, 391, 50);
        usnField.setBackground(Color.WHITE);
        add(usnField);

        ImageIcon LockIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/Lock.png")); // Load the image
        Image LockImage = LockIcon.getImage();
        Image LockscaledImage = LockImage.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon LockscaledIcon = new ImageIcon(LockscaledImage);
        JLabel Locklabel = new JLabel(LockscaledIcon);
        Locklabel.setBounds(135, 382, 24, 24); // Set the position and size of the JLabel
        add(Locklabel);

        RoundedTextField PasswordField = new RoundedTextField(20, 15, "  Password");
        PasswordField.setBounds(175, 371, 391, 50);
        add(PasswordField);

        Login = new RoundedButton("Log In",new Color(202,237,255),Color.BLACK);
        Login.setBounds(404, 445, 163, 44);
        Login.setFont(new Font("Raleway", Font.BOLD,20));
        add(Login);

        JLabel forgot = new JLabel("<html><u>Forgot Password?</u></html>");
        forgot.setBounds(176,450,130,25);
        forgot.setFont(new Font("Raleway",Font.BOLD,14));
        add(forgot);

        JLabel newUser = new JLabel("New User?");
        newUser.setBounds(276,550,130,25);
        newUser.setFont(new Font("Raleway",Font.BOLD,14));
        add(newUser);

        Register = new JButton("<html><u>Sign Up</u><html>");
        Register.setContentAreaFilled(false);
        Register.setBorderPainted(false);
        Register.setBounds(313, 538, 162, 44);
        Register.setFont(new Font("Raleway", Font.BOLD,18));
        add(Register);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,750,800);
        panel.setBackground(new Color(216, 180, 248));
        add(panel);

    }
    public static void main(String[] args) {
        new Login();
    }
}
