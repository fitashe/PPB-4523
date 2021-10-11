package com.example.aplikasikalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Kalkulator extends AppCompatActivity {
    EditText angk1,angk2;
    TextView hasilnya;
    //Button tmbltambah;
    //menggunakan Button tmbltambah dan yang tak beri komentar itu
    //ketika di activity_kalkulator.xml di bagian Button OnClick nya dihapus

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        angk1=(EditText) findViewById(R.id.angka1);
        angk2=(EditText) findViewById(R.id.angka2);
        hasilnya=(TextView) findViewById(R.id.hasilhitung);
        /*
        tmbltambah=(Button) findViewById(R.id.tblHitung);

        tmbltambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a1 = Integer.parseInt(angk1.getText().toString());
                int a2 = Integer.parseInt(angk2.getText().toString());
                Integer hasil = a1+a2;
                hasilnya.setText(hasil.toString());
            }
        });*/
    }

    public void hitung(View view) {
        int a1 = Integer.parseInt(angk1.getText().toString());
        int a2 = Integer.parseInt(angk2.getText().toString());
        Integer hasil = a1+a2;
        hasilnya.setText(hasil.toString());
    }
}