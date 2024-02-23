package edu.up.faceMaker;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        FaceView faceView = this.findViewById(R.id.faceview);
        FaceController faceController = new FaceController(faceView);

        Spinner hairTypeSpinner = findViewById(R.id.hairSpinner);
        String[] hairTypes = getResources().getStringArray(R.array.hairOptions);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,hairTypes);

        hairTypeSpinner.setAdapter(adapter);
        hairTypeSpinner.setOnItemSelectedListener(faceController);

        Button randFace = findViewById(R.id.randFaceButton);
        randFace.setOnClickListener(faceController);

        SeekBar rSeek = findViewById(R.id.rSeek);
        rSeek.setOnSeekBarChangeListener(faceController);

        SeekBar gSeek = findViewById(R.id.gSeek);
        gSeek.setOnSeekBarChangeListener(faceController);

        SeekBar bSeek = findViewById(R.id.bSeek);
        bSeek.setOnSeekBarChangeListener(faceController);



    }
}