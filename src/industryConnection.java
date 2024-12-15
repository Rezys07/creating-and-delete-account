import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class industryConnection {
    public static Connection getConexao() {
        try {
            final String url = "jdbc:mysql://localhost:3306/banco";
            final String user = "root";
            final String password = "mydb";

            return DriverManager.getConnection(url , user, password);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
