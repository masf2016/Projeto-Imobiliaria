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
import negocios.TelefoneCorretor;

/**
 *
 * @author Administrador
 */
public class RepositorioTelefoneCorretor {
 /*    Conexao conexao = new Conexao();
     Connection c = null;


public void inserirTelefoneCorretor(TelefoneCorretor telefoneCorretor)
    {
        PreparedStatement inserir = null;

            try
            {
            c = conexao.abrirConexao();
            inserir = c.prepareStatement("insert into telefoneCorretor (idTelefoneCorretor,tipoTelefoneCorretor,"
                    + "dddTelefoneCorretor,numeroTelefoneCorretor) values"
                    + " ('"+telefoneCorretor.getIdTelefoneCorretor()+"','"+telefoneCorretor.getTipoTelefoneCorretor()+"','"
                    +telefoneCorretor.getDddTelefoneCorretor()+"','"+telefoneCorretor.getNumeroCorretor()+"');");

                        inserir.executeUpdate();

                        c = conexao.fecharConexao();
                        inserir.close();

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public TelefoneCorretor consultarTelefoneCorretor(int idTelefoneCorretor)
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        TelefoneCorretor telefoneCorretor = null;

        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from telefoneCorretor where idTelefoneCorretor = '"+idTelefoneCorretor+"';");
            rsConsulta = consultar.executeQuery();
            rsConsulta.next();


            String tipoTelefoneCorretor = rsConsulta.getString("tipoTelefoneCorretor");
            int dddTelefoneCorretor = rsConsulta.getInt("dddTelefoneCorretor");
            String numeroTelefoneCorretor = rsConsulta.getString("numeroTelefoneCorretor");


        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return telefoneCorretor;

    }

    public void alterarTelefoneCorretor(int idTelefoneCorretor, TelefoneCorretor novoTelefoneCorretor)
    {
        PreparedStatement alterar = null;

        try
        {
            c = conexao.abrirConexao();
            alterar = c.prepareStatement("update telefoneCorretor set idTelefoneCorretor = '"+novoTelefoneCorretor.getIdTelefoneCorretor()+"', tipoTelefoneCorretor = '"
                    +novoTelefoneCorretor.getTipoTelefoneCorretor()+"', dddTelefoneCorretor = '"+novoTelefoneCorretor.getDddTelefoneCorretor()+"', numeroTelefoneCorretor = '"
                    +novoTelefoneCorretor.getNumeroCorretor()+"' where idTelefoneCorretor = '"+idTelefoneCorretor+"';");

            alterar.executeUpdate();

            c = conexao.fecharConexao();
            alterar.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public void excluirTelefoneCorretor(int idTelefoneCorretor)
    {
        PreparedStatement excluir = null;
        try
        {
            c = conexao.abrirConexao();
            excluir = c.prepareStatement("delete from telefoneCorretor where idTelefoneCorretor = '"+idTelefoneCorretor+"';");
            excluir.executeUpdate();

            c = conexao.fecharConexao();
            excluir.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<TelefoneCorretor> listaTelefoneCorretores()
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        TelefoneCorretor  telefoneCorretor = null;

        ArrayList<TelefoneCorretor> telefoneCorretores = new ArrayList<TelefoneCorretor>();


        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from telefoneCorretor order by nome asc;");
            rsConsulta = consultar.executeQuery();

            while(rsConsulta.next())
            {
            int idTelefoneCorretor =rsConsulta.getInt("idTelefoneCorretor");
            String tipoTelefoneCorretor = rsConsulta.getString("tipoTelefoneCorretor");
            int dddTelefoneCorretor = rsConsulta.getInt("dddTelefoneCorretor");
            int numeroTelefoneCorretor = rsConsulta.getInt("numeroTelefoneCorretor");


            telefoneCorretor = new TelefoneCorretor(idTelefoneCorretor, tipoTelefoneCorretor, dddTelefoneCorretor, numeroTelefoneCorretor);

            telefoneCorretores.add(telefoneCorretor);

            }

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return telefoneCorretores;

    }*/
}