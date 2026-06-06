import com.mysql.cj.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CrudCadastro {

    private Connection connection = ConexaoMySQL.getConexao();;

    public CrudCadastro(){
        connection = ConexaoMySQL.getConexao();
    }

    public void salvar(CadastroCliente cadastro){

        try {
            String sqlInstruction = "INSERT INTO mysql_local.cadastro (nome, idade, email) VALUES (?, ?, ?);";
            PreparedStatement con = connection.prepareStatement(sqlInstruction);
            con.setString(1, cadastro.getName());
            con.setInt(2, cadastro.getAge());
            con.setString(3, cadastro.getEmail());

            con.executeUpdate();
            System.out.println("Cliente inserido com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterar(CadastroCliente cadastro){

        String sqlInstruction = "UPDATE cadastro SET nome = ?, email = ? WHERE id = ?";

        try (PreparedStatement con = connection.prepareStatement(sqlInstruction)) {
            con.setString(1, cadastro.getEmail());
            con.setString(2, cadastro.getEmail());
            con.setInt(3, cadastro.getId());

            con.executeUpdate();
            System.out.println("Informações do cliente com ID " + cadastro.getId() + " atualizadas com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluir(int id){

        String sqlInstruction = "DELETE FROM cadastro WHERE id = ?";

        try (PreparedStatement con = connection.prepareStatement(sqlInstruction)) {
            con.setInt(1, id);

            con.executeUpdate();
            System.out.println("O usuário com ID número " + id + " foi deletado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<CadastroCliente> listar(){

        List<CadastroCliente> lista = new ArrayList<>();

        try {
            String sqlInstruction = "SELECT id, nome, idade, email FROM cadastro;";
            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String nome = result.getString("nome");
                int idade = result.getInt("idade");
                String email = result.getString("email");

                CadastroCliente cadastro = new CadastroCliente();
                cadastro.setId(id);
                cadastro.setName(nome);
                cadastro.setAge(idade);
                cadastro.setEmail(email);

                lista.add(cadastro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public CadastroCliente buscar(int id){
        CadastroCliente cadastroId = null;
        try{
            String sqlInstruction = "SELECT * FROM cadastro WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()){
                id = result.getInt("id");
                String nome = result.getString("nome");
                int idade = result.getInt("idade");
                String email = result.getString("email");

                cadastroId = new CadastroCliente();
                cadastroId.setId(id);
                cadastroId.setName(nome);
                cadastroId.setAge(idade);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return cadastroId;

//        try ();
//            Statement stmt = con.createStatement();
//
//            con.setInt(1, id);
//
//                System.out.println(rs.getInt("ID: ") + " | " +
//                        rs.getString("Nome: ") + " | " +
//                        rs.getInt("Idade: ") + " | " +
//                        rs.getString("E-mail: "));
//
//        }catch(Exception e) {
//            e.printStackTrace();
//        }//
//        return null;
    }

}
