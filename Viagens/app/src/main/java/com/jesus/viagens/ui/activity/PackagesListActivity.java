package com.jesus.viagens.ui.activity;

import static com.jesus.viagens.ui.activity.PackageActivityConstants.PACKAGE_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.jesus.viagens.R;
import com.jesus.viagens.dao.PackageDAO;
import com.jesus.viagens.model.Package;
import com.jesus.viagens.ui.adapter.PackagesListAdapter;

import java.util.List;

public class PackagesListActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages_list);

        setTitle(APPBAR_TITLE);

        setUpList();
    }

    private void setUpList() {
        ListView packageslist = findViewById(R.id.packages_list_listview);
        final List<Package> packages = new PackageDAO().list();
        packageslist.setAdapter(new PackagesListAdapter(packages,this));
        packageslist.setOnItemClickListener((parent, view, position, id) -> {
            Package selectedPackage = packages.get(position);
            goToPackageSummary(selectedPackage);
        });
    }

    private void goToPackageSummary(Package selectedPackage) {
        Intent intent = new Intent(PackagesListActivity.this,PackageSummaryActivity.class);
        intent.putExtra(PACKAGE_KEY, selectedPackage);
        startActivity(intent);
    }
}