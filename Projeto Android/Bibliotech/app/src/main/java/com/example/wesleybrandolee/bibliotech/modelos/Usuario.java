package com.example.wesleybrandolee.bibliotech.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;


@Entity
public class Usuario {
    @Id
    private long id;
    private String email;
    private String senha;
    private String apelido;

    public Usuario() {
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
