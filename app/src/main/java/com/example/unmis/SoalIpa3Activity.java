package com.example.unmis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.media.MediaPlayer;

public class SoalIpa3Activity extends AppCompatActivity {
    Integer nilai;
    RadioGroup rgSoalipa3;
    RadioButton rdbA, rdbB, rdbC, rdbD;
    Button btnNext3;
    MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_ipa3);
        tangkapNilai();
        kenalan();
        ketikaButtonDipencet();

        audio = MediaPlayer.create(this, R.raw.ipa3);
        audio.setLooping(true);
        audio.setVolume(1, 1);
        audio.start();
    }

    public void onBackPressed() {
        audio.stop();
        SoalIpa3Activity.this.finish();
    }

    private void tangkapNilai() {
        nilai = getIntent().getIntExtra("nilai", 0);
    }

    private void kenalan() {
        rgSoalipa3 = (RadioGroup) findViewById(R.id.rgSoalipa3);
        rdbA = (RadioButton) findViewById(R.id.rdbA);
        rdbB = (RadioButton) findViewById(R.id.rdbB);
        rdbC = (RadioButton) findViewById(R.id.rdbC);
        rdbD = (RadioButton) findViewById(R.id.rdbD);
        btnNext3 = (Button) findViewById(R.id.btnNext3);
    }

    private void ketikaButtonDipencet() {
        btnNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdbA.isChecked()) {
                    Log.i("Salah", String.valueOf(nilai));
                } else if (rdbB.isChecked()) {
                    nilai++;
                    Log.i("Benar", String.valueOf(nilai));
                } else if (rdbC.isChecked()) {
                    Log.i("Salah", String.valueOf(nilai));
                } else if (rdbD.isChecked()) {
                    Log.i("Salah", String.valueOf(nilai));
                } else {
                    Toast.makeText(SoalIpa3Activity.this, "Anda tidak memilih jawaban", Toast.LENGTH_SHORT).show();
                    Log.i("Salah", String.valueOf(nilai));
                }

                Intent a = new Intent(getApplicationContext(), SoalIpa4Activity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
                audio.stop();
            }
        });
    }
}