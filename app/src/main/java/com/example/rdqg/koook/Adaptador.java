package com.example.rdqg.koook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.DataOutput;

public class Adaptador extends BaseAdapter{

    private static LayoutInflater inflater = null;

    Context  contexto;
    String[][]datos;
    int[]datosImg;

    public Adaptador(Context contexto,String[][]datos, int[] imagenes)
    {
        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = imagenes;
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista,null);
        TextView titulo = (TextView)vista.findViewById(R.id.txtTitulo);
        TextView precio = (TextView)vista.findViewById(R.id.txtPrecio);
        TextView plato = (TextView)vista.findViewById(R.id.txtDir);
        ImageView imagen = (ImageView)vista.findViewById(R.id.ivImagen);
        RatingBar calificaion = (RatingBar)vista.findViewById(R.id.ratingBarPr);
        titulo.setText(datos[i][0]);
        plato.setText(datos[i][1]);
        precio.setText("Precio" + datos[1][2]);
        imagen.setImageResource(datosImg[i]);
        calificaion.setProgress(Integer.valueOf(datos[i][3]));

        imagen.setTag(i);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorImagen = new Intent(contexto, VisorImagen.class);
                visorImagen.putExtra("IMG",datosImg[(Integer)v.getTag()]);
                contexto.startActivity(visorImagen);
            }
        });

        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
