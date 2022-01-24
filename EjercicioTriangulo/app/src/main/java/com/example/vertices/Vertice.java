package com.example.vertices;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.concurrent.TimeUnit;


public class Vertice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String parame;
        Bundle param = getIntent().getExtras();
        parame = param.getString("Datos");


        Lienzo l = new Lienzo(this, parame);
        setContentView(l);
    }

}

class Lienzo extends View {
    Paint p;
    int x, y;

    String parametrosglob;

    public Lienzo(Context c, String b){
        super(c);
        parametrosglob = b;
    }

    protected void onDraw(Canvas c){
        String[] datos=parametrosglob.split(" ");
        String dato1 = datos[0];
        int dato2 = Integer.parseInt(datos[1]);
        int dato3 = Integer.parseInt(datos[2]);
        int vx1,vy1,vx2,vy2,vx3,vy3,vx4,vy4,pmx1=0,pmy1=0;


        super.onDraw(c); // Canvas pinta atributos
        p = new Paint(); // Paint asigna atributos
        //Path path = new Path();
        x = getWidth(); // También: getMeasuredWidth() o getRight(), x=480
        y = getHeight(); // También: getMeasuredHeight() o getBottom(), y=762

        //p.setColor(Color.WHITE); // Fondo blanco
        c.drawPaint(p);
        p.setColor(Color.parseColor(dato1)); // Texto negro
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        //c.drawPath(path,p);
        //c.drawPoint(x/2,y/2,p);

        // Calculo vertice 1
        vx1 = (x/2-dato2/2);
        vy1 = (y/2+dato2/2);
        // Calculo vertice 2
        vx2 = (x/2+dato2/2);
        vy2 = (y/2+dato2/2);
        // Calculo vertice 3
        int a = (int) Math.sqrt(Math.pow(dato2,2)-Math.pow(dato2/2,2));
        vx3 = x/2;
        vy3 = (vy1-a);
        // Vertice fuera del area
        vx4 = 30;
        vy4 = 50;
        // Dibujar los 4 vertices
        c.drawPoint(vx1,vy1,p);
        c.drawPoint(vx2,vy2,p);
        c.drawPoint(vx3,vy3,p);
        c.drawPoint(vx4,vy4,p);

        for(int i=0;i<dato3;i++) {
            int ran = (int)(Math.random()*3 + 1);

            switch(ran) {
                case 1:
                    pmx1 = (vx4+vx1)/2;
                    pmy1 = (vy4+vy1)/2;
                    break;
                case 2:
                    pmx1 = (vx4+vx2)/2;
                    pmy1 = (vy4+vy2)/2;
                    break;
                case 3:
                    pmx1 = (vx4+vx3)/2;
                    pmy1 = (vy4+vy3)/2;
                    break;
                default:
                    break;
            }
            c.drawPoint(pmx1,pmy1,p);
            vx4 = pmx1;
            vy4 = pmy1;
        }
    }
}
