/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class EnderecoImovel {
  //private int idEnderecoImovel;
    private String ruaImovel;
    private String numeroImovel;
    private String bairroImovel;
    private String cidadeImovel;
    
    public EnderecoImovel()
    {
    super();
    }

    public EnderecoImovel(/*int idEnderecoImovel,*/String ruaImovel,String numeroImovel,
            String bairroImovel,String cidadeImovel)
    {
  //this.idEnderecoImovel = idEnderecoImovel;
    this.ruaImovel = ruaImovel;
    this.numeroImovel = numeroImovel;
    this.bairroImovel = bairroImovel;
    this.cidadeImovel = cidadeImovel;
    }


/*
    public void setIdEnderecoImovel(int idEnderecoImovel)
        {
        this.idEnderecoImovel = idEnderecoImovel;
        }
    public  int getIdEnderecoImovel()
        {
        return idEnderecoImovel;
        }
*/
    public void setRuaImovel(String ruaImovel)
        {
        this.ruaImovel = ruaImovel;
        }
    public String getRuaImovel()
        {
        return ruaImovel;
        }

    public void setNumeroImovel(String numeroImovel)
        {
        this.numeroImovel = numeroImovel;
        }
    public String getNumeroImovel()
        {
        return numeroImovel;
        }

    public void setBairroImovel(String bairroImovel)
        {
        this.bairroImovel = bairroImovel;
        }
    public String getBairroImovel()
        {
        return bairroImovel;
        }

    public void setCidadeImovel(String cidadeImovel)
        {
        this.cidadeImovel = cidadeImovel;
        }
    public String getCidadeImovel()
        {
        return cidadeImovel;
        }




}
