package com.example.phoneservice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class message extends AppCompatActivity {
   // private static int call=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Button b=findViewById(R.id.mess);
        //EditText e1,e2;
        //e1=findViewById(R.id.m1);
        //e2=findViewById(R.id.m2);
        //final String n=e1.getText().toString();
        //final String m=e2.getText().toString();


       /* if (ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)){
            }else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},call);
            }
            //ActivityCompat.requestPermissions(message.this,new String[]{Manifest.permission.SEND_SMS},call);
        }*/



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1,e2;
                e1=findViewById(R.id.m1);
                e2=findViewById(R.id.m2);
                String n=e1.getText().toString();
                String m=e2.getText().toString();

                Intent x=new Intent(Intent.ACTION_VIEW);
               // x.setType("vnd.android-dir/mms-sms");
                x.setData(Uri.parse("sms:"));
                x.putExtra("address",""+n);
                x.putExtra("sms_body",""+m);
                startActivity(x);

                //SmsManager smsManager=SmsManager.getDefault();
                //smsManager.sendTextMessage(n,null,m,null,null);
                Toast.makeText(message.this, "Message sent", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
