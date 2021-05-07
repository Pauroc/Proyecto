package com.example.stress1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                    if (Contraseña.equals(CContraseña)){
                        if(ContraseñaV( Contraseña) ) {
                            CrearUsuario("");
                            /*CharSequence text = "Datos correctos";
                            Toast.makeText(Registro.this, text, Toast.LENGTH_SHORT).show();*/
                        }else{
                            Ctxt.setError("La contraseña debe contener al menos una letra en mayúscula, minúscula\n" +
                                    "Un caracter numérico\n"+
                                    "Un caracter especial");
                            CCtxt.setError("La contraseña debe contener al menos una letra en mayúscula, minúscula\n" +
                                    "Un caracter numérico\n"+
                                    "Un caracter especial");
                        }
                    } else {
                        CharSequence text = "Las contraseñas deben ser iguales";
                        Toast.makeText(Registro.this, text, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        });
    }
    public boolean ContraseñaV(String Contraseña) {

        // Patrón para validar la contraseña
        //Pattern pattern = Pattern.compile("^([a-z]{5,6})([A-Z]{2,3})([0-9]{3})$");
        Pattern pattern = Pattern.compile
                (
                        "^"+
                                "(?=.*[0-9])"+
                                "(?=.*[a-z])"+
                                "(?=.*[A-Z])"+
                                "(?=.*[._:¿?!¡])"+
                                "(?=\\S+$)"+
                                ".{7,10}"+
                                "$"
                );
        Matcher mather = pattern.matcher(Contraseña);
        return mather.find();
    }
    public void CrearUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    //Ptxt.setError(response.toString());
                    CharSequence text = "Funciono";
                    Toast.makeText(Registro.this, text, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Ctxt.setError(error.toString());
                //Toast.makeText(Login.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String nombre = Ntxt.getText().toString();
                String apellido = Atxt.getText().toString();
                String email = Etxt.getText().toString();
                String Contraseña = Ctxt.getText().toString();

                Map<String,String> Parametros = new HashMap<>();
                Parametros.put("Nombre", nombre);
                Parametros.put("Apellido", apellido);
                Parametros.put("Correo",email);
                Parametros.put("Contraseña", Contraseña);

                return Parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}