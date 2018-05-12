package com.getl.demo.testfb;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getl.demo.testfb.Model.Demo_employees;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;

public class AddDateEmp extends AppCompatActivity {

    EditText txtdlno,txtdname,txttopics;
    Button btnsave,btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_date_emp);

        txtdlno = (EditText)findViewById(R.id.dlid);
        txtdname = (EditText)findViewById(R.id.txtdname);
        txttopics = (EditText)findViewById(R.id.txttopics);

        btnsave = (Button)findViewById(R.id.btnsave);
        btnCheck = (Button)findViewById(R.id.btnCheck);

        //for current date
        Calendar calendar = Calendar.getInstance();
        final String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        //copy id value in string
        final String dlno = txtdlno.getText().toString();
        FirebaseDatabase database;
        final DatabaseReference emp,driver;

        //init firebased

        database = FirebaseDatabase.getInstance();
        emp = database.getReference("employees/acc/east/mu/"+currentDate);
        driver = database.getReference("driverDB");

        //check id record and display
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driver.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(txtdlno.getText().toString()).exists()) {
                            Toast.makeText(AddDateEmp.this, "In DB", Toast.LENGTH_SHORT).show();

                            //check employee current data and emplyeeDB
                            Demo_employees demo_employees = dataSnapshot.child(txtdlno.getText().toString()).getValue(Demo_employees.class);
                            txttopics.setText(demo_employees.getDMCTopicShared().toString());
                            txtdname.setText(demo_employees.getDriverName().toString());

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                driver.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                       if(dataSnapshot.child(txtdlno.getText().toString()).exists())
                       {
                           Toast.makeText(AddDateEmp.this, "In DB", Toast.LENGTH_SHORT).show();

                            //check employee current data and emplyeeDB
                           Demo_employees demo_employees = dataSnapshot.child(txtdlno.getText().toString()).getValue(Demo_employees.class);
                           txttopics.setText(demo_employees.getDMCTopicShared().toString());
                           txtdname.setText(demo_employees.getDriverName().toString());


                          /* emp.addValueEventListener(new ValueEventListener() {
                               @Override
                               public void onDataChange(DataSnapshot dataSnapshot) {

                                       Demo_employees demo_employees = new Demo_employees(txtdlno.getText().toString(),txttopics.getText().toString(),txtdname.getText().toString());
                                       emp.child(currentDate).child(txtdlno.getText().toString()).setValue(demo_employees);
                                       Toast.makeText(AddDateEmp.this, "Driver Added", Toast.LENGTH_SHORT).show();
                                       finish();

                               }

                               @Override
                               public void onCancelled(DatabaseError databaseError) {

                               }
                           });*/



                            //Add new value on Time stamp.
                           /*emp.addValueEventListener(new ValueEventListener() {
                               @Override
                               public void onDataChange(DataSnapshot dataSnapshot) {
                                   if(dataSnapshot.child(txtdlno.getText().toString()).exists())
                                   {
                                       Toast.makeText(AddDateEmp.this, "Driver in DB", Toast.LENGTH_SHORT).show();
                                   }
                                   else
                                   {
                                       Demo_employees demo_employees = new Demo_employees(txtdlno.getText().toString(),txttopics.getText().toString(),txtdname.getText().toString());
                                       emp.child(currentDate).child(txtdlno.getText().toString()).setValue(demo_employees);
                                       Toast.makeText(AddDateEmp.this, "Driver Added", Toast.LENGTH_SHORT).show();
                                       finish();
                                   }
                               }

                               @Override
                               public void onCancelled(DatabaseError databaseError) {

                               }
                           });*/
                       }
                       else 
                       {
                           Toast.makeText(AddDateEmp.this, "Not in DB", Toast.LENGTH_SHORT).show();
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
