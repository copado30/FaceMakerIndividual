package edu.up.faceMaker;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener {

    private Face face ;

    RadioGroup radioGroup;
    SeekBar bSeek,gSeek,rSeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        face = this.findViewById(R.id.faceview);

        Spinner hairTypeSpinner = findViewById(R.id.hairSpinner);
        String[] hairTypes = getResources().getStringArray(R.array.hairOptions);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,hairTypes);

        hairTypeSpinner.setAdapter(adapter);
        hairTypeSpinner.setOnItemSelectedListener(this);

        Button randFace = findViewById(R.id.randFaceButton);
        randFace.setOnClickListener(this);

        radioGroup = findViewById(R.id.selectorGroup);

        rSeek = findViewById(R.id.rSeek);
        rSeek.setOnSeekBarChangeListener(this);

        gSeek = findViewById(R.id.gSeek);
        gSeek.setOnSeekBarChangeListener(this);

        bSeek = findViewById(R.id.bSeek);
        bSeek.setOnSeekBarChangeListener(this);

    }



    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.randFaceButton) {
            face.randomize();//randomizes the character
        }

        face.invalidate();//refresh
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int selectedButton = radioGroup.getCheckedRadioButtonId();

        face.red = rSeek.getProgress();
        face.green = gSeek.getProgress();
        face.blue = bSeek.getProgress();


        if(selectedButton == R.id.radioEyes){
            face.setEyeColor(face.red,face.green,face.blue);
        }

        else if(selectedButton == R.id.radioSkin){
            face.setSkinColor(face.red,face.green,face.blue);
        }

        else if(selectedButton == R.id.radioHair){
            face.setHairColor(face.red,face.green,face.blue);
        }

        face.invalidate();//refreshes do not delete
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //nothing
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        if(item.equals("Bald")){
            face.hairStyle = 0;
        }
        else if(item.equals("Normal")){
            face.hairStyle = 1;
        }
        else if(item.equals("Long Hair")){
            face.hairStyle = 2;
        }
        face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}