package com.example.tareaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CrudEliminar extends AppCompatActivity {
    EditText edtDetalle_id;
    TextView txtDetalle_propietario, txtDetalle_patente, txtDetalle_fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_eliminar);

        edtDetalle_id  = findViewById(R.id.edtDetalle_id);
        txtDetalle_propietario = findViewById(R.id.txtDetalle_propietario);
        txtDetalle_patente = findViewById(R.id.txtDetalle_patente);
        txtDetalle_fecha = findViewById(R.id.txtDetalle_fecha);
    }

    public void EliminarVehiculo(View view){
        GestorBD gestor = new GestorBD(this, "Vehiculo", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = edtDetalle_id.getText().toString();

        if (!id.isEmpty()){
            int filas = db.delete("vehiculo", "id=" + id,null);

            if (filas == 1){
                Toast.makeText(this, "Se ha eliminado el vehiculo", Toast.LENGTH_LONG).show();
                db.close();
                txtDetalle_propietario.setText("Propietario:");
                txtDetalle_patente.setText("Patente:");
                txtDetalle_fecha.setText("Fecha:");
                edtDetalle_id.setText("");
            }else {
                Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        }
        db.close();
    }

    public void Cancelar(View view){
        Intent Cancelar = new Intent(this, Crudindex.class);
        startActivity(Cancelar);
    }
}