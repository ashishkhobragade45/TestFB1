package com.getl.demo.testfb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getl.demo.testfb.Model.Demo_employees;
import com.getl.demo.testfb.Model.Employees;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;

public class New_Report extends AppCompatActivity {

    EditText txtdlno,txtdname,txttopics;
    Button btnsave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__report);

        txtdlno = (EditText)findViewById(R.id.dlid);
        txtdname = (EditText)findViewById(R.id.txtdname);
        txttopics = (EditText)findViewById(R.id.txttopics);

        btnsave = (Button)findViewById(R.id.btnsave);


        FirebaseDatabase database;
       final DatabaseReference emp,dlno;

        //init firebased

        database = FirebaseDatabase.getInstance();
        emp = database.getReference("driverDB");

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emp.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.child(txtdlno.getText().toString()).exists())
                            {
                                Toast.makeText(New_Report.this, "Driver in DB", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Demo_employees demo_employees = new Demo_employees(txtdlno.getText().toString(),txttopics.getText().toString(),txtdname.getText().toString());
                                emp.child(txtdlno.getText().toString()).setValue(demo_employees);
                                Toast.makeText(New_Report.this, "Driver Added", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });



    }
}
