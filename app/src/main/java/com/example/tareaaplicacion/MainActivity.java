package com.example.tareaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String correo = "admin@mail.com";
    String clave = "admin";
    EditText editText_Correo;
    EditText editText_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_Correo = findViewById(R.id.edtMain_email);
        editText_Password = findViewById(R.id.edtMain_password);

    }

    public void irACrudIndex(View view)
    {
        Intent activityindexcrud = new Intent(this, Crudindex.class);

        if (correo.equals(editText_Correo.getText().toString()) && clave.equals(editText_Password.getText().toString())) {
            startActivity(activityindexcrud);
            Toast.makeText(this, "Bienvenido al home", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
        }
    }

}