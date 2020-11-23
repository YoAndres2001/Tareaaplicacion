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

    public void IrAOperacionesCRUD(View view){
        Intent activitycrudoperaciones = new Intent(this, CrudOperaciones.class);
        startActivity(activitycrudoperaciones);
    }

    public void IrABuscar (View view){
        Intent activitybuscaroperaciones = new Intent(this, Crudbuscar.class);
        startActivity(activitybuscaroperaciones);
    }
}