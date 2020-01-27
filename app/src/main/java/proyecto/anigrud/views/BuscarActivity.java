package proyecto.anigrud.views;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import proyecto.anigrud.R;
import proyecto.anigrud.Utilidades.Calendario;
import proyecto.anigrud.Utilidades.ListaSpinner;
import proyecto.anigrud.interfaces.BuscarInterface;
import proyecto.anigrud.interfaces.ListadoInterface;
import proyecto.anigrud.models.AnimalModelo;
import proyecto.anigrud.presenters.BuscarPresenter;

public class BuscarActivity extends AppCompatActivity implements View.OnClickListener, BuscarInterface.View,  View.OnFocusChangeListener{
    private ImageButton btnFecha;
    private EditText etFecha;
    private Button btnGuardar;
    private BuscarInterface.Presenter presenter;
    private Spinner spinnerTipos;
    private EditText parametro;
    String TAG = "aniGRUD/Buscar";
    private String valorSpinner = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        presenter = new BuscarPresenter(this);
        parametro = findViewById(R.id.parametro);
        btnFecha = findViewById(R.id.btnFecha);
       etFecha =  findViewById(R.id.etFecha);
       btnGuardar = findViewById(R.id.btnGuardar);
       btnFecha.setOnClickListener(this);
       btnGuardar.setOnClickListener(this);
       etFecha.setOnFocusChangeListener(this);



        spinnerTipos = (Spinner) findViewById(R.id.spinner);
        spinnerTipos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,presenter.ObtenerTipos()));

        spinnerTipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                Toast.makeText(adapterView.getContext(),
                        (String) adapterView.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();

                valorSpinner = (String) adapterView.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });
    }

    @Override
    public void onClick(View v) {
        if(v==btnFecha){
            Calendario.CreaCalendario(this.etFecha,this);
        }

        if(v== btnGuardar){
            this.presenter.onClickSave();
        }
    }



    @Override
    public void lanzarGuardado( ) {
        Intent intent = getIntent();
        intent.putExtra("nombreB",parametro.getText().toString());
        intent.putExtra("tipoB",valorSpinner);
        intent.putExtra("fechaB",etFecha.getText().toString());
        Log.d("llamado",intent.getExtras().toString());
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    public void errorFecha(boolean error, TextView tv) {
        if(!error){
            tv.setTextColor(Color.RED);
            tv.setText(R.string.errorFecha);
        }else{
            tv.setText("");
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


    @Override
    public void onFocusChange(View view, boolean b) {
        TextView tvef =findViewById(R.id.errorFecha);
       if(view == etFecha && !b) {
           presenter.checkDate(etFecha.getText().toString(),tvef);
       }

    }



}
