package com.jesus.viagens.ui.activity;

import static com.jesus.viagens.ui.activity.PackageActivityConstants.PACKAGE_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jesus.viagens.R;
import com.jesus.viagens.model.Package;
import com.jesus.viagens.util.UtilCurrency;
import com.jesus.viagens.util.UtilDate;
import com.jesus.viagens.util.UtilDays;
import com.jesus.viagens.util.UtilResources;

public class PackageSummaryActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_summary);

        setTitle(APPBAR_TITLE);
        loadReceivedPackage();
    }

    private void loadReceivedPackage() {
        Intent intent = getIntent();
        if(intent.hasExtra(PACKAGE_KEY)){
            Package aPackage = (Package) intent.getSerializableExtra(PACKAGE_KEY);

            showPlace(aPackage);
            showImage(aPackage);
            showDays(aPackage);
            showPrice(aPackage);
            showDate(aPackage);
            setUpBtnOnClick(aPackage);

        }
    }

    private void setUpBtnOnClick(Package aPackage) {
        Button btnMakePayment = findViewById(R.id.package_summary_button_make_payment);
        btnMakePayment.setOnClickListener(v -> {
            goToPayment(aPackage);
        });
    }

    private void goToPayment(Package aPackage) {
        Intent intent = new Intent(PackageSummaryActivity.this,PaymentActivity.class);
        intent.putExtra(PACKAGE_KEY, aPackage);
        startActivity(intent);
    }

    private void showDate(Package aPackage) {
        TextView date = findViewById(R.id.package_summary_date);
        String finalDatePackage = UtilDate.getPeriod(aPackage.getDays());
        date.setText(finalDatePackage);
    }



    private void showPrice(Package aPackage) {
        TextView price = findViewById(R.id.package_summary_price);
        price.setText(UtilCurrency.formatToBr(aPackage.getPrice()));
    }

    private void showDays(Package aPackage) {
        TextView days = findViewById(R.id.package_summary_days);
        days.setText(UtilDays.formatToText(aPackage.getDays()));
    }

    private void showImage(Package aPackage) {
        ImageView image = findViewById(R.id.package_summary_image);
        image.setImageDrawable(UtilResources.getImageDrawable(this, aPackage.getImage()));
    }

    private void showPlace(Package aPackage) {
        TextView place = findViewById(R.id.package_summary_place);
        place.setText(aPackage.getPlace());
    }
}