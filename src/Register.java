import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {
    Register(){
        setSize(1500,800); // Set the Frame Size
        getContentPane().setBackground(new Color(216,180,248));
        setVisible(true);
        setLocation(0,0);
        setLayout(null);


        JPanel panel = new JPanel();
        panel.setBounds(750,0,750,800);
        panel.setBackground(new Color(255, 255, 255));
        add(panel);

    }

    public static void main(String[] args){
        new Register();
    }
}
