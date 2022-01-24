package com.example.vertices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements OnClickListener{
    Button jbn1;
    EditText jet1, jet2, jet3;
    Bundle bdl;
    Intent itn;

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet1 = findViewById(R.id.xet1);
        jet2 = findViewById(R.id.xet2);
        jet3 = findViewById(R.id.xet3);
        jbn1 = (Button) findViewById(R.id.xbn1);
        jbn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        itn = new Intent(MainActivity.this, Vertice.class);
        bdl = new Bundle();
        bdl.putString("Datos",jet1.getText().toString()+" "+jet2.getText().toString()+" "+jet3.getText().toString());
        itn.putExtras(bdl);
        startActivity(itn);
    }

}