package org.example.Classes;

import com.sun.jdi.IntegerValue;

import javax.management.StringValueExp;

public class Alimento {
    int codigo;
    String nome;
    int nutricao;

    @Override
    public String toString() {
        return "Alimento{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", nutricao=" + nutricao +
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

    public void setNutricao(int nutricao) {
        this.nutricao = nutricao;
    }

    public Alimento(String nome, int nutricao) {
        this.nome = nome;
        this.nutricao = nutricao;
    }

    public Alimento(int codigo, String nome, int nutricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.nutricao = nutricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getNutricao() {
        return nutricao;
    }
}
