package com.example.myfirebaseupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText nimsiswa, namasiswa;
    Button tblsave, tblview;
    DatabaseReference reference;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nimsiswa = findViewById(R.id.nimmhs);
        namasiswa = findViewById(R.id.namamhs);
        tblsave = findViewById(R.id.tombolsave);
        tblview = findViewById(R.id.tombolview);
        mahasiswa = new Mahasiswa();

        reference = FirebaseDatabase.getInstance().getReference().child("siswa");
        //reference = FirebaseDatabase.getInstance().getReference().child("Maha");
        //reference = FirebaseDatabase.getInstance().getReference().child("Siswa");

        tblsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mahasiswa.setNim(nimsiswa.getText().toString().trim());
                mahasiswa.setNama(namasiswa.getText().toString().trim());
                reference.push().setValue(mahasiswa);
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_LONG).show();
            }
        });

        tblview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, TampilSemuaData.class);
                startActivity(intent);
            }
        });


    }
}