package com.example.phoneservice;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class phone extends AppCompatActivity {
    private static int call=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        Button b1=findViewById(R.id.call);
        //EditText e1=findViewById(R.id.e1);
       // final String num=e1.getText().toString();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1=findViewById(R.id.e1);
                String num=e1.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                int l=num.length();

                if (checkSelfPermission(Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(phone.this,new String[]{Manifest.permission.CALL_PHONE},call);
                }


                if(l!=0) {
                    if (l<10) {
                        intent.setData(Uri.parse("tel: 8107283270"));
                        Toast.makeText(phone.this, "too short,Dialing default", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                        else {
                        intent.setData(Uri.parse("tel:" + num));
                        Toast.makeText(phone.this, num + " is entered by you", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                        }
                else {
                    intent.setData(Uri.parse("tel: 8107283270"));
                    Toast.makeText(phone.this, "Plz enter a number,Dialing to default", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });
    }
}
