package com.example.myfirebaseupdate;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UpdateData extends AppCompatActivity {
    EditText nimsiswa, namasiswa;
    Button tbl_update, tbl_detele, tbl_view;
    private String nama, noid, nim;
    public static EditText editText;
    public static ListView listView;


    DatabaseReference databaseReference;
    Mahasiswa mahasiswa;

    ArrayAdapter adapter;
    ArrayList<String> listviewku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        listviewku = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("siswa");

        nimsiswa = findViewById(R.id.nimmhs);
        namasiswa = findViewById(R.id.namamhs);
        tbl_update = findViewById(R.id.tombolupdate);
        tbl_detele = findViewById(R.id.tombolhapus);
        tbl_view = findViewById(R.id.tombolview);
        mahasiswa = new Mahasiswa();

        tbl_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateData.this, TampilSemuaData.class);
                startActivity(intent);
            }
        });

        tbl_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mahasiswa.setNim(nimsiswa.getText().toString().trim());
                mahasiswa.setNama(namasiswa.getText().toString().trim());

                databaseReference.push().startAt(String.valueOf(mahasiswa));

                Toast.makeText(UpdateData.this, "Data sudah terupdate", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(UpdateData.this, TampilSemuaData.class);
                startActivity(intent);
            }
        });


        tbl_detele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noid= listviewku.get(adapter.getPosition(mahasiswa)).toString();
                String nim =noid.substring(0,2);
                String nama= listviewku.get(adapter.getPosition(namasiswa)).toString();
                //String nama =nama.substring(1,10);
                if (nama !=null && nama!= ""){
                    Intent intent = new Intent(UpdateData.this,TampilSemuaData.class);
                    intent.putExtra("data1", nim);
                    intent.putExtra("data2", nama);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplication(), "Data kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
