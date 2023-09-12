import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import com.toedter.calendar.JDateChooser;
public class Register extends JFrame implements ActionListener {
    JButton submit, back;
    JDateChooser date;
    JComboBox<String> dept,yr;
    RoundedTextField usn, password, name, contact, mail, sec;
    Register(){
        setSize(1500,800); // Set the Frame Size
        getContentPane().setBackground(new Color(216,180,248));
        setVisible(true);
        setLocation(0,0);
        setLayout(null);

        ImageIcon LogoIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png")); // Load the image
        Image LogoImage = LogoIcon.getImage();
        Image LogoscaledImage = LogoImage.getScaledInstance(150, 58, Image.SCALE_SMOOTH);
        ImageIcon LogoscaledIcon = new ImageIcon(LogoscaledImage);
        JLabel Logolabel = new JLabel(LogoscaledIcon);
        Logolabel.setBounds(585, 10, 150, 58); // Set the position and size of the JLabel
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

        usn = new RoundedTextField(20, 15, 10,"USN");
        usn.setBounds(121, 70, 450, 50);
        usn.setBackground(Color.WHITE);
        add(usn);

        password = new RoundedTextField(20, 15, 10,"Set Password");
        password.setBounds(121, 140, 450, 50);
        password.setBackground(Color.WHITE);
        add(password);

        JLabel passtext = new JLabel("Remember your password for future use");
        passtext.setBounds(131,187,500,20);
        passtext.setFont(new Font("Raleway",Font.PLAIN,10));
        passtext.setForeground(Color.red);
        add(passtext);

        name = new RoundedTextField(20, 15, 10,"Name");
        name.setBounds(121, 215, 450, 50);
        name.setBackground(Color.WHITE);
        add(name);

        contact = new RoundedTextField(20, 15, 10,"Contact No.");
        contact.setBounds(121, 286, 448, 50);
        contact.setBackground(Color.WHITE);
        add(contact);

        mail = new RoundedTextField(20, 15, 10,"Email Address");
        mail.setBounds(121, 355, 448, 50);
        mail.setBackground(Color.WHITE);
        add(mail);

        sec = new RoundedTextField(20, 15, 10,"Section");
        sec.setBounds(121, 426, 450, 50);
        add(sec);

        String[] departments = {"AE", "CE", "CSE", "ISE", "ECE", "EEE", "ME"};
        dept = new JComboBox<>(departments);
        dept.setFont(new Font("Raleway", Font.BOLD, 16));
        dept.setForeground(Color.BLACK);
        dept.setBackground(Color.WHITE);
        dept.setBounds(121, 566, 450, 50);
        add(dept);

        String[] years = {"1","2","3","4"};
        yr = new JComboBox<>(years);
        yr.setFont(new Font("Raleway", Font.BOLD, 16));
        yr.setForeground(Color.BLACK);
        yr.setBackground(Color.WHITE);
        yr.setBounds(121, 635, 450, 50);
        add(yr);

        date = new JDateChooser(); //Jcalender.jar file was not available. Downloaded and added. File-> Project Structure -> Library -> Add -> Apply
        date.setBounds(121,495,450,50);
        date.setForeground(Color.BLACK);
        date.setToolTipText("Date of Birth");
        date.setFont(new Font("Roboto",Font.PLAIN,18));
        add(date);

        JLabel datetext = new JLabel("Enter your Date of Birth");
        datetext.setBounds(131,540,500,20);
        datetext.setFont(new Font("Raleway",Font.PLAIN,10));
        datetext.setForeground(Color.blue);
        add(datetext);

        submit = new RoundedButton("Submit",new Color(186,104,200),Color.WHITE);
        submit.setBounds(550, 705, 163, 44);
        submit.setFont(new Font("Raleway", Font.BOLD,20));
        submit.addActionListener(this);
        add(submit);

        back = new RoundedButton("Back",new Color(216,180,248),Color.BLACK);
        back.setBounds(60, 705, 163, 44);
        back.setFont(new Font("Raleway", Font.BOLD,20));
        back.addActionListener(this);
        add(back);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,750,800);
        panel.setBackground(new Color(255, 255, 255));
        add(panel);

    }
    public static void main(String[] args){
        new Register();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit) {
            String susn = usn.getText();
            String sname = name.getText();
            String scontact = contact.getText();
            String smail = mail.getText();
            String spassword = password.getText();
            String ssec = sec.getText();
            String sdept = String.valueOf(dept.getSelectedItem());
            String syear = String.valueOf(yr.getSelectedItem());
            String sdate = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            try {
                DbConnectivity c = new DbConnectivity();
                String q1 = "insert into register values('" + susn + "','" + sname + "','" + sdept + "','" + syear + "','" + ssec + "','" + sdate + "','" + scontact + "','" + smail + "')";
                String q2 = "insert into login values('" + susn + "','" + spassword + "')";
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Registration Successful");
                setVisible(false);

            } catch (SQLIntegrityConstraintViolationException e) {
                if (e.getErrorCode() == 1062) {
                    JOptionPane.showMessageDialog(null, "USN already registered");
                }
                System.out.println(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
}
