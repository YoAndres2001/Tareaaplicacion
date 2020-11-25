package com.example.tareaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Crudindex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudindex);
    }

    public void GoToRegistrar(View view){
        Intent ActivityRegistrar = new Intent(this, CrudRegistrar.class);
        startActivity(ActivityRegistrar);
    }

    public void GoToModificar(View view){
        Intent ActivityModificar = new Intent(this, CrudModificar.class);
        startActivity(ActivityModificar);
    }

    public void GoToBuscar (View view){
        Intent ActivityBuscar = new Intent(this, Crudbuscar.class);
        startActivity(ActivityBuscar);
    }
}