package com.example.tareaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrudRegistrar extends AppCompatActivity {
    EditText editText_CrudID, editText_CrudDueño, editText_CrudPatente, editText_CrudFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_registrar);

        editText_CrudID  = findViewById(R.id.editText_CrudID);
        editText_CrudDueño = findViewById(R.id.editText_CrudDueño);
        editText_CrudPatente = findViewById(R.id.editText_CrudPatente);
        editText_CrudFecha = findViewById(R.id.editText_CrudFecha);
}


    public void RegistarVehiculo(View view){

        GestorBD gestor = new GestorBD(this, "Vehiculo", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = editText_CrudID.getText().toString();
        String propietario = editText_CrudDueño.getText().toString();
        String patente = editText_CrudPatente.getText().toString();
        String fecha = editText_CrudFecha.getText().toString();

        if (!id.isEmpty() && !propietario.isEmpty() && !patente.isEmpty() && !fecha.isEmpty()){
            ContentValues fila = new ContentValues();

            fila.put("id", id);
            fila.put("propietario", propietario);
            fila.put("patente", patente);
            fila.put("fecha", fecha);

            db.insert("vehiculo", null, fila);
            db.close();

            Toast.makeText(this, "Vehiculo ingresado exitosamente", Toast.LENGTH_SHORT).show();

            editText_CrudID.setText("");
            editText_CrudDueño.setText("");
            editText_CrudPatente.setText("");
            editText_CrudFecha.setText("");
        }else {
            Toast.makeText(this, "Por favor, complete los campos", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

    public void Cancelar(View view){
        Intent Cancelar = new Intent(this, Crudindex.class);
        startActivity(Cancelar);
    }

}