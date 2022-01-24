package com.HugoAndresMachorroMelendez.paralelepipedoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText jetx1,jetx2,jetx3,jety1,jety2,jety3,jetz1,jetz2,jetz3;
    Button jbt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetx1=(EditText)findViewById(R.id.xetx1);
        jetx2=(EditText)findViewById(R.id.xetx2);
        jetx3=(EditText)findViewById(R.id.xetx3);
        jety1=(EditText)findViewById(R.id.xety1);
        jety2=(EditText)findViewById(R.id.xety2);
        jety3=(EditText)findViewById(R.id.xety3);
        jetz1=(EditText)findViewById(R.id.xetz1);
        jetz2=(EditText)findViewById(R.id.xetz2);
        jetz3=(EditText)findViewById(R.id.xetz3);
        jbt1=(Button)findViewById(R.id.xbt1);
        jbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("EditText",jetx1.getText().toString());
                Intent itn=new Intent(MainActivity.this,ParalelepipedoActivity.class);
                Bundle bdl=new Bundle();
                if(jetx1.getText().toString().isEmpty()){
                    jetx1.setText("0");
                }
                if(jetx2.getText().toString().isEmpty()){
                    jetx2.setText("0");
                }
                if(jetx3.getText().toString().isEmpty()){
                    jetx3.setText("0");
                }
                if(jety1.getText().toString().isEmpty()){
                    jety1.setText("0");
                }
                if(jety2.getText().toString().isEmpty()){
                    jety2.setText("0");
                }
                if(jety3.getText().toString().isEmpty()){
                    jety3.setText("0");
                }
                if(jetz1.getText().toString().isEmpty()){
                    jetz1.setText("0");
                }
                if(jetz2.getText().toString().isEmpty()){
                    jetz2.setText("0");
                }
                if(jetz3.getText().toString().isEmpty()){
                    jetz3.setText("0");
                }
                bdl.putString("Datos",jetx1.getText().toString()+" "+jety1.getText().toString()+" "+jetz1.getText().toString()+" "+
                                jetx2.getText().toString()+" "+jety2.getText().toString()+" "+jetz2.getText().toString()+" "+
                                jetx3.getText().toString()+" "+jety3.getText().toString()+" "+jetz3.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }
}