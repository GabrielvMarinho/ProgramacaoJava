package Classes;

public class Cliente {
    int id;
    String nome;
    String email;
    String telefone;
    String texto;
    Plano plano;

    public Cliente(int id, String nome, String email,String telefone, Plano plano) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.plano = plano;
    }
    public Cliente(String nome, String email,String telefone, Plano plano) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.plano = plano;
    }



    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", texto='" + texto + '\'' +
                ", plano=" + plano +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }


    public String getTelefone() {
        return telefone;
    }

    public Plano getPlano() {
        return plano;
    }


}
