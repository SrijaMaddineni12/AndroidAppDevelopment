package com.example.task2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    TextView tv;
    TextView tv1;
    int a = 0;
    int b = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.add1);
        b2 = findViewById(R.id.add2);
        b3 = findViewById(R.id.add3);
        b4 = findViewById(R.id.add11);
        b5 = findViewById(R.id.add22);
        b6 = findViewById(R.id.add33);
        b7 = findViewById(R.id.zero);
        tv = findViewById(R.id.textcount);
        tv1 = findViewById(R.id.textcount1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = a + 1;
                tv.setText("" + a);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = a + 2;
                tv.setText("" + a);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = a + 3;
                tv.setText("" + a);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b = b + 1;
                tv1.setText("" + b);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b = b + 2;
                tv1.setText("" + b);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b = b + 3;
                tv1.setText("" + b);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b = 0;
                a = 0;
                tv.setText("" + a);
                tv1.setText("" + b);
            }
        });
        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("sri");
            a = Integer.parseInt(s);
            tv.setText(s);
            String r = savedInstanceState.getString("srij");
            b = Integer.parseInt(r);
            tv1.setText(r);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("sri",tv.getText().toString());
        outState.putString("srij",tv1.getText().toString());

    }
}
