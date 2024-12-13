package org.example.CRUDs;

import org.example.Classes.Pessoa;
import org.example.Classes.Pet;
import org.example.DB;

import java.sql.*;
import java.util.ArrayList;

public class CrudPessoa {
    static DB db = new DB();
    public Pessoa create(Pessoa pessoa){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO pessoa(nome, senha, cpf)
                     VALUES(?, ?, ?);""", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getSenha());
            ps.setLong(3, pessoa.getCpf());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                pessoa.setCodigo(rs.getInt(1));
                return pessoa;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static ArrayList<Pessoa> readAll(){
        ArrayList<Pessoa> lista = new ArrayList<>();
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM pessoa;""");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                Long cpf = rs.getLong("cpf");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                int idPet = rs.getInt("idPet");
                Pet pet = null;
                if(idPet!=0){
                    pet = CrudPet.readOne(idPet);
                }
                lista.add(new Pessoa(id, cpf, nome, senha, pet));
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static Pessoa readOne(int id){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM Pessoa WHERE id = ?;""");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Long cpf = rs.getLong("cpf");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                int idPet = rs.getInt("idPet");
                Pet pet = null;
                if(idPet!=0){
                    pet = CrudPet.readOne(idPet);
                }
                return new Pessoa(id, cpf, nome, senha, pet);
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void update(Pessoa pessoa){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE pessoa SET cpf = ?, nome = ?, senha = ? WHERE id = ?;""");
            ps.setLong(1, pessoa.getCpf());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getSenha());
            ps.setInt(4, pessoa.getCodigo());
            ps.execute();

            return;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void trocarPet(Pessoa pessoa, Pet pet){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE pessoa SET idPet= ? WHERE id = ?;""");
            ps.setInt(1, pet.getCodigo());
            ps.setInt(2, pessoa.getCodigo());
            pessoa.setPet(pet);
            ps.execute();
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void delete(int id){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM pessoa WHERE id = ?;""");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                return;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
}
