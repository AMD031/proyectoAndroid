package proyecto.anigrud.views;

import android.Manifest;
import android.app.AlertDialog;
import android.app.slice.SliceItem;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import proyecto.anigrud.R;
import proyecto.anigrud.Utilidades.Calendario;
import proyecto.anigrud.Utilidades.ListaSpinner;
import proyecto.anigrud.interfaces.FormInterface;
import proyecto.anigrud.interfaces.ListadoInterface;
import proyecto.anigrud.presenters.FormPresenter;
import proyecto.anigrud.presenters.ListadoPresenter;

public class FormJavaActivity extends AppCompatActivity implements FormInterface.View, View.OnClickListener,View.OnFocusChangeListener{
    final private int CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 123;
    String TAG = "aniGRUD/Formulario";
    private FormInterface.Presenter presenter;
    Button btnGuardar;
    ImageButton btnFecha;
    ImageButton btnEliminar;
    ImageButton btnAgregar;
    EditText etFecha;
    EditText etLugar;
    EditText etNombre;
    EditText etEspecie;
    TextView errorFecha;
    TextView errorLugar;
    TextView errorNombre;
    TextView errorEspecie;
    Spinner  spinnerTipos;
    ImageView foto;
    Context myContext;


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
        btnEliminar = findViewById(R.id.btnEliminar);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnFecha = findViewById(R.id.btnFechaF);
        etFecha = findViewById(R.id.etFechaF);
        etNombre = findViewById(R.id.etNombeF);
        etLugar = findViewById(R.id.etLugarF);
        etEspecie =  findViewById(R.id.etEspecieF);
        foto = findViewById(R.id.fotoAnimal);

        errorEspecie = findViewById(R.id.errorCampoEspecie);
        errorFecha  =  findViewById(R.id.errorCampoFecha);
        errorNombre = findViewById(R.id.errorCampoNombre);
        errorLugar = findViewById(R.id.errorCampoLugar);

        etFecha.setOnFocusChangeListener(this);
        etEspecie.setOnFocusChangeListener(this);
        etNombre.setOnFocusChangeListener(this);
        etLugar.setOnFocusChangeListener(this);

        btnGuardar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnAgregar.setOnClickListener(this);

        btnFecha.setOnClickListener(this);

        foto.setOnClickListener(
                this
        );



        spinnerTipos = (Spinner) findViewById(R.id.spinner2);
        spinnerTipos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ListaSpinner.getDatos()));
        spinnerTipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                Toast.makeText(adapterView.getContext(),
                        (String) adapterView.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }

        });


        etFecha.addTextChangedListener(new TextWatcher() {

           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void afterTextChanged(Editable editable) {
               presenter.checkDate(etFecha.getText().toString(),errorFecha);
           }
       }


        );
      myContext = this;
    }

    @Override
    public void lanzarGuardado(){
        finish();
    }

    @Override
    public void errorFecha(boolean error, TextView tv) {
        if(!error){
            tv.setText(R.string.errorFecha);
        }else{
            tv.setText("");
        }
    }

    @Override
    public void errorCampo(boolean correcto, TextView tv) {

        if(tv == errorNombre){
            if(!correcto){
                tv.setText(R.string.errorCampo);
            }else{
                tv.setText("");
            }
        }

        if(tv == errorEspecie){
            if(!correcto){
                tv.setText(R.string.errorCampo);
            }else{
                tv.setText("");
            }
        }



        if(tv == errorLugar){
            if(!correcto){
                tv.setText(R.string.errorCampo);
            }else{
                tv.setText("");
            }
        }
    }

    @Override
    public void requestPermission() {
        ActivityCompat.requestPermissions(FormJavaActivity.this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                CODE_WRITE_EXTERNAL_STORAGE_PERMISSION);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case CODE_WRITE_EXTERNAL_STORAGE_PERMISSION:
                presenter.resultPermission(grantResults[0]);
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
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

        if(v == btnEliminar){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.borrarTipo);
            String tipos[] = new String[ListaSpinner.getDatos().size()];
            ListaSpinner.getDatos().toArray(tipos);
            builder.setItems(tipos, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                            okCancel(which);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }


        
       if(v == btnAgregar){
           AlertDialog.Builder builder = new AlertDialog.Builder(this);
           builder.setTitle(R.string.agregar);


           final EditText input = new EditText(this);

           input.setInputType(InputType.TYPE_CLASS_TEXT );
           builder.setView(input);


           builder.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   String m_Text = input.getText().toString();
                   ListaSpinner.agregarDato(m_Text);

               }
           });
           builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   dialog.cancel();
               }
           });

           builder.show();

           
       }
        
        if(v == foto){
            presenter.onclickImagen(myContext);
        }
        


    }


    @Override
    public void onFocusChange(View view, boolean b) {
        if(view == etFecha && !b) {
            presenter.checkDate(etFecha.getText().toString(),errorFecha);
        }

        if(view == etNombre && !b){
            presenter.checkField(etNombre ,errorNombre);
        }

        if(view == etEspecie && !b){
            presenter.checkField(etEspecie ,errorEspecie);
        }

        if(view == etLugar && !b){
            presenter.checkField(etLugar ,errorLugar);
        }


     }

        public void okCancel(final int indice){


            AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(this);
            //myAlertDialog.setTitle("--- Title ---");
            myAlertDialog.setMessage(R.string.borrarTipo);
            myAlertDialog.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {
                    ListaSpinner.borrarDato(indice);
                    finish();
                }});
            myAlertDialog.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {
                    // do something when the Cancel button is clicked
                }});
            myAlertDialog.show();
        }







}
