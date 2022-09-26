package assignment2;

import java.lang.Math;

public class PokemonUtils
{
    public static double truncateDouble(double value, int decimalPlaces) 
    {
        double powerOfTen = Math.pow(10, decimalPlaces);
        return Math.floor(value * powerOfTen) / powerOfTen;
    }
}