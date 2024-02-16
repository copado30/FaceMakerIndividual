package edu.up.faceMaker;

import android.graphics.Canvas;

import java.util.Random;
/*
@author Rafael Copado
Last Updated 2/15/2024

 */
public class Face {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    /*
    * Constructor below will assign pseudorandom
    * numbers to the variable above
    * Instance variables were made public because
    * I am assuming they will need to be accessed by other classes
    * */
    public Face(){
        randomize();
    }
    public void randomize(){
        Random randomNumber = new Random();
        skinColor = randomNumber.nextInt(256);
        eyeColor = randomNumber.nextInt(256);
        hairColor = randomNumber.nextInt(256);
        hairStyle = randomNumber.nextInt(4);
    }
    public void onDraw(Canvas c){
        //empty for now
    }
    public void drawHair(){

    }
    public void drawEyes(){

    }
    public void drawFace(){

    }
}
