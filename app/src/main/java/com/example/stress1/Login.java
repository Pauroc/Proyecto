package com.example.stress1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class Login extends AppCompatActivity {
    private Button Registrop;
    private Button Inicio;
    private EditText Etxt;
    private EditText Ptxt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Etxt = findViewById(R.id.txtEmailI);
        Ptxt = findViewById(R.id.txtContraseñaI);
        Registrop = findViewById(R.id.btnregistro);
        Registrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Registro.class);
                startActivity(i);
            }
        });
        Inicio = findViewById(R.id.Iniciar);
        Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Etxt.getText().toString();
                String Contraseña = Ptxt.getText().toString();

                if(email.isEmpty()) {
                    CharSequence text = "Campos vacios";
                    Toast.makeText(Login.this, text, Toast.LENGTH_SHORT).show();
                }else if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    CharSequence text = "Formato correcto de correo";
                    Toast.makeText(Login.this, text, Toast.LENGTH_SHORT).show();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    CharSequence text = "Formato incorrecto de correo";
                    Toast.makeText(Login.this, text, Toast.LENGTH_SHORT).show();
                }else if (Contraseña.isEmpty()){
                    CharSequence text = "Campos vacios";
                    Toast.makeText(Login.this, text, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}