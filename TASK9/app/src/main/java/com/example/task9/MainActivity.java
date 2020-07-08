package com.example.task9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler);


        int images[] = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
                R.drawable.e,};
        String names[] = {"A","B","C","D","E"};
        String numbers[] = {"3.0","1.0","4.0","6.0","1.0"};
        String apilevel[] = {"1","2","3","4","5"};
        String releasedate[] = {"2-3-2020","3-4-2020","4-5-2020","5-6-2020","6-7-2020"};

        rv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(this,images,names,numbers,apilevel,releasedate);
        rv.setAdapter(adapter);




    }
}