package com.example.myfirebaseupdate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TampilSemuaData extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;

    ArrayList<String> arrayTampilData = new ArrayList<>();
    ArrayList<String> arrayEditData = new ArrayList<>();
    ArrayList<String> arrayHapusData = new ArrayList<>();

    DatabaseReference databaseReference;
    public String data1, data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data_semua);

        listView = findViewById(R.id.listdata);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("siswa");

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arrayTampilData);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TampilSemuaData.this, UpdateData.class);
                startActivity(intent);
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String hasil = snapshot.getValue(Mahasiswa.class).toPrint();
                arrayTampilData.add(hasil);
                String key = snapshot.getKey();
                arrayEditData.add(key);
                arrayHapusData.add(key);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String hasil = snapshot.getValue(Mahasiswa.class).toPrint();
                String key = snapshot.getKey();
                int index = arrayEditData.indexOf(key);
                arrayTampilData.set(index, hasil);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                String hasil = snapshot.getValue(Mahasiswa.class).toPrint();
                String key = snapshot.getKey();
                int index = arrayHapusData.indexOf(key);
                arrayTampilData.remove(index);
                arrayHapusData.remove(index);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
