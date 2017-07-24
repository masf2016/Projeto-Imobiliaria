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
import negocios.TelefoneCliente;

/**
 *
 * @author Administrador
 */
public class RepositorioTelefoneCliente {
  /*   Conexao conexao = new Conexao();
     Connection c = null;


public void inserirTelefoneCliente(TelefoneCliente telefoneCliente)
    {
        PreparedStatement inserir = null;

            try
            {
            c = conexao.abrirConexao();
            inserir = c.prepareStatement("insert into telefoneCliente (tipoTelefoneCliente,"
                    + "dddTelefoneCliente,numeroTelefoneCliente) values"
                    + " ('"+telefoneCliente.getTipoTelefoneCliente()+"','"
                    +telefoneCliente.getDddTelefoneCliente()+"','"+telefoneCliente.getNumeroCliente()+"');");

                        inserir.executeUpdate();

                        c = conexao.fecharConexao();
                        inserir.close();

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public TelefoneCliente consultarTelefoneCliente(int idTelefoneCliente)
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        TelefoneCliente telefoneCliente = null;

        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from telefoneCliente where idTelefoneCliente = '"+idTelefoneCliente+"';");
            rsConsulta = consultar.executeQuery();
            rsConsulta.next();


            String tipoTelefoneCliente = rsConsulta.getString("tipoTelefoneCliente");
            int dddTelefoneCliente = rsConsulta.getInt("dddTelefoneCliente");
            String numeroTelefoneCliente = rsConsulta.getString("numeroTelefoneCliente");
            

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return telefoneCliente;

    }

    public void alterarTelefoneCliente(int idTelefoneCliente, TelefoneCliente novoTelefoneCliente)
    {
        PreparedStatement alterar = null;

        try
        {
            c = conexao.abrirConexao();
            alterar = c.prepareStatement("update telefoneCliente set  tipoTelefoneCliente = '"
                    +novoTelefoneCliente.getTipoTelefoneCliente()+"', dddTelefoneCliente = '"
                    +novoTelefoneCliente.getDddTelefoneCliente()+"', numeroTelefoneCliente = '"
                    +novoTelefoneCliente.getNumeroCliente()+"' where idTelefoneCliente = '"+idTelefoneCliente+"';");

            alterar.executeUpdate();

            c = conexao.fecharConexao();
            alterar.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public void excluirTelefoneCliente(int idTelefoneCliente)
    {
        PreparedStatement excluir = null;
        try
        {
            c = conexao.abrirConexao();
            excluir = c.prepareStatement("delete from telefoneCliente where idTelefoneCliente = '"+idTelefoneCliente+"';");
            excluir.executeUpdate();

            c = conexao.fecharConexao();
            excluir.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<TelefoneCliente> listaTelefoneClientes()
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        TelefoneCliente  telefoneCliente = null;

        ArrayList<TelefoneCliente> telefoneClientes = new ArrayList<TelefoneCliente>();


        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from telefoneCliente order by nome asc;");
            rsConsulta = consultar.executeQuery();

            while(rsConsulta.next())
            {
            int idTelefoneCliente =rsConsulta.getInt("idTelefoneCliente");
            String tipoTelefoneCliente = rsConsulta.getString("tipoTelefoneCliente");
            String dddTelefoneCliente = rsConsulta.getString("dddTelefoneCliente");
            String numeroTelefoneCliente = rsConsulta.getString("telefoneCliente");
            

            telefoneCliente = new TelefoneCliente( tipoTelefoneCliente, dddTelefoneCliente, numeroTelefoneCliente);

            telefoneClientes.add(telefoneCliente);

            }

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return telefoneClientes;

    }*/
}