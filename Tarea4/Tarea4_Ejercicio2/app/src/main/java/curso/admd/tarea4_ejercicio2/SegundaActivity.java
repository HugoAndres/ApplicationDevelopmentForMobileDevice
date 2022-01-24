package curso.admd.tarea4_ejercicio2;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SegundaActivity extends Activity{
    TextView jet;
    Bundle bdl;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        jet = (TextView) findViewById(R.id.xtv1);
        bdl = getIntent().getExtras();
        String a1=bdl.getString("A");
        String b1=bdl.getString("B");
        String c1=bdl.getString("C");
        float a=Integer.parseInt(a1);
        float b2=Integer.parseInt(b1);
        float c=Integer.parseInt(c1);
        float coef=(b2*b2)-(4*a*c);
        double x1=(-b2+Math.sqrt(coef))/(2*a);
        double x2=(-b2-Math.sqrt(coef))/(2*a);
        jet.append("x1= "+x1 +"\n"+ " x2="+x2);
    }
}

