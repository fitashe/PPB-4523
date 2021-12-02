package com.example.tampillistview_updatedata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateData extends AppCompatActivity {
    EditText idne, edbuah, nama_buah, kodehasil;
    private String nama,noid;
    Button saveEd, viewlist;
    BantuDatabase db;

    protected void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        db=new BantuDatabase(this);

        idne = (EditText) findViewById(R.id.nobuah);
        edbuah = (EditText) findViewById(R.id.editbuah);
        nama_buah = findViewById(R.id.hasileditbuah);
        kodehasil = findViewById(R.id.kodehasil);

        Bundle extras = getIntent().getExtras();

        idne.setText(extras.getString("data1"));
        edbuah.setText(extras.getString("data2"));

        saveEd =(Button) findViewById(R.id.tblSaveEdit);
        viewlist = (Button) findViewById(R.id.tblViewList);
        viewlist.setOnClickListener ((v) ->{
            Intent intent = new Intent(UpdateData.this, TampilListView.class);
            startActivity(intent);
        });

        saveEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kodehasil.setText(idne.getText().toString());
                nama_buah.setText(edbuah.getText().toString());

                boolean hasile = db.updateData(edbuah.getText().toString(), idne.getText().toString());
                if(hasile == true){
                    Toast.makeText(UpdateData.this, "Update berhasil", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UpdateData.this,"Update gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
