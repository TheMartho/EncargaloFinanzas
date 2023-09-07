package com.example.encargalofinanzas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class gastospersonales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastospersonales1);

        table_amortizacion = (TableLayout)findViewById(R.id.tbllayout_amortizacion);
        activoDiferido = (EditText)findViewById(R.id.txt_activoDiferido);
        pagoAnticipado =(EditText)findViewById(R.id.txt_pagoAnticipado);
        vigencia = (EditText)findViewById(R.id.txt_vigencia);
        tableDynamic =new TableDynamic(table_amortizacion, getApplicationContext());
        tableDynamic.addHeader(header);
    }
    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operación Exitosa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("nombre","");
                return super.getParams();
            }
        }
    }
}