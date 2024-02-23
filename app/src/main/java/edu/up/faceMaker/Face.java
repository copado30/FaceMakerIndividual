package edu.up.faceMaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class Face extends SurfaceView {
    public Paint facePaint = new Paint();
    public Paint eyePaint = new Paint();
    public Paint hairPaint = new Paint();

    public int red;
    public int green;
    public int blue;

    public Canvas pCanvas;

    public int hairStyle = 0;//default is bald


    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);

        hairPaint.setColor(Color.BLACK);

        setBackgroundColor(Color.WHITE);
        //only gets called once
    }
    public void randomize(){
        Random randomNumber = new Random();

        for(int i = 0; i < 3; i++){
            red = randomNumber.nextInt(256);
            green = randomNumber.nextInt(256);
            blue = randomNumber.nextInt(256);
            if(i == 0){
                setEyeColor(red, green,blue);}
            else if(i == 1){
                setHairColor(red,green,blue);
            }
            else{
                setSkinColor(red,green,blue);
            }

        }


        hairStyle = randomNumber.nextInt(3);
        //works
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        //gets called everytime invalidates()
        drawFace(canvas, facePaint);
        drawEyes(canvas,eyePaint);
        drawHair(canvas,hairPaint);

    }

    public void setEyeColor(int r, int g, int b){
        int color = android.graphics.Color.rgb(r,g,b);
        eyePaint.setColor(color);
    }
    public void setHairColor(int r, int g, int b){
        int color = android.graphics.Color.rgb(r,g,b);
        hairPaint.setColor(color);
    }
    public void setSkinColor(int r, int g, int b){
        int color = android.graphics.Color.rgb(r,g,b);
        facePaint.setColor(color);
    }

    public void drawFace(Canvas canvas, Paint paint){
        int x = 675;
        int y = 100;

        canvas.drawOval(x,y,x+500,y+650,paint);

    }
    public void drawEyes(Canvas canvas, Paint paint){
        int x = 675;
        int y = 100;

        canvas.drawCircle(x+130,y+200,50,paint);
        canvas.drawCircle(x+370,y+200,50,paint);
    }//drawEyes

    public void drawHair(Canvas canvas, Paint paint){

        int x = 675;
        int y = 100;

        if(hairStyle == 1){
            //normal hair
            for(int i = 0; i < 16; i++){
                canvas.drawLine(x+90+(i*20),y-35,x+90+(i*20),y+120,paint);
            }
        }
        if(hairStyle == 2){
            //long hair
            for(int i = 0; i < 16; i++){
                if(i < 2 || i > 13){
                    canvas.drawLine(x+50+(i*27),y-50,x+50+(i*27),y+350,paint);
                }
                else {
                    canvas.drawLine(x + 50 + (i * 27), y - 50, x + 50 + (i * 27), y + 150, paint);
                }
            }
        }

        else{
            //do nothing bald is default (hairStyle == 0)
        }

    }//drawEyes


}
