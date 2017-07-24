/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class EnderecoCorretor {
  //private int idEnderecoCorretor;
    private String ruaCorretor;
    private String numeroCorretor;// vai que tenha um número do tipo "N° 49 A"
    private String complementoCorretor;
    private String bairroCorretor;
    private String cidadeCorretor;

public EnderecoCorretor()
    {
    super();
    }

public EnderecoCorretor(/*int idEnderecoCorretor,*/String ruaCorretor,String numeroCorretor,String complementoCorretor,String bairroCorretor,String cidadeCorretor)
        {
     // this.idEnderecoCorretor = idEnderecoCorretor;
        this.ruaCorretor = ruaCorretor;
        this.numeroCorretor = numeroCorretor;
        this.complementoCorretor = complementoCorretor;
        this.bairroCorretor = bairroCorretor;
        this.cidadeCorretor = cidadeCorretor;

        }
/*
        public void setIdEnderecoCorretor(int idEnderecoCorretor)
            {
            this.idEnderecoCorretor = idEnderecoCorretor;
            }
        public int getIdEnderecoCorretor()
            {
            return idEnderecoCorretor;
            }
*/
        public void setRuaCorretor(String ruaCorretor)
            {
            this.ruaCorretor = ruaCorretor;
            }
        public  String getRuaCorretor()
            {
            return ruaCorretor;
            }

        public void setNumeroCorretor(String numeroCorretor)
            {
            this.numeroCorretor =  numeroCorretor;
            }
        public String getNumeroCorretor()
            {
            return numeroCorretor;
            }

        public void setComplementoCorretor(String complementoCorretor)
            {
            this.complementoCorretor = complementoCorretor;
            }
        public String getComplementoCorretor()
            {
            return complementoCorretor;
            }

        public void setBairroCorretor(String bairroCorretor)
            {
            this.bairroCorretor =bairroCorretor;
            }
        public String getBairroCorretor()
            {
            return  bairroCorretor;
            }

        public void setCidadeCorretor(String cidadeCorretor)
            {
            this.cidadeCorretor = cidadeCorretor;
            }
        public String getCidadeCorretor()
            {
            return cidadeCorretor;
            }

}