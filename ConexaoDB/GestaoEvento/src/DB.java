import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    String URL = "jdbc:mysql://localhost:3306/gestaoEvento";
    String USER = "root";
    String PASSWORD = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
