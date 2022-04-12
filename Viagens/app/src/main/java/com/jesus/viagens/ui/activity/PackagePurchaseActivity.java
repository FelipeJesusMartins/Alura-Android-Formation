package com.jesus.viagens.ui.activity;

import static com.jesus.viagens.ui.activity.PackageActivityConstants.PACKAGE_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jesus.viagens.R;
import com.jesus.viagens.model.Package;
import com.jesus.viagens.util.UtilCurrency;
import com.jesus.viagens.util.UtilDate;
import com.jesus.viagens.util.UtilResources;

import java.math.BigDecimal;

public class PackagePurchaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_purchase);

        setTitle("Ws Towers Lodge");

        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_KEY)) {

            Package aPackage = (Package) intent.getSerializableExtra(PACKAGE_KEY);

            showImage(aPackage);
            showPlace(aPackage);
            showDates(aPackage);
            showPrice(aPackage);
        }
    }

    private void showPrice(Package packageSp) {
        TextView price = findViewById(R.id.purchase_summary_package_price);
        price.setText(UtilCurrency.formatToBr(packageSp.getPrice()));
    }

    private void showDates(Package packageSp) {
        TextView allDates = findViewById(R.id.purchase_summary_travel_date);
        allDates.setText(UtilDate.getPeriod(packageSp.getDays()));
    }

    private void showPlace(Package packageSp) {
        TextView place = findViewById(R.id.purchase_summary_package_place);
        place.setText(packageSp.getPlace());
    }

    private void showImage(Package packageSp) {
        ImageView placeImage = findViewById(R.id.purchase_summary_image_summary);
        placeImage.setImageDrawable(UtilResources.getImageDrawable(this, packageSp.getImage()));
    }
}