package com.example.myfirebaseapp;

import android.os.Bundle;
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
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data_semua);

        listView = findViewById(R.id.listdata);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("siswa");

        arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, arrayTampilData);
        listView.setAdapter(arrayAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String s) {
                String hasil = snapshot.getValue(Mahasiswa.class).toPrint();
                arrayTampilData.add(hasil);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

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
