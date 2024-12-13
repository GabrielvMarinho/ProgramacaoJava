package Classes;

public class Cliente {
    int id;
    String nome;
    String email;
    String telefone;
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
    public Cliente(int id, String nome, String email,String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    public Cliente(String nome, String email,String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Object getPlanoId(){
        if(this.plano!=null){
            return getPlano().getId();
        }else{
            return null;
        }
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
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
