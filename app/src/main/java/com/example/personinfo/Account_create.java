package com.example.personinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Account_create extends AppCompatActivity {
 Button setIN,back;
 TextView num,name,email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_create);
        setIN=(Button)findViewById(R.id.reG);
        back=(Button)findViewById(R.id.caN);
        num=(TextView)findViewById(R.id.editTextPhone);
        name=(TextView)findViewById(R.id.nName);
        email=(TextView)findViewById(R.id.editTextTextEmailAddress2);
        pass=(TextView)findViewById(R.id.editTextTextPersonName2);
        setIN.setOnClickListener(this::SetIN);
        back.setOnClickListener(this::Back);
    }


    public void Back(View view){
        Intent a = new Intent(Account_create.this, MainActivity.class);
        startActivity(a);
    }
    public void SetIN(View view){
        Intent  a = new Intent(Account_create.this, MainActivity.class);
        a.putExtra("NUM",num.getText().toString());
        a.putExtra("NAME",name.getText().toString());
        a.putExtra("PASS",pass.getText().toString());
        a.putExtra("EMAIL",email.getText().toString());
        setResult(RESULT_OK, a);
        finish();
    }
}