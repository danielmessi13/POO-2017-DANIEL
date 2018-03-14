/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author aluno
 */
public class Pessoa {
    
    String nome;
    String email;
    String senha;

    Pessoa(String nome, String email, String senha){
        validaCampos(nome,email,senha);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void validaCampos(String nome, String email, String senha) throws IllegalArgumentException{
       if (nome.trim().length() == 0
               || senha.trim().length() == 0
               || email.trim().length() == 0){
           throw new IllegalArgumentException("Erro ao alterar objeto.");

       }
    }

    
}
