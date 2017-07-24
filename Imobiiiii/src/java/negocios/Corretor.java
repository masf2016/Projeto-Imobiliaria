/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class Corretor {
  //private int idCorretor;
    private String nomeCorretor;
    private String cpfCorretor;
    private String rgCorretor;
    private String emailCorretor;
    private EnderecoCorretor enderecoCorretor;   //estrangeira
    private TelefoneCorretor telefoneCorretor;  //estrangeira
    private Acesso acesso;

    public Corretor()
    {
    super();
    }

    public Corretor(/*int idCorretor,*/String nomeCorretor,String cpfCorretor,String rgCorretor,
            String emailCorretor)
        {
         // this.idCorretor = idCorretor;
            this.nomeCorretor =nomeCorretor;
            this.cpfCorretor = cpfCorretor;
            this.rgCorretor= rgCorretor;
            this.emailCorretor = emailCorretor;
            
        }

    public Corretor(/*int idCorretor,*/String nomeCorretor,String cpfCorretor,String rgCorretor,
            String emailCorretor,EnderecoCorretor enderecoCorretor,TelefoneCorretor telefoneCorretor,Acesso acesso)
        {
         // this.idCorretor = idCorretor;
            this.nomeCorretor =nomeCorretor;
            this.cpfCorretor = cpfCorretor;
            this.rgCorretor= rgCorretor;
            this.emailCorretor = emailCorretor;            
            this.enderecoCorretor = enderecoCorretor;
            this.telefoneCorretor = telefoneCorretor;
            this.acesso = acesso;
        }
    /*
    public void setIdCorretor(int idCorretor)
            {
                this.idCorretor = idCorretor;
            }
    public int getIdCorretor()
            {
                return idCorretor;
            }

     */
    public void setNomeCorretor(String nomeCorretor)
            {
                this.nomeCorretor = nomeCorretor;
            }
    public String getNomeCorretor()
            {
                return nomeCorretor;
            }
    public void setCpfCorretor(String cpfCorretor)
            {
                this.cpfCorretor = cpfCorretor;
            }
    public String getCpfCorretor()
            {
                return cpfCorretor;
            }
    public void setRgCorretor(String rgCorretor)
            {
                this.rgCorretor = rgCorretor;
            }
    public String getRgCorretor()
            {
                return rgCorretor;
            }      
    public void setEmailCorretor(String emailCorretor)
            {
                this.emailCorretor = emailCorretor;
            }
   public String getEmailCorretor()
            {
                return emailCorretor;
            }
/*CHAVE ESTRANGEIRA*/


   public void setEnderecoCorretor(EnderecoCorretor enderecoCorretor)
            {
                this.enderecoCorretor = enderecoCorretor;
            }
   public EnderecoCorretor getEnderecoCorretor()
            {
                return enderecoCorretor;
            }
   public void setTelefone(TelefoneCorretor telefoneCorretor)
            {
                this.telefoneCorretor = telefoneCorretor;
            }
   public TelefoneCorretor getTelefoneCorretor()
            {
            return telefoneCorretor;
            }
   public Acesso getAcesso() {
                return acesso;
            }

   public void setAcesso(Acesso acesso) {
                this.acesso = acesso;
            }

}

