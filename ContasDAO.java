package com.contas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContasDAO extends Conexao{
    //CRUD
    //CREATE - SalvarContas
    //READ - exibirContas
    //UPDATE - atualizarContas
    //DELETE -  apagarRegistro

    public void salvarContas(Contas a) throws SQLException, ClassNotFoundException{

       
        Connection conectar = null;
        PreparedStatement pstm = null;
        String sql = "insert into contas (descricaoConta, precoConta) values (?,?)";

        try {
            //criar conexao com banco de dados;
            conectar = Conexao.abrirConexao();
            pstm = conectar.prepareStatement(sql);
            //exucutar a query;
            pstm.setString(1, a.getDescricaoConta());
            pstm.setDouble(2, a.getprecoConta());
            pstm.execute();
            System.out.println("contato salvo com sucesso!");

        } catch (SQLException e) {
           e.printStackTrace();
        } 
        finally{
            //fechar conexão
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conectar != null){
                    conectar.close();
                }
            } catch (Exception o){
                o.printStackTrace();
            }
        }
    }
    
    public static List<Contas> getContas(){
        String sql = "select * from contas";

        List<Contas> exibirContas = new ArrayList<Contas>();

        Connection conectar = null;
        PreparedStatement pstm = null;
        //vai recuperar os dados do banco
        ResultSet guardar = null;

        try{
            conectar = Conexao.abrirConexao();
            pstm = conectar.prepareStatement(sql);

            guardar = pstm.executeQuery();
            //vai percorrer o banco enquanto tiver informações
            while(guardar.next()){
                Contas recebe = new Contas();

                    //recuperar ID
                    recebe.setIdConta(guardar.getInt("idconta"));
                    recebe.setDescricaoConta(guardar.getString("descricaoConta"));
                    recebe.setprecoConta(guardar.getDouble("precoConta"));
                
                    exibirContas.add(recebe);
            }
        }catch(Exception b){
            b.printStackTrace();
        }finally{
            try{
                if(guardar!= null){
                    guardar.close();
                }
                if(guardar!=null){
                    pstm.close();
                }
                if(conectar!=null){
                    conectar.close();
                }
            }catch(Exception c){
                c.printStackTrace();
            }
           
        }
        return exibirContas;
    }

    public static void atualizarContas(Contas novaConta){
        String sql = "update contas set descricaoConta = ?, precoConta = ?" + "where idconta = ?";
        Connection conectar = null;
        PreparedStatement pstm = null;

            try{
                conectar = ContasDAO.abrirConexao();

                pstm = conectar.prepareStatement(sql);

                //adicionar novos valores
                pstm.setString(1, novaConta.getDescricaoConta());
                pstm.setDouble(2, novaConta.getprecoConta());
                //qual o id do registro que deseja atualizar?
                pstm.setInt(3, novaConta.getIdConta());

                pstm.execute();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if(pstm!=null){
                        pstm.close();
                    }
                    if(conectar!=null){
                        conectar.close();
                    }
                }catch(Exception f){
                    f.printStackTrace();
                }
            }
    }
   
    public void apagarRegistro(int idRegistro){
        String sql = "delete from contas where idconta = ?";

        Connection conectar = null;
        PreparedStatement pstm = null;

        try{
            conectar = ContasDAO.abrirConexao();
            pstm = conectar.prepareStatement(sql);

            pstm.setInt(1, idRegistro);

            pstm.execute();
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conectar!=null){
                    conectar.close();
                }
            }catch(Exception f){
                f.printStackTrace();
            }
        }
    }
}
