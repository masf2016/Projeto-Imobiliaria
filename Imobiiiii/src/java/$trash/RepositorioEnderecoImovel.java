/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package $trash;
import dados.Conexao;
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
public class RepositorioEnderecoImovel {
 /*    Conexao conexao = new Conexao();
     Connection c = null;


public void inserirEnderecoImovel(EnderecoImovel enderecoImovel)
    {
        PreparedStatement inserir = null;

            try
            {
            c = conexao.abrirConexao();
            inserir = c.prepareStatement("insert into enderecoImovel (idEnderecoImovel,ruaImovel,"
                    + "numeroImovel,bairroImovel,cidadeImovel,valorImovel,areaImovel,descricaoImovel) values"
                    + " ('"+enderecoImovel.getRuaImovel()+"','"+enderecoImovel.getNumeroImovel()+"','"
                    +enderecoImovel.getBairroImovel()+"','"+enderecoImovel.getCidadeImovel()+"','"
                    +enderecoImovel.getValorImovel()+"','"+enderecoImovel.getAreaImovel()+"','"+enderecoImovel.getDescricaoImovel()+"');");

                        inserir.executeUpdate();

                        c = conexao.fecharConexao();
                        inserir.close();

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public EnderecoImovel consultarEnderecoImovel(int idEnderecoImovel)
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        EnderecoImovel enderecoImovel = null;

        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from enderecoImovel where idEnderecoImovel = '"+idEnderecoImovel+"';");
            rsConsulta = consultar.executeQuery();
            rsConsulta.next();


            String ruaImovel = rsConsulta.getString("ruaImovel");
            int numeroImovel = rsConsulta.getInt("numeroImovel");
            String bairroImovel = rsConsulta.getString("bairroImovel");
            String cidadeImovel = rsConsulta.getString("bairroImovel");
            double valorImmovel =rsConsulta.getDouble("valorImovel");
            double areaImovel = rsConsulta.getDouble("areaImovel");
            String descricaoImovel = rsConsulta.getString("numeroImovel");



        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return enderecoImovel;

    }

    public void alterarEnderecoImovel(int idEnderecoImovel, EnderecoImovel novoEnderecoImovel)
    {
        PreparedStatement alterar = null;

        try
        {
            c = conexao.abrirConexao();
            alterar = c.prepareStatement("update enderecoImovel set idEnderecoImovel = '"+novoEnderecoImovel.getIdEnderecoImovel()+"', ruaImovel = '"
                    +novoEnderecoImovel.getRuaImovel()+"', numeroImovel = '"+novoEnderecoImovel.getNumeroImovel()+
                    "' where idEnderecoImovel = '"+idEnderecoImovel+"';");

            alterar.executeUpdate();

            c = conexao.fecharConexao();
            alterar.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public void excluirEnderecoImovel(int idEnderecoImovel)
    {
        PreparedStatement excluir = null;
        try
        {
            c = conexao.abrirConexao();
            excluir = c.prepareStatement("delete from enderecoImovel where idEnderecoImovel = '"+idEnderecoImovel+"';");
            excluir.executeUpdate();

            c = conexao.fecharConexao();
            excluir.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<EnderecoImovel> listaEnderecoImoveis()
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        EnderecoImovel  enderecoImovel = null;

        ArrayList<EnderecoImovel> enderecoImoveis = new ArrayList<EnderecoImovel>();


        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from enderecoImovel order by nome asc;");
            rsConsulta = consultar.executeQuery();

            while(rsConsulta.next())
            {
            int idEnderecoImovel =rsConsulta.getInt("idEnderecoImovel");
            String ruaImovel = rsConsulta.getString("ruaImovel");
            int numeroImovel = rsConsulta.getInt("numeroliente");
            String bairroImovel = rsConsulta.getString("bairroImovel");
            String cidadeImovel = rsConsulta.getString("cidadeImovel");
            double valorImovel = rsConsulta.getDouble("valorImovel");
            double areaImovel = rsConsulta.getDouble("areaImovel");
            String descricaoImovel = rsConsulta.getString("descricaoImovel");


            enderecoImovel = new EnderecoImovel(idEnderecoImovel, ruaImovel, numeroImovel, bairroImovel, cidadeImovel, valorImovel, areaImovel, descricaoImovel);

            enderecoImoveis.add(enderecoImovel);

            }

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return enderecoImoveis;

    }
  
  */
}