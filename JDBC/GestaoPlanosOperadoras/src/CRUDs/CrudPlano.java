package CRUDs;

import Classes.*;
import DB.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudPlano {
    //classe responsável pelo crud do plano


    public static Plano cadastro(Plano plano){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO plano(operadora, nome, quantidade_dados, quantidade_dados_bonus, beneficios, valor)
                    VALUES(?, ?, ?, ?, ?, ?);
                    """, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, plano.getOperadora());
            ps.setString(2, plano.getNome());
            ps.setDouble(3, plano.getQuantidade_dados());
            ps.setDouble(4, plano.getQuantidade_dados_bonus());
            ps.setString(5, plano.getBeneficios());
            ps.setDouble(6, plano.getValor());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()){
                plano.setId(rs.getInt(1));
                return plano;
            }

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static Plano consultaIndividual(int id){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM plano WHERE id = ?
                    """);
            ps.setDouble(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String operadora = rs.getString("operadora");
                String nome = rs.getString("nome");
                double quantidade_dados = rs.getDouble("quantidade_dados");
                double quantidade_dados_bonus = rs.getDouble("quantidade_dados_bonus");
                String beneficios = rs.getString("beneficios");
                double valor = rs.getDouble("valor");
                return new Plano(id, operadora, nome, quantidade_dados, quantidade_dados_bonus, beneficios, valor);
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static List<Plano> consulta(){
        List<Plano> lista = new ArrayList<>();
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM plano;
                    """);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String operadora = rs.getString("operadora");
                String nome = rs.getString("nome");
                double quantidade_dados = rs.getDouble("quantidade_dados");
                double quantidade_dados_bonus = rs.getDouble("quantidade_dados_bonus");
                String beneficios = rs.getString("beneficios");
                double valor = rs.getDouble("valor");
                lista.add(new Plano(id, operadora, nome, quantidade_dados, quantidade_dados_bonus, beneficios, valor));
            }


            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static List<Plano> consultaOperadora(String operadoraBusca){
        List<Plano> lista = new ArrayList<>();
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM plano WHERE operadora = ?
                    """);
            ps.setString(1, operadoraBusca);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String operadora = rs.getString("operadora");
                String nome = rs.getString("nome");
                double quantidade_dados = rs.getDouble("quantidade_dados");
                double quantidade_dados_bonus = rs.getDouble("quantidade_dados_bonus");
                String beneficios = rs.getString("beneficios");
                double valor = rs.getDouble("valor");
                lista.add(new Plano(id, operadora, nome, quantidade_dados, quantidade_dados_bonus, beneficios, valor));
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void atualizacao(Plano plano){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE plano 
                    SET operadora = ?,
                    nome = ?,
                    quantidade_dados = ?,
                    quantidade_dados_bonus = ?,
                    beneficios = ?,
                    valor = ?
                    WHERE id = ?;
                    """);
            ps.setString(1, plano.getOperadora());
            ps.setString(2, plano.getNome());
            ps.setDouble(3, plano.getQuantidade_dados());
            ps.setDouble(4, plano.getQuantidade_dados_bonus());
            ps.setString(5, plano.getBeneficios());
            ps.setDouble(6, plano.getValor());
            ps.setInt(7, plano.getId());
            if(ps.executeUpdate()>0){
                return;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void remocao(int id){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM plano WHERE ID = ?
                    """);
            ps.setInt(1, id);

            if(ps.executeUpdate()>0){
                return;
            }

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void adicionarServico(Plano plano, ServicoAdicional servicoAdicional){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO plano_servico(id_plano, id_servico) 
                    VALUES(?, ?)""");
            ps.setInt(1, plano.getId());
            ps.setInt(2, servicoAdicional.getId());

            CrudPlano.checarConexaoPlanoServico(plano, servicoAdicional);


            if(ps.executeUpdate()>0){
                return;
            }

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void removerServico(Plano plano, ServicoAdicional servicoAdicional){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM plano_servico WHERE id_plano = ? && id_servico = ?; 
                    """);
            ps.setInt(1, plano.getId());
            ps.setInt(2, servicoAdicional.getId());


            if(ps.executeUpdate()>0){
                return;
            }

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static void checarConexaoPlanoServico(Plano plano, ServicoAdicional servicoAdicional){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM plano_servico WHERE id_plano = ? && id_servico = ?""");
            ps.setInt(1, plano.getId());
            ps.setInt(2, servicoAdicional.getId());

            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                return;
            }

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();

    }

    public static List<ServicoAdicional> consultaServicosAdicionaisPlano(Plano plano){
        List<ServicoAdicional> lista = new ArrayList<>();
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM plano_servico WHERE id_plano = ?""");


            ps.setInt(1, plano.getId());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lista.add(CrudServicoAdicional.consultaId(rs.getInt("id_servico")));

            }
            return lista;

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static void associarContratoPlano(Contrato contrato){

        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO contrato(id_plano, termos, data_inicio, data_fim)
                    VALUES(?, ?, ?, ?);""");

            ps.setInt(1, contrato.getPlano().getId());
            ps.setString(2, contrato.getTermos());
            ps.setString(3, contrato.getData_inicio());
            ps.setString(4, contrato.getData_fim());


            if(ps.executeUpdate()>0){
                return;

            }

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static Contrato buscarContratoPlano(Plano planoBusca){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM contrato WHERE id_plano = ?;""");

            ps.setInt(1, planoBusca.getId());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                Plano plano = CrudPlano.consultaIndividual(rs.getInt("id_plano"));
                String termos = rs.getString("termos");
                String data_inicio = rs.getString("data_inicio");
                String data_fim = rs.getString("data_fim");
                return new Contrato(id, plano, termos, data_inicio, data_fim);
            }

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static List<Cliente> clientesEmUmPlano(Plano planoBusca){
        List<Cliente> lista = new ArrayList<>();
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM cliente WHERE id_plano = ?
                    """);
            ps.setInt(1, planoBusca.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                Plano plano = CrudPlano.consultaIndividual(rs.getInt("id"));
                lista.add(new Cliente(id, nome, email, telefone, plano));
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

}


