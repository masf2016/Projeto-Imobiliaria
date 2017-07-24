package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrador
 */
public class Conexao {

    // Declarações globais
  
    private String login = "root";
    private String senha = "123";
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/imobiliaria";
    
    private Connection conexao = null;

    public Connection abrirConexao()
    {

        try // Substitui o if para algumas classes
        {
            // Carregando o JDBC Driver
            Class.forName(driver);
            System.out.println("Driver Carregado!");
            

        }
        // Driver não encontrado
        catch (ClassNotFoundException ex)
        {
            System.out.println("Driver não encontrado! " + ex);
        }

        try 
        {
            // Criando a conexão com o Banco de Dados
            conexao = DriverManager.getConnection(url, login, senha);
            System.out.println("Banco Conectado!");

        }
        // Não está conseguindo se conectar ao banco
        catch (SQLException ex)
        {
            System.out.println("Não foi possivel conectar ao banco! Erro: "+ex);
        }

        return conexao;

    }

    public Connection fecharConexao()
    {

        try
        {
            // Fecha a conexão
            conexao.close();
            System.out.println("Conexão com o banco encerrada!");

        }
        // Não está conseguindo fechar a conexão
        catch (SQLException ex)
        {
            System.out.println("Não foi possível encerrar a conexão! Erro: " + ex);
        }

        return conexao;

    }
    
}