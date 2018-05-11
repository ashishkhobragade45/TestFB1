package com.getl.demo.testfb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getl.demo.testfb.Model.Employees;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;

public class New_Report extends AppCompatActivity {

    EditText txtcompany,txtzon,txtlocation,txtdlno;
    Button btnSearch;
    String sCompany,sZone,sLocation,sDlno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__report);

        txtcompany = (EditText)findViewById(R.id.company);
        txtzon = (EditText)findViewById(R.id.zon);
        txtlocation = (EditText)findViewById(R.id.location);
        txtdlno = (EditText)findViewById(R.id.dlno);

        btnSearch = (Button)findViewById(R.id.btnsearch);

        sCompany = txtcompany.getText().toString().trim();
        sZone = txtlocation.getText().toString().trim();
        sLocation =txtlocation.getText().toString().trim();
        sDlno = txtdlno.getText().toString().trim();

        FirebaseDatabase database;
       final DatabaseReference emp,company;

        //init firebased

        database = FirebaseDatabase.getInstance();
        emp = database.getReference("acc");
        Log.e("Name", String.valueOf(emp));



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emp.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(txtdlno.getText().toString()).exists()) {


                        }
                        else
                        {
                            Toast.makeText(New_Report.this, "Driver not in DB", Toast.LENGTH_SHORT).show();
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
