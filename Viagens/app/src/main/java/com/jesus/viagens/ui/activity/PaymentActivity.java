package com.jesus.viagens.ui.activity;

import static com.jesus.viagens.ui.activity.PackageActivityConstants.PACKAGE_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jesus.viagens.R;
import com.jesus.viagens.model.Package;
import com.jesus.viagens.util.UtilCurrency;

import java.math.BigDecimal;

public class PaymentActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setTitle(TITLE_APPBAR);

        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_KEY)) {
            final Package aPackage = (Package) intent.getSerializableExtra(PACKAGE_KEY);
            showPrice(aPackage.getPrice());
            setUpBtn(aPackage);
        }

    }

    private void setUpBtn(Package aPackage) {
        Button btnFinishPayment = findViewById(R.id.payment_button_finish_purchase);

        btnFinishPayment.setOnClickListener(v -> {
            goToPayment(aPackage);
        });
    }

    private void goToPayment(Package aPackage) {
        Intent intent1 = new Intent(PaymentActivity.this,PackagePurchaseActivity.class);
        intent1.putExtra(PACKAGE_KEY, aPackage);
        startActivity(intent1);
    }

    private void showPrice(BigDecimal packagePrice) {
        TextView price = findViewById(R.id.payment_purchase_price);
        price.setText(UtilCurrency.formatToBr(packagePrice));
    }
}