package curso.admd.tarea1_ejercicio19;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.*;
import android.widget.*;
public class MainActivity extends Activity {
    EditText jet1;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet1 = (EditText) findViewById(R.id.xet1);
        jet1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int id, KeyEvent ke) {
                boolean b = false;
                if(id == EditorInfo.IME_ACTION_SEARCH){
                    Toast.makeText(MainActivity.this,
                            "búsqueda..."
                                    +
                                    v.getText().toString(), Toast.LENGTH_LONG).show();
                    InputMethodManager
                            imm
                            =
                            (InputMethodManager)
                                    getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    b = true;
                }
                return b;
            }
        });
    }
}