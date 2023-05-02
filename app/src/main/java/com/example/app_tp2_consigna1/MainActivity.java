package com.example.app_tp2_consigna1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnJugar;
    private Intent panelJugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnJugar = findViewById(R.id.btnJugar);
        panelJugar = new Intent(MainActivity.this,Juego.class);

        btnJugar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnJugar)
            startActivity(this.panelJugar);
    }
}