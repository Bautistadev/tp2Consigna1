package com.example.app_tp2_consigna1;

public class Vida {

    private Integer Vida = 5;

    public Vida(){

    }

    public Integer getVida(){
        return this.Vida;
    }
    public void Decrementar(){
        this.Vida--;
    }
    public Boolean isCero(){
        if(this.Vida == 1)
            return true;
        else
            return false;
    }
}
