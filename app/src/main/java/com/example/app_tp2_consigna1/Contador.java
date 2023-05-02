package com.example.app_tp2_consigna1;

import android.widget.TextView;

public class Contador {

    private TextView lblContador;
    private Integer contador = 0;

    public Contador (TextView lblContador ){
        this.lblContador = lblContador;
        this.lblContador.setText(String.valueOf(contador));
    }

    public String getValor(){
        return String.valueOf(this.contador);
    }

    public void Aumentar(){
        this.contador += 10;
        Actualizar();
    }
    public void Actualizar(){
        this.lblContador.setText(String.valueOf(contador));
    }


}
