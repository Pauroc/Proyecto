package com.example.stress1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private Button RRegistro;
    private EditText Ntxt;
    private EditText Atxt;
    private EditText Etxt;
    private EditText Ctxt;
    private EditText CCtxt;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Ntxt = findViewById(R.id.Nombres);
        Atxt = findViewById(R.id.Apellidos);
        Etxt = findViewById(R.id.REmail);
        Ctxt = findViewById(R.id.RContraseña);
        CCtxt = findViewById(R.id.RConfiContreseña);

        RRegistro = findViewById(R.id.Iniciar);
        RRegistro.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            String nombre = Ntxt.getText().toString();
            String apellido = Atxt.getText().toString();
            String email = Etxt.getText().toString();
            String Contraseña = Ctxt.getText().toString();
            String CContraseña = CCtxt.getText().toString();

            if(nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || Contraseña.isEmpty() || CContraseña.isEmpty()) {
                CharSequence text = "Diligencie todos los campos";
                Toast.makeText(Registro.this, text, Toast.LENGTH_SHORT).show();
                // Etxt.setError("Campo vacio");
                // Ptxt.setError("Campo vacio");
            }else {
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Etxt.setError("Correo inválido");

                }else if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (Contraseña == CContraseña){
                        CharSequence text = "Datos correctos";
                        Toast.makeText(Registro.this, text, Toast.LENGTH_SHORT).show();
                    } else if(Contraseña != CContraseña) {
                        CCtxt.setError(CContraseña);
                        Ctxt.setError(Contraseña);
                    }
                }
            }

        }
        });
    }
}