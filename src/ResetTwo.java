import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetTwo  extends JFrame implements ActionListener {
    JButton back, enter;
    ResetTwo(){
        setSize(1500,800);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLocation(0,0);
        setLayout(null);

        ImageIcon LogoIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png"));
        Image LogoImage = LogoIcon.getImage();
        Image LogoscaledImage = LogoImage.getScaledInstance(180, 74, Image.SCALE_SMOOTH);
        ImageIcon LogoscaledIcon = new ImageIcon(LogoscaledImage);
        JLabel Logolabel = new JLabel(LogoscaledIcon);
        Logolabel.setBounds(20, 25, 180, 74);
        add(Logolabel);

        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/reset.png"));
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(609, 624, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(62, 130, 609, 624);
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

        enter = new RoundedButton("Enter",new Color(202,237,255),Color.BLACK);
        enter.setBounds(1109, 392, 163, 44);
        enter.setFont(new Font("Raleway", Font.BOLD,20));
        add(enter);

        back = new RoundedButton("Back",new Color(216,180,248),Color.BLACK);
        back.setBounds(926, 392, 163, 44);
        back.setFont(new Font("Raleway", Font.BOLD,20));
        back.addActionListener(this);
        add(back);

    }

    public static void main(String[] args){ new ResetTwo();}

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new Resetone();
        }
    }
}
