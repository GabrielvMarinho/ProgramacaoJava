package org.example;

import org.example.Classes.*;

import java.util.Scanner;

public class Main {
    static Banco banco = new Banco();
    static Scanner sc = new Scanner(System.in);
    static Pessoa usuarioLogado = null;
    public static void main(String[] args) {

        banco.cadastrarPessoa(new Pessoa(14220034935L, "gabriel", "123123"));
        banco.cadastrarPessoa(new Pessoa(123L, "bia", "123123"));
        banco.cadastrarPet(new Pet("pet fofo"));
        banco.cadastrarPet(new Pet("pet muito fofo"));
        Banco.getBrincadeiras().add(new Brincadeira("brincadeira legal", 10, 10, 20, 20, 20));
        Banco.getBrincadeiras().add(new Brincadeira("brincadeira divertida", 50, 10, 50, 60, 20));

        Banco.getAlimentos().add(new Alimento("comida divertida", 30));
        Banco.getAlimentos().add(new Alimento("comida boa", 80));
        do{
            opcoesSemLogin();

        }while(true);
    }
    public static void opcoesSemLogin(){
        System.out.println("""
                { Sem login }
                [ 0 ] mostrar Pets
                [ 9 ] fazer login
                """);
        int escolha = sc.nextInt();
        sc.nextLine();
        switch (escolha){

            case 0:
                mostrarPetsMain();
                break;
            case 9:
                fazerLoginMain();
                break;
            default:
                break;
        }
    }
    public static void mostrarPetsMain(){
        for(Pet pet:banco.getPets()){
            System.out.println("ID: "+pet.getCodigo());
            System.out.println(pet.toString());
        }
    }
    public static void fazerLoginMain(){
        System.out.println("Digite o cpf");
        int cpf = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a senha");
        String senha = sc.nextLine();
        usuarioLogado = banco.login(cpf, senha);

        if(!(usuarioLogado==null)){
            sessaoLogadoMain();
        }

    }
    public static void sessaoLogadoMain(){
        int escolha = 0;
        do {
            System.out.println("""
                    [ 0 ] Adotar Pet
                    [ 1 ] Avaliar meu Pet
                    [ 2 ] botar pet para dormir
                    [ 3 ] acordar pet
                    [ 4 ] dar agua para pet
                    [ 5 ] alimentar pet
                    [ 6 ] levar pet para fazer necessidades
                    [ 7 ] brincar com pet

                    """);
            escolha = sc.nextInt();

            sc.nextLine();
            switch (escolha) {
                case 0:
                    adotarPetLogado();
                    break;
                case 1:
                    avaliarPetLogado();
                    break;
                case 2:
                    usuarioLogado.botaPetParaDormir();
                    avaliarPetLogado();
                    break;
                case 3:
                    usuarioLogado.acordarPet();
                    avaliarPetLogado();
                    break;
                case 4:
                    usuarioLogado.darAguaParaPet();
                    avaliarPetLogado();
                    break;
                case 5:
                    mostrarAlimentos();
                    System.out.println("Digite o id do alimento: ");
                    int idAli = sc.nextInt();
                    sc.nextLine();
                    usuarioLogado.alimentarPet(Banco.procurarAlimento(idAli));
                    avaliarPetLogado();
                    break;
                case 6:
                    usuarioLogado.levarPetParaFazerNecessidades();
                    avaliarPetLogado();
                    break;
                case 7:
                    mostrarBrincadeiras();
                    System.out.println("Digite o id da brincadeira: ");
                    int idBrin = sc.nextInt();
                    usuarioLogado.brincarComPet(Banco.procurarBrincadeira(idBrin));
                    avaliarPetLogado();
                    break;

                default:
                    break;
            }
        }while(escolha!=99);

    }
    public static void adotarPetLogado(){
        mostrarPetsMain();
        System.out.println("Digite o codigo do Pet: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        usuarioLogado.adotarPet(banco.procurarPet(codigo));
        System.out.println("Pet adotado!");
    }

    public static void avaliarPetLogado(){
        System.out.println(usuarioLogado.avaliarPet());
    }

    public static void mostrarBrincadeiras(){
        for(Brincadeira brincadeira: Banco.getBrincadeiras()){
            System.out.println(brincadeira.toString());
        }
    }
    public static void mostrarAlimentos(){
        for(Alimento alimentos: Banco.getAlimentos()){
            System.out.println(alimentos.toString());
        }
    }

}