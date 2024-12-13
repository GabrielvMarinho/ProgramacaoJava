package org.example.Classes;

import com.sun.jdi.IntegerValue;

import javax.management.StringValueExp;

public class Alimento {
    static int geradorCodigo=1;
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

    public Alimento(String nome, int nutricao) {
        this.nome = nome;
        this.nutricao = nutricao;
        this.codigo = geradorCodigo;
        geradorCodigo+=1;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getNutricao() {
        return nutricao;
    }
}
