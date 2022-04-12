package com.jesus.viagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jesus.viagens.R;
import com.jesus.viagens.util.UtilCurrency;
import com.jesus.viagens.util.UtilDays;
import com.jesus.viagens.util.UtilResources;
import com.jesus.viagens.model.Package;

import java.util.List;

public class PackagesListAdapter extends BaseAdapter {

    private final List<Package> packages;
    private final Context context;

    public PackagesListAdapter(List<Package> packages, Context context) {
        this.context = context;
        this.packages = packages;
    }

    @Override
    public int getCount() {
        return packages.size();
    }

    @Override
    public Package getItem(int position) {
        return packages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View createdView = LayoutInflater.from(context).inflate(R.layout.item_package, parent, false);

        Package aPackage = packages.get(position);

        showPlace(createdView, aPackage);
        showImage(createdView, aPackage);
        showDays(createdView, aPackage);
        showPrice(createdView, aPackage);

        return createdView;
    }

    private void showPrice(View createdView, Package aPackage) {
        TextView price = createdView.findViewById(R.id.item_package_price);
        String brazilianCurrency = UtilCurrency.formatToBr(aPackage.getPrice());
        price.setText(brazilianCurrency);
    }

    private void showDays(View createdView, Package aPackage) {
        TextView days = createdView.findViewById(R.id.item_package_days);
        String textInDays = UtilDays.formatToText(aPackage.getDays());
        days.setText(textInDays);
    }

    private void showPlace(View createdView, Package aPackage) {
        TextView place = createdView.findViewById(R.id.item_package_place);
        place.setText(aPackage.getPlace());
    }

    private void showImage(View createdView, Package aPackage) {
        ImageView image = createdView.findViewById(R.id.item_package_image);
        Drawable drawableImagePackage = UtilResources.getImageDrawable(context, aPackage.getImage());
        image.setImageDrawable(drawableImagePackage);
    }
}
