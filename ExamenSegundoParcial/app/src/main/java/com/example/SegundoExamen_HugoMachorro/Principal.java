package com.example.SegundoExamen_HugoMachorro;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.example.SegundoExamen_HugoMachorro.R;

import java.util.List;

import io.paperdb.Paper;

public class Principal extends AppCompatActivity {

    String clave_guardada = "pattern_code";
    PatternLockView mPatternLockView;
    String clave_final = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Paper.init(this);
        final String save_pattern = Paper.book().read(clave_guardada);
        if (save_pattern != null && !save_pattern.equals("null")) {
            setContentView(R.layout.activity_principal);
            mPatternLockView = (PatternLockView) findViewById(R.id.pattern_lock_view);
            mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {

                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {
                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    clave_final = PatternLockUtils.patternToString(mPatternLockView, pattern);
                    if (clave_final.equals(save_pattern)) {
                        Toast.makeText(Principal.this, "Patron correcto!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Principal.this, ActividadDesbloqueada.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Principal.this, "Patron Incorrecta!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCleared() {
                }
            });
        }
    }
}