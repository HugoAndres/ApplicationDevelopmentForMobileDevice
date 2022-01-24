package com.example.cuadromagico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button jbn1;
    EditText jet1;
    Bundle bdl;
    Intent itn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jet1 = findViewById(R.id.xet1);
        jbn1 = (Button) findViewById(R.id.xbn1);
        jbn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itn = new Intent(MainActivity.this,CuadroMagico.class);
        bdl = new Bundle();
        itn.putExtra("Dato", jet1.getText().toString());
        startActivity(itn);
    }
}