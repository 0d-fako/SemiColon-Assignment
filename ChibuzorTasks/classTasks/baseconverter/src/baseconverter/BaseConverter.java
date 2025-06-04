package baseconverter;

import java.util.Scanner;

public class BaseConverter {
    public int baseConverter(int base, int numberToConvert) {
        int convertedInteger = 0;
        int counter = 0;

        while (numberToConvert != 0){
            int rem = numberToConvert % 10;
            double remPowered =  rem * Math.pow(base,counter);
            numberToConvert /=   10;
            convertedInteger  += remPowered ;
            counter++;
        


    }
}



