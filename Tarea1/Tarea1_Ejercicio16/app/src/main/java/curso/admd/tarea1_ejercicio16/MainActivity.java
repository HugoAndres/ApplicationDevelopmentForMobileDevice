package curso.admd.tarea1_ejercicio16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText jet1 = (EditText) findViewById(R.id.xet1);
        jet1.selectAll();
    }
}