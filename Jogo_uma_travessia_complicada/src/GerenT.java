import java.lang.reflect.Method;
import java.util.ArrayList;

public class GerenT {
    static ArrayList<Pessoa> margemDireita = new ArrayList<Pessoa>();
    static ArrayList<Pessoa> margemEsquerda = new ArrayList<Pessoa>();
    static ArrayList<Pessoa> todasPessoas = new ArrayList<Pessoa>();


    static public boolean possuiLadrao(ArrayList<Pessoa> margem){
        for(Pessoa i:margem){
            if(i instanceof Ladrao)
                return true;
        }
        return false;
    }
    static public boolean possuiHomem(ArrayList<Pessoa> margem){
        for(Pessoa i:margem){
            if(i instanceof Homem)
                return true;
        }
        return false;
    }
    static public boolean possuiMulher(ArrayList<Pessoa> margem){
        for(Pessoa i:margem){
            if(i instanceof Mulher)
                return true;
        }
        return false;
    }
    static public boolean possuiMenina(ArrayList<Pessoa> margem){
        for(Pessoa i:margem){
            if(i instanceof Menina)
                return true;
        }
        return false;
    }
    static public boolean possuiMenino(ArrayList<Pessoa> margem){
        for(Pessoa i:margem){
            if(i instanceof Menino)
                return true;
        }
        return false;
    }
    static public boolean possuiPolicial(ArrayList<Pessoa> margem){
        for(Pessoa i:margem){
            if(i instanceof Policial)
                return true;
        }
        return false;
    }
    static public boolean possuiLadrao(Barco barco){
        if(barco.listaPessoas()[0] instanceof Ladrao ||barco.listaPessoas()[1] instanceof Ladrao){
            return true;
        }
        return false;
    }
    static public boolean possuiHomem(Barco barco){
        if(barco.listaPessoas()[0] instanceof Homem ||barco.listaPessoas()[1] instanceof Homem){
            return true;
        }
        return false;
    }
    static public boolean possuiMulher(Barco barco){
        if(barco.listaPessoas()[0] instanceof Mulher ||barco.listaPessoas()[1] instanceof Mulher){
            return true;
        }
        return false;
    }
    static public boolean possuiMenina(Barco barco){
        if(barco.listaPessoas()[0] instanceof Menina ||barco.listaPessoas()[1] instanceof Menina){
            return true;
        }
        return false;
    }
    static public boolean possuiMenino(Barco barco){
        if(barco.listaPessoas()[0] instanceof Menino ||barco.listaPessoas()[1] instanceof Menino){
            return true;
        }
        return false;
    }
    static public boolean possuiPolicial(Barco barco){
        if(barco.listaPessoas()[0] instanceof Policial ||barco.listaPessoas()[1] instanceof Policial){
            return true;
        }
        return false;
    }
    public static boolean checarVitoria(){
        if(getMargemDireita().size()==8){
            return true;
        }
        return false;
    }
    static public void validacaoDeTrocaDeMargem(ArrayList<Pessoa> MA,ArrayList<Pessoa> MD, Barco barco) throws Exception{
        if(!possuiHomem(barco) && !possuiPolicial(barco) && !possuiMulher(barco)){
            throw new ExceptionSemAdultoBarco();
        }
        else if(possuiHomem(MA) && possuiMenina(MA) && !possuiMulher(MA)) {
            throw new ExceptionPaiBateuMenina();
        }
        else if(possuiMulher(MA) && possuiMenino(MA) && !possuiHomem(MA)) {
            throw new ExceptionMaeBateuMenino();
        }
        else if(possuiHomem(barco) && possuiMenina(barco)) {
            throw new ExceptionPaiBateuMenina();
        }
        else if(possuiMulher(barco) && possuiMenino(barco)) {
            throw new ExceptionMaeBateuMenino();
        }
        else if(possuiLadrao(MA) && !possuiPolicial(MA) && (possuiMenino(MA) || possuiMenina(MA) || possuiHomem(MA) || possuiMulher(MA))){
            throw new ExceptionLadraoBateuFamilia();
        }
        else if(possuiMulher(barco) && possuiMenino(MD) && !possuiHomem(MD) && !possuiHomem(barco)){
            throw new ExceptionMaeBateuMenino();
        }
        else if(possuiHomem(barco) && possuiMenina(MD) && !possuiMulher(MD) && !possuiMulher(barco)){
            throw new ExceptionPaiBateuMenina();
        }
        else if(possuiLadrao(barco) && (possuiPolicial(MA) || possuiPolicial(MD))){
            throw new ExceptionLadraoBateuFamilia();
        }
    }
    static public void retornarStatus(Barco barco) {
        System.out.println("Margem Esquerda= "+desenharMargem(margemEsquerda)+
                //operador ternário que desenha a margem antes ou depois do barco baseado em sua posição
                "\n"+(barco.getMargemProxima()==getMargemEsquerda() ? desenhoBarco(barco)+desenhoAguas(): desenhoAguas()+desenhoBarco(barco))+
                "Margem Direita = "+desenharMargem(margemDireita));
    }
    public static String desenharMargem(ArrayList<Pessoa> margem){
        String desenho = "[   ";
        for(Pessoa i:margem){
            desenho += i.getIcon()+"|"+i.getId()+"   ";
        }
        desenho +="]";
        return desenho;

    }
    public static String desenhoBarco(Barco barco){
        String barco1="";
        String barco2="";

        if(barco.listaPessoas()[0]!=null){
            barco1 = barco.listaPessoas()[0].getIcon()+"|"+String.valueOf(barco.listaPessoas()[0].getId());
        }
        if(barco.listaPessoas()[1]!=null){
            barco2 = barco.listaPessoas()[1].getIcon()+"|"+String.valueOf(barco.listaPessoas()[1].getId());

        }
        return "\u200B\uD83D\uDEA2 = "+"[  "+barco1+"   "+barco2+"  ]"+ "   { 0 mover }\n";

    }
    public static String desenhoAguas(){
        String g="\uD83D\uDCA7";
        String gs="\uD83D\uDCA6";
        String on="\uD83C\uDF0A";
        return g+g+g+gs+gs+on+gs+on+g+gs+g+gs+on+g+on+g+gs+g+gs+"\n"+
                g+gs+gs+on+gs+on+g+on+g+gs+gs+on+g+gs+g+g+g+gs+gs+"\n"+
                g+gs+g+gs+g+gs+on+g+on+g+gs+gs+on+gs+on+g+g+on+g+g+"\n"+
                g+g+on+g+on+g+gs+gs+on+gs+on+gs+g+gs+g+gs+gs+gs+g+"\n";
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
