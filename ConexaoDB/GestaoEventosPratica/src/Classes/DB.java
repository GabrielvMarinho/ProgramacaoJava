package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private final String URL = "jdbc:mysql://localhost:3306/gestaoevento";
    private final String user = "root";
    private final String password = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }

}
