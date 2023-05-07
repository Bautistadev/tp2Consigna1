package com.example.app_tp2_consigna1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnJugar;
    private Intent panelJugar;

    private TextView lblMaxPuntuacion;
    private TextView lblUltPuntuacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblMaxPuntuacion = findViewById(R.id.lblMaxPuntuacion);
        lblUltPuntuacion = findViewById(R.id.lblUltPuntuacion);
        btnJugar = findViewById(R.id.btnJugar);
        panelJugar = new Intent(MainActivity.this,Juego.class);

        Cargar();
        btnJugar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnJugar)
            startActivity(this.panelJugar);
    }

    public void Cargar(){
        SharedPreferences preferences = getSharedPreferences("puntuaciones", Context.MODE_PRIVATE);
        String maxPuntuacion = preferences.getString("maximaPuntuacion","0");
        String ultPuntuacion = preferences.getString("ultimaPuntuacion","0");
        this.lblMaxPuntuacion.setText(maxPuntuacion);
        this.lblUltPuntuacion.setText(ultPuntuacion);
    }
}