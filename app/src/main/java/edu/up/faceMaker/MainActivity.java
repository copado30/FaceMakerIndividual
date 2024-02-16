package edu.up.faceMaker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
/*
@author Rafael Copado
Last Updated 2/15/2024

 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner hairTypeSpinner = findViewById(R.id.hairSpinner);
        String[] hairTypes = getResources().getStringArray(R.array.hairOptions);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,hairTypes);

        hairTypeSpinner.setAdapter(adapter);
    }
}