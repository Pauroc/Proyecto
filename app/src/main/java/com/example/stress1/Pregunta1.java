package com.example.stress1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pregunta1 extends AppCompatActivity {
    private Button  graficar;
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