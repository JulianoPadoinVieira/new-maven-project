import java.sql.Connection;
import java.sql.PreparedStatement;
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

            int rows = con.executeUpdate();
            System.out.println(rows + " cliente inserido com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterar(CadastroCliente cadastro){

        String sqlInstruction = "UPDATE cadastro SET name = ? email = ? WHERE id = ?";
        int id = 0;

        try (PreparedStatement con = connection.prepareStatement(sqlInstruction)) {
            con.setString(1, cadastro.getEmail());
            con.setInt(2, 4);

            int rows = con.executeUpdate();
            System.out.println(rows + " informação de cliente atualizada com sucesso. ");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluir(Integer id){

    }

    public List<CadastroCliente> listar(){
        return null;
    }

    public CadastroCliente buscar(){
        return null;
    }

}
