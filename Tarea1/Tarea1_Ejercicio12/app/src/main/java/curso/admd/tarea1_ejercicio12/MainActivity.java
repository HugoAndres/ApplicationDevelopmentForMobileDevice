package curso.admd.tarea1_ejercicio12;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.xet1).isFocusable()) {
            findViewById(R.id.xet2).requestFocus();
        }
    }
}