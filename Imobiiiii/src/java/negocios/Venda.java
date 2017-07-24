/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import java.util.Calendar;
import java.util.Date;
import utilitarios.FormataData;

/**
 *
 * @author Administrador
 *
 * As chaves estrangeiras foram comentadas
 */
public class Venda {
    //private int idVenda;

    private String dataVenda;
    private Cliente cliente;          //estrangeira
    private Imovel imovel;            //estrangeira
    private Corretor corretor;        //estrangeira
    private Pagamento pagamento;      //estrangeira

    public Venda() {
        super();
    }

    public Venda(/*int idVenda,*/String dataVenda) {
        // this.idVenda = idVenda;
        this.dataVenda = dataVenda;
    }

    public Venda(/*int idVenda,*/String dataVenda, Cliente cliente, Imovel imovel, Corretor corretor, Pagamento pagamento) {
        // this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.imovel = imovel;
        this.corretor = corretor;
        this.pagamento = pagamento;
    }
    /*
    public void setIdVenda(int idVenda)
    {
    this.idVenda = idVenda;
    }
    public int getIdVenda()
    {
    return idVenda;
    }
     */

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getDataVenda() {
        Calendar c = Calendar.getInstance();
        int mes = c.get(Calendar.MONTH) + 1;
        dataVenda = (c.get(Calendar.YEAR) + "/" + mes + "/" + c.get(Calendar.DAY_OF_MONTH));
        return dataVenda;

    }

    /*CHAVES ESTRANGEIRAS*/
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}
