/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocios;

/**
 *
 * @author Administrador
 */
public class Imovel {
 // private int idImovel;
    private double areaImovel;
    private int qtdComodos;
    private double valorImovel;
    private String descricaoImovel;
    private EnderecoImovel enderecoImovel;  //   estrangeira

    public Imovel()
    {
    super();
    }

        public Imovel(/*int idImovel,*/double areaImovel,int qtdComodos, double valorImovel,
                            String descricaoImovel)
            {
   //       this.idImovel = idImovel;
            this.areaImovel = areaImovel;
            this.qtdComodos = qtdComodos;
            this.valorImovel = valorImovel;
            this.descricaoImovel = descricaoImovel;
            }

        public Imovel(/*int idImovel, */double areaImovel,int qtdComodos, double valorImovel,
                            String descricaoImovel, EnderecoImovel enderecoImovel)
             {
     //     this.idImovel = idImovel;
            this.areaImovel = areaImovel;
            this.qtdComodos = qtdComodos;
            this.valorImovel = valorImovel;
            this.descricaoImovel = descricaoImovel;
            this.enderecoImovel = enderecoImovel;
             }
       /*
        public void setIdImovel(int idImovel)
            {
                this.idImovel = idImovel;
            }
        public int getIdImovel()
            {
                return idImovel;
            }
        */
       
        public void setAreaImovel(double areaImovel)
            {
                this.areaImovel = areaImovel;
            }
        public double getAreaImovel()
            {
            return areaImovel;
            }


        public void setQtdComodos(int qtdComodos)
            {
            this.qtdComodos = qtdComodos;
            }
        public int getQtdComodos()
            {
            return qtdComodos;
            }

        public void setValorImovel(double valorImovel)
            {
            this.valorImovel = valorImovel;
            }
        public double getValorImovel()
            {
            return valorImovel;
            }

        public void setDescricaoImovel(String descricaoImovel)
            {
            this.descricaoImovel = descricaoImovel;
            }
        public String getDescricaoImovel()
            {
            return descricaoImovel;
            }

        public EnderecoImovel getEnderecoImovel()
            {
                return enderecoImovel;
            }

        public void setEnderecoImovel(EnderecoImovel enderecoImovel)
            {
                this.enderecoImovel = enderecoImovel;
            }



}
