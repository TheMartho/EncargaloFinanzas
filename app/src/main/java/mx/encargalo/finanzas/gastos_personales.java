package mx.encargalo.finanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class gastos_personales extends AppCompatActivity {

    private TableLayout table_depreciacion;
    private EditText nombreGasto;
    private EditText importe;
    private EditText valorUnitario;
    private EditText vidaUtil;
    private String[]header={"Activo fijo", "Unidades", "Valor unitario", "Total", "Vida útil", "Anual", "Mensual"};
    private ArrayList<String[]> rows = new ArrayList<>();
    private TableDynamic tableDynamic;

    private double[] acumulados = new double[3];

    private TextView cantidadTotal;
    private TextView cantidadAnual;
    private TextView cantidadMensual;
    Button btnLimpiar;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos_personales);

    }
}