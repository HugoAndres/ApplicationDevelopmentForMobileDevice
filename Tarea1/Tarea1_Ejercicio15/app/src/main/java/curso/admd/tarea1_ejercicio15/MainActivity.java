package curso.admd.tarea1_ejercicio15;

import android.app.*;
import android.os.*;
import android.text.Editable;
import android.widget.EditText;
public class MainActivity extends Activity {
    EditText jet1;
    Editable jet2;
    int ini = 0, fin = 0;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet1 = (EditText) findViewById(R.id.xet1);
        jet2 = jet1.getText();
        for (int i = ini; i < jet1.length(); i++)
            if (jet2.charAt(i) == ' ')
                fin = i;
        jet1.setSelection(ini, fin);
    }
}