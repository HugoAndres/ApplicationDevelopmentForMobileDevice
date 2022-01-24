package curso.admd.tarea1_ejercicio26;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    public static String[] MI_LISTA = {"Android", "Arriba", "Africa", "Asia", "América",
            "A", "AGUILA"};
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView jactv1 = (AutoCompleteTextView) findViewById(R.id.xactv1);
        ArrayAdapter<String>
                aa
                =
                new
                        ArrayAdapter<>(this,
                        android.R.layout.simple_dropdown_item_1line, MI_LISTA);
        jactv1.setAdapter(aa);
    }
}