package curso.admd.tarea14_ejercicio1;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
public class MainActivity extends Activity {
    EditText jetI, jetN;
    Button jbnA, jbnL, jbnB, jbnC;
    TextView jtvL;
    SQLiteDatabase sqld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetI = (EditText) findViewById(R.id.xetI);
        jetN = (EditText) findViewById(R.id.xetN);
        jbnA = (Button) findViewById(R.id.xbnA);
        jbnL = (Button) findViewById(R.id.xbnL);
        jbnB = (Button) findViewById(R.id.xbnB);
        jbnC = (Button) findViewById(R.id.xbnC);
        jtvL = (TextView) findViewById(R.id.xtvL);
        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        sqld = dsqlh.getWritableDatabase();
        jbnA.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String id = jetI.getText().toString();
                String nombre = jetN.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put("id", id);
                cv.put("nombre", nombre);
                sqld.insert("Contactos", null, cv);
                jetI.setText(""); jetN.setText("");
            }
        });
        jbnL.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String id, nombre;
                Cursor c = sqld.rawQuery("SELECT id,nombre FROM Contactos", null);
                jtvL.setText("");
                if (c.moveToFirst()) {
                    do {
                        id = c.getString(0);
                        nombre = c.getString(1);
                        jtvL.append(" " + id + "\t" + nombre + "\n");
                    } while(c.moveToNext());
                }
            }
        });

        jbnB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String id;
                id=jetI.getText().toString();
                sqld.delete("Contactos","id='"+id+"'",null);
            }
        });

        jbnC.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String id, nombre;
                id=jetI.getText().toString();
                nombre=jetN.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put("nombre",nombre);
                sqld.update("Contactos",cv,"id='"+id+"'",null);
            }
        });
    }
}