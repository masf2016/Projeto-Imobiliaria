/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorios;

import dados.Conexao;
import negocios.Imovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocios.EnderecoImovel;


/**
 *
 * @author Administrador
 */
public class RepositorioImovel {
    
    Conexao conexao =new Conexao();
    Connection c = null;
    
    public void inserirImovel(Imovel imovel, EnderecoImovel enderecoImovel)
    {
    PreparedStatement inserirImovel = null;
    PreparedStatement inserirEnderecoImovel = null;

    PreparedStatement consultarEnderecoImovel = null;
    
    
    ResultSet rsConsultaEnderecoImovel = null;
   


    
    try
        {
            c =  conexao.abrirConexao();

            //inserção do endereço do Imovel.
           inserirEnderecoImovel = c.prepareStatement("insert into enderecoImovel (ruaImovel,numeroImovel,bairroImovel,cidadeImovel) values ('"+enderecoImovel.getRuaImovel()+"','"+enderecoImovel.getNumeroImovel()+"','"+enderecoImovel.getBairroImovel()+"','"+enderecoImovel.getCidadeImovel()+"');");
           inserirEnderecoImovel.executeUpdate();//executa a inserção
          


           consultarEnderecoImovel = c.prepareStatement("select idEnderecoImovel from enderecoImovel where ruaImovel = '"+enderecoImovel.getRuaImovel()+"' and numeroImovel = '"+enderecoImovel.getNumeroImovel()+"' and bairroImovel = '"+enderecoImovel.getBairroImovel()+"' and cidadeImovel = '"+ enderecoImovel.getCidadeImovel()+"';");
           rsConsultaEnderecoImovel = consultarEnderecoImovel.executeQuery();
           rsConsultaEnderecoImovel.next();
            
           int idEnderecoImovel = rsConsultaEnderecoImovel.getInt("idEnderecoImovel");
           

           inserirImovel = c.prepareStatement("insert into imovel (areaImovel,qtdComodos,valorImovel,descricaoImovel,idEnderecoImovel) values("+imovel.getAreaImovel()+","+imovel.getQtdComodos()+","+imovel.getValorImovel()+",'"+imovel.getDescricaoImovel()+"',"+idEnderecoImovel+");");
           inserirImovel.executeUpdate();



           
                            c = conexao.fecharConexao();
                            inserirImovel.close();
                            inserirEnderecoImovel.close();
                        

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    
    }


public Imovel consultarImovel(int idImovel)
    {
        PreparedStatement consultarImovel = null;
        ResultSet rsConsultarImovel = null;
        Imovel imovel = null;

        PreparedStatement consultarEnderecoImovel = null;
        ResultSet rsConsultarEnderecoImovel = null;
        EnderecoImovel enderecoImovel = null;

        try
        {
            c = conexao.abrirConexao();
            consultarImovel = c.prepareStatement("select * from imovel where idImovel = '"+idImovel+"';");
            rsConsultarImovel = consultarImovel.executeQuery();
            rsConsultarImovel.next();


            double areaImovel = rsConsultarImovel.getDouble("areaImovel");
            int qtdComodos = rsConsultarImovel.getInt("qtdComodos");
            double valorImovel = rsConsultarImovel.getDouble("valorImovel");
            String descricaoImovel =rsConsultarImovel.getString("descricaoImovel");

            int idEnderecoImovel = rsConsultarImovel.getInt("idImovel");//consulta o endereco do imóvel e o coloca em outra variavel
            consultarEnderecoImovel = c.prepareStatement("select * from enderecoImovel where idEnderecoImovel = " + idEnderecoImovel + ";");
            rsConsultarEnderecoImovel = consultarEnderecoImovel.executeQuery();
            rsConsultarEnderecoImovel.next();

                String ruaImovel = rsConsultarEnderecoImovel.getString("ruaImovel");
                String numeroImovel = rsConsultarEnderecoImovel.getString("numeroImovel");
                String bairroImovel = rsConsultarEnderecoImovel.getString("bairroImovel");
                String cidadeImovel = rsConsultarEnderecoImovel.getString("cidadeImovel");

                enderecoImovel = new EnderecoImovel(ruaImovel, numeroImovel, bairroImovel, cidadeImovel);
                imovel = new Imovel(areaImovel, qtdComodos, valorImovel, descricaoImovel, enderecoImovel);

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return imovel;

    }

        public void alterarImovel(int idImovelAnterior, Imovel novoImovel, EnderecoImovel enderecoImovel)
    {
        PreparedStatement alterarImovel = null;
        PreparedStatement alterarEnderecoImovel = null;
        PreparedStatement consultarImovel = null;
        ResultSet rsConsultaImovel = null;

        try
        {
            c = conexao.abrirConexao();
            
            
            consultarImovel = c.prepareStatement("select * from Imovel where idImovel = " + idImovelAnterior + ";");
            rsConsultaImovel = consultarImovel.executeQuery();
            rsConsultaImovel.next();
            
            int idEnderecoImovel = rsConsultaImovel.getInt("idEnderecoCliente");
            alterarEnderecoImovel = c.prepareStatement("update enderecoImovel set ruaImovel = '" + enderecoImovel.getRuaImovel() + "', numeroImovel = '" + enderecoImovel.getNumeroImovel() + "', bairroCliente = '" + enderecoImovel.getBairroImovel() + "', cidadeImovel = '" + enderecoImovel.getCidadeImovel() + "' where idEnderecoImovel = " + idEnderecoImovel + ";");
            alterarEnderecoImovel.executeUpdate();
            
            alterarImovel = c.prepareStatement("update imovel set areaImovel = " + novoImovel.getAreaImovel() + ", qtdComodos = " + novoImovel.getQtdComodos() + ", valorImovel = '" + novoImovel.getValorImovel() + ", descricaoImovel = '"+novoImovel.getDescricaoImovel()+"' where cpfCliente = " + idImovelAnterior + ";");
            alterarImovel.executeUpdate();
            
            
            c = conexao.fecharConexao();
            alterarImovel.close();
            alterarEnderecoImovel.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

            public void excluirImovel(int idImovel)
    {
        PreparedStatement excluirImovel = null;
        ResultSet rsConsultaImovel = null;
        try
        {
            c = conexao.abrirConexao();


            excluirImovel = c.prepareStatement("delete from imovel where idImovel = "+idImovel+";");
            excluirImovel.executeUpdate();

            int idEnderecoImovel = rsConsultaImovel.getInt("idEnderecoCliente");

            excluirImovel = c.prepareStatement("delete from enderecoCliente where idEnderecoImovel = '" + idEnderecoImovel + "';");
            excluirImovel.executeUpdate();
            
            c = conexao.fecharConexao();
            excluirImovel.close();
           
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<Imovel> listaImoveis()
    {
        PreparedStatement consultarImovel = null;
        ResultSet rsConsultaImovel = null;
            
            PreparedStatement consultaEnderecoImovel = null;
            ResultSet rsConsultaEnderecoImovel = null;
            
            Imovel imovel = null;
                EnderecoImovel enderecoImovel = null;

        ArrayList<Imovel> imoveis = new ArrayList<Imovel>();


        try
        {
            c = conexao.abrirConexao();
            consultarImovel = c.prepareStatement("select * from imovel order by idImovel asc;");
            rsConsultaImovel = consultarImovel.executeQuery();

            while(rsConsultaImovel.next())
            {
            
            double areaImovel = rsConsultaImovel.getDouble("areaImovel");
            int qtdComodos = rsConsultaImovel.getInt("qtdComodos");
            double valorImovel = rsConsultaImovel.getDouble("valorImovel");
            String descricaoImovel = rsConsultaImovel.getString("descricaoImovel");
            
                int idEnderecoImovel = rsConsultaImovel.getInt("idImovel");
                consultaEnderecoImovel = c.prepareStatement("select * from enderecoImovel where idEnderecoImovel = " + idEnderecoImovel + ";");
                rsConsultaEnderecoImovel = consultaEnderecoImovel.executeQuery();
                rsConsultaEnderecoImovel.next();
                    String ruaImovel = rsConsultaEnderecoImovel.getString("ruaImovel");
                    String numeroImovel = rsConsultaEnderecoImovel.getString("numeroImovel");
                    String bairroImovel = rsConsultaEnderecoImovel.getString("bairroImovel");
                    String cidadeImovel = rsConsultaEnderecoImovel.getString("cidadeImovel");
                    
                        enderecoImovel = new EnderecoImovel(ruaImovel, numeroImovel, bairroImovel, cidadeImovel);
                            imovel = new Imovel(areaImovel, qtdComodos, valorImovel, descricaoImovel, enderecoImovel);
                            
                imoveis.add(imovel);
            }

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return imoveis;

    }
}
