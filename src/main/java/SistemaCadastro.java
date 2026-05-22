
public class SistemaCadastro {
    public static void main(String[] args) {

        ConexaoMySQL.conectar();
        CadastroRepository repository = new CadastroRepository();
        CadastroCliente cadastro = new CadastroCliente();
        cadastro.setName("Bento");
        cadastro.setAge(2);
        cadastro.setEmail("bento@hotmail.com");

        repository.salvar(cadastro);



    }
}
