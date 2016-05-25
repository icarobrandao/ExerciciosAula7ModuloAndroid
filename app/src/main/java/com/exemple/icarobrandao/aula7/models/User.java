package com.exemple.icarobrandao.aula7.models;

import java.io.Serializable;

/**
 * Created by icarobrandao on 21/05/16.
 */
public class User implements Serializable {

    private Long id;
    private String nome;
    private String email;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
