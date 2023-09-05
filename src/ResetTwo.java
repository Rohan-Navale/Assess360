import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class ResetTwo  extends JFrame{
    ResetTwo(){
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
        label.setBounds(62, 130, 609, 624); // Set the position and size of the JLabel
        add(label);

        JLabel text  = new JLabel("Enter new your password");
        text.setFont(new Font("Raleway",Font.BOLD, 30));
        text.setBounds(830,164,700,40);
        text.setForeground(Color.BLACK);
        add(text);

        RoundedTextField newpass = new RoundedTextField(20, 15, 10,"New Password");
        newpass.setBounds(822, 230, 450, 55);
        newpass.setBackground(Color.WHITE);
        add(newpass);

        RoundedTextField repass = new RoundedTextField(20, 15, 10,"Re-enter New Password");
        repass.setBounds(822, 308, 450, 55);
        repass.setBackground(Color.WHITE);
        add(repass);

    }

    public static void main(String[] args){ new ResetTwo();}
}
