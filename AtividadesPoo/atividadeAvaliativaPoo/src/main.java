import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Produto mistoQuente = new Lanche("misto quente queijo e presunto", 12.9, 500);
        Produto pastelDeCarne = new Lanche("pastel recheado com carne", 10.9, 400);
        Produto sucoMorango = new Bebida("suco sabor Morango", 7.9, 300);
        Produto sucoLaranja = new Bebida("suco sabor Laranja", 7.9, 300);

        Combo lancheCompleto = new Combo("Possui misto quente e suco de morango", 19.9);
        lancheCompleto.adicionarProdutos(mistoQuente);
        lancheCompleto.adicionarProdutos(sucoMorango);

        Combo fomeDemais = new Combo("Possui misto quente e pastel de carne", 22.9);
        fomeDemais.adicionarProdutos(mistoQuente);
        fomeDemais.adicionarProdutos(pastelDeCarne);

        GerenciadorDeCardapio cardapio = new GerenciadorDeCardapio();
        cardapio.adicionarProduto(mistoQuente);
        cardapio.adicionarProduto(pastelDeCarne);
        cardapio.adicionarProduto(sucoMorango);
        cardapio.adicionarProduto(sucoLaranja);
        cardapio.adicionarProduto(lancheCompleto);
        cardapio.adicionarProduto(fomeDemais);

        GerenciadoDeClientes listaClientes = new GerenciadoDeClientes();
        Cliente cliente = new Cliente("Márcia", "Bairro tal", "977887788");
        Cliente cliente1 = new Cliente("Matheus", "Bairro aqui", "977887789");
        Cliente cliente2 = new Cliente("Cleber", "Bairro ali", "977887790");
        listaClientes.adicionarCliente(cliente);
        listaClientes.adicionarCliente(cliente1);
        listaClientes.adicionarCliente(cliente2);
        Garcom garcom = new Garcom("joão", "rua do limoeiro", "977667766", 2500);
        System.out.println("<--- SISTEMA DO GARÇOM --->");

        do{
            System.out.println("[ 0 ] mostrar o cardápio\n[ 1 ] fazer um pedido\n[ 2 ] mostrar os pedidos\n[ 3 ] finalizar um pedido\n[ 4 ] mude o status de um pedido\n");
            switch(sc.nextInt()){
                case 0:
                    System.out.println(cardapio.getCardapioString());
                    break;
                case 1:
                    System.out.println(listaClientes.getGerenciadorDeClientesString());
                    System.out.println("Digite o nome do cliente pedindo: ");
                    String nome = sc.next();
                    Cliente oCliente=null;
                    boolean achouCliente = false;
                    do{
                    for(Cliente pessoas:listaClientes.getListaClientes()){
                        if(pessoas.getNome().equals(nome)){
                            oCliente = pessoas;

                            achouCliente=true;
                            break;
                        }
                    }
                        if (achouCliente == false) {

                            System.out.println("não foi encontrado, tente novamente");
                            nome = sc.next();
                        }
                    }while(achouCliente==false);

                    Pedido pedido = new Pedido();
                    garcom.cadastrarPedido(oCliente, pedido);
                    do {
                        System.out.println("Digite o que adicionar [ -1 ] para sair ");
                        System.out.println(cardapio.getCardapioString());
                        System.out.println("Digite o código do produto que quer adicionar: ");
                        int cod = sc.nextInt();
                        boolean achou = false;
                        if(cod==-1){
                            break;
                        }
                        else {
                            do {

                                for (Produto produto : cardapio.getCardapio()) {
                                    if (produto.getCodigo() == cod) {
                                        System.out.println("PRODUTO -> '" + produto.getDescricao() + "' adicionado ao pedido");
                                        achou = true;
                                        garcom.adicionarItemAoPedido(pedido, cardapio.getCardapio().get(cod));
                                    }

                                }
                                if (achou == false) {

                                    System.out.println("não foi encontrado, tente novamente");
                                    cod = sc.nextInt();
                                }
                            } while (achou == false);
                        }



                    }while(true);

                    System.out.println("Pedido Finalizado");
                    break;
                case 2:
                    for(Cliente pessoas:listaClientes.getListaClientes()) {
                        System.out.println(pessoas.getNome());
                        for (Pedido pedidos : pessoas.getPedidos()) {
                            System.out.println("Pedido --->");
                            System.out.println(pedidos.getStatus());
                            System.out.println(pedidos.listarItens());
                            System.out.println("\n");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    for(Cliente pessoas:listaClientes.getListaClientes()) {
                        System.out.println(pessoas.getNome());
                        for (Pedido pedidos : pessoas.getPedidos()) {
                            System.out.println("Pedido --->");
                            System.out.println(pedidos.getStatus());
                            System.out.println(pedidos.listarItens());
                            System.out.println("\n");
                        }
                        System.out.println("\n");
                    }
                    System.out.println("Digite o codigo do produto para dar desconto: ");
                    int cod = sc.nextInt();
                    for (Produto produto : cardapio.getCardapio()) {
                        if (produto.getCodigo() == cod) {
                            System.out.println("Digite o desconto em porcentagem: ");
                            double desconto = sc.nextDouble();

                        }

                    }
                    break;
                case 4:
                    break;
            }
        }while(true);



    }
}
