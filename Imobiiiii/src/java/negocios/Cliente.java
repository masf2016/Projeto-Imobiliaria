/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class Cliente {
 // private int idCliente;  auto incremento no BD, não é usada aqui
    private String nomeCliente ;
    private String cpfCliente;
    private String rgCliente;
    private String emailCliente;
    private EnderecoCliente enderecoCliente; 
    private TelefoneCliente telefoneCliente; 
    private Acesso acesso;

    public Cliente()
    {
     super();
    }

    public Cliente(/*int idCliente,*/String nomeCliente,String cpfCliente,String rgCliente,
            String emailCliente)
        {
         // this.idCliente =idCliente;
            this.nomeCliente =nomeCliente;
            this.cpfCliente = cpfCliente;
            this.rgCliente= rgCliente;
            this.emailCliente = emailCliente;
    
        }
    public Cliente(/*int idCliente,*/String nomeCliente,String cpfCliente,String rgCliente,
            String emailCliente,EnderecoCliente enderecoCliente,TelefoneCliente telefoneCliente,Acesso acesso)
        {
          //this.idCliente =idCliente;
            this.nomeCliente =nomeCliente;
            this.cpfCliente = cpfCliente;
            this.rgCliente= rgCliente;
            this.emailCliente = emailCliente;            
            this.enderecoCliente = enderecoCliente;
            this.telefoneCliente = telefoneCliente;
            this.acesso = acesso;
            
        }

    
  /*
    public void setIdCliente(int idCliente) //auto incremento
            {
                this.idCliente = idCliente;
            }
    public int getIdCliente()
            {
                return idCliente;
            }*/
    public void setNomeCliente(String nomeCliente)
            {
                this.nomeCliente = nomeCliente;
            }
    public String getNomeCliente()
            {
                return nomeCliente;
            }
    public void setCpfCliente(String cpfCliente)
            {
                this.cpfCliente = cpfCliente;
            }
    public String getCpfCliente()
            {
                return cpfCliente;
            }
    public void setRgCliente(String rgCliente)
            {
                this.rgCliente = rgCliente;
            }
    public String getRgCliente()
            {
                return rgCliente;
            }      
    public void setEmailCliente(String emailCliente)
            {
                this.emailCliente = emailCliente;
            }
   public String getEmailCliente()
            {
                return emailCliente;
            }
 /* CHAVE ESTRANGEIRA*/



   
   public void setEnderecoCliente(EnderecoCliente enderecoCliente)
            {
                this.enderecoCliente = enderecoCliente;
            }
   public EnderecoCliente getEnderecoCliente()
            {
                return enderecoCliente;
            }
   public void setTelefoneCliente(TelefoneCliente telefoneCliente)
            {
                this.telefoneCliente = telefoneCliente;
            }
   public TelefoneCliente getTelefoneCliente()
            {
            return telefoneCliente;
            }
   public Acesso getAcesso() {
            return acesso;
            }

   public void setAcesso(Acesso acesso) {
                this.acesso = acesso;
            }

}