package com.example.encargalofinanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class costos extends AppCompatActivity {

    Button btn_sueldo_emprendedor;
    Button btn_costos;
    Button btn_depreciacion;
    Button btn_amortizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costos);

        btn_sueldo_emprendedor=(Button)findViewById(R.id.btn_sueldo_emprendedor);
        btn_sueldo_emprendedor.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(view.getContext(), plantilla_financiera.class);
                startActivity(intent);
            }
        });

        btn_depreciacion=(Button)findViewById(R.id.btn_depreciacion);
        btn_depreciacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), depreciacion.class);
                startActivity(intent);
            }
        });

        btn_amortizacion=(Button)findViewById(R.id.btn_amortizacion);
        btn_amortizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), amortizacion.class);
                startActivity(intent);
            }
        });


    }
}