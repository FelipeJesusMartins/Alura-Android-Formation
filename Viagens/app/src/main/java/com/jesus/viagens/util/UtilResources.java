package com.jesus.viagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.jesus.viagens.model.Package;

public class UtilResources {

    public static Drawable getImageDrawable(Context context, String drawableToText) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawableToText, "drawable", context.getPackageName());
        Drawable drawableImagePackage = resources.getDrawable(idDrawable);
        return drawableImagePackage;
    }
}
