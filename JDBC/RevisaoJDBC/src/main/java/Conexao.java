import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private final String URL="jdbc:mysql://localhost:3306/db_revisao";
    private final String USUARIO="root";
    private final String SENHA="";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

}
