package com.example.task4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.message);
        tv1 = findViewById(R.id.reply);
    }

    public void send(View view) {
        String data = et.getText().toString();
        if (data.isEmpty()){
            Toast.makeText(this, "Please enter your message", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(MainActivity.this,SecondActivity.class);
            i.putExtra("mydata",data);
            startActivityForResult(i,1);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            String r = data.getStringExtra("mytext");
            tv1.setText(r);
        }
    }
}