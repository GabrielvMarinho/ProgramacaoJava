public class Executavel {
    public static void main(String[] args){


        Item livro1 = new Livro("Harry Potter", 60, 100, 123, "JK Rowing");
        Item livro2 = new Livro("Senhor dos Aneis", 70, 80, 321, "Tolking");
        Item livro3 = new Livro("Dom Casmurro", 10, 10, 654, "Machado de Assis");
        Item livro4 = new Livro("Memórias Póstumas de Bras Cubas", 100, 10, 456, "Machado de Assis");

        Item revista1 = new Revista("Quatro Rodas", 20, 50, 200);
        Item revista2 = new Revista("Recreio", 10, 150, 2);
        Item revista3 = new Revista("Veja", 30, 10, 400);
        Item revista4 = new Revista("Detonado", 10, 9, 1);

        Biblioteca.adicionarItem(livro1);
        Biblioteca.adicionarItem(livro2);
        Biblioteca.adicionarItem(livro3);
        Biblioteca.adicionarItem(livro4);
        Biblioteca.adicionarItem(revista1);
        Biblioteca.adicionarItem(revista2);
        Biblioteca.adicionarItem(revista3);
        Biblioteca.adicionarItem(revista4);

        Biblioteca.listarItens();

        System.out.println(Biblioteca.calcularValorTotalEstoque());

        System.out.println(Biblioteca.buscarItemPorTitulo("Harry Potter"));
        System.out.println(Biblioteca.buscarItemPorTitulo("Recreio"));

        System.out.println(livro1.calcularValorTotalComDesconto(0.1));
        System.out.println(livro2.calcularValorTotalComDesconto(0.1));
        System.out.println(livro3.calcularValorTotalComDesconto(0.1));
        System.out.println(livro4.calcularValorTotalComDesconto(0.1));
        System.out.println(revista1.calcularValorTotalComDesconto(0.1));
        System.out.println(revista2.calcularValorTotalComDesconto(0.1));
        System.out.println(revista3.calcularValorTotalComDesconto(0.1));
        System.out.println(revista4.calcularValorTotalComDesconto(0.1));



//        biblioteca.adicionarItem(null);
    }
}
