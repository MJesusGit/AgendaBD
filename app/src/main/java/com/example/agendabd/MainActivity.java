package com.example.agendabd;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtTelefono;
    private ImageButton btnAniadirContacto;
    private ImageButton btnListarContactos;
    private RecyclerView lstContactos;

    private ConectorBD conectorBD;

    private ArrayList<Contacto> contactos = new ArrayList<>();
    private AdaptadorListaContactos adaptadorLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono= findViewById(R.id.txtTelefono);
        btnAniadirContacto = findViewById(R.id.btnAniadirContacto);
        btnListarContactos = findViewById(R.id.btnListarContactos);
        lstContactos = findViewById(R.id.lstContactos);

        conectorBD = new ConectorBD(this);
        btnAniadirContacto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                conectorBD.abrir();
                conectorBD.insertarContacto(txtNombre.getText().toString(),
                        txtTelefono.getText().toString() );
                //conectorBD.cerrar();
                Toast.makeText(getBaseContext(), "Se añadió un nuevo contacto a la BD local!", Toast.LENGTH_SHORT).show();
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new  LinearLayoutManager(getApplicationContext());
        lstContactos.setLayoutManager(mLayoutManager);
        adaptadorLista = new AdaptadorListaContactos(contacto);
        lstContactos.setAdapter(adaptadorLista);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}