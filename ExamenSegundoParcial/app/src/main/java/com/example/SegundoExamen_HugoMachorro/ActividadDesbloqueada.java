package com.example.SegundoExamen_HugoMachorro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.net.*;
import android.view.View;
import android.view.View.*;
import android.widget.*;

import com.example.SegundoExamen_HugoMachorro.R;

public class ActividadDesbloqueada extends AppCompatActivity implements OnClickListener {

    Button jbnplay, jbnexit;
    VideoView vvw;
    Uri uri;
    MediaController mcr;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_actividad_desbloqueada);
        jbnplay = (Button) findViewById(R.id.xbnplay);
        jbnexit = (Button) findViewById(R.id.xbnexit);
        jbnplay.setOnClickListener(this);
        jbnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActividadDesbloqueada.this, "Aplicación finalizada", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void onClick(View v) {
        vvw = (VideoView) findViewById(R.id.xvv1);
        uri = Uri.parse("android.resource://com.example.SegundoExamen_HugoMachorro/" +
                R.raw.video);
        mcr = new MediaController(this);
        vvw.setMediaController(mcr);
        vvw.setVideoURI(uri);
        vvw.start();
    }
}