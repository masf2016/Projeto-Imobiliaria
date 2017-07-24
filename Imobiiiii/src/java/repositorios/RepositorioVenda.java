/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorios;

import dados.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import negocios.Cliente;
import negocios.Corretor;
import negocios.Imovel;
import negocios.Pagamento;
import negocios.Venda;


/**
 *
 * @author Administrador
 */
public class RepositorioVenda
{

    Conexao conexao = new Conexao();
    Connection c = null;

    public void inserirVenda(Venda venda, Cliente cliente,Imovel imovel,Corretor corretor,Pagamento pagamento)
    {
        PreparedStatement inserirVenda = null;
        PreparedStatement inserirPagamento = null;
            PreparedStatement consultarCliente = null;
            PreparedStatement consultarImovel = null;
            PreparedStatement consultarCorretor = null;
            PreparedStatement consultaPagamento = null;
                ResultSet rsConsultaCliente = null;
                ResultSet rsConsultaImovel = null;
                ResultSet rsConsultaCorretor = null;
                ResultSet rsConsultaPagamento = null;
        
        
              

        try
        {
            c = conexao.abrirConexao();

            
            consultarCliente = c.prepareStatement("select cpfCliente from Cliente where nomeCliente = '" +cliente.getNomeCliente()+"' and rgCliente = '"+cliente.getRgCliente()+"' and emailCliente ='"+cliente.getEmailCliente()+"';");
            rsConsultaCliente = consultarCliente.executeQuery();
            rsConsultaCliente.next();
            int idCliente = rsConsultaCliente.getInt("idCliente");


            consultarCorretor = c.prepareStatement("select idCorretor from Corretor where nomeCorretor ='"+corretor.getNomeCorretor()+"' and cpfCorretor = '"+corretor.getCpfCorretor()+"' and rgCorretor = '"+corretor.getRgCorretor()+"' and emailCorretor = '"+corretor.getEmailCorretor()+"' ;");
            rsConsultaCorretor = consultarCorretor.executeQuery();
            rsConsultaCorretor.next();
            int idCorretor = rsConsultaCorretor.getInt("idCorretor");


            consultarImovel = c.prepareStatement("select idImovel from Imovel where areaImovel ="+imovel.getAreaImovel()+" and qtdComodos = "+imovel.getQtdComodos()+" and valorImovel = "+imovel.getValorImovel()+" and descricaoImovel = '"+imovel.getDescricaoImovel()+"' ;");
            rsConsultaImovel = consultarImovel.executeQuery();
            rsConsultaImovel.next();
            int idImovel = rsConsultaImovel.getInt("idImovel");



            inserirPagamento = c.prepareStatement("insert into pagamento (parcelasPagamento,valorParcelas,valorPagamento) values ("+pagamento.getParcelasPagamento()+","+pagamento.getValorParcelas()+","+pagamento.getValorPagamento()+");");
            inserirPagamento.executeUpdate();
            
            consultaPagamento = c.prepareStatement("select idPagamento from Pagamento where parcelasPagamento = " + pagamento.getParcelasPagamento() + " and valorParcelas = " + pagamento.getValorParcelas() + " and valorPagamento = " + pagamento.getParcelasPagamento() + " ;");
            rsConsultaPagamento = consultaPagamento.executeQuery();
            rsConsultaPagamento.next();
            int idPagamento = rsConsultaPagamento.getInt("idPagamento");

            

            inserirVenda = c.prepareStatement("insert into venda (dataVenda) values ('"+venda.getDataVenda()+"'"+idCliente+""+idImovel+""+idCorretor+""+idPagamento+");");
            inserirVenda.executeUpdate();

                    

                        c = conexao.fecharConexao();
                        inserirVenda.close();
                        inserirPagamento.close();

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public Venda consultarVenda(String dataVenda)
    {
        PreparedStatement consultarVenda = null;
        ResultSet rsConsultaVenda = null;
        Venda venda = null;

            PreparedStatement consultarPagamento =null;
            ResultSet rsConsultaPagamento = null;
            Pagamento pagamento = null;

                PreparedStatement consultarImovel = null;
                ResultSet rsConsultaImovel = null;
                Imovel imovel = null;

                    PreparedStatement consultarCorretor = null;
                    ResultSet rsConsultaCorretor = null;
                    Corretor corretor = null;

                        PreparedStatement consultarCliente = null;
                        ResultSet rsConsultaCliente = null;
                        Cliente cliente = null;

        try
        {
            c = conexao.abrirConexao();
            consultarVenda = c.prepareStatement("select * from venda where dataVenda = "+dataVenda+";");
            rsConsultaVenda = consultarVenda.executeQuery();
            rsConsultaVenda.next();

         
                int idPagamneto = rsConsultaPagamento.getInt("idPagamento");
                consultarPagamento = c.prepareStatement("select * from pagamento where idPagamento = "+idPagamneto+";");
                rsConsultaPagamento = consultarPagamento.executeQuery();
                rsConsultaPagamento.next();

                int parcelasPagamento = rsConsultaPagamento.getInt("parcelasPagamento");
                double valorParcelas = rsConsultaPagamento.getDouble("valorParcelas");
                double valorPagamento = rsConsultaPagamento.getDouble("valorPagamento");

                pagamento = new Pagamento(parcelasPagamento, valorParcelas, valorPagamento);

                    int idImovel = rsConsultaImovel.getInt("idImovel");
                    consultarImovel = c.prepareStatement("select * from imovel where idImovel = "+idImovel+";");
                    rsConsultaImovel = consultarImovel.executeQuery();
                    rsConsultaImovel.next();

                    double areaImovel = rsConsultaImovel.getDouble("areaImovel");
                    int qtdComodos = rsConsultaImovel.getInt("qtdComodos");
                    double valorImovel = rsConsultaImovel.getDouble("valorImovel");
                    String descricaoImovel = rsConsultaImovel.getString("descricaoImovel");

                    imovel =new Imovel(areaImovel, qtdComodos, valorImovel, descricaoImovel);

                        int idCorretor = rsConsultaCorretor.getInt("idCorretor");
                        consultarCorretor = c.prepareStatement("select * from corretor where idCorretor = "+idCorretor+";");
                        rsConsultaCorretor = consultarCorretor.executeQuery();
                        rsConsultaCorretor.next();

                        String nomeCorretor = rsConsultaCorretor.getString("nomeCorretor");
                        String cpfCorretor = rsConsultaCorretor.getString("cpfCorretor");
                        String rgCorretor = rsConsultaCorretor.getString("rsCorretor");
                        String emailCorretor = rsConsultaCorretor.getString("emailCorretor");

                        corretor = new Corretor(nomeCorretor, cpfCorretor, rgCorretor, emailCorretor);

                            int idCliente = rsConsultaCliente.getInt("idCliente");
                            consultarCliente = c.prepareStatement("select * from cliente where idCliente = "+idCliente+";" );
                            rsConsultaCliente = consultarCliente.executeQuery();
                            rsConsultaCliente.next();

                            String nomeCliente = rsConsultaCliente.getString("nomeCliente");
                            String cpfCliente = rsConsultaCliente.getString("cpfCliente");
                            String rgCliente = rsConsultaCliente.getString("rgCliente");
                            String emailCliente = rsConsultaCliente.getString("emailCliente");

                            cliente = new Cliente(nomeCliente, cpfCliente, rgCliente, emailCliente);

           venda = new Venda(dataVenda, cliente, imovel, corretor, pagamento);

           
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return venda;

    }

    public void alterarVenda(int idVendaAnterior, Venda novaVenda,Pagamento pagamento)
    {
        PreparedStatement alterarVenda = null;
        PreparedStatement alterarPagamento = null;
        PreparedStatement consultarVenda = null;
        ResultSet rsConsultaVenda = null;

        try
        {
            c = conexao.abrirConexao();

            consultarVenda = c.prepareStatement("select * from venda where idVenda = " + idVendaAnterior + ";");
            rsConsultaVenda = consultarVenda.executeQuery();
            rsConsultaVenda.next();

            int idPagamento = rsConsultaVenda.getInt("idPagamento");
            alterarPagamento = c.prepareStatement("update pagamento set parcelasPagamento = " + pagamento.getParcelasPagamento() + ", valorParcelas = " + pagamento.getValorParcelas() + ", valorPagamento = " + pagamento.getValorPagamento() + " where idPagamento = " + idPagamento + ";");
            alterarPagamento.executeUpdate();


            alterarVenda = c.prepareStatement("update venda set  dataVenda = '"+novaVenda.getDataVenda()+"' where idVenda = '"+idVendaAnterior+"';");
            alterarVenda.executeUpdate();

            c = conexao.fecharConexao();
            alterarPagamento.close();
            alterarVenda.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public void excluirVenda(int idVenda)
    {
        PreparedStatement excluirVenda = null;
        ResultSet rsConsultaVenda = null;

        try
        {
            c = conexao.abrirConexao();



            excluirVenda = c.prepareStatement("delete from venda where idVenda = '"+idVenda+"';");
            excluirVenda.executeUpdate();

            //exclui dados do pagamento
            int idPagamento = rsConsultaVenda.getInt("idPagamento");
            excluirVenda = c.prepareStatement("delete from Pagamento where idPagamento = '" + idPagamento + "';");
            excluirVenda.executeUpdate();

            c = conexao.fecharConexao();
            excluirVenda.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

    }

    public ArrayList<Venda> listaVenda()
    {
        PreparedStatement consultarVenda = null;
        ResultSet rsConsultavenda = null;
            PreparedStatement consultarCliente = null;
            ResultSet rsConsultaCliente = null;
                PreparedStatement consultarCorretor = null;
                ResultSet rsConsultaCorretor = null;
                    PreparedStatement consultarImovel = null;
                    ResultSet rsConsultaImovel = null;
                        PreparedStatement consultarPagamento = null;
                        ResultSet rsConsultaPagamento = null;

        Venda venda = null;
            Cliente cliente = null;
                Corretor corretor = null;
                    Imovel imovel = null;
                        Pagamento pagamento = null;

        ArrayList<Venda> vendas = new ArrayList<Venda>();


        try
        {
            c = conexao.abrirConexao();
            consultarVenda = c.prepareStatement("select * from venda order by nome asc;");
            rsConsultavenda = consultarVenda.executeQuery();

            while(rsConsultavenda.next())
            {
            
           
           String dataVenda =  rsConsultavenda.getString("dataVenda");///??????????????????????????

            //recebe as ids
            int idCliente = rsConsultavenda.getInt("idCliente");
                int idCorretor = rsConsultavenda.getInt("idCorretor");
                    int idImovel  = rsConsultavenda.getInt("idImovel");
                        int idPagamento = rsConsultavenda.getInt("idPagamento");

            consultarCliente = c.prepareStatement("select * from Cliente where idCliente = " + idCliente + ";");
            rsConsultaCliente = consultarCliente.executeQuery();
            rsConsultaCliente.next();
                String nomeCliente = rsConsultaCliente.getString("nomeCliente");
                String cpfCliente = rsConsultaCliente.getString("cpfCliente");
                String rgCliente = rsConsultaCliente .getString("rgCliente");
                String emailCliente = rsConsultaCliente.getString("emailCliente");


                consultarCorretor = c.prepareStatement("select * from Corretor where idCorretor = "+idCorretor+";");
                rsConsultaCorretor = consultarCorretor.executeQuery();
                rsConsultaCorretor.next();
                       String nomecCorretor = rsConsultaCorretor.getString("nomecCorretor");
                       String cpfCorretor = rsConsultaCorretor.getString("cpfCorretor");
                       String rgCorretor = rsConsultaCorretor .getString("rgCorretor");
                       String emailCorretor = rsConsultaCorretor.getString("emailCorretor");


                       consultarImovel = c.prepareStatement("select * from imovel where idImovel = "+idImovel+";");
                       rsConsultaImovel = consultarImovel.executeQuery();
                       rsConsultaImovel.next();
                             double areaImovel = rsConsultaImovel.getDouble("ruaImovel");
                             int qtdComodos = rsConsultaImovel.getInt("numeroImovel");
                             double valorImovel = rsConsultaImovel.getDouble("bairroImovel");
                             String descricaoImovel = rsConsultaImovel.getString("cidadeImovel");

                             consultarPagamento = c.prepareStatement("select * from pagamneto where idPagamento = "+idPagamento+";");
                             rsConsultaPagamento = consultarPagamento.executeQuery();
                             rsConsultaPagamento.next();
                                                int parcelasPagamento = rsConsultaPagamento.getInt("parcelasPagamento");
                                                double valorParcelas = rsConsultaPagamento.getDouble("valorParcelas");
                                                double valorPagamento = rsConsultaPagamento.getDouble("valorPagamento");
       cliente = new Cliente(nomeCliente, cpfCliente, rgCliente, emailCliente);
                corretor = new Corretor(nomecCorretor, cpfCorretor, rgCorretor, emailCorretor);
                        imovel = new Imovel(areaImovel, qtdComodos, valorImovel, descricaoImovel);
                                pagamento = new Pagamento(parcelasPagamento, valorParcelas, valorPagamento);


            //corrigir este problema de atribuição na data
            venda = new Venda(dataVenda, cliente, imovel, corretor, pagamento);

            vendas.add(venda);

            }

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return vendas;

    }

}
