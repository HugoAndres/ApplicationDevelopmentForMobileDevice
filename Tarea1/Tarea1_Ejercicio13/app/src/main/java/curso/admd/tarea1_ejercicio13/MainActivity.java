package curso.admd.tarea1_ejercicio13;

import android.app.*;
import android.os.Bundle;
import android.widget.*;
public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        EditText jet1 = (EditText) findViewById(R.id.xet1);
        jet1.setSelection(3);
    }
}