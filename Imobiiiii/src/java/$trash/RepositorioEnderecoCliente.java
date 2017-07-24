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
import negocios.EnderecoCliente;

/**
 *
 * @author Administrador
 */
public class RepositorioEnderecoCliente {
    /* Conexao conexao = new Conexao();
     Connection c = null;


public void inserirEnderecoCliente(EnderecoCliente enderecoCliente)
    {
        PreparedStatement inserir = null;

            try
            {
            c = conexao.abrirConexao();
            inserir = c.prepareStatement("insert into enderecoCliente (ruaCliente,"
                    + "numeroCliente,complementoCliente,bairroCliente,cidadeCliente) values"
                    + " ('"+enderecoCliente.getRuaCliente()+"','"+enderecoCliente.getNumeroCliente()
                    +"','"+enderecoCliente.getComplementoCliente()+"','"+enderecoCliente.getBairroCliente()
                    +"','"+enderecoCliente.getCidadeCliente()+"');");

                        inserir.executeUpdate();

                        c = conexao.fecharConexao();
                        inserir.close();

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public EnderecoCliente consultarEnderecoCliente(int idEnderecoCliente)
    {
        PreparedStatement consultarEnderecoCliente = null;
        ResultSet rsConsultaEnderecoCliente = null;
        EnderecoCliente enderecoCliente = null;

        try
        {
            c = conexao.abrirConexao();
            consultarEnderecoCliente = c.prepareStatement("select * from corretor where idEnderecoCliente = '"+idEnderecoCliente+"';");
            rsConsultaEnderecoCliente = consultarEnderecoCliente.executeQuery();
            rsConsultaEnderecoCliente.next();


            String ruaCliente = rsConsultaEnderecoCliente.getString("ruaCliente");
            int numeroCliente = rsConsultaEnderecoCliente.getInt("numeroCliente");
            String complementoCliente = rsConsultaEnderecoCliente.getString("complementoCliente");
            String bairroCliente = rsConsultaEnderecoCliente.getString("bairroCliente");
            String cidadeCliente = rsConsultaEnderecoCliente.getString("bairroCliente");



        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return enderecoCliente;

    }

    public void alterarEnderecoCliente(int idEnderecoCliente, EnderecoCliente novoEnderecoCliente)
    {
        PreparedStatement alterar = null;

        try
        {
            c = conexao.abrirConexao();
            alterar = c.prepareStatement("update enderecoCliente set  ruaCliente = '"
                    +novoEnderecoCliente.getRuaCliente()+"', numeroCliente = '"+novoEnderecoCliente.getNumeroCliente()+"', complementoCliente = '"
                    +novoEnderecoCliente.getComplementoCliente()+"' where idEnderecoCliente = '"+idEnderecoCliente+"';");

            alterar.executeUpdate();

            c = conexao.fecharConexao();
            alterar.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public void excluirEnderecoCliente(int idEnderecoCliente)
    {
        PreparedStatement excluir = null;
        try
        {
            c = conexao.abrirConexao();
            excluir = c.prepareStatement("delete from enderecoCliente where idEnderecoCliente = '"+idEnderecoCliente+"';");
            excluir.executeUpdate();

            c = conexao.fecharConexao();
            excluir.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<EnderecoCliente> listaEnderecoClientes()
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        EnderecoCliente  enderecoCliente = null;

        ArrayList<EnderecoCliente> enderecoClientes = new ArrayList<EnderecoCliente>();


        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from enderecoCliente order by nome asc;");
            rsConsulta = consultar.executeQuery();

            while(rsConsulta.next())
            {
            int idEnderecoCliente =rsConsulta.getInt("idEnderecoCliente");
            String ruaCliente = rsConsulta.getString("ruaCliente");
            String numeroCliente = rsConsulta.getString("numeroliente");
            String complementoCliente = rsConsulta.getString("complementoCliente");
            String bairroCliente = rsConsulta.getString("bairroCliente");
            String cidadeCliente = rsConsulta.getString("cidadeCliente");

            enderecoCliente = new EnderecoCliente(idEnderecoCliente, ruaCliente, numeroCliente, complementoCliente, bairroCliente, cidadeCliente);

            enderecoClientes.add(enderecoCliente);

            }

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return enderecoClientes;

    }*/
}