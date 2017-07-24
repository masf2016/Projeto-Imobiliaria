/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import sun.rmi.log.LogInputStream;

/**
 *
 * @author Administrador
 */
public class Acesso {

    private String login;
    private String senha;
    private String tipoDeUsuario;

    public Acesso() {

        super();
    }

    public Acesso(String login, String senha, String tipoDeUsuario) {
        this.login = login;
        this.senha = senha;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getLogin() {

        return login;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoDeUsuario() {

        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public boolean permissão(Object o) {

        Acesso acesso = (Acesso) o;

        if ((this.login.equals(acesso.getLogin())) && (this.senha.equals(acesso.getSenha())) && (this.tipoDeUsuario.equals(acesso.getTipoDeUsuario()))) {
            return true;
        } else {
            return false;
        }
    }
}
