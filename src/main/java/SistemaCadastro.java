import java.util.List;

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
        crudCadastro.excluir(26);

        //crudCadastro.listar();
        CrudCadastro listarClientes = new CrudCadastro();
        List<CadastroCliente> listarTodosClientes = listarClientes.listar();
        for (CadastroCliente c: listarTodosClientes) {
            System.out.println(c.getId() + " - " + c.getName() + " - " + c.getAge() + " - " + c.getEmail());
        }

        //crudBuscarPorId
        CrudCadastro crudCadastroId = new CrudCadastro();
        CadastroCliente cadastroId = crudCadastroId.buscar(9);
        if (cadastroId!= null){
            System.out.println("| ID: " + cadastroId.getId() + " | Nome:  " + cadastroId.getName());
        }else{
            System.out.println("ID não localizado.");
        }

    }
}
