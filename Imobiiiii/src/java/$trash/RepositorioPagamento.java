/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package $trash;

import dados.Conexao;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocios.Pagamento;

/**
 *
 * @author Administrador
 */
public class RepositorioPagamento
{
/*
    Conexao conexao = new Conexao();
    Connection c = null;

    public void inserirPagamento(Pagamento pagamento)
    {
        PreparedStatement inserir = null;

        try
        {
            c = conexao.abrirConexao();
            inserir = c.prepareStatement("insert into pagamento (idPagamento,parcelasPagamento,valorParcelas,valorPagamento,) values"
                    + " ('"+pagamento.getIdPagamento()+"','"+pagamento.getParcelasPagamento()+"','"+pagamento.getValorParcelas()+"','"+pagamento.getValorPagamento()+"');");

                        inserir.executeUpdate();

                        c = conexao.fecharConexao();
                        inserir.close();

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public Pagamento consultarPagamento(int idPagamento)
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        Pagamento pagamento = null;

        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from pagamento where idPagamento = '"+idPagamento+"';");
            rsConsulta = consultar.executeQuery();
            rsConsulta.next();

            int parcelasPagamento = rsConsulta.getInt("parcelasPagamento");
            double valorParcelas = rsConsulta.getDouble("valorParcelas");
            double valorPagamento = rsConsulta.getDouble("valorPagamento");

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return pagamento;

    }

    public void alterarPagamento(int idPagamento, Pagamento novoPagamento)
    {
        PreparedStatement alterar = null;

        try
        {
            c = conexao.abrirConexao();
            alterar = c.prepareStatement("update pagamento set idPagamento = '"+novoPagamento.getIdPagamento()
                    +"', parelasPagamento = '"+novoPagamento.getParcelasPagamento()+"',valorParcelas'"
                    +novoPagamento.getValorParcelas()+"',valorPagamento'"+novoPagamento.getValorPagamento()
                    +"' where idVenda = '"+idPagamento+"';");
            
            alterar.executeUpdate();

            c = conexao.fecharConexao();
            alterar.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public void excluirVendas(int idVenda)
    {
        PreparedStatement excluir = null;
        try
        {
            c = conexao.abrirConexao();
            excluir = c.prepareStatement("delete from vendas where idVendas = '"+idVenda+"';");
            excluir.executeUpdate();

            c = conexao.fecharConexao();
            excluir.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<Pagamento> listaPagamentos()
    {
        PreparedStatement consultar = null;
        ResultSet rsConsulta = null;
        Pagamento pagamento = null;

        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();


        try
        {
            c = conexao.abrirConexao();
            consultar = c.prepareStatement("select * from pagamento order by nome asc;");
            rsConsulta = consultar.executeQuery();

            while(rsConsulta.next())
            {
            int idPagamento =rsConsulta.getInt("idPagamento");
            int parcelasPagamento = rsConsulta.getInt("parcelasPagamento");
            double valorParcelas = rsConsulta.getDouble("valorParcelas");
            double valorPagamento = rsConsulta.getDouble("valorPagamento");


            pagamento = new Pagamento(idPagamento, parcelasPagamento, valorParcelas, valorPagamento);

            pagamentos.add(pagamento);

            }

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return pagamentos;

    }

 
 */
}
