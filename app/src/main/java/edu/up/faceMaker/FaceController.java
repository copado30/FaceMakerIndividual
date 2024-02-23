package edu.up.faceMaker;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.SeekBar;

/*
@author Rafael Copado
Last Updated 2/15/2024
 */

//class that takes actions and does something with them
// like a button gets incrementing the seekbars and changing the displaying value

public class FaceController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener {
    private FaceView faceView;

    public FaceController(FaceView passedView ){
        faceView = passedView;
    }

    @Override
    public void onClick(View v) {
        faceView.randomize();//randomizes the character
        faceView.invalidate();//refresh
        Log.d("click"," I was clicked  " );
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (seekBar.getId() == R.id.rSeek) {
            faceView.red = progress;
        }
        if (seekBar.getId() == R.id.gSeek) {
            faceView.green = progress;
        }
        if (seekBar.getId() == R.id.bSeek) {
            faceView.blue = progress;
        }

        faceView.invalidate();
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
            faceView.hairStyle = 0;
        }
        else if(item.equals("Normal")){
            faceView.hairStyle = 1;
        }
        else if(item.equals("Long Hair")){
            faceView.hairStyle = 2;
        }
        faceView.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
