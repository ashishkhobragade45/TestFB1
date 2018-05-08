package com.getl.demo.testfb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.getl.demo.testfb.Model.Employees;

public class Report extends AppCompatActivity {

    TextView tx1,tx2,tx3,tx4,tx5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        tx1 = (TextView)findViewById(R.id.textView);
        tx2 = (TextView)findViewById(R.id.textView2);
        tx3 = (TextView)findViewById(R.id.textView3);
        tx4 = (TextView)findViewById(R.id.textView4);
        tx5 = (TextView)findViewById(R.id.textView5);

        Intent intent = getIntent();


        tx1.setText(intent.getStringExtra("dlno"));
        tx2.setText(intent.getStringExtra("drivername"));
        tx3.setText(intent.getStringExtra("mobile"));
        tx4.setText(intent.getStringExtra("topic"));
        tx5.setText(intent.getStringExtra("trainer"));


    }
}
