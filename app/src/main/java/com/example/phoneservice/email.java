package com.example.phoneservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        Button b1,b2,b3;
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText p1=findViewById(R.id.id);
                String id=p1.getText().toString();
                Toast.makeText(email.this, "Value Entered "+id, Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText p1=findViewById(R.id.sub);
                String id=p1.getText().toString();
                Toast.makeText(email.this, "Value Entered "+id, Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText p1=findViewById(R.id.msg);
                String id=p1.getText().toString();
                Toast.makeText(email.this, "Value Entered "+id, Toast.LENGTH_SHORT).show();
            }
        });
        Button em=findViewById(R.id.email);
        em.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText p1=findViewById(R.id.id);
                EditText p2=findViewById(R.id.sub);
                EditText p3=findViewById(R.id.msg);
                String id=p1.getText().toString();
                String sub=p2.getText().toString();
                String msg=p3.getText().toString();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{id});
                i.putExtra(Intent.EXTRA_SUBJECT, sub);
                i.putExtra(Intent.EXTRA_TEXT   , msg);
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                    Toast.makeText(email.this, "Email sent", Toast.LENGTH_SHORT).show();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(email.this, "There are no email clients installed.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
