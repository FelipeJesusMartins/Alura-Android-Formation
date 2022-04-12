package com.jesus.viagens.util;

import androidx.annotation.NonNull;

import com.jesus.viagens.model.Package;

public class UtilDays {
    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formatToText(int quantityDays) {
        String textInDays = (quantityDays > 1 ? quantityDays + PLURAL : quantityDays + SINGULAR);
        return textInDays;
    }
}
