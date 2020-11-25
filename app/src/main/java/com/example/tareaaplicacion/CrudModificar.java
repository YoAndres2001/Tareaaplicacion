package com.example.tareaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrudModificar extends AppCompatActivity {

    EditText editText_CrudID, editText_CrudDueño, editText_CrudPatente, editText_CrudFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_modificar);

        editText_CrudID  = findViewById(R.id.editText_CrudID);
        editText_CrudDueño = findViewById(R.id.editText_CrudDueño);
        editText_CrudPatente = findViewById(R.id.editText_CrudPatente);
        editText_CrudFecha = findViewById(R.id.editText_CrudFecha);
    }
    public void ModificarVehiculo(View view){
        GestorBD gestor = new GestorBD(this, "Vehiculo", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = editText_CrudID.getText().toString();
        String propietario = editText_CrudDueño.getText().toString();
        String patente = editText_CrudPatente.getText().toString();
        String fecha = editText_CrudFecha.getText().toString();

        ContentValues fila = new ContentValues();

        fila.put("propietario", propietario);
        fila.put("patente", patente);
        fila.put("fecha", fecha);

        if (!id.isEmpty() && !propietario.isEmpty() && !patente.isEmpty() && !fecha.isEmpty()){
            int filas = db.update("vehiculo", fila, "id=" + id, null);

            if (filas == 1){
                Toast.makeText(this, "El vehiculo se actualizo correctamente", Toast.LENGTH_SHORT).show();
                db.close();

                editText_CrudID.setText("");
                editText_CrudDueño.setText("");
                editText_CrudPatente.setText("");
                editText_CrudFecha.setText("");
            }
            else {
                Toast.makeText(this, "ha ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        }

        db.close();
    }

    public void Cancelar(View view){
        Intent Cancelar = new Intent(this, Crudindex.class);
        startActivity(Cancelar);
    }

}