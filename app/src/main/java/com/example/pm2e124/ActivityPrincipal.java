package com.example.pm2e124;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pm2e124.ActivityLLamar;
import com.example.pm2e124.ActivityLista;
import com.example.pm2e124.MainActivity;
import com.example.pm2e124.R;

public class ActivityPrincipal extends AppCompatActivity {
    Button btnadd, btnlist;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnadd = (Button) findViewById(R.id.btnadd);
        btnlist = (Button) findViewById(R.id.btnlist);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), ActivityLLamar.class);
                startActivity(intent);
            }
        });



    }
}