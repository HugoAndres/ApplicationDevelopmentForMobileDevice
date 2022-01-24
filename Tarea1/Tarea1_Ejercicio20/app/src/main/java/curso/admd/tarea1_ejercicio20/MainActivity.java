package curso.admd.tarea1_ejercicio20;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        EditText jet1 = (EditText) findViewById(R.id.xet1);
        jet1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ImageView iconoDescuento = (ImageView) findViewById(R.id.xiv1);
                    Drawable d = iconoDescuento.getDrawable();
                    d = DrawableCompat.wrap(d);
                    DrawableCompat.setTint(d,
                            ContextCompat.getColor(MainActivity.this, R.color.black));
                } // micolor es un archivo xml en la carpeta color.xml.
            }
        });
    }
}
