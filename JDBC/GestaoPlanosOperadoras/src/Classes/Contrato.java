package Classes;

public class Contrato {
    int id;
    Plano plano;
    String termos;
    String data_inicio;
    String data_fim;
    public Object getPlanoId(){
        if(this.plano!=null){
            return getPlano().getId();
        }else{
            return null;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + id +
                ", plano=" + plano +
                ", termos='" + termos + '\'' +
                ", data_inicio='" + data_inicio + '\'' +
                ", data_fim='" + data_fim + '\'' +
                '}';
    }

    public Contrato(int id, Plano plano, String termos, String data_inicio, String data_fim) {
        this.id = id;
        this.plano = plano;
        this.termos = termos;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }
    public Contrato(Plano plano, String termos, String data_inicio, String data_fim) {
        this.id = id;
        this.plano = plano;
        this.termos = termos;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }

    public int getId() {
        return id;
    }

    public Plano getPlano() {
        return plano;
    }

    public String getTermos() {
        return termos;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }
}
