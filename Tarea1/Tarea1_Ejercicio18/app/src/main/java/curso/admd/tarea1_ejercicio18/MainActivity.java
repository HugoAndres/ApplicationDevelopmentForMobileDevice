package curso.admd.tarea1_ejercicio18;

import android.app.Activity;
import android.os.Bundle;
import android.text.*;
import android.widget.*;
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        EditText jet1 = (EditText) findViewById(R.id.xet1);
        jet1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int
                    after){}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {}
            @Override
            public void afterTextChanged(Editable e) {
                TextView tv = (TextView) findViewById(R.id.xtv1);
                String t = String.valueOf(e.length());
                tv.setText(t);
            }
        });
    }
}