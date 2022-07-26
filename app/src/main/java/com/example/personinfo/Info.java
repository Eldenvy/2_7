package com.example.personinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    Button oK;
    Intent c;
    TextView num,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        oK=(Button)findViewById(R.id.ok);
        num=(TextView)findViewById(R.id.textView2);
        name=(TextView)findViewById(R.id.textView3);
        num.setText(MainActivity.number);
        name.setText(MainActivity.name);
        oK.setOnClickListener(this::nBack);
    }
    public void nBack(View view){
        c = new Intent(Info.this, MainActivity.class);
        startActivity(c);
    }
}