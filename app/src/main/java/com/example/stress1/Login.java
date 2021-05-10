package com.example.stress1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private Button Registrop;
    private Button Inicio;
    private EditText Etxt;
    private EditText Ptxt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Etxt = findViewById(R.id.Nombres);
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

                if(email.isEmpty() || Contraseña.isEmpty()) {
                    Etxt.setError("Campo vacio");
                    Ptxt.setError("Campo vacio");
                }else if(Patterns.EMAIL_ADDRESS.matcher(email).matches() && !Contraseña.isEmpty()){
                    ValidarUsuario("http://10.0.2.2/Prueba/validar_usuario.php");
                    /*CharSequence text = "Datos correctos";
                    Toast.makeText(Login.this, text, Toast.LENGTH_SHORT).show();
                    //Etxt.setError("Formato correcto de correo\"");*/
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Etxt.setError("Formato incorrecto de correo");
                }
            }
        });
    }
    public void ValidarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    //Ptxt.setError("Usuario correcto");
                    CharSequence text = response;
                    Toast.makeText(Login.this, text, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, Pregunta1.class);
                    startActivity(i);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Ptxt.setError(error.toString());
                //Toast.makeText(Login.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String email = Etxt.getText().toString();
                String Contraseña = Ptxt.getText().toString();
                Map<String,String> Parametros = new HashMap<>();
                Parametros.put("usuario",email);
                Parametros.put("password", Contraseña);

                return Parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}