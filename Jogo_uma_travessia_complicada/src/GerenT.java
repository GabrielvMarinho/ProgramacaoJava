import java.lang.reflect.Method;
import java.util.ArrayList;

public class GerenT {
    static ArrayList<Pessoa> margemDireita = new ArrayList<Pessoa>();

    static ArrayList<Pessoa> margemEsquerda = new ArrayList<Pessoa>();
    static ArrayList<Pessoa> todasPessoas = new ArrayList<Pessoa>();
    static public String retornarStatus(Barco barco) {
        String subIdD = "[   ";
        String subIdE = "[   ";
        for(Pessoa i:margemEsquerda){
            subIdD += i.getClass().getName()+"|"+i.getId()+"   ";
        }
        for(Pessoa i:margemDireita){
            subIdE += i.getClass()+"|"+i.getId()+"   ";
        }
        subIdD +="]";
        subIdE +="]";
        String barco1="";
        String barco2="";

        if(barco.listaPessoas()[0]!=null){
            barco1 = barco.listaPessoas()[0].getClass().getName()+"|"+String.valueOf(barco.listaPessoas()[0].getId());
        }
        if(barco.listaPessoas()[1]!=null){
            barco2 = barco.listaPessoas()[1].getClass().getName()+"|"+String.valueOf(barco.listaPessoas()[1].getId());

        }
        if(barco.getMargemProxima()==getMargemEsquerda()){
            String texto = "Margem Esquerda = "+subIdD+
                    "\nBarco = "+"[  "+barco1+"   "+barco2+"  ]"+ "   { 0 move o barco }"+
                    "\n----------------------------------------------------------"+
                    "\n----------------------------------------------------------"+
                    "\nMargem Direita = "+subIdE;
            return texto;

        }

        String texto = "Margem Esquerda = "+subIdD+
                "\n----------------------------------------------------------"+
                "\n----------------------------------------------------------"+
                "\nBarco = "+"[  "+barco1+"   "+barco2+"  ]"+ "   { 0 move o barco }"+
                "\nMargem Direita = "+subIdE;
        return texto;
    }

    public static ArrayList<Pessoa> getMargemDireita() {
        return margemDireita;
    }

    public static ArrayList<Pessoa> getTodasPessoas() {
        return todasPessoas;
    }

    public static ArrayList<Pessoa> getMargemEsquerda() {
        return margemEsquerda;
    }
    public static ArrayList<Pessoa> emQualMargemEsta(Pessoa pessoa){
        for(Pessoa i:getMargemDireita()){
            if(i==pessoa)
                return getMargemDireita();
        }
        for(Pessoa i:getMargemEsquerda()){
            if(i==pessoa)
                return getMargemEsquerda();
        }
        return null;
    }

    public static Pessoa returnById(int id) throws ExceptionIdNaoExiste {
        for(Pessoa i:getTodasPessoas()){
            if(i.getId()==id){
                return i;
            }
        }
        throw new ExceptionIdNaoExiste();
    }


    static public void moverDePara(Pessoa pessoa, ArrayList<Pessoa> margem, Barco barco) throws Exception {
        if(!(barco.getMargemProxima()==margem)){
            throw new ExceptionBarcoLonge();
        }
        barco.adicionarPessoa(pessoa);
        margem.remove(pessoa);

    }
    static public void moverDePara(Pessoa pessoa, Barco barco, ArrayList<Pessoa> margem) throws Exception {
        if(!(barco.getMargemProxima()==margem)){
            throw new ExceptionBarcoLonge();
        }
        barco.retirarPessoa(pessoa);
        margem.add(pessoa);
    }


}
