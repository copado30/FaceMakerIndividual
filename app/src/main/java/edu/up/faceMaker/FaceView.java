package edu.up.faceMaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/*
@author Rafael Copado
Last Updated 2/15/2024

 */
public class FaceView extends SurfaceView {

    public Paint facePaint = new Paint();
    public Paint eyePaint = new Paint();
    public Paint hairPaint = new Paint();

    public int red;
    public int green;
    public int blue;

    public int hairStyle = 0;//default is bald

    String faceColor;
    String eyeColor;
    String hairColor;



    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);

        hairPaint.setColor(Color.BLACK);

        setBackgroundColor(Color.WHITE);
        //only gets called once
    }


    public void randomize(){
        Random randomNumber = new Random();

        red = randomNumber.nextInt(256);
        green = randomNumber.nextInt(256);
        blue = randomNumber.nextInt(256);

        facePaint.setColor((int)Long.parseLong(faceColor,16));
        eyePaint.setColor((int)Long.parseLong(eyeColor,16));
        hairPaint.setColor((int)Long.parseLong(hairColor,16));

        hairStyle = randomNumber.nextInt(3);//0,1,2


        //works
    }



    @Override
    public void onDraw(Canvas canvas)
    {

        faceColor = String.format("%02X%02X%02X%02X",255, red, green, blue);
        eyeColor = String.format("%02X%02X%02X%02X",255, green, blue, red);
        hairColor = String.format("%02X%02X%02X%02X",255, blue, red, green);

        facePaint.setColor((int)Long.parseLong(faceColor,16));
        facePaint.setStyle(Paint.Style.FILL);

        eyePaint.setColor((int)Long.parseLong(eyeColor,16));
        eyePaint.setStyle(Paint.Style.FILL);

        hairPaint.setColor((int)Long.parseLong(hairColor,16));
        hairPaint.setStyle(Paint.Style.FILL);
        //gets called everytime invalidates()
        drawFace(canvas,facePaint,eyePaint,hairPaint);

    }

    public void drawFace(Canvas canvas, Paint faceP, Paint eyeP, Paint hairP){

        int x = 675;
        int y = 100;
        //randomize();

        canvas.drawOval(x,y,x+500,y+650,faceP);

        canvas.drawCircle(x+130,y+200,50,eyeP);
        canvas.drawCircle(x+370,y+200,50,eyeP);

        if(hairStyle == 1){
            //normal hair
            for(int i = 0; i < 16; i++){
                canvas.drawLine(x+90+(i*20),y-35,x+90+(i*20),y+120,hairP);
            }
        }
        if(hairStyle == 2){
            //long hair
            for(int i = 0; i < 16; i++){
                if(i < 2 || i > 13){
                    canvas.drawLine(x+50+(i*27),y-50,x+50+(i*27),y+350,hairP);
                }
                else {
                    canvas.drawLine(x + 50 + (i * 27), y - 50, x + 50 + (i * 27), y + 150, hairP);
                }
            }
        }
        else{
            //do nothing bald is default (hairStyle == 0)
        }

    }


}




