package com.example.rdqg.koook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetallesProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_producto);

        TextView titulo = (TextView)findViewById(R.id.tbTituloDescripcion);
        TextView detalles = (TextView)findViewById(R.id.tbDescripcion);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b!=null){
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
        }
    }
}
