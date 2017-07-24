/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class EnderecoCliente {
 // private int idEnderecoClente;
    private String ruaCliente;
    private String numeroCliente; // vai que tenha um número do tipo "N° 49 A"
    private String complementoCliente;
    private String bairroCliente;
    private String cidadeCliente;
    
    public EnderecoCliente()
    {
    super();
    }

    public EnderecoCliente(/*int idEnderecoCliente,*/String ruaCliente, String numeroCliente, String complementoCliente,
            String bairroCliente,String cidadeCliente)
    {
         // this.idEnderecoClente = idEnderecoCliente;
            this.ruaCliente = ruaCliente;
            this.numeroCliente = numeroCliente;
            this.complementoCliente = complementoCliente;
            this.bairroCliente = bairroCliente;
            this.cidadeCliente = cidadeCliente;

    }
/*
    public void setIdEnderecoCliente(int idEnderecoCliente)
        {
        this.idEnderecoClente = idEnderecoCliente;
        }
    public int getIdEnderecoCliente()
        {
        return idEnderecoClente;
        }
*/
    public void setRuaCliente(String ruaCliente)
        {
        this.ruaCliente = ruaCliente;
        }
    public String getRuaCliente()
        {
        return ruaCliente;
        }

    public void setNumeroCliente(String numeroCliente)
        {
        this.numeroCliente = numeroCliente;
        }
    public String getNumeroCliente()
        {
        return numeroCliente;
        }

    public void setComplementoCliente(String complementoCliente)
        {
        this.complementoCliente = complementoCliente;
        }
    public String getComplementoCliente()
        {
        return complementoCliente;
        }

    public void setBairroCliente(String bairroCliente)
        {
        this.bairroCliente = bairroCliente;
        }
    public String getBairroCliente()
        {
        return bairroCliente;
        }

    public void setCidadeCliente(String cidadeCliente)
        {
        this.cidadeCliente = cidadeCliente;
        }
    public String getCidadeCliente()
        {
        return cidadeCliente;
        }


}
