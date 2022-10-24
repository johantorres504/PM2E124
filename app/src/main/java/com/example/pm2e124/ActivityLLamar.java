package com.example.pm2e124;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pm2e124.configuracion.SQLiteConexion;
import com.example.pm2e124.tablas.Contactos;
import com.example.pm2e124.tablas.Transacciones;

import java.util.ArrayList;

public class ActivityLLamar extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_llamar);

        }
}