package com.example.personinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static public String email="",password="",number="",name="";
    EditText emailED,passwordED;
    Button logIN,create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordED = (EditText) findViewById(R.id.editTextTextPassword);
        emailED = (EditText) findViewById(R.id.editTextTextEmailAddress);
        logIN = (Button) findViewById(R.id.Login);
        create = (Button) findViewById(R.id.Create);
        create.setOnClickListener(this::nCreate);
        logIN.setOnClickListener(this::LogIN);

        if(email.equals("") || password.equals("")){
            Toast.makeText(this,"Account doesn't exist, try to create new",Toast.LENGTH_LONG).show();
        }
    }
    public void LogIN(View view){
        if(!(email.equals("") && password.equals(""))&&email.equals(emailED.getText().toString()) && password.equals(passwordED.getText().toString())){
            Intent i = new Intent(MainActivity.this, Info.class);
            i.putExtra("NAME",name);
            i.putExtra("NUM",number);
            startActivity(i);
        }else
            Toast.makeText(this,"Wrong Password/Login",Toast.LENGTH_LONG).show();
    }

    public void nCreate(View view){
        Intent j = new Intent(MainActivity.this, Account_create.class);
        startActivityForResult(j,1);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                email = data.getStringExtra("EMAIL");
                password = data.getStringExtra("PASS");
                number = data.getStringExtra("NUM");
                name = data.getStringExtra("NAME");
                break;
        }
    }
}