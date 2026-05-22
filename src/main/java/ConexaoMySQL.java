import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoMySQL {

    private static Connection connection;
    public static void conectar() {
        try {
            if(connection==null){
                String url = "jdbc:mysql://localhost:3306/mysql_local";
                String user = "root";
                String password = "123456";
                connection = DriverManager.getConnection(url, user, password);

                System.out.println("Conexão efetuada com sucessso!");

            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

    public static Connection getConexao() {
        return connection;
    }





}
