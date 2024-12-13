package org.example;

import org.example.Classes.*;

import java.util.Scanner;

public class Main {
    static Banco banco = new Banco();
    static Scanner sc = new Scanner(System.in);
    static Pessoa usuarioLogado = null;
    public static void main(String[] args) {

        do{
            try{
                usuarioLogado = null;
                opcoesSemLogin();

            }catch (Exception e){
                System.err.println("Erro crítico na aplicação!");
            }
        }while(true);
    }
    public static void opcoesSemLogin(){
        System.out.println("""
                { Sem login }
                ------------
                [ 0 ] Mostrar Pets
                [ 1 ] Pesquisar Pet
                [ 2 ] Atualizar Pet
                [ 3 ] Inserir novo Pet
                [ 4 ] Deletar Pet
                ------------------
                [ 5 ] Mostrar Pessoas
                [ 6 ] Pesquisar Pessoas
                [ 7 ] Atualizar Pessoas
                [ 8 ] Inserir novo Pessoas
                [ 9 ] Deletar Pessoas
                ------------------
                [ 10 ] Mostrar Alimento
                [ 11 ] Pesquisar Alimentos
                [ 12 ] Atualizar Alimentos
                [ 13 ] Inserir novo Alimentos
                [ 14 ] Deletar Alimentos
                ------------------
                [ 15 ] Mostrar Brincadeira
                [ 16 ] Pesquisar Brincadeiras
                [ 17 ] Atualizar Brincadeiras
                [ 18 ] Inserir novo Brincadeiras
                [ 19 ] Deletar Brincadeiras
                ------------------

                [ 99 ] fazer login
                """);
        int escolha = sc.nextInt();
        sc.nextLine();
        switch (escolha){

            case 0:
                mostrarPetsMain();
                break;
            case 1:
                pesquisarPetMain();
                break;
            case 2:
                atualizarPetMain();
                break;
            case 3:
                inserirPetMain();
                break;
            case 4:
                deletarPetMain();
                break;
            case 5:
                mostrarPessoasMain();
                break;
            case 6:
                pesquisarPessoaMain();
                break;
            case 7:
                atualizarPessoaMain();
                break;
            case 8:
                inserirPessoaMain();
                break;
            case 9:
                deletarPessoaMain();
                break;
            case 10:
                mostrarAlimentosMain();
                break;
            case 11:
                pesquisarAlimentosMain();
                break;
            case 12:
                atualizarAlimentosMain();
                break;
            case 13:
                inserirAlimentosMain();
                break;
            case 14:
                deletarAlimentosMain();
                break;
            case 15:
                mostrarBrincadeirasMain();
                break;
            case 16:
                pesquisarBrincadeirasMain();
                break;
            case 17:
                atualizarBrincadeirasMain();
                break;
            case 18:
                inserirBrincadeirasMain();
                break;
            case 19:
                deletarBrincadeirasMain();
                break;
            case 99:
                fazerLoginMain();
                break;
            default:
                break;
        }
    }
    //PET
    public static void mostrarPetsMain(){
        for(Pet pet:banco.procurarPets()){
            System.out.println("ID: "+pet.getCodigo());
            System.out.println(pet.toString());
        }
    }
    public static void pesquisarPetMain(){
        System.out.println("pet procurado -> "+ pegarEvalidarIdPet().toString());
    }
    public static void atualizarPetMain(){
        Pet pet = pegarEvalidarIdPet();

        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        pet.setNome(nome);
        banco.salvarPet(pet);
        System.out.println("pet atualizado");
    }
    public static void inserirPetMain(){
        System.out.println("Digite o nome do pet: ");
        String nome = sc.nextLine();
        System.out.println("pet inserido -> "+banco.salvarPet(new Pet(nome)).toString());
    }
    public static void deletarPetMain(){
        banco.removerPet(pegarEvalidarIdPet());

        System.out.println("pet deletado");

    }
    public static Pet pegarEvalidarIdPet(){
        do{

            mostrarPetsMain();
            System.out.println("Digite um id: ");
            int id = sc.nextInt();
            sc.nextLine();
            try{
                return banco.procurarPet(id);
            }catch (RuntimeException e){
                System.out.println("Código inválido tente denovo");
            }
        }while(true);


    }

    //PESSOAS
    public static void mostrarPessoasMain(){
        for(Pessoa pessoa:banco.procurarPessoas()){
            System.out.println("ID: "+pessoa.getCodigo());
            System.out.println(pessoa.toString());
        }
    }
    public static void pesquisarPessoaMain(){
        System.out.println("pessoa procurada -> "+ pegarEvalidarIdPessoa().toString());
    }
    public static void atualizarPessoaMain(){
        Pessoa pessoa = pegarEvalidarIdPessoa();
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o cpf: ");
        Long cpf = sc.nextLong();
        sc.nextLine();
        System.out.println("Digite a senha: ");
        String senha = sc.nextLine();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setSenha(senha);
        banco.salvarPessoa(pessoa);
        System.out.println("pessoa atualizado ");
    }
    public static void inserirPessoaMain(){
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o cpf: ");
        Long cpf = sc.nextLong();
        sc.nextLine();
        System.out.println("Digite a senha: ");
        String senha = sc.nextLine();
        banco.salvarPessoa(new Pessoa(cpf, nome, senha));
    }
    public static void deletarPessoaMain(){
        banco.removerPessoa(pegarEvalidarIdPessoa());
        System.out.println("pessoa deletado");
    }
    public static Pessoa pegarEvalidarIdPessoa(){
        do{

            mostrarPessoasMain();
            System.out.println("Digite um id: ");
            int id = sc.nextInt();
            sc.nextLine();
            try{
                return banco.procurarPessoa(id);
            }catch (RuntimeException e){
                System.out.println("Código inválido tente denovo");
            }
        }while(true);


    }


