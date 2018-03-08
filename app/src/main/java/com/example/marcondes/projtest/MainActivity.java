package com.example.marcondes.projtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import com.example.marcondes.projtest.models.Conversor;


public class MainActivity extends AppCompatActivity {


    private EditText eTxtMile;
    private EditText eTxtCelsius;
    private EditText eTxtLibra;
    private EditText eTxtHz;

    private TextView tVKm;
    private TextView tVKelvin;
    private TextView tVKg;
    private TextView tVMHz ;

    Conversor conversor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTxtMile = (EditText) findViewById(R.id.editTextMile);
        eTxtCelsius = (EditText) findViewById(R.id.editTextCelsius);
        eTxtLibra = (EditText) findViewById(R.id.editTextLibra);
        eTxtHz = (EditText) findViewById(R.id.editTextHz);

        tVKm = (TextView) findViewById(R.id.textViewKm);
        tVKelvin = (TextView) findViewById(R.id.textViewKelvin);
        tVKg = (TextView) findViewById(R.id.textViewKg);
        tVMHz = (TextView) findViewById(R.id.textViewMHz);

        conversor = new Conversor();
    }

    public void btMileToKm(View view){
        Double mile = Double.valueOf(eTxtMile.getText().toString());
        Double km = conversor.mileToKm(mile);
        tVKm.setText(km.toString());
    }

    public void btCelsiusToKelvin(View view){
        Double celsius = Double.valueOf(eTxtCelsius.getText().toString());
        Double Kelvin = conversor.celsiusToKelvin(celsius);
        tVKelvin.setText(Kelvin.toString());
    }

    public void btLibraKg(View view){
        Double libra = Double.valueOf(eTxtLibra.getText().toString());
        Double kg = conversor.lbToKg(libra);
        tVKg.setText(kg.toString());
    }

    public void btHzToMHz(View view){
        Double hz = Double.valueOf(eTxtHz.getText().toString());
        Double mHz = conversor.hzToMhz(hz);
        tVMHz.setText(mHz.toString());
    }



}





