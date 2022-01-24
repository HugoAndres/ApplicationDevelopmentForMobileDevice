package curso.admd.tarea4_ejercicio1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText jet,jet2;
    Button jbn;
    Bundle bdl;
    Intent itn;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet = (EditText) findViewById(R.id.xet);
        jet2 = (EditText) findViewById(R.id.xet2);
        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("DATO_X", jet.getText().toString()+" "+jet2.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }
}