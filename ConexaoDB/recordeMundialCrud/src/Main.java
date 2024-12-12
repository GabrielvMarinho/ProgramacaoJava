import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static CRUD crud = new CRUD();
    public static void main(String[] args) {
        System.out.println("Sistema de CRUD dos funcionários\n");
        do{
            tratarOpcoes(mostrarRetornarOpcao());
        }while (true);

    }
    public static int mostrarRetornarOpcao(){
        System.out.println("""
                [ 0 ] Create
                [ 1 ] Read
                [ 2 ] Update
                [ 3 ] Delete
                
                >""");
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;

    }
    public static void tratarOpcoes(int escolha){
        switch (escolha){
            case 0:
                createFun();
                break;
            case 1:
                selectFun();
                break;
            case 2:
                updateFun();
                break;
            case 3:
                deleteFun();
                break;
            default:
                System.out.println("Escolha indisponível");
                break;
        }
    }
    public static void createFun(){
        System.out.println("Digite o nome do funcionario para criar:\n");
        String nome = sc.nextLine();
        System.out.println("Deu certo o creates: "+crud.create(new Funcionario(nome)).toString());
    }
    public static void selectFun(){
        for(Funcionario f: crud.select()){
            System.out.println(f.toString());
        }
    }

    public static void updateFun(){
        selectFun();
        System.out.println("Digite o id que deseja alterar:\n");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o novo nome:\n");
        String nome = sc.nextLine();
        System.out.println("Update com sucesso "+crud.update(id, new Funcionario(nome)).toString());
    }

    public static void deleteFun(){
        selectFun();
        System.out.println("Digite o id que deseja alterar:\n");
        int id = sc.nextInt();
        sc.nextLine();

        crud.delete(id);
        System.out.println("Deletado com sucesso");
    }

}