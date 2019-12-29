package proyecto.anigrud.views;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.FileNotFoundException;
import java.io.InputStream;

import proyecto.anigrud.R;
import proyecto.anigrud.Utilidades.Calendario;
import proyecto.anigrud.Utilidades.Image;
import proyecto.anigrud.Utilidades.ListaSpinner;
import proyecto.anigrud.interfaces.FormInterface;
import proyecto.anigrud.models.Animal;
import proyecto.anigrud.presenters.FormPresenter;

public class FormJavaActivity extends AppCompatActivity implements FormInterface.View, View.OnClickListener,View.OnFocusChangeListener
    , CompoundButton.OnCheckedChangeListener
{
    final private int CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 123;
    private static final int SELECT_FILE = 1;
    String TAG = "aniGRUD/Formulario";
    private FormInterface.Presenter presenter;
    private Button btnGuardar;
    private ImageButton btnFecha;
    private ImageButton btnEliminar;
    private ImageButton btnAgregar;
    private  EditText etFecha;
    private EditText etLugar;
    private EditText etNombre;
    private EditText etEspecie;
    private Switch tAdorable;
    private Integer valorSwitch;
    private String valorSpinner = "Mamífero";




    private TextView errorFecha;
    private TextView errorLugar;
    private TextView errorNombre;
    private TextView errorEspecie;
    private Spinner  spinnerTipos;
    private ImageView foto;
    private Context myContext;
    String idAnimal ="";
    private  Animal animalDatos;
    private Button btnEliminarT;

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
        tAdorable = findViewById(R.id.tAdorable);

        errorEspecie = findViewById(R.id.errorCampoEspecie);
        errorFecha  =  findViewById(R.id.errorCampoFecha);
        errorNombre = findViewById(R.id.errorCampoNombre);
        errorLugar = findViewById(R.id.errorCampoLugar);
        btnEliminarT = findViewById(R.id.btnEliminarT);

        etFecha.setOnFocusChangeListener(this);
        etEspecie.setOnFocusChangeListener(this);
        etNombre.setOnFocusChangeListener(this);
        etLugar.setOnFocusChangeListener(this);

        btnGuardar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnAgregar.setOnClickListener(this);

        btnFecha.setOnClickListener(this);

        foto.setOnClickListener(this);
        btnEliminarT.setOnClickListener(this);
        tAdorable.setOnCheckedChangeListener(this);
        valorSwitch =0;

        spinnerTipos = (Spinner) findViewById(R.id.sTipo);
        spinnerTipos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ListaSpinner.getDatos()));
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
        int id = getIntent().getIntExtra("idanimal",0);
        boolean mostarbtnEliminar = getIntent().getBooleanExtra("btnEliminar",true);


        this.ocultarMostarbtnEliminar(mostarbtnEliminar);



    }



    public void ocultarMostarbtnEliminar(boolean mostar){
        Log.d("btne",String.valueOf(mostar));
        if(mostar){
            btnEliminarT.setVisibility(View.VISIBLE);
        }else{
            btnEliminarT.setVisibility(View.INVISIBLE);
        }

    }


    @Override
    public void finalizaViewAnimal(){
        finish();
    }

    @Override
    public void errorFecha(boolean error, TextView tv) {
       if(tv== errorFecha){
           if(!error){
               tv.setText(R.string.errorFecha);
           }else{
               tv.setText("");
           }
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
    public void lanzarSnackbar() {
        Snackbar snackbar = Snackbar
                .make(foto, "No tienes permisos", Snackbar.LENGTH_LONG);
        snackbar.show();
    }


    public void abrirGaleria(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(intent, "Seleccione una imagen"),
                SELECT_FILE);
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
            boolean valido = false;
            animalDatos = new Animal();
            boolean nombre = animalDatos.setNombreAnimal(etNombre.getText().toString());
            boolean especie = animalDatos.setEspecie((etEspecie.getText().toString()));
            boolean lugarfoto = animalDatos.setLugarFoto(etLugar.getText().toString());
            boolean fechafoto =animalDatos.setFechaFoto(etFecha.getText().toString());
            boolean adorable =  animalDatos.setAdorable(valorSwitch);
            boolean tipo =  animalDatos.setTipo(valorSpinner);
            if(nombre && especie && lugarfoto && fechafoto && adorable && tipo){
                animalDatos.setImagen(Image.base64(foto));
                valido = true;
            }

            if(!nombre){
                presenter.errorSegundaVerificacion(nombre,errorNombre);
            }
            if(!especie){
                presenter.errorSegundaVerificacion(especie,errorEspecie);
            }
            if(!lugarfoto){
                presenter.errorSegundaVerificacion(lugarfoto,errorLugar);
            }
            if(!fechafoto){
                presenter.errorSegundaVerificacion(fechafoto,errorFecha);
            }



           presenter.onClickSave(animalDatos,valido);



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

        if(v == btnEliminarT){
            presenter.mostarOkCancelT();

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

        public void okCancelT(){

            AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(this);
            //myAlertDialog.setTitle("--- Title ---");
            myAlertDialog.setMessage(R.string.borrarRegistro);
            myAlertDialog.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {
                    presenter.clicSiElimnar();
                }});
            myAlertDialog.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {
                    // do something when the Cancel button is clicked
                }});
            myAlertDialog.show();


        }

    @Override
    public void lanzarEliminado() {

        finish();
    }

    @Override
    public void errorGuardado() {
        Toast.makeText(myContext, R.string.errorGuardado, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void existoGuardado() {
        Toast.makeText(myContext, R.string.existoGuardado, Toast.LENGTH_SHORT).show();
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



    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        Uri selectedImageUri = null;
        Uri selectedImage;

        String filePath = null;
        switch (requestCode) {
            case SELECT_FILE:
                if (resultCode == Activity.RESULT_OK) {
                    selectedImage = imageReturnedIntent.getData();
                    String selectedPath=selectedImage.getPath();
                    if (requestCode == SELECT_FILE) {

                        if (selectedPath != null) {
                            InputStream imageStream = null;
                            try {
                                imageStream = getContentResolver().openInputStream(
                                        selectedImage);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            // Transformamos la URI de la imagen a inputStream y este a un Bitmap
                            Bitmap bmp = BitmapFactory.decodeStream(imageStream);


                            //compresion
                            Bitmap imageScaled = Bitmap.createScaledBitmap(bmp, 100, 100, false);

                           // ByteArrayOutputStream out = new ByteArrayOutputStream(); bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
                           // Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray())); Log.e("Original dimensions", bmp.getWidth()+" "+bmp.getHeight());
                           // Log.e("Compressed dimensions", decoded.getWidth()+" "+decoded.getHeight());


                            // Ponemos nuestro bitmap en un ImageView que tengamos en la vista
                            ImageView mImg = (ImageView) findViewById(R.id.fotoAnimal);
                            mImg.setImageBitmap(imageScaled);

                        }
                    }
                }
                break;
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b) {
            valorSwitch =1;
        } else {
            valorSwitch =0;
        }
    }
}
