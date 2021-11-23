package com.example.intento11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton boton1 = (ImageButton) findViewById(R.id.imageButton);
        boton1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast notificacion = Toast.makeText(MainActivity.this, "Trekking", Toast.LENGTH_SHORT);
                notificacion.show();
                Intent intencion = new Intent(getApplicationContext(),MenuSlideActivity.class);
                startActivity(intencion);
            }
        }));
        ImageButton boton2 = (ImageButton) findViewById(R.id.imageButton2);
        boton1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast notificacion = Toast.makeText(MainActivity.this, "Senderismo", Toast.LENGTH_SHORT);
                notificacion.show();
                Intent intencion = new Intent(getApplicationContext(),MenuSlideActivity.class);
                startActivity(intencion);
            }
        }));
        ImageButton boton3 = (ImageButton) findViewById(R.id.imageButton3);
        boton1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast notificacion = Toast.makeText(MainActivity.this, "Ciclismo", Toast.LENGTH_SHORT);
                notificacion.show();
                Intent intencion = new Intent(getApplicationContext(),MenuSlideActivity.class);
                startActivity(intencion);
            }
        }));
    }

    @Override
    public void onClick(View v) {

    }
}