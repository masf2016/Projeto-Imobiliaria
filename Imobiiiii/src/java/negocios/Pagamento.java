/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class Pagamento {
  //private int idPagamento;
    private int parcelasPagamento;
    private double valorParcelas;
    private double valorPagamento;

    public Pagamento()
    {
    super();
    }

    public Pagamento(/*int idPagamento,*/int parcelasPagamento,double valorParcelas,double valorPagamento)
        {
     // this.idPagamento = idPagamento;
        this.parcelasPagamento = parcelasPagamento;
        this.valorParcelas = valorParcelas;
        this.valorPagamento = valorPagamento;
        }
/*
        public void setIdPagamento(int idPagamento)
        {
        this.idPagamento = idPagamento;
        }
        public int getIdPagamento()
        {
        return idPagamento;
        }
*/
        public void setParcelasPagamento(int parcelasPagamento)
        {
        this.parcelasPagamento = parcelasPagamento;
        }
        public int getParcelasPagamento()
        {

        return parcelasPagamento;
        }

        public void setValorParcelas(double valorParcelas)
        {
             this.valorParcelas = valorParcelas;
        }

        public double getValorParcelas()
        {

            valorParcelas = parcelasPagamento / valorPagamento;

        return valorParcelas;
        }

        public void setValorPagamento(double valorPagamento)
        {
        this.valorPagamento = valorPagamento;
        }
        public double getValorPagamento()
        {
        return valorPagamento;
        }
}
