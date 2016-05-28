package com.exemple.icarobrandao.aula7.models;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by icarobrandao on 28/05/16.
 */
public class UserSugar extends SugarRecord implements Serializable {

    private String email;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public UserSugar() {
    }
}
