package proyecto.anigrud.views;

import android.app.slice.SliceItem;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import proyecto.anigrud.R;
import proyecto.anigrud.Utilidades.Calendario;
import proyecto.anigrud.interfaces.FormInterface;
import proyecto.anigrud.interfaces.ListadoInterface;
import proyecto.anigrud.presenters.FormPresenter;
import proyecto.anigrud.presenters.ListadoPresenter;

public class FormJavaActivity extends AppCompatActivity implements FormInterface.View, View.OnClickListener{
    String TAG = "aniGRUD/Formulario";
    private FormInterface.Presenter presenter;
    Button btnGuardar;
    ImageButton btnFecha;
    EditText etFecha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_java);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        presenter = new FormPresenter(this);
        btnGuardar = findViewById(R.id.botonGuardar);
        btnFecha = findViewById(R.id.btnFechaF);
        etFecha = findViewById(R.id.etFechaF);
        btnGuardar.setOnClickListener(this);
        btnFecha.setOnClickListener(this);



    }

    @Override
    public void lanzarGuardado(){
        finish();
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"entrado en el onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"entrado en el onresume");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"entrado en el stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"entrado en el stop");
    }


    @Override
    public void onClick(View v) {
        if(v== btnGuardar){
            presenter.onClickSave();
        }

        if(v== btnFecha){
            Calendario.CreaCalendario( etFecha ,this);
        }





    }
}
