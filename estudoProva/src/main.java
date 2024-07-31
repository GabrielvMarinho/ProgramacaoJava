public class main {
    public static void main(String args[]){
        Pet pet = new Pet("nome", 123);

        Pessoa pessoa = new Pessoa(123, "nome", "123");

        System.out.println(pessoa.avaliarPet());
        pessoa.adotarPet(pet);
        System.out.println(pessoa.avaliarPet());

    }
}
