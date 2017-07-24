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
import negocios.EnderecoCorretor;

/**
 *
 * @author Administrador
 */
public class RepositorioEnderecoCorretor {
 /*    Conexao conexao = new Conexao();
     Connection c = null;


public void inserirEnderecoCorretor(EnderecoCorretor enderecoCorretor)
    {
        PreparedStatement inserir = null;

            try
            {
            c = conexao.abrirConexao();             //lembrar de retirar o campo idEnderecoCorretor = ele é autoincremento
            inserir = c.prepareStatement("insert into enderecoCorretor (idEnderecoCorretor,ruaCorretor,"
                    + "numeroCorretor,complementoCorretor,bairroCorretor,cidadeCorretor) values"
                    + " ('"+enderecoCorretor.getRuaCorretor()+"','"+enderecoCorretor.getNumeroCorretor()+"','"
                    +enderecoCorretor.getComplementoCorretor()+"','"+enderecoCorretor.getBairroCorretor()+"','"+enderecoCorretor.getCidadeCorretor()+"');");

                        inserir.executeUpdate();

                        c = conexao.fecharConexao();
                        inserir.close();

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public EnderecoCorretor consultarEnderecoCorretor(int idEnderecoCorretor)
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        EnderecoCorretor enderecoCorretor = null;

        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from corretor where idEnderecoCorretor = '"+idEnderecoCorretor+"';");
            rsConsulta = consultar.executeQuery();
            rsConsulta.next();


            String ruaCorretor = rsConsulta.getString("ruaCorretor");
            int numeroCorretor = rsConsulta.getInt("numeroCorretor");
            String complementoCorretor = rsConsulta.getString("complementoCorretor");
            String bairroCorretor = rsConsulta.getString("bairroCorretor");
            String cidadeCorretor = rsConsulta.getString("bairroCorretor");



        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return enderecoCorretor;

    }

    public void alterarEnderecoCorretor(int idEnderecoCorretor, EnderecoCorretor novoEnderecoCorretor)
    {
        PreparedStatement alterar = null;

        try
        {
            c = conexao.abrirConexao();
            alterar = c.prepareStatement("update enderecoCorretor set idEnderecoCorretor = '"+novoEnderecoCorretor.getIdEnderecoCorretor()+"', ruaCorretor = '"
                    +novoEnderecoCorretor.getRuaCorretor()+"', numeroCorretor = '"+novoEnderecoCorretor.getNumeroCorretor()+"', complementoCorretor = '"
                    +novoEnderecoCorretor.getComplementoCorretor()+"' where idEnderecoCorretor = '"+idEnderecoCorretor+"';");

            alterar.executeUpdate();

            c = conexao.fecharConexao();
            alterar.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public void excluirEnderecoCorretor(int idEnderecoCorretor)
    {
        PreparedStatement excluir = null;
        try
        {
            c = conexao.abrirConexao();
            excluir = c.prepareStatement("delete from enderecoCorretor where idEnderecoCorretor = '"+idEnderecoCorretor+"';");
            excluir.executeUpdate();

            c = conexao.fecharConexao();
            excluir.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<EnderecoCorretor> listaEnderecoCorretores()
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        EnderecoCorretor  enderecoCorretor = null;

        ArrayList<EnderecoCorretor> enderecoCorretores = new ArrayList<EnderecoCorretor>();


        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from enderecoCorretor order by nome asc;");
            rsConsulta = consultar.executeQuery();

            while(rsConsulta.next())
            {
            int idEnderecoCorretor =rsConsulta.getInt("idEnderecoCorretor");
            String ruaCorretor = rsConsulta.getString("ruaCorretor");
            int numeroCorretor = rsConsulta.getInt("numeroliente");
            String complementoCorretor = rsConsulta.getString("complementoCorretor");
            String bairroCorretor = rsConsulta.getString("bairroCorretor");
            String cidadeCorretor = rsConsulta.getString("cidadeCorretor");

            enderecoCorretor = new EnderecoCorretor(idEnderecoCorretor, ruaCorretor, numeroCorretor, complementoCorretor, bairroCorretor, cidadeCorretor);

            enderecoCorretores.add(enderecoCorretor);

            }

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return enderecoCorretores;

    }*/
}