    //ALIMENTOS
    public static void mostrarAlimentosMain(){
        for(Alimento alimento:banco.procurarAlimentos()){
            System.out.println("ID: "+alimento.getCodigo());
            System.out.println(alimento.toString());
        }
    }
    public static void pesquisarAlimentosMain(){
        System.out.println("alimento procurado -> "+ pegarEvalidarIdAlimento().toString());
    }
    public static void atualizarAlimentosMain(){
        Alimento alimento = pegarEvalidarIdAlimento();
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite a nutricão: ");
        int nutricao = sc.nextInt();
        sc.nextLine();
        alimento.setNome(nome);
        alimento.setNutricao(nutricao);
        banco.salvarAlimento(alimento);
        System.out.println("alimento atualizado ");
    }
    public static void inserirAlimentosMain(){
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite a nutricão: ");
        int nutricao = sc.nextInt();
        sc.nextLine();
        banco.salvarAlimento(new Alimento(nome, nutricao));
    }
    public static void deletarAlimentosMain(){
        banco.removerAlimento(pegarEvalidarIdAlimento());
        System.out.println("alimento deletado");
    }
    public static Alimento pegarEvalidarIdAlimento(){
        do{

            mostrarAlimentosMain();
            System.out.println("Digite um id: ");
            int id = sc.nextInt();
            sc.nextLine();
            try{
                return banco.procurarAlimento(id);
            }catch (RuntimeException e){
                System.out.println("Código inválido tente denovo");
            }
        }while(true);


    }


    //Brincadeira
    public static void mostrarBrincadeirasMain(){
        for(Brincadeira brincadeira:banco.procurarBrincadeiras()){
            System.out.println("ID: "+brincadeira.getCodigo());
            System.out.println(brincadeira.toString());
        }
    }
    public static void pesquisarBrincadeirasMain(){
        System.out.println("brincadeira procurada -> "+ pegarEvalidarIdBrincadeira().toString());
    }
    public static void atualizarBrincadeirasMain(){


        Brincadeira brincadeira = pegarEvalidarIdBrincadeira();
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o cansaco: ");
        int cansaco = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a fome: ");
        int fome = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a sede: ");
        int sede = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a sujeira: ");
        int sujeira = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o divertimento: ");
        int divertimento = sc.nextInt();
        sc.nextLine();
        brincadeira.setNome(nome);
        brincadeira.setCansaco(cansaco);
        brincadeira.setDivertimento(divertimento);
        brincadeira.setSujeira(sujeira);
        brincadeira.setFome(fome);
        brincadeira.setSede(sede);
        banco.salvarBrincadeira(brincadeira);
        System.out.println("brincadeira atualizada ");
    }
    public static void inserirBrincadeirasMain(){
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o cansaco: ");
        int cansaco = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a fome: ");
        int fome = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a sede: ");
        int sede = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a sujeira: ");
        int sujeira = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o divertimento: ");
        int divertimento = sc.nextInt();
        sc.nextLine();
        banco.salvarBrincadeira(new Brincadeira(nome, divertimento, cansaco, fome, sede, sujeira));
    }
    public static void deletarBrincadeirasMain(){
        banco.removerBrincadeira(pegarEvalidarIdBrincadeira());
        System.out.println("brincadeira deletada");
    }
    public static Brincadeira pegarEvalidarIdBrincadeira(){
        do{
            mostrarBrincadeirasMain();
            System.out.println("Digite um id: ");
            int id = sc.nextInt();
            sc.nextLine();
            try{
                return banco.procurarBrincadeira(id);
            }catch (RuntimeException e){
                System.out.println("Código inválido tente denovo");
            }
        }while(true);


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
                    banco.mudarDadosPet(usuarioLogado.getPet());

                    break;
                case 3:
                    usuarioLogado.acordarPet();
                    avaliarPetLogado();
                    banco.mudarDadosPet(usuarioLogado.getPet());
                    break;
                case 4:
                    usuarioLogado.darAguaParaPet();
                    avaliarPetLogado();
                    banco.mudarDadosPet(usuarioLogado.getPet());

                    break;
                case 5:
                    Alimento alimento = pegarEvalidarIdAlimento();
                    usuarioLogado.alimentarPet(alimento);
                    avaliarPetLogado();
                    banco.mudarDadosPet(usuarioLogado.getPet());

                    break;
                case 6:
                    usuarioLogado.levarPetParaFazerNecessidades();
                    avaliarPetLogado();
                    banco.mudarDadosPet(usuarioLogado.getPet());

                    break;
                case 7:
                    Brincadeira brincadeira = pegarEvalidarIdBrincadeira();
                    usuarioLogado.brincarComPet(brincadeira);
                    banco.mudarDadosPet(usuarioLogado.getPet());

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
        banco.trocarPet(usuarioLogado, banco.procurarPet(codigo));

        System.out.println("Pet adotado!");
    }
    public static void avaliarPetLogado(){
        System.out.println(usuarioLogado.avaliarPet());
    }
    public static void mostrarBrincadeiras(){
        for(Brincadeira brincadeira: Banco.procurarBrincadeiras()){
            System.out.println(brincadeira.toString());
        }
    }
    public static void mostrarAlimentos(){
        for(Alimento alimentos: Banco.procurarAlimentos()){
            System.out.println(alimentos.toString());
        }
    }

}