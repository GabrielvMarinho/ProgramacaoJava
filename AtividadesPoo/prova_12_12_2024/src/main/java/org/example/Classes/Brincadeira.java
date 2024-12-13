package org.example.Classes;

public class Brincadeira {
    static int geradorCodigo=1;
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

    public Brincadeira(String nome, int divertimento, int cansaco, int fome, int sede, int sujeira) {
        this.nome = nome;
        this.cansaco = cansaco;
        this.fome = fome;
        this.sede = sede;
        this.sujeira = sujeira;
        this.divertimento = divertimento;
        this.codigo = geradorCodigo;
        geradorCodigo+=1;

    }

    public long getCodigo() {
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
