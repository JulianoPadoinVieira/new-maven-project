public class SistemaCadastro {
    public static void main(String[] args) {


        CrudCadastro crudCadastro = new CrudCadastro();

        //Salvar
        CadastroCliente cadastroCliente = new CadastroCliente();
        cadastroCliente.setName("Chica");
        cadastroCliente.setAge(19);
        cadastroCliente.setEmail("chica@hotmail.com");
        crudCadastro.salvar(cadastroCliente);

        //Atualizar
        CadastroCliente atualizarCliente = new CadastroCliente();
        atualizarCliente.setName("Ezequiel");
        atualizarCliente.setEmail("ezequiel@gmail.com");
        atualizarCliente.setId(5);
        crudCadastro.alterar(atualizarCliente);

        CadastroCliente deletarCliente = new CadastroCliente();
//        deletarCliente.setId(18);
        crudCadastro.excluir(26);







    }
}
