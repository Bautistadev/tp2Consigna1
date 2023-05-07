package com.example.app_tp2_consigna1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    private Intent panelMain;
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

        panelMain = new Intent(Juego.this,MainActivity.class);
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
                     guardar();
                     startActivity(this.panelMain);
                 }else {
                     SacarVida();
                     this.vida.Decrementar();
                 }
             }
        }
    }

    private void guardar(){
        SharedPreferences preferences = getSharedPreferences("puntuaciones", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ultimaPuntuacion",this.contador.getValor());
        if(Integer.parseInt(this.contador.getValor()) > Integer.parseInt(preferences.getString("maximaPuntuacion","0")))
            editor.putString("maximaPuntuacion",this.contador.getValor());
        editor.commit();

    }

    private void SacarVida(){
        switch (this.vida.getVida()){
            case 5: findViewById(R.id.Corazon5).setVisibility(View.INVISIBLE);
                    break;
            case 4: findViewById(R.id.Corazon4).setVisibility(View.INVISIBLE);
                    break;
            case 3: findViewById(R.id.Corazon3).setVisibility(View.INVISIBLE);
                    break;
            case 2: findViewById(R.id.Corazon2).setVisibility(View.INVISIBLE);
                    break;
            case 1: findViewById(R.id.Corazon1).setVisibility(View.INVISIBLE);
                    break;
        }
    }
}