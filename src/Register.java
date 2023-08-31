import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {
    JButton submit;
    Register(){
        setSize(1500,800); // Set the Frame Size
        getContentPane().setBackground(new Color(216,180,248));
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

        JLabel text  = new JLabel("Enter Your Details");
        text.setFont(new Font("Rale-way",Font.BOLD, 20));
        text.setBounds(767,20,300,40);
        text.setForeground(Color.BLACK);
        add(text);

        RoundedTextField usn = new RoundedTextField(20, 15, 10,"USN");
        usn.setBounds(900, 70, 450, 60);
        usn.setBackground(Color.WHITE);
        add(usn);

        RoundedTextField name = new RoundedTextField(20, 15, 10,"Name");
        name.setBounds(900, 150, 450, 60);
        name.setBackground(Color.WHITE);
        add(name);

        RoundedTextField dept = new RoundedTextField(20, 15, 10,"Department");
        dept.setBounds(900, 230, 450, 60);
        dept.setBackground(Color.WHITE);
        add(dept);

        RoundedTextField year = new RoundedTextField(20, 15, 10,"Year");
        year.setBounds(900, 310, 450, 60);
        year.setBackground(Color.WHITE);
        add(year);

        RoundedTextField sec = new RoundedTextField(20, 15, 10,"Section");
        sec.setBounds(900, 390, 450, 60);
        sec.setBackground(Color.WHITE);
        add(sec);

        RoundedTextField dob = new RoundedTextField(20, 15, 10,"Date of Birth");
        dob.setBounds(900, 470, 450, 60);
        dob.setBackground(Color.WHITE);
        add(dob);

        RoundedTextField contact = new RoundedTextField(20, 15, 10,"Contact No.");
        contact.setBounds(900, 550, 450, 60);
        contact.setBackground(Color.WHITE);
        add(contact);

        RoundedTextField mail = new RoundedTextField(20, 15, 10,"Email Address");
        mail.setBounds(900, 630, 450, 60);
        mail.setBackground(Color.WHITE);
        add(mail);

        submit = new RoundedButton("Submit",new Color(255,119,234),Color.WHITE);
        submit.setBounds(1313, 710, 163, 44);
        submit.setFont(new Font("Raleway", Font.BOLD,20));
        add(submit);

        JPanel panel = new JPanel();
        panel.setBounds(750,0,750,800);
        panel.setBackground(new Color(255, 255, 255));
        add(panel);

    }

    public static void main(String[] args){
        new Register();
    }
}
