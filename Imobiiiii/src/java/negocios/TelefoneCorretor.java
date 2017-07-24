/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class TelefoneCorretor {
  //private int idTelefoneCorretor;
    private String tipoTelefoneCorretor;
    private int dddTelefoneCorretor;
    private int numeroTelefoneCorretor;

    public TelefoneCorretor()
    {
    super();
    }

    public TelefoneCorretor(/*int idTelefoneCorretor,*/String tipoTelefoneCorretor,int dddTelefoneCorretor,int numeroTelefoneCorretor)
        {
     // this.idTelefoneCorretor = idTelefoneCorretor;
        this.tipoTelefoneCorretor = tipoTelefoneCorretor;
        this.dddTelefoneCorretor = dddTelefoneCorretor;
        this.numeroTelefoneCorretor = numeroTelefoneCorretor;
        }
/*
        public void setIdTelefoneCorretor(int IdTelefoneCorretor)
        {
        this.idTelefoneCorretor = IdTelefoneCorretor;
        }
        public int getIdTelefoneCorretor()
        {
        return idTelefoneCorretor;
        }
*/
        public void setTipoTelefoneCorretor(String tipoTelefoneCorretor)
        {
        this.tipoTelefoneCorretor = tipoTelefoneCorretor;
        }
        public String getTipoTelefoneCorretor()
        {
        return tipoTelefoneCorretor;
        }

        public void setDddTelefoneCorretor(int dddTelefoneCorretor)
        {
        this.dddTelefoneCorretor = dddTelefoneCorretor;
        }
        public int getDddTelefoneCorretor()
        {
        return dddTelefoneCorretor;
        }

        public void setNumeroTelefoneCorretor(int numeroTelefoneCorretor)
        {
        this.numeroTelefoneCorretor = numeroTelefoneCorretor;
        }
        public int getNumeroTelefoneCorretor()
        {
        return numeroTelefoneCorretor;
        }


}
