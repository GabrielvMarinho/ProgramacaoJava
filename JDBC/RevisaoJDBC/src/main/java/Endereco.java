public class Endereco {
    private int id;
    private int cep;
    private int numero;
    private Pessoa pessoa;

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep=" + cep +
                ", numero=" + numero +
                ", pessoa=" + pessoa +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public int getId() {
        return id;
    }

    public int getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco(int cep, int numero, Pessoa pessoa) {
        this.cep = cep;
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public Endereco(int id, int cep, int numero) {
        this.id = id;
        this.cep = cep;
        this.numero = numero;
    }

    public Endereco(int cep, int numero) {
        this.cep = cep;
        this.numero = numero;

    }
    public Endereco(){};
}
