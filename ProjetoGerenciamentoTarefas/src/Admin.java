public class Admin {

    public static void cadastrarGerente(Gerente gerente){
        GerenciadorEmpresa.addPessoa(gerente);
    }
    public static void cadastrarfuncionario(Gerente gerente, Funcionario funcionario){
        gerente.addFuncionario(funcionario);
        GerenciadorEmpresa.addPessoa(funcionario);

    }
}
