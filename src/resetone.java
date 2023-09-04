import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class resetone extends JFrame {
    JDateChooser date;
    JButton  enter, back;
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
        label.setBounds(62, 130, 609, 624); // Set the position and size of the JLabel
        add(label);

        JLabel text  = new JLabel("Enter the below details to reset your password");
        text.setFont(new Font("Raleway",Font.BOLD, 30));
        text.setBounds(721,164,700,40);
        text.setForeground(Color.BLACK);
        add(text);

        JLabel text1  = new JLabel("USN:");
        text1.setFont(new Font("Raleway",Font.BOLD, 24));
        text1.setBounds(792,244,60,30);
        text1.setForeground(Color.BLACK);
        add(text1);

        JLabel text2  = new JLabel("DoB:");
        text2.setFont(new Font("Raleway",Font.BOLD, 24));
        text2.setBounds(792,323,60,30);
        text2.setForeground(Color.BLACK);
        add(text2);

        JTextField usn = new JTextField();
        usn.setBounds(866,232,450,55);
        usn.setFont(new Font("Raleway",Font.PLAIN,24));
        add(usn);

        date = new JDateChooser(); //Jcalender.jar file was not available. Downloaded and added. File-> Project Structure -> Library -> Add -> Apply
        date.setBounds(865,308,450,55);
        date.setForeground(Color.BLACK);
        date.setToolTipText("Date of Birth");
        date.setFont(new Font("Roboto",Font.PLAIN,18));
        add(date);

        enter = new RoundedButton("Enter",new Color(202,237,255),Color.BLACK);
        enter.setBounds(1153, 392, 163, 44);
        enter.setFont(new Font("Raleway", Font.BOLD,20));
        add(enter);

        back = new RoundedButton("Back",new Color(216,180,248),Color.BLACK);
        back.setBounds(970, 392, 163, 44);
        back.setFont(new Font("Raleway", Font.BOLD,20));
        add(back);

    }

    public static void main(String[] args){
        new resetone();
    }
}
