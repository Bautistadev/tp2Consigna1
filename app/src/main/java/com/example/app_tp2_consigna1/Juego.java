package com.example.app_tp2_consigna1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Juego extends AppCompatActivity implements View.OnClickListener {

    private TextView lblContador;
    private TextView txtNumero;
    private Button btnComparar;
    private Vida vida;
    private Contador contador;
    private String num = String.valueOf(numGenerator.getRandomNum());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        lblContador = findViewById(R.id.lblContador);
        txtNumero = findViewById(R.id.txtNumero);
        btnComparar = findViewById(R.id.btnComparar);

        contador = new Contador(this.lblContador);

        vida = new Vida();

        this.btnComparar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnComparar){
             if(String.valueOf(this.txtNumero.getText()).equals(this.num)){
                this.contador.Aumentar();
                this.num = String.valueOf(numGenerator.getRandomNum());
             }else{
                 if(this.vida.isCero()) {
                     this.btnComparar.setEnabled(false);
                     System.out.println("PERDISTE");
                 }else {
                     this.vida.Decrementar();

                 }
             }
        }
    }
}