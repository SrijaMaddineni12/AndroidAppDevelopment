package com.example.task6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_rollno, et_name, et_phone, et_email, et_password;
    TextView tv;
    RadioButton r_male, r_female;
    String gender;
    Spinner sp_branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_rollno = findViewById(R.id.rollno);
        et_name = findViewById(R.id.name);
        et_phone = findViewById(R.id.mobile);
        et_email = findViewById(R.id.email);
        et_password = findViewById(R.id.password);
        r_male = findViewById(R.id.male);
        r_female = findViewById(R.id.female);
        sp_branch = findViewById(R.id.branch);
        tv = findViewById(R.id.result);

        ArrayAdapter<CharSequence> branchAdapter = ArrayAdapter.createFromResource(this,
                R.array.Branch, android.R.layout.simple_spinner_item);
        sp_branch.setAdapter(branchAdapter);

    }

    public void submit(View view) {

        String rollno = et_rollno.getText().toString();
        String name = et_name.getText().toString();
        String mobile = et_phone.getText().toString();
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        if (r_male.isChecked()) {
            gender = r_male.getText().toString();
        }
        if (r_female.isChecked()) {
            gender = r_female.getText().toString();
        }
        String selectedBranch = sp_branch.getSelectedItem().toString();
        tv.setText(rollno+"\n"+name+"\n"+mobile+"\n"+email+"\n"+password+"\n"+gender+"\n"+selectedBranch);

    }
}
