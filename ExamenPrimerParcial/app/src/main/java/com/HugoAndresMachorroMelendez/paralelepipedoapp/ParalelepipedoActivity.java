package com.HugoAndresMachorroMelendez.paralelepipedoapp;

import android.app.Activity;
import android.os.Bundle;

public class ParalelepipedoActivity extends Activity {
    Figura field_1;

    public ParalelepipedoActivity() {}

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        paramBundle = getIntent().getExtras();
        String parametros=paramBundle.getString("Datos");
        setContentView(new Figura(this,parametros));
    }
}
