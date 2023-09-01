import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import com.toedter.calendar.JDateChooser;


public class Register extends JFrame {
    JButton submit;
    JDateChooser date;
    Register(){
        setSize(1500,800); // Set the Frame Size
        getContentPane().setBackground(new Color(216,180,248));
        setVisible(true);
        setLocation(0,0);
        setLayout(null);

        ImageIcon LogoIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png")); // Load the image
        Image LogoImage = LogoIcon.getImage();
        Image LogoscaledImage = LogoImage.getScaledInstance(160, 60, Image.SCALE_SMOOTH);
        ImageIcon LogoscaledIcon = new ImageIcon(LogoscaledImage);
        JLabel Logolabel = new JLabel(LogoscaledIcon);
        Logolabel.setBounds(550, 5, 160, 60); // Set the position and size of the JLabel
        add(Logolabel);

        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/RegisterUiICon.png")); // Load the image
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(524, 514, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(875, 143, 524, 514); // Set the position and size of the JLabel
        add(label);

        JLabel text  = new JLabel("Enter Your Details:");
        text.setFont(new Font("Outfit",Font.BOLD, 20));
        text.setBounds(50,20,300,40);
        text.setForeground(Color.BLACK);
        add(text);

        RoundedTextField usn = new RoundedTextField(20, 15, 10,"USN");
        usn.setBounds(70, 70, 450, 50);
        usn.setBackground(Color.WHITE);
        add(usn);

        RoundedTextField password = new RoundedTextField(20, 15, 10,"Set Password");
        password.setBounds(70, 140, 450, 50);
        password.setBackground(Color.WHITE);
        add(password);

        JLabel passtext = new JLabel("Remember your password for future use");
        passtext.setBounds(80,187,500,20);
        passtext.setFont(new Font("Raleway",Font.PLAIN,10));
        passtext.setForeground(Color.blue);
        add(passtext);

        RoundedTextField name = new RoundedTextField(20, 15, 10,"Name");
        name.setBounds(70, 215, 450, 50);
        name.setBackground(Color.WHITE);
        add(name);

        String[] departments = {"AE", "CE", "CSE", "ISE", "ECE", "EEE", "ME"};
        JComboBox<String> combo = new JComboBox<>(departments);
        combo.setFont(new Font("Raleway", Font.BOLD, 16));
        combo.setForeground(Color.GRAY);
        combo.setBackground(Color.WHITE);
        combo.setBounds(10, 10, 448, 50);

        JPanel comboPanel = new JPanel();
        comboPanel.setLayout(new BorderLayout());
        comboPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // 10 pixels padding on all sides
        comboPanel.add(combo, BorderLayout.CENTER);
        comboPanel.setToolTipText("Department"); // Set the tooltip for the JPanel

        RoundedTextField year = new RoundedTextField(20, 15, 10,"Year");
        year.setBounds(70, 355, 450, 50);
        year.setBackground(Color.WHITE);
        add(year);

        RoundedTextField sec = new RoundedTextField(20, 15, 10,"Section");
        sec.setBounds(70, 426, 450, 50);
        add(sec);

        date = new JDateChooser(); //Jcalender.jar file was not available. Downloaded and added. File-> Project Structure -> Library -> Add -> Apply
        date.setBounds(70,495,450,50);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("Roboto",Font.PLAIN,18));
        add(date);

        RoundedTextField contact = new RoundedTextField(20, 15, 10,"Contact No.");
        contact.setBounds(70, 566, 450, 50);
        contact.setBackground(Color.WHITE);
        add(contact);

        RoundedTextField mail = new RoundedTextField(20, 15, 10,"Email Address");
        mail.setBounds(70, 635, 450, 50);
        mail.setBackground(Color.WHITE);
        add(mail);

        submit = new RoundedButton("Submit",new Color(186,104,200),Color.WHITE);
        submit.setBounds(550, 705, 163, 44);
        submit.setFont(new Font("Raleway", Font.BOLD,20));
        add(submit);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,750,800);
        panel.setBackground(new Color(255, 255, 255));
        add(panel);

    }

    public static void main(String[] args){
        new Register();
    }
}