package mx.encargalo.finanzas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import kotlin.contracts.Returns;

public class amortizacion extends AppCompatActivity {

    private TableLayout table_amortizacion;
    private EditText activoDiferido;
    private EditText pagoAnticipado;
    private EditText vigencia;
    private String[]header={"Activo Diferido", "Pago Anticipado", "Vigencia Años", "Anual", "Mensual"};
    private ArrayList<String[]> rows = new ArrayList<>();
    private TableDynamic tableDynamic;
    private double[] acumulados_1 = new double[3];
    private TextView cantidadPagoAnticipado;
    private TextView cantidadAnual;
    private TextView cantidadMensual;
     Button btnLimpiar;
     Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amortizacion);

        table_amortizacion = (TableLayout)findViewById(R.id.tbllayout_amortizacion);
        activoDiferido = (EditText)findViewById(R.id.txt_activoDiferido);
        pagoAnticipado =(EditText)findViewById(R.id.txt_pagoAnticipado);
        vigencia = (EditText)findViewById(R.id.txt_vigencia);
        tableDynamic =new TableDynamic(table_amortizacion, getApplicationContext());
        tableDynamic.addHeader(header);
        //tableDynamic.addData(cargarRegistrosBD());

        cantidadPagoAnticipado =(TextView)findViewById(R.id.txt_AcumuladoPago);
        cantidadAnual =(TextView)findViewById(R.id.txt_cantidadAnual_1);
        cantidadMensual =(TextView)findViewById(R.id.txt_cantidadMensual_1);
<<<<<<< HEAD:app/src/main/java/com/example/encargalofinanzas/amortizacion.java
=======
        btnLimpiar = (Button)findViewById(R.id.btn_limpiar);
        btnVolver = (Button)findViewById(R.id.btn_Volver2);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiar();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void limpiar(){
        activoDiferido.setText("");
        pagoAnticipado.setText("");
        vigencia.setText("");
>>>>>>> bdf1117909a503d8bc2875df92192064265318f0:app/src/main/java/mx/encargalo/finanzas/amortizacion.java
    }

    public ArrayList<String[]> cargarRegistrosBD(){
        rows.add(new String[]{"1"});
        return rows;
    }
    public double calcularAnual(double pagoAnticipado, int vigencia){
        if (vigencia == 0) {
            throw new ArithmeticException("No se puede dividir por 0");
        }
        return (pagoAnticipado / vigencia);
    }

    public void acumular(int indice, double valor) {
        if (indice >= 0 && indice < acumulados_1.length) {
            acumulados_1[indice] += valor;
        }
    }
    //acumular función
    public double obtenerAcumulado(int indice) {
        if (indice >= 0 && indice < acumulados_1.length) {
            return acumulados_1[indice];
        }
        return 0.0;
    }

    public String[] insertarDatosEnArray(){

        double pagoAnticipadoCalculado = Double.parseDouble(pagoAnticipado.getText().toString());
        double anualCalculado = calcularAnual(Double.parseDouble(pagoAnticipado.getText().toString()), Integer.parseInt(vigencia.getText().toString()));
        double mensualCalculado = anualCalculado/12;

        acumular(0, pagoAnticipadoCalculado); // Acumulado del total
        acumular(1, anualCalculado); // Acumulado del anual
        acumular(2, mensualCalculado); // Acumulado del mensual

        String[] array = new String[]{
                activoDiferido.getText().toString(),
                pagoAnticipado.getText().toString(),
                vigencia.getText().toString(),
                Double.toString(anualCalculado),
                Double.toString(mensualCalculado)
        };
        return array;
    }
    public void agregarItem(View view){

        tableDynamic.addItems(insertarDatosEnArray());

        // mostrar el acumulado
        cantidadPagoAnticipado.setText(String.valueOf(obtenerAcumulado(0)));
        cantidadAnual.setText(String.valueOf(obtenerAcumulado(1)));
        cantidadMensual.setText(String.valueOf(obtenerAcumulado(2)));
        limpiar();
    }

}