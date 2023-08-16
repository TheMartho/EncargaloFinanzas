package com.example.encargalofinanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class plantilla_financiera extends AppCompatActivity {

    Button btn_negocio;
    Button btn_costos;
    Button btn_manufacturas;
    Button btn_personal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantilla_financiera);

        btn_negocio=(Button)findViewById(R.id.btn_negocio);
        btn_negocio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), plantilla_financiera.class);
                startActivity(intent);
            }
        });

        btn_costos=(Button)findViewById(R.id.btn_costos);
        btn_costos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), costos.class);
                startActivity(intent);
            }
        });

        btn_manufacturas=(Button)findViewById(R.id.btn_manufacturas);
        btn_manufacturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), plantilla_financiera.class);
                startActivity(intent);
            }
        });

        btn_personal=(Button)findViewById(R.id.btn_personal);
        btn_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), plantilla_financiera.class);
                startActivity(intent);
            }
        });




    }
}