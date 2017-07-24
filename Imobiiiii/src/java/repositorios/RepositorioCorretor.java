/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorios;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dados.Conexao;
import negocios.Acesso;
import negocios.Corretor;
import negocios.EnderecoCorretor;
import negocios.TelefoneCorretor;


/**
 *
 * @author Mário
 *
 * Métodos: inserirCorretor,consultarCorretor,alterarCorretor,excluirCorretor,listaCorretores
 */
public class RepositorioCorretor
{

    Conexao conexao = new Conexao();
    Connection c = null;

    public void inserirCorretor(Corretor corretor,EnderecoCorretor enderecoCorretor,TelefoneCorretor telefoneCorretor,Acesso acesso)
    {
        PreparedStatement inserirCorretor = null;        
        PreparedStatement inserirEnderecoCorretor = null;
        PreparedStatement inserirTelefoneCorretor = null;
        PreparedStatement inserirAcesso = null;

        
        PreparedStatement consultaEnderecoCorretor = null;
        PreparedStatement consultaTelefoneCorretor = null;
        PreparedStatement consultaAcesso = null;
        
        ResultSet rsConsultaEnderecoCorretor = null;
        ResultSet rsConsultaTelefoneCorretor = null;
        ResultSet rsConsultaAcesso = null;

         /*
         * 27 -11- 2010  12:32 analizar as consultas do sql e os objetos rsConsulta
         *
         */

        try
        {
            c = conexao.abrirConexao();

            //inserção da senha e login  do Cliente.

 

            //inserção do endereço do Corretor.
           inserirEnderecoCorretor = c.prepareStatement("insert into enderecoCorretor (ruaCorretor,numeroCorretor,complementoCorretor,bairroCorretor,cidadeCorretor) values ('"+enderecoCorretor.getRuaCorretor()+"','"+enderecoCorretor.getNumeroCorretor()+"','"+enderecoCorretor.getComplementoCorretor()+"','"+enderecoCorretor.getBairroCorretor()+"','"+enderecoCorretor.getCidadeCorretor()+"');");
           inserirEnderecoCorretor.executeUpdate();//executa a inserção


           consultaEnderecoCorretor = c.prepareStatement("select idEnderecoCorretor from enderecoCorretor where ruaCorretor = '" + enderecoCorretor.getRuaCorretor() + "' and numeroCorretor = '" + enderecoCorretor.getNumeroCorretor() + "' and complementoCorretor = '" + enderecoCorretor.getComplementoCorretor() + "' and bairroCorretor = '" + enderecoCorretor.getBairroCorretor() + "' and cidadeCorretor = '" + enderecoCorretor.getCidadeCorretor() + "';");
           rsConsultaEnderecoCorretor = consultaEnderecoCorretor.executeQuery();
           rsConsultaEnderecoCorretor.next();

           //recebe o resultado da consulta do endereço do corretor,será usado em corretor
           int idEnderecoCorretor = rsConsultaEnderecoCorretor.getInt("idEnderecoCorretor");


           //inserção do telefone do cliente
           inserirTelefoneCorretor = c.prepareStatement("insert into telefoneCorretor (tipoTelefoneCorretor,numeroTelefoneCorretor,dddTelefoneCorretor) values "
                   + "('"+telefoneCorretor.getTipoTelefoneCorretor()+"',"+telefoneCorretor.getNumeroTelefoneCorretor()+","+telefoneCorretor.getDddTelefoneCorretor()+");");
           inserirTelefoneCorretor.executeUpdate();//executa a inseção

           consultaTelefoneCorretor = c.prepareStatement("select idTelefoneCorretor from TelefoneCorretor where tipoTelefoneCorretor = '" + telefoneCorretor.getTipoTelefoneCorretor() + "' and numeroTelefoneCorretor = " + telefoneCorretor.getNumeroTelefoneCorretor() + " and dddTelefoneCorretor = " + telefoneCorretor.getDddTelefoneCorretor() +" ;");
           rsConsultaTelefoneCorretor = consultaTelefoneCorretor.executeQuery();
           rsConsultaTelefoneCorretor.next();

           //recebe o resultado da consulta do endereço do cliente,será usado em cliente
           int idTelefoneCorretor = rsConsultaTelefoneCorretor.getInt("idTelefoneCorretor");


           inserirAcesso = c.prepareStatement("insert into acesso(login, senha,tipodeusuario) values ('"+acesso.getLogin()+"','"+acesso.getSenha()+"','"+acesso.getTipoDeUsuario()+"');");
           inserirAcesso.executeUpdate();

           consultaAcesso = c.prepareStatement("select idAcesso from acesso where login = '"+acesso.getLogin()+"' and senha ='"+acesso.getSenha()+"' and tipodeusuario = '"+acesso.getTipoDeUsuario()+"';");
           rsConsultaAcesso = consultaAcesso.executeQuery();
           rsConsultaAcesso.next();


           // armazena em idAcesso o resultado da consulta
           int idAcesso = rsConsultaAcesso.getInt("idAcesso");


           //inserção do Cliente
           inserirCorretor = c.prepareStatement("insert into corretor (nomeCorretor,cpfCorretor,rgCorretor,emailCorretor,idEnderecoCorretor,idTelefoneCorretor,idAcesso) values('"+corretor.getNomeCorretor()+"','"+corretor.getCpfCorretor()+"','"+corretor.getRgCorretor()+"','"+corretor.getEmailCorretor()+"',"+idEnderecoCorretor+","+idTelefoneCorretor+","+idAcesso+");");

           inserirCorretor.executeUpdate();//executa a inserção


           c = conexao.fecharConexao();//encerra a conexão com o servidor
                        
                        inserirCorretor.close();
                        inserirEnderecoCorretor.close();
                        inserirTelefoneCorretor.close();
                        inserirAcesso.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public Corretor consultarCorretor(String cpfCorretor)
    {
        PreparedStatement consultarCorretor = null;
        ResultSet rsConsultarCorretor = null;
        Corretor corretor = null;



        PreparedStatement consultarEnderecoCorretor = null;
        ResultSet rsConsultarEnderecoCorretor = null;
        EnderecoCorretor enderecoCorretor = null;

        PreparedStatement consultarTelefoneCorretor = null;
        ResultSet rsConsultarTelefoneCorretor = null;
        TelefoneCorretor telefoneCorretor = null;

        PreparedStatement consultarAcesso = null;
        ResultSet rsConsultarAcesso = null;
        Acesso acesso = null;



        try
        {
            c = conexao.abrirConexao();

            consultarCorretor = c.prepareStatement("select * from corretor where cpfCorretor ='"+cpfCorretor+"';");
            rsConsultarCorretor = consultarCorretor.executeQuery();
            rsConsultarCorretor.next();
             
             
             
            String nomeCorretor = rsConsultarCorretor.getString("nomeCorretor");
            String rgCorretor = rsConsultarCorretor.getString("rgCorretor");
            String emailCorretor = rsConsultarCorretor.getString("emailCorretor");

             
          
            int idAcesso = rsConsultarCorretor.getInt("idAcesso");
            consultarAcesso = c.prepareStatement("select * from acesso where idAcesso = "+idAcesso+";");
            rsConsultarAcesso = consultarAcesso.executeQuery();
            rsConsultarAcesso.next();
             
            String login = rsConsultarAcesso.getString("login");
            String senha = rsConsultarAcesso.getString("senha");
            String tipoDeUsuario = rsConsultarAcesso.getString("tipoDeUsuario");

            acesso = new Acesso(login, senha, tipoDeUsuario);
            
            //consulta o endereco do Cliente e retorna o id do endereco para o corretor
            int idEnderecoCorretor = rsConsultarCorretor.getInt("idEnderecoCorretor");
            consultarEnderecoCorretor = c.prepareStatement("select * from enderecoCorretor where idEnderecoCorretor = " + idEnderecoCorretor + ";");
            rsConsultarEnderecoCorretor = consultarEnderecoCorretor.executeQuery();
            rsConsultarEnderecoCorretor.next();

            String ruaCorretor = rsConsultarEnderecoCorretor.getString("ruaCorretor");
            String numeroCorretor = rsConsultarEnderecoCorretor.getString("numeroCorretor");
            String complementoCorretor = rsConsultarEnderecoCorretor.getString("complementoCorretor");
            String bairroCorretor = rsConsultarEnderecoCorretor.getString("bairroCorretor");
            String cidadeCorretor =rsConsultarEnderecoCorretor.getString("cidadeCorretor");

            enderecoCorretor = new EnderecoCorretor(ruaCorretor,numeroCorretor,complementoCorretor,bairroCorretor,cidadeCorretor);

            //consulta o telefone do corretor  retorna o id do telefone para o corretor
            int idTelefoneCorretor = rsConsultarCorretor.getInt("idTelefoneCorretor");
            consultarTelefoneCorretor = c.prepareStatement("select * from TelefoneCorretor where idTelefoneCorretor = " + idTelefoneCorretor + ";");
            rsConsultarTelefoneCorretor = consultarTelefoneCorretor.executeQuery();
            rsConsultarTelefoneCorretor.next();

            String tipoTelefoneCorretor = rsConsultarTelefoneCorretor.getString("tipoTelefoneCorretor");
            int dddTelefoneCorretor = rsConsultarTelefoneCorretor.getInt("dddTelefoneCorretor");
            int numeroTelefoneCorretor = rsConsultarTelefoneCorretor.getInt("numeroTelefoneCorretor");

            telefoneCorretor = new TelefoneCorretor(tipoTelefoneCorretor, dddTelefoneCorretor, numeroTelefoneCorretor);

            corretor = new Corretor(nomeCorretor, cpfCorretor, rgCorretor, emailCorretor, enderecoCorretor, telefoneCorretor, acesso);

           

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return corretor;

    }

    public void alterarCorretor(String cpfCorretorAnterior, Corretor novoCorretor, Acesso acesso,EnderecoCorretor enderecoCorretor,TelefoneCorretor telefoneCorretor)
    {
        PreparedStatement alterarCorretor = null;
        PreparedStatement alterarAcesso = null;
        PreparedStatement alterarEnderecoCorretor = null;
        PreparedStatement alterarTelefoneCorretor = null;
        PreparedStatement consultarCorretor = null;
        ResultSet rsConsultaCorretor = null;

        try
        {
            c = conexao.abrirConexao();

            consultarCorretor = c.prepareStatement("select * from corretor where cpfCorretor = '" + cpfCorretorAnterior + "';");
            rsConsultaCorretor = consultarCorretor.executeQuery();
            rsConsultaCorretor.next();

            int idAcesso = rsConsultaCorretor.getInt("idAcesso");
            alterarAcesso = c.prepareStatement("update acesso set login ='"+acesso.getLogin()+"',senha = '"+acesso.getSenha()+"',tipodeusuario = '"+acesso.getTipoDeUsuario()+"' where idAcesso ="+idAcesso+";");


            int idEnderecoCorretor = rsConsultaCorretor.getInt("idEnderecoCorretor");
            alterarEnderecoCorretor = c.prepareStatement("update enderecoCorretor set ruaCorretor = '" + enderecoCorretor.getRuaCorretor() + "', numeroCorretor = '" + enderecoCorretor.getNumeroCorretor() + "', complementoCorretor = '" + enderecoCorretor.getComplementoCorretor() + "', bairroCorretor = '" + enderecoCorretor.getBairroCorretor() + "', cidadeCorretor = '" + enderecoCorretor.getCidadeCorretor() + "' where idEnderecoCorretor = " + idEnderecoCorretor + ";");
            alterarEnderecoCorretor.executeUpdate();

            int idTelefoneCorretor = rsConsultaCorretor.getInt("idTelefoneCorretor");
            alterarTelefoneCorretor = c.prepareStatement("update telefoneCorretor set tipoTelefoneCorretor = '" + telefoneCorretor.getTipoTelefoneCorretor() + "', dddTelefoneCorretor = " + telefoneCorretor.getDddTelefoneCorretor() + ", numeroTelefoneCorretor = '" + telefoneCorretor.getNumeroTelefoneCorretor() + "' where idTelefoneCorretor = " + idTelefoneCorretor + ";");
            alterarTelefoneCorretor.executeUpdate();

            alterarCorretor = c.prepareStatement("update Corretor set nomeCliente = '" + novoCorretor.getNomeCorretor() + "', cpfCorretor = '" + novoCorretor.getCpfCorretor() + "', rgCorretor = '" + novoCorretor.getRgCorretor() + "', emailCorretor = '"+novoCorretor.getEmailCorretor()+"' where cpfCorretor = '" + cpfCorretorAnterior + "';");
            alterarCorretor.executeUpdate();


            c = conexao.fecharConexao();
            alterarAcesso.close();
            alterarEnderecoCorretor.close();
            alterarTelefoneCorretor.close();
            alterarCorretor.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public void excluirCorretor(String cpfCorretor)
    {
        PreparedStatement excluirCorretor = null;
        ResultSet rsConsultaCorretor = null;
        try
        {
            c = conexao.abrirConexao();
       /*   Cliente corretor = consultarCorretor(cpfCliente);
            excluirCorretor = c.prepareStatement("select * from corretor where cpfCliente = '"+corretor.getCpfCliente()+"';");
            rsConsultaCorretor = excluirCorretor.executeQuery();
            rsConsultaCorretor.next();*/


            excluirCorretor = c.prepareStatement("delete from Corretor where cpfCorretor = '" + cpfCorretor + "';");
            excluirCorretor.executeUpdate();

            int idAcesso = rsConsultaCorretor.getInt("idAcesso");
            excluirCorretor = c.prepareStatement("delete from acesso where idAcesso = "+idAcesso+";");
            excluirCorretor.executeUpdate();


            int idEnderecoCorretor = rsConsultaCorretor.getInt("idEnderecoCorretor");

            excluirCorretor = c.prepareStatement("delete from enderecoCliente where idEnderecoCliente = " + idEnderecoCorretor + ";");
            excluirCorretor.executeUpdate();

            int idTelefoneCorretor = rsConsultaCorretor.getInt("idtelefoneCorretor");

            excluirCorretor = c.prepareStatement("delete from telefoneCorretor where idTelefoneCorretor = "+idTelefoneCorretor+";");
            excluirCorretor.executeUpdate();
            c = conexao.fecharConexao();
            excluirCorretor.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<Corretor> listaCorretores()
    {
        PreparedStatement consultarCorretor = null;
        ResultSet rsConsultaCorretor = null;

            PreparedStatement consultaEnderecoCorretor = null;
            ResultSet rsConsultaEnderecoCorretor = null;

                PreparedStatement consultaTelefoneCorretor = null;
                ResultSet rsConsultaTelefoneCorretor = null;

                    PreparedStatement consultaAcesso = null;
                    ResultSet rsConsultaAcesso = null;


        Corretor corretor = null;
            EnderecoCorretor enderecoCorretor = null;
                TelefoneCorretor telefoneCorretor = null;
                    Acesso acesso = null;



        ArrayList<Corretor> corretores = new ArrayList<Corretor>();


        try
        {
            c = conexao.abrirConexao();
            consultarCorretor = c.prepareStatement("select * from Corretor order by nomeCorretor asc;");
            rsConsultaCorretor = consultarCorretor.executeQuery();

            while(rsConsultaCorretor.next())
            {

            String nomeCorretor = rsConsultaCorretor.getString("nomeCorretor");
            String cpfCorretor = rsConsultaCorretor.getString("CpfCorretor");
            String rgCorretor = rsConsultaCorretor.getString("rgCorretor");
            String emailCorretor = rsConsultaCorretor.getString("EmailCorretor");

            int idEnderecoCorretor = rsConsultaCorretor.getInt("idEnderecoCorretor");//id do endereco e do telefone do Corretor retornado na consulta
            int idTelefoneCorretor = rsConsultaCorretor.getInt("idTelefoneCorretor");
            int idAcesso = rsConsultaCorretor.getInt("idAcesso");

            consultaEnderecoCorretor = c.prepareStatement("select * from enderecoCorretor where idEnderecoCorretor = " + idEnderecoCorretor + ";");
            rsConsultaEnderecoCorretor = consultaEnderecoCorretor.executeQuery();
            rsConsultaEnderecoCorretor.next();
                String ruaCorretor = rsConsultaEnderecoCorretor.getString("ruaCorretor");
                String numeroCorretor = rsConsultaEnderecoCorretor.getString("numeroCorretor");
                String complementoCorretor = rsConsultaEnderecoCorretor .getString("complementoCorretor");
                String bairroCorretor = rsConsultaEnderecoCorretor.getString("bairroCorretor");
                String cidadeCorretor = rsConsultaEnderecoCorretor.getString("cidadeCorretor");

                consultaTelefoneCorretor = c.prepareStatement("select * from telefoneCorretor where idTelefoneCorretor = " + idTelefoneCorretor + ";");
                rsConsultaTelefoneCorretor = consultaTelefoneCorretor.executeQuery();
                rsConsultaTelefoneCorretor.next();
                    String tipoTelefoneCorretor = rsConsultaTelefoneCorretor.getString("tipoTelefoneCorretor");
                    int dddtelefoneCorretor = rsConsultaTelefoneCorretor.getInt("dddtelefoneCorretor");
                    int numeroTelefoneCorretor = rsConsultaTelefoneCorretor.getInt("numeroTelefoneCorretor");


                            consultaAcesso = c.prepareStatement("select * from acesso where idAcesso = "+idAcesso+";");
                            rsConsultaAcesso = consultaAcesso.executeQuery();
                            rsConsultaAcesso.next();
                                    String login = rsConsultaAcesso.getString("login");
                                    String senha = rsConsultaAcesso.getString("senha");
                                    String tipoDeUsuario = rsConsultaAcesso.getString("tipoDeUsuario");


                     enderecoCorretor = new EnderecoCorretor(ruaCorretor, numeroCorretor, complementoCorretor, bairroCorretor, cidadeCorretor);//vai para Corretor
                        telefoneCorretor =new TelefoneCorretor(tipoTelefoneCorretor, dddtelefoneCorretor, numeroTelefoneCorretor);           //vai para Corretor
                            acesso = new Acesso(login, senha,tipoDeUsuario);
                                corretor = new Corretor(nomeCorretor, cpfCorretor, rgCorretor, emailCorretor, enderecoCorretor, telefoneCorretor, acesso);


                              corretores.add(corretor);

             }

                }
                catch(SQLException e)
                {
                    System.out.println(e);
                }

        return corretores;

    }

    public Acesso consultaAcesso(String cpfCorretor) {
        PreparedStatement consultaCorretor = null;
        ResultSet rsConsultaCorretor = null;

        PreparedStatement consultaAcesso = null;
        ResultSet rsConsultaAcesso = null;

        Acesso acesso = null;

        try {
            c = conexao.abrirConexao();

            consultaCorretor = c.prepareStatement("select * from Cliente where cpfCorretor = '" + cpfCorretor + "';");
            rsConsultaCorretor = consultaCorretor.executeQuery();
            rsConsultaCorretor.next();

            String loginCorretor = rsConsultaCorretor.getString("login");

            consultaAcesso = c.prepareStatement("select * from acesso where login = '" + loginCorretor + "'");
            rsConsultaAcesso = consultaAcesso.executeQuery();
            rsConsultaAcesso.next();

            loginCorretor = rsConsultaAcesso.getString("login");
            String senha = rsConsultaAcesso.getString("senha");
            String tipoDeUsuario = rsConsultaAcesso.getString("tipoDeUsuario");

            acesso = new Acesso(loginCorretor, senha, tipoDeUsuario);

            c = conexao.fecharConexao();
            consultaAcesso.close();
            consultaCorretor.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return acesso;

    }

}
