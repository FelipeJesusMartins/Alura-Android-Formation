package com.jesus.viagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UtilDate {

    public static final String DAY_AND_MONTH = "dd/MM";

    @NonNull
    public static String getPeriod(int days) {
        Calendar departureDate = Calendar.getInstance();
        Calendar backDate = Calendar.getInstance();
        backDate.add(Calendar.DATE, days);
        SimpleDateFormat brazilianFormat = new SimpleDateFormat(DAY_AND_MONTH);
        String formatedDepartureDate = brazilianFormat.format(departureDate.getTime());
        String formatedBackDate = brazilianFormat.format(backDate.getTime());
        return formatedDepartureDate + " - " + formatedBackDate + " de " + backDate.get(Calendar.YEAR);
    }
}
