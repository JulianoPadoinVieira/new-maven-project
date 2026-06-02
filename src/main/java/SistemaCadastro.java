public class SistemaCadastro {
    public static void main(String[] args) {

        CadastroCliente cadastroCliente = new CadastroCliente();
        CrudCadastro crudCadastro = new CrudCadastro();

        cadastroCliente.setName("Chica");
        cadastroCliente.setAge(19);
        cadastroCliente.setEmail("chica@hotmail.com");

        crudCadastro.salvar(cadastroCliente);

        CadastroCliente atualizarCliente = new CadastroCliente();
        atualizarCliente.setName("Dorothy");
        atualizarCliente.setEmail("dorothy@gmail.com");
        crudCadastro.alterar(atualizarCliente);

        CadastroCliente deletarCliente = new CadastroCliente();
        deletarCliente.setId(5);






    }
}
