package com.example.tugas2_2008107010093_pbm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private boolean isGambarAwal = true;
    private int gambarAwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void tombolGantiGambar(View view) {
        String namaGambar = "logo_unsyiah_2";
        int res = getResources().getIdentifier(namaGambar, "drawable", getPackageName());

        ImageView iv = findViewById(R.id.logoUSK);

        if (isGambarAwal) {
            gambarAwal = getResources().getIdentifier("logo_unsyiah", "drawable", getPackageName());
            iv.setImageResource(res);
            isGambarAwal = false;
        } else {
            iv.setImageResource(gambarAwal);
            isGambarAwal = true;
        }
    }

    public void tombolAsset(View view) {
        String namaGambar = "logo_informatika.png";
        ImageView iv = findViewById(R.id.logoUSK);

        InputStream stream = null;
        try {
            stream = getAssets().open(namaGambar);
            Drawable drawable = Drawable.createFromStream(stream, null);
            iv.setImageDrawable(drawable);
        } catch (Exception e) {
            Log.e("Error Image", e.getMessage());
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    Log.e("Error Stream", e.getMessage());
                }
            }
        }
    }
}
