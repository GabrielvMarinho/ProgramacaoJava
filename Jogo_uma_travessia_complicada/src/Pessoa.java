public class Pessoa {
    private int id;
    public Pessoa(int id){
        this.id = id;
        GerenT.margemEsquerda.add(this);
        GerenT.todasPessoas.add(this);
    }



    public int getId() {
        return id;
    }
}
