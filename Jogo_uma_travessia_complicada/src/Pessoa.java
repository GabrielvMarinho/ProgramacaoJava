public class Pessoa {
    private int id;
    private String icon;
    public Pessoa(int id, String icon){
        this.id = id;
        this.icon = icon;
        GerenT.margemEsquerda.add(this);
        GerenT.todasPessoas.add(this);
    }


    public String getIcon() {
        return icon;
    }

    public int getId() {
        return id;
    }
}
