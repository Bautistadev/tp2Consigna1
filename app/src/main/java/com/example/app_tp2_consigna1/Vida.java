package com.example.app_tp2_consigna1;

public class Vida {

    private Integer Vida = 5;

    public Vida(){

    }

    public String getVida(){
        return String.valueOf(this.Vida);
    }
    public void Decrementar(){
        this.Vida--;
    }
    public Boolean isCero(){
        if(this.Vida == 0)
            return true;
        else
            return false;
    }
}