package org.example.Classes;

public class Brincadeira {
    int codigo;
    String nome;
    int cansaco;
    int fome;
    int sede;
    int sujeira;
    int divertimento;

    @Override
    public String toString() {
        return "Brincadeira{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cansaco=" + cansaco +
                ", fome=" + fome +
                ", sede=" + sede +
                ", sujeira=" + sujeira +
                ", divertimento=" + divertimento +
                '}';
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCansaco(int cansaco) {
        this.cansaco = cansaco;
    }

    public void setFome(int fome) {
        this.fome = fome;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public void setSujeira(int sujeira) {
        this.sujeira = sujeira;
    }

    public void setDivertimento(int divertimento) {
        this.divertimento = divertimento;
    }

    public Brincadeira(int codigo, String nome, int cansaco, int fome, int sede, int sujeira, int divertimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.cansaco = cansaco;
        this.fome = fome;
        this.sede = sede;
        this.sujeira = sujeira;
        this.divertimento = divertimento;
    }

    public Brincadeira(String nome, int divertimento, int cansaco, int fome, int sede, int sujeira) {
        this.nome = nome;
        this.cansaco = cansaco;
        this.fome = fome;
        this.sede = sede;
        this.sujeira = sujeira;
        this.divertimento = divertimento;

    }

    public int getCodigo() {
        return codigo;
    }

    public int getCansaco() {
        return cansaco;
    }

    public int getFome() {
        return fome;
    }

    public int getSede() {
        return sede;
    }

    public int getSujeira() {
        return sujeira;
    }

    public int getDivertimento() {
        return divertimento;
    }
}
