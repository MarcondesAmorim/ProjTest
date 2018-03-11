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
        String valueMile = eTxtMile.getText().toString();
        if(valueMile==null || valueMile.equals("")) {
            valueMile = "0";
            eTxtMile.setText(valueMile);
        }
        double mile = Float.valueOf(valueMile);
        double km = conversor.mileToKm(mile);
        tVKm.setText(Double.toString(km));
    }

    public void btCelsiusToKelvin(View view){
        String valueCelsius = eTxtCelsius.getText().toString();
        if(valueCelsius==null || valueCelsius.equals("")) {
            valueCelsius = "0";
            eTxtCelsius.setText(valueCelsius);
        }
        double celsius = Float.valueOf(valueCelsius);
        double Kelvin = conversor.celsiusToKelvin(celsius);
        tVKelvin.setText(Double.toString(Kelvin));
    }

    public void btLbToKg(View view){
        String valueLibra = eTxtLibra.getText().toString();
        if(valueLibra==null || valueLibra.equals("")) {
            valueLibra = "0";
            eTxtLibra.setText(valueLibra);
        }
        double libra = Float.valueOf(valueLibra);
        double kg = conversor.lbToKg(libra);
        tVKg.setText(Double.toString(kg));
    }

    public void btHzToMHz(View view){
        String valueHz = eTxtHz.getText().toString();
        if(valueHz==null || valueHz.equals("")) {
            valueHz = "0";
            eTxtHz.setText(valueHz);
        }
        double hz = Float.valueOf(valueHz);
        double mHz = conversor.hzToMhz(hz);
        tVMHz.setText(Double.toString(mHz));
    }

}





