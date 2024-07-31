public class Pet {
    int codigo;
    String nome;
    boolean vivo;
    boolean acordado;
    double sede=0;
    double fome=0;
    double energia=0;
    double diversao=0;
    double higiene=100;
    double vontadeBanheiro=0;

    Pet(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }

    public void beberAgua(){
        this.sede = mm(this.sede+50);
        this.vontadeBanheiro = mm(this.vontadeBanheiro-25);
        if(this.vontadeBanheiro==0){
            this.vontadeBanheiro=100;
            this.higiene=0;
        }
    }
//    public void comer(Alimento alimento){
//
//    }
    public void dormir(){
        this.energia = mm(this.energia+25);
    }
    public void acordar(){
        this.energia = mm(this.energia+25);
    }
//    public void brincar(Brincadeira brincadeira){
//
//    }
    public void limpar(){
        this.higiene = 100;
    }
    public void fazerNecessidade(){
        this.vontadeBanheiro= 100;
        this.higiene= mm(this.higiene-25);
    }
    public void morrer(){
        if(this.sede==0 && this.fome==0 && this.energia==0){
            vivo = false;
        }
    }
    public double mm(double valor){
        if(valor>100){
            valor=100;
            return valor;
        }
        if(valor<0){
            valor=0;
            return valor;
        }
        return valor;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", vivo=" + vivo +
                ", acordado=" + acordado +
                ", sede=" + sede +
                ", fome=" + fome +
                ", energia=" + energia +
                ", diversao=" + diversao +
                ", higiene=" + higiene +
                ", vontadeBanheiro=" + vontadeBanheiro +
                '}';
    }
}
