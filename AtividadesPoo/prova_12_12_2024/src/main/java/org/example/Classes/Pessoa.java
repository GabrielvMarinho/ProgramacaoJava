package org.example.Classes;

public class Pessoa {
    long cpf;
    String nome;
    String senha;
    Pet pet;

    public Pessoa(long cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }
    public boolean temPet(){
        if(this.pet==null){
            return false;
        }
        return true;
    }
    public long getCpf() {
        return cpf;
    }
    public String getSenha() {
        return senha;
    }
    public void botaPetParaDormir(){
        if(!this.temPet())
            return;
        this.pet.dormir();
    }
    public void acordarPet(){
        if(!this.temPet())
            return;
        this.pet.acordar();
    }

    public void adotarPet(Pet pet){
        this.pet = pet;
    }

    public void darAguaParaPet(){
        if(!this.temPet())
            return;
        this.pet.beberAgua();
    }
    public void brincarComPet(Brincadeira brincadeira){
        if(!this.temPet())
            return;
        this.pet.brincar(brincadeira);
    }
    public void alimentarPet(Alimento alimento){
        if(!this.temPet())
            return;
        this.pet.comer(alimento);
    }
    public void levarPetParaFazerNecessidades(){
        if(!this.temPet())
            return;
        this.pet.fazerNecessidades();
    }
    public void limparPet(){
        if(!this.temPet())
            return;
        this.pet.limpar();
    }
    public String avaliarPet(){
        if(!this.temPet())
            return "Sem pet";
        return this.pet.toString();
    }

    @Override
    public String toString() {
        if(!this.temPet()) {
            return "CPF: " + cpf+
                    "\nNome: " + nome +
                    "\nPet: Sem pet";
        }
        return "CPF: " +cpf+
                "\nNome: " + nome +
                "\nPet: "+pet.toString();

    }
}
