import Exceptions.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    static CrudEvento crudEvento = new CrudEvento();
    static CrudParticipante crudParticipante = new CrudParticipante();
    static CrudInscricao crudInscricao = new CrudInscricao();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do{
            pegarEscolha();
        }while(true);
    }
    public static void pegarEscolha(){
        System.out.println("""
                --- EVENTOS ---
                ( 1 ) ADICIONAR 
                ( 2 ) PESQUISAR POR NOME
                ( 3 ) REMOVER 
       
                --- PARTICIPANTES ---
                ( 4 ) ADICIONAR
                ( 5 ) PESQUISAR POR EMAIL
                ( 6 ) REMOVER

                               
                --- INSCRIÇÕES ---
                ( 7 ) MOSTRAR INSCRIÇÕES
                ( 8 ) INSCREVER PARTICIPANTE
                ( 9 ) REMOVER INSCRIÇÃO
                """);
        int escolha = sc.nextInt();

        switch (escolha){
            case 1:
                adicionarEvento();
                break;
            case 2:
                buscarEventoPorNome();
                break;
            case 3:
                removerEvento();
                break;
            case 4:
                adicionarParticipante();
                break;
            case 5:
                buscarParticipantePorEmail();
                break;
            case 6:
                removerParticipante();
                break;
            case 7:
                mostrarTodasInscricoes();
                break;
            case 8:
                inscreverParticipante();
                break;
            case 9:
                removerInscricao();
                break;
        }
    }
    public static void adicionarEvento(){
        try{
            String nome = null;
            String localidade = null;

            do{
                try {
                    System.out.println("Digite o NOME do evento\n");
                    sc.nextLine();
                    nome = sc.nextLine();
                    crudEvento.checarNomeExistente(nome);
                    break;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }while(true);

            do{
                try {
                    System.out.println("Digite a localidade do evento\n");
                    sc.nextLine();
                    localidade = sc.next();
                    break;
                } catch (Exception e) {
                    System.out.println(e);
                }

            }while(true);

            String data = null;
            do{
                try{
                    System.out.println("Digite a data do evento [ formato: 2000-12-31 ]\n");
                    data = sc.next();
                    validarData(data);
                    break;
                }catch (Exception e){
                    System.out.println("Dado inválido");
                }
            }while(true);


            System.out.println("Digite a descricao do evento\n");
            String descricao = sc.next();


            Evento evento = new Evento(nome, localidade, data, descricao);
            crudEvento.adicionarEvento(evento);
        }catch (ErroInsercaoException e){
            e.printStackTrace();
        }
    }
    public static void buscarEventoPorNome(){
        try{
            System.out.println("Digite o nome do evento\n");
            sc.nextLine();
            String nome = sc.nextLine();

            Evento evento = crudEvento.buscarEventoPorNome(nome);
            System.out.println("Evento encontrado: ");
            System.out.println(evento.toString());


        }catch (EventoInexistenteException e){
            System.out.println(e);
        }
    }
    public static void removerEvento(){
        try {
            mostrarTodosEventos();
            System.out.println("Digite o id do evento para deletar");
            int id = sc.nextInt();
            crudEvento.removerEvento(id);
            System.out.println("Deletado com sucesso");
        }catch (EventoInexistenteException e){
            System.out.println(e);
        }
    }
    public static void adicionarParticipante(){
        try{
            String nome=null;
            do{

                try{
                    System.out.println("Digite o nome\n");
                    sc.nextLine();
                    nome = sc.nextLine();
                    crudParticipante.checarNomeExistente(nome);
                    break;
                }catch (Exception e){
                    System.out.println(e);
                }
            }while(true);


            String email=null;
            do{
                try{
                    System.out.println("Digite o email\n");
                    email = sc.next();
                    crudParticipante.checarEmailExistente(email);
                    break;
                }catch (Exception e){
                    System.out.println(e);
                }

            }while(true);

            crudParticipante.adicionarParticipante(new Participante(nome, email));
            System.out.println("Participante adicionado!");
        }catch (ErroInsercaoException e){
            System.out.println(e);
        }
    }
    public static void buscarParticipantePorEmail(){
        try{
            System.out.println("Digite um email para procura\n");
            String email = sc.next();

            Participante participante = crudParticipante.buscarParticipantePorEmail(email);
            System.out.println("Participante encontrado: ");
            System.out.println(participante.toString());
        }catch (ParticipanteInexistenteException e){
            System.out.println(e);
        }
    }
    public static void removerParticipante(){
        try {
            mostrarTodosParticipantes();
            System.out.println("Digite o id do participante para deletar");
            int id = sc.nextInt();
            crudParticipante.removerParticipante(id);
            System.out.println("Deletado com sucesso");
        }catch (ParticipanteInexistenteException e){
            System.out.println(e);
        }
    }
    public static void inscreverParticipante(){
        try{
            mostrarTodosParticipantes();
            System.out.println("Digite o id de um dos participantes\n");
            int idPa = sc.nextInt();

            mostrarTodosEventos();
            System.out.println("Digite o id de um dos eventos para inscreve-lo\n");
            int idEv = sc.nextInt();
            crudInscricao.inscreverParticipante(idEv, idPa);
            System.out.println("Participante inscrito no evento");
        }catch (IdInvalidoException e){
            System.out.println(e);
        }
    }
    public static void removerInscricao(){
        try{
            mostrarTodasInscricoes();
            System.out.println("Digite o id da inscrição para deletar\n");
            int id = sc.nextInt();
            crudInscricao.removerInscricao(id);
            System.out.println("Inscrição deletada!");
        }catch (IdInvalidoException e){
            System.out.println(e);
        }
    }
    public static void mostrarTodosEventos() {
        for(Evento evento:crudEvento.buscarTodosEventos()){
            System.out.println(evento.toStringId());
        }
    }
    public static void mostrarTodosParticipantes() {
        for(Participante participante:crudParticipante.buscarTodosParticipantes()){
            System.out.println(participante.toStringId());
        }
    }
    public static void mostrarTodasInscricoes(){
        for(Inscricao inscricao:CrudInscricao.buscarTodasInscrições()){
            System.out.println(inscricao.toString());
        }


    }
    public static boolean validarData(String date) throws DataInvalidaException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            throw new DataInvalidaException();
        }
    }
}