import java.sql.Connection;
import java.util.List;

public class CadastroRepository {

    private Connection connection;
    public CadastroRepository(){
        connection = ConexaoMySQL.getConexao();
    }

    public void salvar(CadastroCliente cadastro){
        String sqlInstruction = "INSERT INTO mysql_local.cadastro (nome, idade, email) VALUES (?, ?, ?);";

    }
    public void alterar(CadastroCliente cadastro){

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
