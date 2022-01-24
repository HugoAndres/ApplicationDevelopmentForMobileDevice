package curso.admd.tarea4_ejercicio2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText jet1,jet2,jet3;
    Button bt1;
    Intent itn;
    Bundle bdl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jet1=(EditText)findViewById(R.id.xet1);
        jet2=(EditText)findViewById(R.id.xet2);
        jet3=(EditText)findViewById(R.id.xet3);
        bt1=(Button) findViewById(R.id.xbt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("A", jet1.getText().toString());
                bdl.putString("B",jet2.getText().toString());
                bdl.putString("C",jet3.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }
}