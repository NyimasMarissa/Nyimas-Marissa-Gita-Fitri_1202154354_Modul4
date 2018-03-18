package com.example.marissagift.nyimas_1202154354_modul4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class PencarianGambar extends AppCompatActivity {

    private EditText mInputLink;
    private Button mButtonCari;
    private ImageView mTampilGambar;
    private ProgressDialog mProgressDialog;

    //Jangan lupa masukkan uses-permission untuk dapat mengakses internet kedalam manifest
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian_gambar);

        mInputLink = findViewById(R.id.inputLink);
        mButtonCari = findViewById(R.id.buttonCari);
        mTampilGambar = findViewById(R.id.tampilGambar);
    }

    public void buttonCari(View view) {
        loadImageInit();
    }

    private void loadImageInit(){
        String ImgUrl = mInputLink.getText().toString();

        //AsyncTask mencari gambar di internet
        new loadImage().execute(ImgUrl);
    }

    private class loadImage extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Membuat Progress Dialog
            mProgressDialog = new ProgressDialog(PencarianGambar.this);

//            // Judul Progress Dialog
//            mProgressDialog.setTitle("Downloading image");

            // Seting message Progress Dialog
            mProgressDialog.setMessage("Loading...");

            // menampilkan Progress Dialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                // mendownload gambar dari url
                URL url = new URL(params[0]);
                // mengkonversikan gambar ke bitmat (decode to bitmap)
                bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            // menampung gambar ke imageView dan menampilkannya
            mTampilGambar.setImageBitmap(bitmap);

            // menghilangkan Progress Dialog
            mProgressDialog.dismiss();
        }
    }
}
