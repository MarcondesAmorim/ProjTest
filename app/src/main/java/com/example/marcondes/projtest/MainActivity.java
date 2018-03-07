package com.example.marcondes.projtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    private EditText eTxtMile;
    private EditText eTxtCelsius;
    private EditText eTxtLibra;
    private EditText eTxtHz;

    private TextView tVKm;
    private TextView tVKelvin;
    private TextView tVKg;
    private TextView tVMHz ;

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
    }

    public void btMileToKm(View view){
        Float mile = Float.valueOf(eTxtMile.getText().toString());
        Float km = mileToKm(mile);
        tVKm.setText(km.toString());
    }

    public void btCelsiusToKelvin(View view){
        Float celsius = Float.valueOf(eTxtCelsius.getText().toString());
        Float Kelvin = celsiusToKelvin(celsius);
        tVKelvin.setText(Kelvin.toString());
    }

    public void btLibraToKg(View view){
        Float libra = Float.valueOf(eTxtLibra.getText().toString());
        Float kg = lbToKg(libra);
        tVKg.setText(kg.toString());
    }

    public void btHzToMHz(View view){
        Float hz = Float.valueOf(eTxtHz.getText().toString());
        Float mHz = hzToMhz(hz);
        tVMHz.setText(mHz.toString());
    }


    public float mileToKm(float mile){return 1.6f * mile;}

    public float celsiusToKelvin(float celsius){
        return celsius + 273f;
    }

    public float lbToKg(float lb){ return lb * 0.4536f;}

    public float hzToMhz(float hz){return hz * 0.001f;}

}





