package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et1 = findViewById(R.id.reply);
        String s = getIntent().getStringExtra("mydata");
        TextView tv =findViewById(R.id.text);
        tv.setText(s);
    }
    public void reply1(View view) {
        String data = et1.getText().toString();
        if (data.isEmpty()) {
            Toast.makeText(this, "Please reply ", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(SecondActivity.this,MainActivity.class);
            i.putExtra("mytext",data);
            setResult(RESULT_OK,i);
            finish();
        }

    }

}

