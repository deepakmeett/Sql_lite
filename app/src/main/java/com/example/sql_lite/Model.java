package com.example.sql_lite;

public class Model {
    
    String password, email;

    public Model(String password, String email) {
        
        this.password = password;
        this.email = email;
    }
    
    public Model(){
        
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
