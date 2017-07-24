/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorios;


import java.sql.*;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import dados.Conexao;
import negocios.*;
import negocios.Acesso;
//import negocios.Cliente;
//import negocios.EnderecoCliente;
//import negocios.TelefoneCliente;


/**
 *
 * @author Mário
 */
public class RepositorioCliente
{

    Conexao conexao = new Conexao();
    Connection c = null;
    
    public void inserirCliente(Cliente cliente,EnderecoCliente enderecoCliente,TelefoneCliente telefoneCliente,Acesso acesso)
    {   
        
        PreparedStatement inserirCliente = null;        
        PreparedStatement inserirEnderecoCliente = null;
        PreparedStatement inserirTelefoneCliente = null;
        PreparedStatement inserirAcesso = null;

        PreparedStatement consultaEnderecoCliente = null;
        PreparedStatement consultaTelefoneCliente = null;
        PreparedStatement consultaAcesso = null;
       
        ResultSet rsConsultaEnderecoCliente = null;
        ResultSet rsConsultaTelefoneCliente = null;
        ResultSet rsConsultaAcesso = null;

         /*
         * 27 -11- 2010  12:32 analizar as consultas do sql e os objetos rsConsulta
         * 
         */
                
        try
        {
            c = conexao.abrirConexao();

            //inserção de dados de acesso
           
           //o login será efetuado com o cpf do cliente
           //inserção do endereço do Cliente.

           
           inserirEnderecoCliente = c.prepareStatement("insert into enderecoCliente (ruaCliente,numeroCliente,complementoCliente,bairroCliente,cidadeCliente) values ('"+enderecoCliente.getRuaCliente()+"','"+enderecoCliente.getNumeroCliente()+"','"+enderecoCliente.getComplementoCliente()+"','"+enderecoCliente.getBairroCliente()+"','"+enderecoCliente.getCidadeCliente()+"');");
           inserirEnderecoCliente.executeUpdate();//executa a inserção
          

           consultaEnderecoCliente = c.prepareStatement("select idEnderecoCliente from enderecoCliente where ruaCliente = '" + enderecoCliente.getRuaCliente() + "' and numeroCliente = '" + enderecoCliente.getNumeroCliente() + "' and complementoCliente = '" + enderecoCliente.getComplementoCliente() + "' and bairroCliente = '" + enderecoCliente.getBairroCliente() + "' and cidadeCliente = '" + enderecoCliente.getCidadeCliente() + "';");
           rsConsultaEnderecoCliente = consultaEnderecoCliente.executeQuery();
           rsConsultaEnderecoCliente.next();

           //recebe o resultado da consulta do endereço do cliente,será usado em cliente
           int idEnderecoCliente = rsConsultaEnderecoCliente.getInt("idEnderecoCliente");

           

           //inserção do telefone do cliente
           inserirTelefoneCliente = c.prepareStatement("insert into telefoneCliente (tipoTelefoneCliente,dddTelefoneCliente,numeroTelefoneCliente) values ('"+telefoneCliente.getTipoTelefoneCliente()+"',"+telefoneCliente.getDddTelefoneCliente()+","+telefoneCliente.getNumeroTelefoneCliente()+");");
           inserirTelefoneCliente.executeUpdate();//executa a inseção
          
           consultaTelefoneCliente = c.prepareStatement("select idTelefoneCliente from TelefoneCliente where tipoTelefoneCliente = '" + telefoneCliente.getTipoTelefoneCliente() + "' and dddTelefoneCliente = "+ telefoneCliente.getDddTelefoneCliente() +" and numeroTelefoneCliente = " + telefoneCliente.getNumeroTelefoneCliente() +" ;");
           rsConsultaTelefoneCliente = consultaTelefoneCliente.executeQuery();
           rsConsultaTelefoneCliente.next();
           
           
           //recebe o resultado da consulta do endereço do cliente,será usado em cliente
           int idTelefoneCliente = rsConsultaTelefoneCliente.getInt("idTelefoneCliente");

           

           inserirAcesso = c.prepareStatement("insert into acesso(login, senha,tipoDeUsuario) values ('"+acesso.getLogin()+"','"+acesso.getSenha()+"','cliente');");
           inserirAcesso.executeUpdate();

           consultaAcesso = c.prepareStatement("select idAcesso from acesso where login = '"+acesso.getLogin()+"' and senha ='"+acesso.getSenha()+"' and tipodeusuario = '"+acesso.getTipoDeUsuario()+"';");
           rsConsultaAcesso = consultaAcesso.executeQuery();
           rsConsultaAcesso.next();
          
           
           int idAcesso = rsConsultaAcesso.getInt("idAcesso");
        
           //inserção do Cliente


           inserirCliente = c.prepareStatement("insert into cliente (nomeCliente,cpfCliente,rgCliente,emailCliente,idEnderecoCliente,idTelefoneCliente,idAcesso) values ('"+cliente.getNomeCliente()+"','"+cliente.getCpfCliente()+"','"+cliente.getRgCliente()+"','"+cliente.getEmailCliente()+"',"+idEnderecoCliente+","+idTelefoneCliente+","+idAcesso+");");

           inserirCliente.executeUpdate();//executa a inserção


           c = conexao.fecharConexao();//encerra a conexão com o servidor
                        inserirCliente.close();
                        inserirAcesso.close();
                        inserirEnderecoCliente.close();
                        inserirTelefoneCliente.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }
    
    public Cliente consultarCliente(String cpfCliente)
    {
        PreparedStatement consultarCliente = null;
        ResultSet rsConsultarCliente = null;
        Cliente cliente = null;

        PreparedStatement consultarAcesso = null;
        ResultSet rsConsultarAcesso = null;
        Acesso acesso = null;

        PreparedStatement consultarEnderecoCliente = null;
        ResultSet rsConsultarEnderecoCliente = null;
        EnderecoCliente enderecoCliente = null;

        PreparedStatement consultarTelefoneCliente = null;
        ResultSet rsConsultarTelefoneCliente = null;
        TelefoneCliente telefoneCliente = null;


        
        try
        {
            c = conexao.abrirConexao();
            consultarCliente = c.prepareStatement("select * from cliente where cpfCliente = '"+cpfCliente+"';");
            rsConsultarCliente = consultarCliente.executeQuery();
            rsConsultarCliente.next();

            
            String nomeCliente = rsConsultarCliente.getString("nomeCliente");
            String rgCliente = rsConsultarCliente.getString("rgCliente");
            String emailCliente = rsConsultarCliente.getString("emailCliente");


            int idAcesso = rsConsultarCliente.getInt("idAcesso");
            consultarAcesso = c.prepareStatement("select * from acesso where idAcesso = "+idAcesso+";");
            rsConsultarAcesso = consultarAcesso.executeQuery();
            rsConsultarAcesso.next();

            String login = rsConsultarAcesso.getString("login");
            String senha = rsConsultarAcesso.getString("senha");
            String tipoDeUsuario = rsConsultarAcesso.getString("tipodeusuario");

            acesso = new Acesso(login, senha, tipoDeUsuario);

            //consulta o endereco do Cliente e retorna o id do endereco para o cliente
            int idEnderecoCliente = rsConsultarCliente.getInt("idEnderecoCliente");
            consultarEnderecoCliente = c.prepareStatement("select * from enderecoCliente where idEnderecoCliente = " + idEnderecoCliente + ";");
            rsConsultarEnderecoCliente = consultarEnderecoCliente.executeQuery();
            rsConsultarEnderecoCliente.next();

            String ruaCliente = rsConsultarEnderecoCliente.getString("ruaCliente");
            String numeroCliente = rsConsultarEnderecoCliente.getString("numeroCliente");
            String complementoCliente = rsConsultarEnderecoCliente.getString("complementoCliente");
            String bairroCliente = rsConsultarEnderecoCliente.getString("bairroCliente");
            String cidadeCliente =rsConsultarEnderecoCliente.getString("cidadeCliente");

            enderecoCliente = new EnderecoCliente(ruaCliente,numeroCliente,complementoCliente,bairroCliente,cidadeCliente);

            //consulta o telefone do cliente  retorna o id do telefone para o cliente
            int idTelefoneCliente = rsConsultarCliente.getInt("idTelefoneCliente");
            consultarTelefoneCliente = c.prepareStatement("select * from TelefoneCliente where idTelefoneCliente = " + idTelefoneCliente + ";");
            rsConsultarTelefoneCliente = consultarTelefoneCliente.executeQuery();
            rsConsultarTelefoneCliente.next();

            String tipoTelefoneCliente = rsConsultarTelefoneCliente.getString("tipoTelefoneCliente");
            int dddTelefoneCliente = rsConsultarTelefoneCliente.getInt("dddTelefoneCliente");
            int numeroTelefoneCliente = rsConsultarTelefoneCliente.getInt("numeroTelefoneCliente");

            telefoneCliente = new TelefoneCliente(tipoTelefoneCliente, dddTelefoneCliente, numeroTelefoneCliente);
            
            cliente = new Cliente(nomeCliente, cpfCliente, rgCliente, emailCliente, enderecoCliente, telefoneCliente, acesso);

            

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        System.out.println(cliente);
        return cliente;
        
    }

    public void alterarCliente(String cpfClienteAnterior, Cliente novoCliente, EnderecoCliente enderecoCliente,TelefoneCliente telefoneCliente,Acesso acesso)
    {
        PreparedStatement alterarCliente = null;        
        PreparedStatement alterarEnderecoCliente = null;
        PreparedStatement alterarTelefoneCliente = null;
        PreparedStatement alterarAcesso = null;

        PreparedStatement consultarCliente = null;

        ResultSet rsConsultaCliente = null;

        try
        {
            c = conexao.abrirConexao();
            
            consultarCliente = c.prepareStatement("select * from cliente where cpfCliente = '" + cpfClienteAnterior + "';");
            rsConsultaCliente = consultarCliente.executeQuery();
            rsConsultaCliente.next();

            int idEnderecoCliente = rsConsultaCliente.getInt("idEnderecoCliente");
            alterarEnderecoCliente = c.prepareStatement("update enderecoCliente set ruaCliente = '" + enderecoCliente.getRuaCliente() + "', numeroCliente = '" + enderecoCliente.getNumeroCliente() + "', complementoCliente = '" + enderecoCliente.getComplementoCliente() + "', bairroCliente = '" + enderecoCliente.getBairroCliente() + "', cidadeCliente = '" + enderecoCliente.getCidadeCliente() + "' where idEnderecoCliente = " + idEnderecoCliente + ";");
            alterarEnderecoCliente.executeUpdate();
            
            int idTelefoneCliente = rsConsultaCliente.getInt("idTelefoneCliente");
            alterarTelefoneCliente = c.prepareStatement("update telefoneCliente set tipoTelefoneCliente = '" + telefoneCliente.getTipoTelefoneCliente() + "', dddTelefoneCliente = " + telefoneCliente.getDddTelefoneCliente() + ", numeroTelefoneCliente = '" + telefoneCliente.getNumeroTelefoneCliente() + "' where idTelefoneCliente = " + idTelefoneCliente + ";");
            alterarTelefoneCliente.executeUpdate();


            int idAcesso = rsConsultaCliente.getInt("idAcesso");
            alterarAcesso = c.prepareStatement("update acesso set login ='"+acesso.getLogin()+"',senha = '"+acesso.getSenha()+"',tipodeusuario = '"+acesso.getTipoDeUsuario()+"' where idAcesso ="+idAcesso+";");


            alterarCliente = c.prepareStatement("update Cliente set nomeCliente = '" + novoCliente.getNomeCliente() + "', cpfCliente = '" + novoCliente.getCpfCliente() + "', rgCliente = '" + novoCliente.getRgCliente() + "', emailCliente = '"+novoCliente.getEmailCliente()+"' where cpfCliente = '" + cpfClienteAnterior + "';");
            alterarCliente.executeUpdate();
            

            c = conexao.fecharConexao();
            alterarAcesso.close();
            alterarEnderecoCliente.close();
            alterarTelefoneCliente.close();
            alterarCliente.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public void excluirCliente(String cpfCliente)
    {
        PreparedStatement excluirCliente = null;
        ResultSet rsConsultaCliente = null;
        try
        {
            c = conexao.abrirConexao();
       /*   Cliente cliente = consultarCliente(cpfCliente);
            excluirCliente = c.prepareStatement("select * from cliente where cpfCliente = '"+cliente.getCpfCliente()+"';");
            rsConsultaCliente = excluirCliente.executeQuery();
            rsConsultaCliente.next();*/
            
            
            excluirCliente = c.prepareStatement("delete from Cliente where cpfCliente = '" + cpfCliente + "';");
            excluirCliente.executeUpdate();

            int idEnderecoCliente = rsConsultaCliente.getInt("idEnderecoCliente");

            excluirCliente = c.prepareStatement("delete from enderecoCliente where idEnderecoCliente = " + idEnderecoCliente + ";");
            excluirCliente.executeUpdate();

            int idTelefoneCliente = rsConsultaCliente.getInt("idtelefoneCliente");

            excluirCliente = c.prepareStatement("delete from telefoneCliente where idTelefoneCliente = "+idTelefoneCliente+";");
            excluirCliente.executeUpdate();

            int idAcesso = rsConsultaCliente.getInt("idAcesso");
            excluirCliente = c.prepareStatement("delete from acesso where idAcesso = "+idAcesso+";");
            excluirCliente.executeUpdate();


                        
            c = conexao.fecharConexao();
            excluirCliente.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<Cliente> listaCliente()
    {
        PreparedStatement consultarCliente = null;
        ResultSet rsConsultaCliente = null;
            
            PreparedStatement consultaEnderecoCliente = null;
            ResultSet rsConsultaEnderecoCliente = null;
                
                PreparedStatement consultaTelefoneCliente = null;
                ResultSet rsConsultaTelefoneCliente = null;

                    PreparedStatement consultaAcesso = null;
                    ResultSet rsConsultaAcesso = null;
        
        Cliente cliente = null;
            EnderecoCliente enderecoCliente = null;
                TelefoneCliente telefoneCliente = null;
                    Acesso acesso = null;
        
        

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();


        try
        {
            c = conexao.abrirConexao();
            consultarCliente = c.prepareStatement("select * from Cliente order by nomeCliente asc;");
            rsConsultaCliente = consultarCliente.executeQuery();
            
            while(rsConsultaCliente.next())
            {
            
            String nomeCliente = rsConsultaCliente.getString("nomeCliente");
            String cpfCliente = rsConsultaCliente.getString("CpfCliente");
            String rgCliente = rsConsultaCliente.getString("RGCliente");
            String emailCliente = rsConsultaCliente.getString("EmailCliente");
            
            int idEnderecoCliente = rsConsultaCliente.getInt("idEnderecoCliente");//id do endereco e do telefone do cliente retornado na consulta
            int idTelefoneCliente = rsConsultaCliente.getInt("idTelefoneCliente");
            int idAcesso = rsConsultaCliente.getInt("idAcesso");


            consultaEnderecoCliente = c.prepareStatement("select * from enderecoCliente where idEnderecoCliente = " + idEnderecoCliente + ";");
            rsConsultaEnderecoCliente = consultaEnderecoCliente.executeQuery();
            rsConsultaEnderecoCliente.next();
                String ruaCliente = rsConsultaEnderecoCliente.getString("ruaCliente");
                String numeroCliente = rsConsultaEnderecoCliente.getString("numeroCliente");
                String complementoCliente = rsConsultaEnderecoCliente .getString("complementoCliente");
                String bairroCliente = rsConsultaEnderecoCliente.getString("bairroCliente");
                String cidadeCliente = rsConsultaEnderecoCliente.getString("cidadeCliente");
                
                consultaTelefoneCliente = c.prepareStatement("select * from telefoneCliente where idTelefoneCliente = " + idTelefoneCliente + ";");
                rsConsultaTelefoneCliente = consultaTelefoneCliente.executeQuery();
                rsConsultaTelefoneCliente.next();
                    String tipoTelefoneCliente = rsConsultaTelefoneCliente.getString("tipoTelefoneCliente");
                    int dddtelefoneCliente = rsConsultaTelefoneCliente.getInt("dddtelefoneCliente");
                    int numeroTelefoneCliente = rsConsultaTelefoneCliente.getInt("numeroTelefoneCliente");
                    

                            consultaAcesso = c.prepareStatement("select * from acesso where idAcesso = "+idAcesso+";");
                            rsConsultaAcesso = consultaAcesso.executeQuery();
                            rsConsultaAcesso.next();
                                    String login = rsConsultaAcesso.getString("login");
                                    String senha = rsConsultaAcesso.getString("senha");
                                    String tipoDeUsuario = rsConsultaAcesso.getString("tipoDeUsuario");

                     enderecoCliente = new EnderecoCliente(ruaCliente, numeroCliente, complementoCliente, bairroCliente, cidadeCliente);//vai para cliente
                        telefoneCliente = new TelefoneCliente(tipoTelefoneCliente, dddtelefoneCliente, numeroTelefoneCliente);           //vai para cliente
                                acesso = new Acesso(login, senha, tipoDeUsuario);                                                            //vai para cliente
                                    cliente = new Cliente(nomeCliente, cpfCliente, rgCliente, emailCliente, enderecoCliente, telefoneCliente, acesso);
                    
                              clientes.add(cliente);
                              System.out.println("listaCliente efetuada Com sucesso !!!");
             }
                
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                }

        return clientes;

    }

    public Acesso consultaAcesso(String login) {
        
        PreparedStatement consultaAcesso = null;
        ResultSet rsConsultaAcesso = null;

        Acesso acesso = null;

        try {
            c = conexao.abrirConexao();

            consultaAcesso = c.prepareStatement("select * from Acesso where login = '" + login + "';");
            rsConsultaAcesso = consultaAcesso.executeQuery();
            rsConsultaAcesso.next();

            String senha = rsConsultaAcesso.getString("senha");
            String tipoDeusuario = rsConsultaAcesso.getString("tipoDeusuario");

           acesso = new Acesso(login, senha, tipoDeusuario);
           



        } catch (SQLException e) {
            System.out.println(e);
        }

        return acesso;

    }
}
