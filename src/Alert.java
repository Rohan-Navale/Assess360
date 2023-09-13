import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alert extends JFrame{
RoundedButton proceed;
    private JLabel timerLabel;
    private int secondsRemaining = 60;
    Alert(){
        setSize(1500, 800); // Set the Frame Size
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLocation(0, 0);
        setLayout(null);

        ImageIcon LogoIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png")); // Load the image
        Image LogoImage = LogoIcon.getImage();
        Image LogoscaledImage = LogoImage.getScaledInstance(180, 74, Image.SCALE_SMOOTH);
        ImageIcon LogoscaledIcon = new ImageIcon(LogoscaledImage);
        JLabel Logolabel = new JLabel(LogoscaledIcon);
        Logolabel.setBounds(20, 25, 180, 74); // Set the position and size of the JLabel
        add(Logolabel);

        ImageIcon AlertIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/alert.png")); // Load the image
        Image AlertImage = AlertIcon.getImage();
        Image AlertscaledImage = AlertImage.getScaledInstance(50, 47, Image.SCALE_SMOOTH);
        ImageIcon AlertscaledIcon = new ImageIcon(AlertscaledImage);
        JLabel Alertlabel = new JLabel(AlertscaledIcon);
        Alertlabel.setBounds(267, 225, 40, 37); // Set the position and size of the JLabel
        add(Alertlabel);

        JLabel text1 = new JLabel();
        text1.setText("Read the below instructions carefully!");
        text1.setFont(new Font("Raleway",Font.BOLD,30));
        text1.setForeground(Color.BLACK);
        text1.setBounds(322,222,600,40);
        add(text1);

        JLabel text2 = new JLabel();
        text2.setText("1. Each question has a strict time limit of 15 seconds for you to read and answer.");
        text2.setFont(new Font("Roboto",Font.PLAIN,25));
        text2.setForeground(Color.BLACK);
        text2.setBounds(267,295,1000,30);
        add(text2);

        JLabel text3 = new JLabel();
        text3.setText("2. Your answer will be automatically submitted once the 15-second timer expires.");
        text3.setFont(new Font("Roboto",Font.PLAIN,25));
        text3.setForeground(Color.BLACK);
        text3.setBounds(267,335,1000,30);
        add(text3);

        JLabel text4 = new JLabel();
        text4.setText("3. When the timer runs out, the exam will automatically move to the next question.");
        text4.setFont(new Font("Roboto",Font.PLAIN,25));
        text4.setForeground(Color.BLACK);
        text4.setBounds(267,375,1000,30);
        add(text4);

        JLabel text5 = new JLabel();
        text5.setText("4. You will see only one question on the screen at a time");
        text5.setFont(new Font("Roboto",Font.PLAIN,25));
        text5.setForeground(Color.BLACK);
        text5.setBounds(267,415,1000,30);
        add(text5);

        JLabel text6 = new JLabel();
        text6.setText("ALL THE BEST");
        text6.setFont(new Font("Raleway",Font.BOLD,30));
        text6.setForeground(Color.BLACK);
        text6.setBounds(650,490,320,45);
        add(text6);

        RoundedPanel panel = new RoundedPanel();
        panel.setBounds(241, 200, 1018, 360);
        panel.setBackground(new Color(202, 237, 255));
        add(panel);

        timerLabel = new JLabel("Time Left: " + secondsRemaining + " seconds");
        timerLabel.setFont(new Font("Raleway", Font.PLAIN, 20));
        timerLabel.setForeground(Color.RED);
        timerLabel.setBounds(1200, 25, 300, 40);
        add(timerLabel);

        Timer countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsRemaining--;
                timerLabel.setText("Time Left: " + secondsRemaining + " seconds");

                if (secondsRemaining <= 0) {
                    // Time's up, close the frame or perform some action
                    ((Timer) e.getSource()).stop();
                    setVisible(false);

                    // Add code to close or hide the frame here if needed.
                    // For example, setVisible(false);
                }
            }
        });
        countdownTimer.start();
    }
    public static void main(String[] args) {
        new Alert();
    }
}
