package com.example.marissagift.nyimas_1202154354_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void cariGambar(View view) {
        Intent intent = new Intent(this, PencarianGambar.class);
        startActivity(intent);
    }

    public void listNama(View view) {
        Intent intentt = new Intent(this, ListNamaMahasiswa.class);
        startActivity(intentt);
    }
}
