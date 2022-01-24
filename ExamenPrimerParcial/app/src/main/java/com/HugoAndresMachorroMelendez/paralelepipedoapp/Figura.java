package com.HugoAndresMachorroMelendez.paralelepipedoapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Figura extends View {
    Paint paint=new Paint();
    Paint p;
    int s=-1;
    int centerX,centerY,maxX,maxY,minMaxXY;
    Obj obj;
    String parametrosglob;
    double X;
    double Y;

    public Figura(Context c, String parametros){
        super(c);
        parametrosglob=parametros;
        obj=new Obj(parametros);
        paint=new Paint();
        centerX=550;
        centerY=700;
    }
    int iX(double x){
        return (int)(centerX+x);
    }
    int iY(double y){
        return (int)(centerY-y);
    }
    void line(Canvas c, int i, int j){
        paint.setColor(Color.RED);
        if(i>7){
            paint.setColor(Color.BLACK);
        }
        Point2D p=obj.vScr[i],q=obj.vScr[j];
        c.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y),paint);
    }
    protected void onDraw(Canvas can){
        can.drawColor(Color.WHITE);
        maxX=getWidth()-1;maxY=getHeight()-1;minMaxXY=Math.min(maxX,maxY);
        obj.d=obj.rho*minMaxXY/obj.objSize;
        obj.eyeAndScreen();
        //Paralelepipedo
        line(can,0,1);line(can,0,2);line(can,0,3);//vector a,b,c
        line(can,1,4);line(can,3,4);line(can,3,5);//vector d,e,f
        line(can,2,5);line(can,2,6);line(can,1,6);//vector g,h,i
        line(can,5,7);line(can,4,7);line(can,6,7);//Vector j,k,l
        //Ejes coordenados
        line(can,8,9);
        line(can,10,11);
        line(can,12,13);
        paint.setTextSize(50);
        float posy=getHeight()/2+getHeight()/4;
        String[] datos=parametrosglob.split(" ");
        double[] cantidades=new double[9];
        for(int i=0;i<9;i++){
            cantidades[i]=Double.parseDouble(datos[i]);
        }
        can.drawText("Vertice A=(0,0,0)",0,posy,paint);
        can.drawText("Vertice B=("+datos[0]+","+datos[1]+","+datos[2]+")",0,posy+55,paint);
        can.drawText("Vertice C=("+datos[3]+","+datos[4]+","+datos[5]+")",0,posy+110,paint);
        can.drawText("Vertice D=("+datos[6]+","+datos[7]+","+datos[8]+")",0,posy+165,paint);
        double x=cantidades[0]+cantidades[6],y=cantidades[1]+cantidades[7],z=cantidades[2]+cantidades[8];
        can.drawText("Vertice E=("+x+","+y+","+z+")",0,posy+220,paint);
        x=cantidades[3]+cantidades[6];y=cantidades[4]+cantidades[7];z=cantidades[5]+cantidades[8];
        can.drawText("Vertice F=("+x+","+y+","+z+")",0,posy+275,paint);
        x=cantidades[3]+cantidades[0];y=cantidades[4]+cantidades[1];z=cantidades[2]+cantidades[5];
        can.drawText("Vertice G=("+x+","+y+","+z+")",0,posy+330,paint);
        x=cantidades[0]+cantidades[3]+cantidades[6];y=cantidades[1]+cantidades[4]+cantidades[7];z=cantidades[2]+cantidades[5]+cantidades[8];
        can.drawText("Vertice H=("+x+","+y+","+z+")",0,posy+385,paint);
        double volumen=Math.abs((((cantidades[1]*cantidades[5])-(cantidades[2]*cantidades[4]))*cantidades[6])+((((cantidades[0]*cantidades[5])-(cantidades[2]*cantidades[3]))*-1)*cantidades[7])+(((cantidades[0]*cantidades[4])-(cantidades[1]*cantidades[3]))*cantidades[8]));
        can.drawText("El Volumen del paralelepipedo es: "+volumen,0,posy+440,paint);
    }
    public boolean onTouchEvent(MotionEvent me){
        if(me.getAction()== MotionEvent.ACTION_DOWN){
            s=-1;
            X=me.getX();
            Y=me.getY();
            for(int i=0;i<2;i++){
                double dx=X-centerX,dy=Y-centerY;
                double d=(double)Math.sqrt(dx*dx+dy*dy);
                if(d<=75){
                    s=i;
                    invalidate();
                }
            }
        }
        if(me.getAction()==MotionEvent.ACTION_MOVE){
            if(s>-1){
                centerX=(int)me.getX();
                centerY=(int)me.getY();
                invalidate();
            }
        }
        if(me.getX()<X){
            obj.theta= (float) (obj.theta-2*Math.PI/300);
        }
        if(me.getX()>X){
            obj.theta=(float)(obj.theta+2*Math.PI/300);
        }
        if(me.getY()<Y){
            obj.phi= (float) (obj.phi-2*Math.PI/300);
        }
        if(me.getY()>Y){
            obj.phi= (float) (obj.phi+2*Math.PI/300);
        }
        invalidate();
        return true;
    }
}
