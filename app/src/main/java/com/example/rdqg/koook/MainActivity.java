package com.example.rdqg.koook;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity {

    TextView tvRegistrese;
    Button btnIngresar;

    //LLAMAR AL OPEN HELPER DE SQLITE
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        tvRegistrese=(TextView)findViewById(R.id.tvRegistrese);
        tvRegistrese.setOnClickListener(new View.OnClickListener() {
            @Override
            //PARA LLAMAR AL REGISTRO CUANDO HACEMOS CLICK
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),registro.class);
                startActivity(i);
            }
        });

        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtusu=(EditText)findViewById(R.id.txtUsuario);
                EditText txtpas=(EditText)findViewById(R.id.txtPassword);

                try{
                    Cursor cursor=helper.ConsultarUsuario
                            (txtusu.getText().toString(),txtpas.getText().toString());
                    if(cursor.getCount()>0){
                        Intent i=new Intent(getApplicationContext(),Principal.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplicationContext(),"Usuario y/o password incorrectos"
                                ,Toast.LENGTH_LONG).show();
                    }
                    txtusu.setText("");
                    txtpas.setText("");
                    txtusu.findFocus();

                }catch (SQLException e){
                    e.printStackTrace();
                }

            }
        });

    }
}
