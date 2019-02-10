package com.blitz.sqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.blitz.sqliteapp.model.ListaData;

public class AddDataActivity extends AppCompatActivity {

    private EditText id, nombre, persona, descripcion, caracteristicas,favoritos;
    private ImageView image;
    private ListaData listaData;
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        id = (EditText) findViewById(R.id.id);
        nombre = (EditText) findViewById(R.id.nombre);
        persona = (EditText) findViewById(R.id.persona);
        descripcion = (EditText) findViewById(R.id.descripcion);
        caracteristicas = (EditText) findViewById(R.id.caracteristicas);
        image = (ImageView) findViewById(R.id.image);
        favoritos = (EditText) findViewById(R.id.favoritos);
    }

    public void agregar(View view){
        listaData = new ListaData(id.getText().toString(), nombre.getText().toString(),
                Integer.valueOf(persona.getText().toString()), descripcion.getText().toString(),
                caracteristicas.getText().toString(), "imagen.jpg",
                Integer.valueOf(favoritos.getText().toString()));

        data = new Data(getApplicationContext());
        data.open();
        data.insertDataList(listaData);

        Toast.makeText(this, "Se agregaron los datos correctamente", Toast.LENGTH_SHORT).show();

        finish();
    }
}
