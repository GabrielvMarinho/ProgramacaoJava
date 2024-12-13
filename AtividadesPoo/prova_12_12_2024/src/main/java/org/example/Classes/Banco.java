package org.example.Classes;

import java.util.ArrayList;

public class Banco {
    static ArrayList<Alimento> alimentos = new ArrayList<>();
    static ArrayList<Brincadeira> brincadeiras = new ArrayList<>();
    static ArrayList<Pet> pets = new ArrayList<>();
    static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void cadastrarPet(Pet pet){
        pets.add(pet);
    }
    public static void removerPet(Pet pet){
        pets.remove(pet);
    }
    public static void removerPessoa(Pessoa pessoa){
        pessoas.remove(pessoa);
    }
    public static Alimento procurarAlimento(int codigo){
        int posi = 0;
        for(Alimento alimento:alimentos){

            if(alimento.getCodigo()==codigo){
                return alimentos.get(posi);
            }
            posi +=1;
        }
        return null;
    }
    public static Brincadeira procurarBrincadeira(int codigo){
        int posi = 0;
        for(Brincadeira brincadeira:brincadeiras){
            if(brincadeira.getCodigo()==codigo){
                return brincadeiras.get(posi);
            }
            posi +=1;
        }
        return null;
    }
    public static Pet procurarPet(long codigo){
        int posi = 0;
        for(Pet pet:pets){
            if(pet.getCodigo()==codigo){
                return pets.get(posi);
            }
            posi +=1;
        }
        return null;

    }
    public static Pessoa procurarPessoa(long cpf){
        int posi = 0;
        for(Pessoa pessoa:pessoas){
            if(pessoa.getCpf()==cpf){
                return pessoas.get(posi);
            }
            posi +=1;
        }
        return null;
    }

    public static ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }
    public static ArrayList<Pet> getPets(){
        return pets;
    }
    public static Pessoa login(long cpf, String senha){
        int posi = 0;
        for(Pessoa pessoa:pessoas){
            if(pessoa.getCpf()==cpf && pessoa.getSenha().equals(senha)){
                return pessoas.get(posi);
            }
            posi +=1;
        }
        return null;
    }
    public static void cadastrarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }
    public static ArrayList<Brincadeira> getBrincadeiras(){
        return brincadeiras;
    }
}
