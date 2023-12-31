package mx.encargalo.finanzas;

<<<<<<< HEAD:app/src/main/java/com/example/encargalofinanzas/depreciacion.java
import androidx.appcompat.app.AppCompatActivity;

=======
>>>>>>> bdf1117909a503d8bc2875df92192064265318f0:app/src/main/java/mx/encargalo/finanzas/depreciacion.java
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

<<<<<<< HEAD:app/src/main/java/com/example/encargalofinanzas/depreciacion.java
=======
import androidx.appcompat.app.AppCompatActivity;

>>>>>>> bdf1117909a503d8bc2875df92192064265318f0:app/src/main/java/mx/encargalo/finanzas/depreciacion.java
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
     Button btnLimpiar;
     Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depreciacion);

        table_depreciacion = (TableLayout)findViewById(R.id.tbllayout_depreciacion);
        activoFijo = (EditText) findViewById(R.id.txt_nombreGasto);
        unidades = (EditText) findViewById(R.id.txt_montoImporte);
        valorUnitario = (EditText) findViewById(R.id.txt_valorUnitario);
        vidaUtil = (EditText) findViewById(R.id.txt_vidaUtil);
        tableDynamic = new TableDynamic(table_depreciacion, getApplicationContext());
        tableDynamic.addHeader(header);

        cantidadTotal = (TextView)findViewById(R.id.txt_cantidadTotal);
        cantidadAnual = (TextView)findViewById(R.id.txt_cantidadAnual);
        cantidadMensual = (TextView)findViewById(R.id.txt_cantidadMensual);
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


    public void limpiar (){
        activoFijo.setText("");
        unidades.setText("");
        valorUnitario.setText("");
        vidaUtil.setText("");
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
        limpiar();
    }

}