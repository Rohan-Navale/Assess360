import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login extends JFrame implements ActionListener {
    RoundedTextField usnField, PasswordField;
    JButton Login, Register, forgot;
    Login(){
        setSize(1500,800); // Set the Frame Size
        getContentPane().setBackground(new Color(255,255,255));
        setVisible(true);
        setLocation(0,0);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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

        usnField = new RoundedTextField(20, 15, 10,"USN");
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

        PasswordField = new RoundedTextField(20, 15, 10,"Password");
        PasswordField.setBounds(175, 371, 391, 50);
        add(PasswordField);

        Login = new RoundedButton("Log In",new Color(202,237,255),Color.BLACK);
        Login.setBounds(404, 445, 163, 44);
        Login.addActionListener(this);
        Login.setFont(new Font("Raleway", Font.BOLD,20));
        add(Login);

        forgot = new JButton("<html><u>Forgot Password?</u></html>");
        forgot.setContentAreaFilled(false);
        forgot.setBorderPainted(false);
        forgot.setBounds(176, 450, 130, 25);
        forgot.setFont(new Font("Raleway", Font.BOLD,14));
        forgot.addActionListener(this);
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
        Register.addActionListener(this);
        add(Register);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,750,800);
        panel.setBackground(new Color(216, 180, 248));
        add(panel);
    }
    public static void main(String[] args) {
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==forgot){
            setVisible(false);
            new Resetone();
        }
        if(ae.getSource()==Register){
            setVisible(false);
            new Register();
        }

        if (ae.getSource() == Login) {
            String susn = usnField.getText();
            String spass = PasswordField.getText();

            if (susn.equals("USN") || spass.equals("Password")) { // Use isBlank() here
                JOptionPane.showMessageDialog(null, "Please enter the required details");
            } else {
                DbConnectivity conn = new DbConnectivity();
                if (conn.usnpasswordmatch(susn, spass)) {
                    setVisible(false);
                    new Alert();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Credentials Entered");
                }
            }
        }
    }
}