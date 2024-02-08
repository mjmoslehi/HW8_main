package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static Connection connection = null;

    private JdbcConnection(){}

    public static Connection getConnection() {
        if(connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "mjm6yhn7ujm");
            } catch (SQLException e) {
                System.out.println("not found url");
            }
        }
        return connection;
    }
}
