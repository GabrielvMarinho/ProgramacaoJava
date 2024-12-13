package org.example.Classes;

import org.example.CRUDs.CrudAlimento;
import org.example.CRUDs.CrudBrincadeira;
import org.example.CRUDs.CrudPessoa;
import org.example.CRUDs.CrudPet;

import java.util.ArrayList;

public class Banco {
    static CrudPet crudPet = new CrudPet();
    static CrudPessoa crudPessoa = new CrudPessoa();
    static CrudAlimento crudAlimento = new CrudAlimento();
    static CrudBrincadeira crudBrincadeira = new CrudBrincadeira();

    public Pet salvarPet(Pet pet) {
        if (pet.getCodigo() != 0) {
            crudPet.update(pet);
            return null;
        } else {
            return crudPet.create(pet);
        }
    }
    public void mudarDadosPet(Pet pet){
        crudPet.updateDados(pet);
    }

    public static void removerPet(Pet pet) {
        crudPet.delete(pet.getCodigo());
    }

    public static Pet procurarPet(int codigo) {
        return crudPet.readOne(codigo);
    }

    public static ArrayList<Pet> procurarPets() {
        return crudPet.readAll();
    }


    public Pessoa salvarPessoa(Pessoa pessoa) {
        if (pessoa.getCodigo() != 0) {
            crudPessoa.update(pessoa);
            return null;
        } else {
            return crudPessoa.create(pessoa);
        }
    }

    public static void removerPessoa(Pessoa pessoa) {
        crudPessoa.delete(pessoa.getCodigo());
    }

    public static Pessoa procurarPessoa(int codigo) {
        return crudPessoa.readOne(codigo);
    }

    public static ArrayList<Pessoa> procurarPessoas() {
        return crudPessoa.readAll();
    }

    public static void trocarPet(Pessoa pessoa, Pet pet) {
        crudPessoa.trocarPet(pessoa, pet);
    }


    public Alimento salvarAlimento(Alimento alimento) {
        if (alimento.getCodigo() != 0) {
            crudAlimento.update(alimento);
            return null;
        } else {
            return crudAlimento.create(alimento);
        }
    }

    public static void removerAlimento(Alimento alimento) {
        crudAlimento.delete(alimento.getCodigo());
    }

    public static Alimento procurarAlimento(int codigo) {
        return crudAlimento.readOne(codigo);
    }

    public static ArrayList<Alimento> procurarAlimentos() {
        return crudAlimento.readAll();
    }


    public Brincadeira salvarBrincadeira(Brincadeira brincadeira) {
        if (brincadeira.getCodigo() != 0) {
            crudBrincadeira.update(brincadeira);
            return null;
        } else {
            return crudBrincadeira.create(brincadeira);
        }
    }

    public static void removerBrincadeira(Brincadeira brincadeira) {
        crudBrincadeira.delete(brincadeira.getCodigo());
    }

    public static Brincadeira procurarBrincadeira(int codigo) {
        return crudBrincadeira.readOne(codigo);
    }

    public static ArrayList<Brincadeira> procurarBrincadeiras() {
        return crudBrincadeira.readAll();
    }


    public static Pessoa login(long cpf, String senha) {
        for (Pessoa pessoa : crudPessoa.readAll()) {
            if (pessoa.getCpf() == cpf && pessoa.getSenha().equals(senha)) {
                return pessoa;
            }
        }
        return null;
    }
}
