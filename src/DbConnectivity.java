import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return c.prepareStatement(sql);
    }

    public boolean usnExists(String usn) {
        try {
            String sql = "SELECT * FROM register WHERE USN=?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, usn);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean dateOfBirthMatches(String usn, String dateOfBirth) {
        try {
            String sql = "SELECT COUNT(*) FROM register WHERE USN = ? AND DOB = ?";
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, usn);
            preparedStatement.setString(2, dateOfBirth);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
