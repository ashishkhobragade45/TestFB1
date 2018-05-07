package com.getl.demo.testfb;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Romania");
        list.add("Mexico");
        list.add("Germany");
        list.add("United Kingdom");
        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(this, R.layout.spinner_item, list);
        mySpinner.setAdapter(dataAdapter);


    }
}
