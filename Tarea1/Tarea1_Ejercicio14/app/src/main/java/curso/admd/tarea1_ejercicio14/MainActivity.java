package curso.admd.tarea1_ejercicio14;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        EditText campo1 = (EditText) findViewById(R.id.xet1);
        Log.d("Obteniendo cursor...", String.valueOf(campo1.getSelectionEnd()));
    }
}