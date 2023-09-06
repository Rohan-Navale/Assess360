import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnectivity {
    Connection  c;
    Statement s;
    public DbConnectivity() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///onlineexams", "root", "123456789");
            s = c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
