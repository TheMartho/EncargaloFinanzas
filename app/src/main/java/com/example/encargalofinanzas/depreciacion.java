package com.example.encargalofinanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class depreciacion extends AppCompatActivity {

    private TableLayout table_depreciacion;
    private EditText activoFijo;
    private EditText unidades;
    private EditText valorUnitario;
    private EditText vidaUtil;
    private String[]header={"Activo fijo", "Unidades", "Valor unitario", "Total", "Vida útil", "Anual", "Mensual"};
    private ArrayList<String[]> rows = new ArrayList<>();
    private TableDynamic tableDynamic;

    private double[] acumulados = new double[3];

    private TextView cantidadTotal;
    private TextView cantidadAnual;
    private TextView cantidadMensual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depreciacion);

        table_depreciacion = (TableLayout)findViewById(R.id.tbllayout_depreciacion);
        activoFijo = (EditText) findViewById(R.id.txt_activoFijo);
        unidades = (EditText) findViewById(R.id.txt_unidades);
        valorUnitario = (EditText) findViewById(R.id.txt_valorUnitario);
        vidaUtil = (EditText) findViewById(R.id.txt_vidaUtil);
        tableDynamic = new TableDynamic(table_depreciacion, getApplicationContext());
        tableDynamic.addHeader(header);

        cantidadTotal = (TextView)findViewById(R.id.txt_cantidadTotal);
        cantidadAnual = (TextView)findViewById(R.id.txt_cantidadAnual);
        cantidadMensual = (TextView)findViewById(R.id.txt_cantidadMensual);
    }
    public double calcularTotal(int unidades, double valorUnitario){
        return unidades*valorUnitario;
    }
    public double calcularAnual(double total, int vidaUtil){
        if (vidaUtil == 0) {
            throw new ArithmeticException("No se puede dividir por 0");
        }
        return (total / vidaUtil);
    }
    //acumular método
    public void acumular(int indice, double valor) {
        if (indice >= 0 && indice < acumulados.length) {
            acumulados[indice] += valor;
        }
    }
    //acumular función
    public double obtenerAcumulado(int indice) {
        if (indice >= 0 && indice < acumulados.length) {
            return acumulados[indice];
        }
        return 0.0;
    }

    public void agregarActivoFijo(View view){

        double totalCalculado = calcularTotal(Integer.parseInt(unidades.getText().toString()), Double.parseDouble(valorUnitario.getText().toString()));
        double anualCalculado = totalCalculado/(Integer.parseInt(vidaUtil.getText().toString()));
        double mensualCalculado = anualCalculado/12;

        acumular(0, totalCalculado); // Acumulado del total
        acumular(1, anualCalculado); // Acumulado del anual
        acumular(2, mensualCalculado); // Acumulado del mensual

        String[] item = new String[]{
                activoFijo.getText().toString(),
                unidades.getText().toString(),
                valorUnitario.getText().toString(),
                Double.toString(totalCalculado),
                vidaUtil.getText().toString(),
                Double.toString(anualCalculado),
                Double.toString(mensualCalculado)
        };

        tableDynamic.addItems(item); //rellenar tabla con nuevo registro

        // mostrar el acumulado
        cantidadTotal.setText(String.valueOf(obtenerAcumulado(0)));
        cantidadAnual.setText(String.valueOf(obtenerAcumulado(1)));
        cantidadMensual.setText(String.valueOf(obtenerAcumulado(2)));
    }

}