package com.example.makananuas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.makananuas.Common.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    EditText editNo, editPassword;
    Button tblSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editNo = (EditText) findViewById(R.id.edit_nomor);
        editPassword = (EditText) findViewById(R.id.edit_password);
        tblSignIn = (Button) findViewById(R.id.tombolSignIn);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        tblSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SignIn.this);
                builder.setMessage(R.string.dialog_message);
                AlertDialog dialog = builder.create();
                dialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.child(editNo.getText().toString()).exists()){
                            dialog.cancel();
                            User user = snapshot.child(editNo.getText().toString()).getValue(User.class);
                            user.setNomor(editNo.getText().toString());

                            if(user.getPassword().equals(editPassword.getText().toString())){
                                {
                                    Intent home = new Intent(SignIn.this, Home.class);
                                    Common.currentuser = user;
                                    startActivity(home);
                                    finish();
                                }
                            }
                            else{
                                Toast.makeText(SignIn.this,"Wrong Password", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            dialog.cancel();
                            Toast.makeText(SignIn.this,"Not Found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }


}

