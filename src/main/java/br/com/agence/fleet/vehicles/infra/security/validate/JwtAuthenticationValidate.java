package br.com.agence.fleet.vehicles.infra.security.validate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class JwtAuthenticationValidate {

    private String login;
    private String senha;

    public JwtAuthenticationValidate() {
    }

    @NotEmpty(message = "Login não pode ser vazio.")
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    @NotEmpty(message = "Senha não pode ser vazia.")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "JwtAuthenticationRequestDto [email=" + this.login + ", senha=" + senha + "]";
    }

}
