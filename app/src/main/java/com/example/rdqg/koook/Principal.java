package com.example.rdqg.koook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class Principal extends AppCompatActivity {

    ListView lista;

    String[][] datos = {
            {"Adobo de Chancho", "Plato de Fondo"," S/7.00","5","INGREDIENTES:\n" +
                    "->1/2 kg de carne de chancho trozado\n" +
                    "->2 cucharadas de ajo molido\n" +
                    "->1 cucharadita de comino\n" +
                    "->3 cucharadas de ají colorado molido\n" +
                    "->1/4 de vaso de vinagre\n" +
                    "->1 cucharada de orégano seco\n" +
                    "->1 vaso de chicha de jora (o 1 copita de pisco)\n" +
                    "->1 cebolla mediana cortada a la pluma (a lo largo)\n" +
                    "->Sal y pimienta al gusto\n" +
                    "->1/2 kilo de camote amarillo sancochado"},
            {"Alitas de Pollo a la BBQ", "Plato de Fondo"," S/7.00","5","INGREDIENTES:\n" +
                    "->Alitas de pollo (1000 g)\n" +
                    "->Cebolla blanca Olímpica (1 unidad)\n" +
                    "->Ajo Olímpica (5 dientes)\n" +
                    "->Mantequilla Olímpica (1 cucharada)\n" +
                    "->Salsa de tomate Olímpica (125 g)\n" +
                    "->Salsa barbecue Olímpica (125 g)\n" +
                    "->Miel de abejas Olímpica (60 cm3)\n" +
                    "->Azúcar morena Olímpica (2 cucharadas)\n" +
                    "->Mostaza Olímpica (2 cucharadas)\n" +
                    "->Sal y Pimienta Olímpica (al gusto)\n" +
                    "->Agua (60 cm3)"},
            {"Arroz con Pollo", "Plato de Fondo"," S/7.00","5","INGREDIENTES:\n" +
                    "->8 presas de pollo\n" +
                    "->½ taza de aceite\n" +
                    "->1 cebolla mediana picada en cuadritos\n" +
                    "->3 dientes de ajo picados\n" +
                    "->½ taza de ají amarillo fresco licuado\n" +
                    "->1 taza de culantro molido\n" +
                    "->2 pimientos (1 picado y el otro en tiras para decorar)\n" +
                    "->3 tazas de arroz\n" +
                    "->1 taza de arvejas\n" +
                    "->½ taza de choclo desgranado\n" +
                    "->2 ½ taza de agua hirviendo\n" +
                    "->½ taza de cerveza\n" +
                    "->Sal\n" +
                    "->Pimienta"},
            {"Bistec a lo Pobre", "Plato de Fondo"," S/7.00","5","INGREDIENTES:\n" +
                    "->4 filetes de carne\n" +
                    "->4  huevos fritos\n" +
                    "->2 plátanos para freír maduros o plátanos de la isla\n" +
                    "->1/2 kg de arroz blanco cocido\n" +
                    "->Papas fritas\n" +
                    "->1 cda. de ajo molido\n" +
                    "->Aceite\n" +
                    "->Sal y pimienta al gusto"},
            {"Carapulcra con Chancho", "Plato de Fondo"," S/7.00","5","INGREDIENTES:\n" +
                    "->1/2 kg de papa seca previamente tostada ligeramente y remojada\n" +
                    "->1/2 kg de carne de chancho (cerdo)o pollo\n" +
                    "->50 gr de maní (cacahuete) tostado y molido\n" +
                    "->1 cebolla roja grande cortada en cuadritos\n" +
                    "->4 cucharadas de ají panca molido\n" +
                    "->1/4 de vaso de vino tinto dulce\n" +
                    "->1/2 taza de aceite\n" +
                    "->1 cucharada pequeña de ajo molido\n" +
                    "->1 taza de caldo de carne\n" +
                    "->1/2 kg de arroz blanco preparado para acompañar\n" +
                    "->Perejil, comino, sal y pimienta"},
            {"Chancho al Horno c/n Puré", "Plato de Fondo"," S/7.00","5","INGREDIENTES:\n" +
                    "->800 gr. de lomo de cerdo (limpio)\n" +
                    "->800 gr. de tomate triturado\n" +
                    "->1 cebolleta\n" +
                    "->2 patatas\n" +
                    "->2 dientes de ajo\n" +
                    "->50 gr. de pasas\n" +
                    "->12 higos secos\n" +
                    "->Agua\n" +
                    "->1/2 vaso de vino fino\n" +
                    "->aceite de oliva virgen extra\n" +
                    "->sal\n" +
                    "->pimienta\n" +
                    "->perejil"},
    };

    int[] datosImg = {R.drawable.adobocerdo, R.drawable.alitasdepollobbq, R.drawable.arrozpollo, R.drawable.bistecalopobre, R.drawable.chanchocarapulcra, R.drawable.chichapescao};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lista = (ListView)findViewById(R.id.lvLista);
        lista.setAdapter(new Adaptador(this,datos,datosImg));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesProducto.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][4]);
                startActivity(visorDetalles);
            }
        });
    }
}
