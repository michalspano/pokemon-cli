package assignment2;

import java.lang.Math;

public class PokemonUtils
{    
    /** 
     * @param value
     * @param decimalPlaces
     * @return double
     */
    public static double truncateDouble(double value, int decimalPlaces) 
    {
        double powerOfTen = Math.pow(10, decimalPlaces);
        return Math.floor(value * powerOfTen) / powerOfTen;
    }
}