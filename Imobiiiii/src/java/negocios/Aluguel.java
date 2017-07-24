/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Administrador
 */
public class Aluguel {

    private int tempoDeAluguel;
    private String dataAluguel;
    private Corretor corretor;
    private Imovel imovel;
    private Cliente cliente;
    private Pagamento pagamento;

    public Aluguel() {
        super();
    }
    public Aluguel(int tempoDeAluguel,String dataAluguel){
    this.tempoDeAluguel = tempoDeAluguel;
    this.dataAluguel = dataAluguel;
    }

    public Aluguel(int tempoDeAluguel,String dataAluguel,Corretor corretor,Imovel imovel,Cliente cliente,Pagamento pagamento){
    this.tempoDeAluguel = tempoDeAluguel;
    this.dataAluguel = dataAluguel;
    this.corretor = corretor;
    this.imovel = imovel;
    this.cliente = cliente;
    this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public String getDataAluguel() {
        Calendar c = Calendar.getInstance();
        int mes = c.get(Calendar.MONTH)+1;
        dataAluguel = (c.get(Calendar.YEAR)+"/"+ mes+"/"+c.get(Calendar.DAY_OF_MONTH));
        return dataAluguel;
    }

    public void setDataAluguel(String dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public int getTempoDeAluguel() {
        return tempoDeAluguel;
    }

    public void setTempoDeAluguel(int tempoDeAluguel) {
        this.tempoDeAluguel = tempoDeAluguel;
    }
    
}
