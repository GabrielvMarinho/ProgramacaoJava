import Classes.Alimento;
import Crud.AlimentoCrud;

public class main {
    public static void main(String [] args){
        AlimentoCrud alimentoCrud = new AlimentoCrud();
        try{
//            alimentoCrud.removerAlimento(new Alimento(1, "gabriel"));
//            System.out.println(alimentoCrud.procurarAlimento(1));
            alimentoCrud.salvarAlimento(new Alimento("gabriel"));

        }catch (Exception e) {
            System.err.println(e);
        }
    }
}
