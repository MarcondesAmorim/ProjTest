package com.example.marcondes.projtest.models;

/**
 * Created by Marcondes on 08/03/2018.
 */

public class Conversor {

    public double mileToKm(double mile){return 1.6 * mile;}

    public double celsiusToKelvin(double celsius){return celsius + 273.15;}

    public double lbToKg(double lb){ return lb * 0.4536;}

    public double  hzToMhz(double hz){return hz * 0.001;}
}
