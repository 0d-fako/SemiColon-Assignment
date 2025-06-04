package baseconverter;

import java.util.Scanner;

public class BaseConverter {
    public int baseConverter(int newBase, int numberToConvert, int currentBase) {
        int convertedInteger = 0;
        int counter = 0;

        while (numberToConvert != 0) {
            int rem = numberToConvert % newBase;
            double remPowered = rem * Math.pow(currentBase, counter);
            numberToConvert /= 10;
            convertedInteger += remPowered;
            counter++;

        }
        return convertedInteger;
    }
}



