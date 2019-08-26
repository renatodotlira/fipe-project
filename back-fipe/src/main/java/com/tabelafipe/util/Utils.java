package com.tabelafipe.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Utils {

    public static String formatPercent(double percent){
        DecimalFormat df = new DecimalFormat(".#");
        df.setRoundingMode(RoundingMode.DOWN);
        BigDecimal bd = new BigDecimal(percent);
        bd = bd.setScale(1, BigDecimal.ROUND_DOWN);
        if(isInt(bd.doubleValue()))
            return  Integer.toString((int) percent);
        else {
            return df.format(bd.doubleValue());
        }
    }

    public static boolean isInt(double number){
        return (number % 1) == 0;
    }
}
