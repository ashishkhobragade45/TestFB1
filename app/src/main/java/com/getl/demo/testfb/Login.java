package com.getl.demo.testfb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getl.demo.testfb.Model.Employees;
import com.getl.demo.testfb.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button btnsubmit;
    EditText edtcompany,edtdlno;
    Employees employees;
    FirebaseDatabase database;
    DatabaseReference emp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnsubmit = (Button)findViewById(R.id.submit);
        edtcompany = (EditText)findViewById(R.id.company);
        edtdlno = (EditText)findViewById(R.id.dlno);

        // init firebased

        database = FirebaseDatabase.getInstance();
        emp = database.getReference("employees");

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emp.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(edtdlno.getText().toString()).exists()) {

                            //getting information
                            employees = dataSnapshot.child(edtcompany.getText().toString()).getValue(Employees.class);
                            if (employees.getDLNO().equals(edtcompany.getText().toString())) {
                                Toast.makeText(Login.this, "Success", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Login.this,Report.class);
                                intent.putExtra("dlno",employees.getDLNO());
                                intent.putExtra("drivername",employees.getDriverName());
                                intent.putExtra("mobile",employees.getDriverMobNo());
                                intent.putExtra("topic",employees.getDMCTopicShared());
                                intent.putExtra("trainer",employees.getTrainerName());
                                startActivity(intent);
                            } else {
                                Toast.makeText(Login.this, "Driver not ", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Driver not in DB", Toast.LENGTH_SHORT).show();
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
