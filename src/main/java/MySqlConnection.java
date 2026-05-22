import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlConnection {
    public static void main(String[] args) {


        String sqlInstruction = "INSERT INTO mysql_local.cadastro (nome, idade, email) VALUES (?, ?, ?);";
        String nome = "Karine Velasco";
        int idade = 37;
        String email = "Karine@gmail.com";
        String url = "jdbc:mysql://localhost:3306/mysql_local";
        String user = "root";
        String password = "123456";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sqlInstruction);
                pst.setString(1, nome);
                pst.setInt(2, 6);
                pst.setString(3, email);
                pst.execute();
                System.out.println("Connected to the database!");
            }

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}