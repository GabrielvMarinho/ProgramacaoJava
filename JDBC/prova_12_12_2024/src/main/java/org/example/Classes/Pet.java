package org.example.Classes;

public class Pet {
    int sede=100;
    int fome=100;
    int codigo;
    String nome;
    int vontadeBanheiro=100;
    int higiene=100;
    boolean acordado = true;
    int energia=100;
    boolean vivo = true;
    int diversao=100;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public Pet(int sede, int fome, int codigo, String nome, int vontadeBanheiro, int higiene, boolean acordado, int energia, boolean vivo, int diversao) {
        this.sede = sede;
        this.fome = fome;
        this.codigo = codigo;
        this.nome = nome;
        this.vontadeBanheiro = vontadeBanheiro;
        this.higiene = higiene;
        this.acordado = acordado;
        this.energia = energia;
        this.vivo = vivo;
        this.diversao = diversao;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public int getFome() {
        return fome;
    }

    public void setFome(int fome) {
        this.fome = fome;
    }

    public int getVontadeBanheiro() {
        return vontadeBanheiro;
    }

    public void setVontadeBanheiro(int vontadeBanheiro) {
        this.vontadeBanheiro = vontadeBanheiro;
    }

    public int getHigiene() {
        return higiene;
    }

    public void setHigiene(int higiene) {
        this.higiene = higiene;
    }

    public boolean isAcordado() {
        return acordado;
    }

    public void setAcordado(boolean acordado) {
        this.acordado = acordado;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getDiversao() {
        return diversao;
    }

    public void setDiversao(int diversao) {
        this.diversao = diversao;
    }

    public Pet(String nome){
        this.nome = nome;
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
        if(this.vivo==false){
            System.err.println("Não pode brincar, pet morreu");
            return;
        }
        this.sede +=50;
        this.vontadeBanheiro -=25;
        this.arrumarValores();
        if(vontadeBanheiro ==0){
            this.vontadeBanheiro=100;
            this.higiene=0;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void limpar(){
        if(this.vivo==false){
            System.err.println("Não pode brincar, pet morreu");
            return;
        }
        this.higiene+=100;
        this.arrumarValores();
    }
    public void fazerNecessidades(){
        if(this.vivo==false){
            System.err.println("Não pode brincar, pet morreu");
            return;
        }
        this.vontadeBanheiro+=100;
        this.higiene -=25;
        this.arrumarValores();
    }
    public void brincar(Brincadeira brincadeira){
        if(this.vivo==false){
            System.err.println("Não pode brincar, pet morreu");
            return;
        }
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
        if(this.vivo==false){
            System.err.println("Não pode brincar, pet morreu");
            return;
        }
        this.energia +=25;
        this.acordado = false;
        this.arrumarValores();
    }

    public void morrer(){
        if(this.vivo==false){
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
        if(this.vivo==false){
            System.err.println("Não pode brincar, pet morreu");
            return;
        }
            this.energia +=25;
        this.acordado = true;
        this.arrumarValores();
    }
    public void comer(Alimento alimento){
        if(this.vivo==false){
            System.err.println("Não pode brincar, pet morreu");
            return;
        }
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
