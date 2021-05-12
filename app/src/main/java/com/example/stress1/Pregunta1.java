package com.example.stress1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Pregunta1 extends AppCompatActivity {
    private Button  graficar;
    private RadioButton
    P1O1,
    P1O2,
            P1O3,
    P1O4,
            P1O5,
    P1O6,
            P1O7,
    P1O8,
            P1O9,
    P1O10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);
        graficar = findViewById(R.id.Graficar);
        graficar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pregunta1.this, Graficas.class);
                startActivity(i);
            }
        });
    }
}