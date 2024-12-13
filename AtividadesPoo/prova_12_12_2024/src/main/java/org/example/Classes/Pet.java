package org.example.Classes;

public class Pet {
    static int geradorCodigo=1;
    int sede=100;
    int fome=100;
    int codigo;
    String nome;
    int vontadeBanheiro;
    int higiene=100;
    boolean acordado = true;
    int energia=100;
    boolean vivo = true;
    int diversao=100;

    public Pet(String nome){
        this.nome = nome;
        this.codigo = geradorCodigo;
        geradorCodigo+=1;

    }
    public void arrumarValores(){
        if(this.sede<0){
            this.sede=0;
        }
        if(this.sede>100){
            this.sede=100;
        }
        if(this.fome<0){
            this.fome=0;
        }
        if(this.fome>100){
            this.fome=100;
        }
        if(this.vontadeBanheiro<0){
            this.vontadeBanheiro=0;
        }
        if(this.vontadeBanheiro>100){
            this.vontadeBanheiro=100;
        }
        if(this.higiene<0){
            this.higiene=0;
        }
        if(this.higiene>100){
            this.higiene=100;
        }
        if(this.energia<0){
            this.energia=0;
        }
        if(this.energia>100){
            this.energia=100;
        }
        if(this.diversao<0){
            this.diversao=0;
        }
        if(this.diversao>100){
            this.diversao=100;
        }
        this.morrer();

    }
    public void beberAgua(){
        this.sede +=50;
        this.vontadeBanheiro -=25;
        this.arrumarValores();
        if(vontadeBanheiro ==0){
            this.vontadeBanheiro=100;
            this.higiene=0;
        }
    }
    public void limpar(){
        this.higiene+=100;
        this.arrumarValores();
    }
    public void fazerNecessidades(){
        this.vontadeBanheiro+=100;
        this.higiene -=25;
        this.arrumarValores();
    }
    public void brincar(Brincadeira brincadeira){
        this.diversao +=brincadeira.getDivertimento();
        this.energia -=brincadeira.getCansaco();
        this.fome -=brincadeira.getFome();
        this.sede -=brincadeira.getSede();
        this.higiene -=brincadeira.getSujeira();
        this.arrumarValores();

    }
    @Override
    public String toString() {
        String varVivo="Não";
        String varAcordado="Não";
        if(vivo){
            varVivo = "Sim";
        }
        if(acordado) {
            varAcordado = "Sim";
        }
        return "Nome: " + nome +
                "\nVivo: " +varVivo+
                "\nAcordado: " + varAcordado +
                "\nSede: " + sede  +
                "\nFome: " + fome +
                "\nEnergia: " + energia +
                "\nDiversão: " + diversao +
                "\nHigiene: " + higiene +
                "\nVontade de ir ao banheiro: " + vontadeBanheiro+"\n";

    }
    public String dadosSaude(){
        return
                "\nsede=" + sede +
                "\nfome=" + fome +
                "\nvontadeBanheiro=" + vontadeBanheiro +
                "\nhigiene=" + higiene +
                "\nenergia=" + energia +
                "\ndiversao=" + diversao+"\n"+
                "\nvivo=" + vivo +
                "\nacordado=" + acordado ;

    }
    public void dormir(){
        this.energia +=25;
        this.acordado = false;
        this.arrumarValores();
    }
    public void morrer(){
        if(this.sede==0) {
            System.err.println("morreu pet");
            this.vivo=false;
        }else if(this.fome==0){
            System.err.println("morreu pet");
            this.vivo=false;
        }else if(this.energia==0){
            System.err.println("morreu pet");
            this.vivo=false;
        }


    }
    public void acordar(){
        this.energia +=25;
        this.acordado = true;
        this.arrumarValores();
    }
    public void comer(Alimento alimento){
        this.fome +=alimento.getNutricao();
        this.vontadeBanheiro -=(alimento.getNutricao()/2);
        this.arrumarValores();
        if(vontadeBanheiro ==0){
            this.vontadeBanheiro=100;
            this.higiene=0;
        }
    }
    public int getCodigo() {
        return this.codigo;
    }
}
