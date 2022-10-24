package com.example.pm2e124;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pm2e124.configuracion.SQLiteConexion;
import com.example.pm2e124.tablas.Transacciones;

public class MainActivity extends AppCompatActivity {
 //    uthLogo = findViewById(R.id.uthlogo);
        Button salvar, salvados;
        EditText nombres, telefono,nota,pais;
            static final int peticion_captura_imagen = 100;
            static final int peticion_acceso_cam = 201;
            ImageView imageView;
            Button btntakephoto;
            String PathImagen;
    private void config()
    {
        nombres = (EditText) findViewById(R.id.txtEditName);
        nota = (EditText) findViewById(R.id.txtEditNota);
        telefono = (EditText) findViewById(R.id.editarTel);
        pais = (EditText) findViewById(R.id.paises);
        salvar = (Button) findViewById(R.id.btnSalvar);
        salvados = (Button) findViewById(R.id.btnSalvados);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        config();

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarContactos();
            }
          //  Intent intent = new Intent(getApplicationContext(), ActivityLista.class);
          //  startActivity(intent);
        });

        salvados.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {

                Intent intent = new Intent(getApplicationContext(), ActivityLista.class);
                startActivity(intent);
              //  Toast.makeText(MainActivity.this, " *_*", Toast.LENGTH_SHORT).show();

                //Intent intent = new Intent(getApplicationContext(),ActivityLista.class);

           //     intent.putExtra("nombre", nombres.getText().toString());
             //   intent.putExtra("telefono", telefono.getText().toString());

                startActivity(intent);

            }
        });
        /*
        //BOTON SALVAR
        salvar = findViewById(R.id.btnSalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                //DECLARACION DEL INTENT
                Intent intent = new Intent(getApplicationContext(),ActivityLista.class);
                //GENERAR LLAVES
               intent.putExtra("nombre" , nombres.getText().toString());
               //INICIAMOS LA ACTIVIDAD
               startActivity(intent);

            }
        });

        //BOTON SALVADOS
        salvados = findViewById(R.id.btnSalvados);
        salvados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DECLARACION DEL INTENT
                Intent intent = new Intent(getApplicationContext(),ActivityLista.class);
                //GENERAR LLAVES
                intent.putExtra("nombre" , nombres.getText().toString());
                //INICIAMOS LA ACTIVIDAD
                startActivity(intent);
            }
        });*/
    }




    private void tomarfoto() {
        Intent intentfoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intentfoto.resolveActivity(getPackageManager())!= null)
        {
            startActivityForResult(intentfoto, peticion_captura_imagen);
        }
    }




    private void AgregarContactos() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.nota, nota.getText().toString());
        valores.put(Transacciones.telefono, telefono.getText().toString());
        valores.put(Transacciones.pais, pais.getText().toString());

        Long listaContactos  = db.insert(Transacciones.TbContactos, Transacciones.id, valores);

        Toast.makeText(getApplicationContext(), "Contacto Ingresado: " + listaContactos.toString()
                , Toast.LENGTH_SHORT).show();

        db.close();

        ClearScreen();
    }

    private void ClearScreen() {
        nombres.setText("");
        nota.setText("");
        telefono.setText("");
        pais.setText("");
    }
}