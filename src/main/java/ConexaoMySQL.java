import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {

    private static Connection connection;

    public static Connection getConexao() {

        try {
            if (connection == null || connection.isClosed()) {

                String url = "jdbc:mysql://localhost:3306/mysql_local";
                String user = "root";
                String password = "123456";

                connection =
                        DriverManager.getConnection(url, user, password);

                System.out.println("Conexão efetuada com sucesso!");
            }

            return connection;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
