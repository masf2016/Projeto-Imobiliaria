/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class TelefoneCliente {
 // private int  idTelefoneCliente;
    private String tipoTelefoneCliente;
    private int dddTelefoneCliente;
    private int numeroTelefoneCliente;


    public TelefoneCliente()
    {
    super();
    }

    public TelefoneCliente(/*int idTelefoneCliente,*/String tipoTelefoneCliente,int dddTelefoneCliente,int numeroTelefoneCliente)
        {
    //  this.idTelefoneCliente = idTelefoneCliente;
        this.tipoTelefoneCliente = tipoTelefoneCliente;
        this.dddTelefoneCliente = dddTelefoneCliente;
        this.numeroTelefoneCliente = numeroTelefoneCliente;
        }
/*
        public void setIdTelefoneCliente(int IdTelefoneCliente)
        {
        this.idTelefoneCliente = IdTelefoneCliente;
        }
        public int getIdTelefoneCliente()
        {
        return idTelefoneCliente;
        }
*/
        public void setTipoTelefoneCliente(String tipoTelefoneCliente)
        {
        this.tipoTelefoneCliente = tipoTelefoneCliente;
        }
        public String getTipoTelefoneCliente()
        {
        return tipoTelefoneCliente;
        }

        public void setDddTelefoneCliente(int dddTelefoneCliente)
        {
        this.dddTelefoneCliente = dddTelefoneCliente;
        }
        public int getDddTelefoneCliente()
        {
        return dddTelefoneCliente;
        }

        public void setNumeroTelefoneCliente(int numeroTelefoneCliente)
        {
        this.numeroTelefoneCliente = numeroTelefoneCliente;
        }
        public int getNumeroTelefoneCliente()
        {
        return numeroTelefoneCliente;
        }


}
