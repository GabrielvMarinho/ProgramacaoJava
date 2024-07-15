public class Executavel {
    public static void main(String arg[]){

        ItemBiblioteca livro = new Livro("atividades de banco de dados para pessoas inteligentes", 0, 0, "0" ,"0" );

      System.out.println(Biblioteca.buscarItemPorTitulo("atividades de banco de dados para pessoas inteligentes"));
      System.out.println("---------------");
      ItemBiblioteca revista = new Revista("Revista Veja", 0, 0, 0 );
      Biblioteca.listarItens();
      Biblioteca.adicionarItem(livro);
      Biblioteca.atualizarItem(0, revista);
      Biblioteca.listarItens();
    }
}
