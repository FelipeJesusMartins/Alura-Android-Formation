package com.jesus.viagens.util;

import androidx.annotation.NonNull;

import com.jesus.viagens.model.Package;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class UtilCurrency {

    public static final String BRAZIL = "br";
    public static final String PORTUGUESE = "pt";
    public static final String CURRENCY_FORMAT_WITH_SPACING = "R$ ";

    @NonNull
    public static String formatToBr(BigDecimal value) {
        NumberFormat brazilianFormat = DecimalFormat.getInstance(new Locale(PORTUGUESE, BRAZIL));
        String brazilianCurrency = brazilianFormat.format(value ).replace(CURRENCY_FORMAT_WITH_SPACING,CURRENCY_FORMAT_WITH_SPACING);
        return brazilianCurrency;
    }
}
