package com.example.task10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;

    ArrayList<CovidModel> covidModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recycler);
        covidModels = new ArrayList<>();
        new CovidTask(this,rv,covidModels).execute();
        /*rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CovidAdapter(this,covidModels));*/

    }
}