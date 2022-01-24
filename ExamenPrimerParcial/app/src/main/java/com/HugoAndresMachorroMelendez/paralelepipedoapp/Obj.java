package com.HugoAndresMachorroMelendez.paralelepipedoapp;

import android.os.Bundle;

class Obj {    // Posee los datos del objeto 3D
    float rho, theta = 0.3F, phi = 1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D[] w;    // coordenadas universales
    Point2D[] vScr; // coordenadas de la pantalla

    Obj(String parametros) {
        w = new Point3D[14];
        vScr = new Point2D[14];
        String[] datos=parametros.split(" ");
        double[] cantidades=new double[9];
        double mayor=0;
        for(int i=0;i<9;i++){
            if(Double.parseDouble(datos[i])<0){
                if(mayor<(Double.parseDouble(datos[i])*-1)){
                    mayor=Double.parseDouble(datos[i]);
                }
                cantidades[i]=Double.parseDouble(datos[i]);
            }else{
                if(mayor<Double.parseDouble(datos[i])){
                    mayor=Double.parseDouble(datos[i]);
                }
                cantidades[i]=Double.parseDouble(datos[i]);
            }
        }
        for(int i=0;i<9;i++){
            cantidades[i]=cantidades[i]/mayor;
        }
        //Cubo
        w[0]	= new Point3D(0, 0, 0); // base
        w[1]	= new Point3D(cantidades[0],cantidades[1], cantidades[2]);//vertice 1-a
        w[2]	= new Point3D(cantidades[3],cantidades[4],cantidades[5]);//vertice 2-b
        w[3]	= new Point3D(cantidades[6],cantidades[7],cantidades[8]);//vertice 3-c
        w[4]	= new Point3D(cantidades[0]+cantidades[6], cantidades[1]+cantidades[7], cantidades[2]+cantidades[8]);//vertice a+c-d
        w[5]	= new Point3D(cantidades[3]+cantidades[6], cantidades[4]+cantidades[7], cantidades[5]+cantidades[8]);//vertice b+c-e
        w[6]	= new Point3D(cantidades[3]+cantidades[0], cantidades[4]+cantidades[1], cantidades[5]+cantidades[2]);//vertice a+b-f
        w[7]	= new Point3D(cantidades[3]+cantidades[0]+cantidades[6], cantidades[4]+cantidades[1]+cantidades[7], cantidades[5]+cantidades[2]+cantidades[8]);//vector a+b+c-g
        //ejes del plano cartesiano
        w[8]	= new Point3D(2, 0, 0);
        w[9]	= new Point3D(-2, 0, 0);
        w[10]	= new Point3D(0, 2, 0);
        w[11]	= new Point3D(0, -2, 0);
        w[12]	= new Point3D(0, 0, 2);
        w[13]	= new Point3D(0, 0, -2);

        objSize = (float) Math.sqrt(12F); // = sqrt(2*2 + 2*2 + 2*2) es la distancia entre dos vertices opuestos
        rho = 5 * objSize;        // para cambiar la perspectiva
    }
    void initPersp(){
        float costh = (float)Math.cos(theta), sinth=(float)Math.sin(theta), cosph=(float)Math.cos(phi), sinph=(float)Math.sin(phi);
        v11 = -sinth; v12 = -cosph*costh; v13 = sinph*costh;
        v21 = costh; v22 = -cosph*sinth; v23 = sinph*sinth;
        v32 = sinph; v33 = cosph; v43 = -rho;
    }
    void eyeAndScreen(){
        initPersp();
        for(int i=0; i<14; i++){
            Point3D p = w[i];
            float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
            vScr[i] = new Point2D(-d*x/z, -d*y/z);
        }
    }
}