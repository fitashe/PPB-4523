package com.example.makananuas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeNew  extends AppCompatActivity {
    CardView btn1, btn2, btn3, btn4, btn5, btn6;
    TextView total;
    Button tbl1, tbl2, tbl3, tbl4, tbl5, tbl6;

    private int tothar,totam=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_bar);
        btn1 = (CardView) findViewById(R.id.btn1);
        btn2 = (CardView) findViewById(R.id.btn2);
        btn3 = (CardView) findViewById(R.id.btn3);
        btn4 = (CardView) findViewById(R.id.btn4);
        btn5 = (CardView) findViewById(R.id.btn5);
        btn6 = (CardView) findViewById(R.id.btn6);
        tbl1 = findViewById(R.id.button1);
        tbl2 = findViewById(R.id.button2);
        tbl3 = findViewById(R.id.button3);
        tbl4 = findViewById(R.id.button4);
        tbl5 = findViewById(R.id.button5);
        tbl6 = findViewById(R.id.button6);
        total = findViewById(R.id.floatingActionButton);

        tbl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lele = new Intent(HomeNew.this, PecelLele.class);
                startActivity(lele);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tothar=15000;
                totam+=tothar;
                total.setText("Total : Rp."+Integer.toString(totam));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tothar=5000;
                totam+=tothar;;
                total.setText("Total : Rp."+Integer.toString(totam));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tothar=20000;
                totam+=tothar;
                total.setText("Total : Rp."+Integer.toString(totam));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tothar=10000;
                totam+=tothar;
                total.setText("Total : Rp."+Integer.toString(totam));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tothar=10000;
                totam+=tothar;
                total.setText("Total : Rp."+Integer.toString(totam));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tothar=5000;
                totam+=tothar;
                total.setText("Total : Rp."+Integer.toString(totam));
            }
        });
    }




}
