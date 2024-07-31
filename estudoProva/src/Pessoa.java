public class Pessoa {
    long cpf;
    String nome;
    String senha;
    Pet pet;

    Pessoa(long cpf, String nome, String senha){
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
    public void botaPetParaDormir(){
        this.pet.dormir();
    }
    public void acordarPet(){
        this.pet.acordar();
    }
    public void adotarPet(Pet pet){
        this.pet = pet;
    }
    public void darAguaParaPet(){
        this.pet.beberAgua();
    }
//    public void brincarComPet(Brincadeira brincadeira){
//        this.pet.brincar(brincadeira);
//    }
//    public void alimentarPet(Alimento alimento){
//        this.pet.comer(alimento);
//    }
    public void levarPetParaFazerNecessidades(){
        this.pet.fazerNecessidade();
    }
    public void limparPet(){
        this.pet.limpar();
    }
    public String avaliarPet(){
        if(this.pet==null){
            return "Pet não existente cara!!";
        }else{
            return pet.toString();
        }
    }
}
