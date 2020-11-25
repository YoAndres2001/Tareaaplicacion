package com.example.tareaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Crudbuscar extends AppCompatActivity {
    EditText edtDetalle_id;
    TextView txtDetalle_propietario, txtDetalle_patente, txtDetalle_fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudbuscar);

        edtDetalle_id  = findViewById(R.id.edtDetalle_id);
        txtDetalle_propietario = findViewById(R.id.txtDetalle_propietario);
        txtDetalle_patente = findViewById(R.id.txtDetalle_patente);
        txtDetalle_fecha = findViewById(R.id.txtDetalle_fecha);
    }

    public void BuscarVehiculo(View view){
        GestorBD gestor = new GestorBD(this, "Vehiculo", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = edtDetalle_id.getText().toString();

        Cursor datos = db.rawQuery("select propietario, patente, fecha from vehiculo where id =" + id, null);
        if (datos.moveToFirst()){

            txtDetalle_propietario.setText(datos.getString(0).toString());
            txtDetalle_patente.setText(datos.getString(1).toString());
            txtDetalle_fecha.setText(datos.getString(2).toString());

            edtDetalle_id.setText("");
            db.close();
        }else{
            Toast.makeText(this, "No existen registros asociados a este id", Toast.LENGTH_SHORT).show();
        }

        db.close();
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
                txtDetalle_propietario.setText("Dueño");
                txtDetalle_patente.setText("Patente");
                txtDetalle_fecha.setText("Fecha de ingreso");
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