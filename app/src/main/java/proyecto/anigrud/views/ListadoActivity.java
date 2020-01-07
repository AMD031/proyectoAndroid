package proyecto.anigrud.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import proyecto.anigrud.R;
import proyecto.anigrud.interfaces.ListadoInterface;
import proyecto.anigrud.models.Animal;
import proyecto.anigrud.models.AnimalModelo;
import proyecto.anigrud.presenters.ListadoPresenter;

public class ListadoActivity extends AppCompatActivity implements ListadoInterface.View {
    private ArrayList<Animal> items;
    String TAG = "aniCRUD/Listado";
    private static ListadoInterface.Presenter presenter;
    private RecyclerView listadoRecyclerView;
    private AnimalAdapter adaptador;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private static Context lcontext;
    private TextView contadorTextView;

    MyApplication my = new MyApplication();




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        contadorTextView = findViewById(R.id.contadorTextView);



        recyclerView = (RecyclerView) findViewById(R.id.listadoRecyclesView);

        lcontext = this;

        presenter = new ListadoPresenter(this);

        FloatingActionButton fab = findViewById(R.id.listadofab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Pulsando boton flotante");
                presenter.onClickRecyclerView(-1,false);

            }
        });


        // Inicializa el RecyclerView
        /*final RecyclerView*/ listadoRecyclerView= (RecyclerView) findViewById(R.id.listadoRecyclesView);

        // Crea el Adaptador con los datos de la lista anterior
         items = presenter.getAllAnimal();
         adaptador = new AnimalAdapter(items);

        // Asocia el elemento de la lista con una acción al ser pulsado
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al pulsar el elemento

                int position = listadoRecyclerView.getChildAdapterPosition(v);

            }
        });

        // Asocia el Adaptador al RecyclerView
        listadoRecyclerView.setAdapter(adaptador);

        // Muestra el RecyclerView en vertical
        listadoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Accion al pulsar el elemento
                int position = listadoRecyclerView.getChildAdapterPosition(v);
                Log.d("Error1", "Clic : " + items.get(position).getId());

                if(items.get(position)!=null){
                    presenter.onClickRecyclerView(items.get(position).getId(),true);
                }
            }
        });

        actualizaContador();
        setUpRecyclerView(adaptador);

    }

    @Override
    protected void onResume() {
        super.onResume();

      presenter.Actulizarlista(items,adaptador);
        Bundle datos = this.getIntent().getExtras();
        if(datos!=null) {

                 String nombreAnimal = datos.getString("nombreB", "");
                 String tipo = datos.getString("tipoB", "");
                 String fecha = datos.getString("fechaB", "");


                ArrayList<String> argumentos = new ArrayList<>();
                argumentos.add(nombreAnimal);
                argumentos.add(tipo);
                argumentos.add(fecha);

                presenter.ActulizarlistaCriterios(items, adaptador, argumentos);
                datos.putBoolean("eBuscqueda",false);



        }
        datos =null;
    }

    public void actualizaContador(){
        contadorTextView.setText( adaptador.getItemCount()+" "+getResources().getString(R.string.resultadosEncontrados));
    }

    private void setUpRecyclerView(AnimalAdapter mAdapter) {
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new SwipeToDeleteCallback(mAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
  @Override
    public void finalizaLista(){
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_search:

                presenter.onClicckSearch();
                return true;
            case R.id.ordenar:
               //showHelp();
                return true;
            case R.id.Configuracion:

                return  true;

            case R.id.sobreAplicacion:

                presenter.onClickAbout();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        // add this
        menu.add(Menu.NONE, 0, Menu.NONE, "custom")
                .setActionView(R.layout.activity_listado)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }


    public Animal item( Animal  a){
        return a;
    }


   static ListadoInterface.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void lanzarFormulario(int id,boolean mostraElimanar) {
        if(id == -1) {
            // esto es launchForm() basicamente
            Intent intent = new Intent(ListadoActivity.this, FormJavaActivity.class);
            intent.putExtra("btnEliminar",mostraElimanar);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(ListadoActivity.this, FormJavaActivity.class);
            //bundle
            //TODO bundle para encapsular el id y pasarselo al activity
            //TODO es un paquete en el que metemos variables cadena->valor
           // cadena->valor
            //TODO empaquetamos el id y luego en el formulario activity en el oncreate
           // recuperamos el id. Al final del oncreate mejor

             Log.i("intent",String.valueOf(id));
             intent.putExtra("idanimal",id);
             intent.putExtra("btnEliminar",mostraElimanar);

           startActivity(intent);
           actualizaContador();
        }

    }


    @Override
    public void lanzarSobre() {
        Intent intent = new Intent(ListadoActivity.this,
                SobreActivity.class);
        startActivity(intent);
    }

    @Override
    public void lanzarBuscar() {
        Intent intent = new Intent(ListadoActivity.this,
                BuscarActivity.class);
        startActivity(intent);

    }

    @Override
    public void lanzarDialog(final int position, final ArrayList<Animal> items, final AnimalAdapter animalAdapter) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(lcontext);
        dialog.setMessage(R.string.dialogBorrar);
        dialog.setTitle(R.string.borrar);
        dialog.setPositiveButton(R.string.si,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        presenter.ejecutarBorrado(position,items,animalAdapter);
                        presenter.repintarRecycler(animalAdapter);
                        Toast.makeText(getApplicationContext(),
                                R.string.ElementoBorrado, Toast.LENGTH_SHORT).show();
                    }
                });
        dialog.setNegativeButton(R.string.cancelar,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               presenter.repintarRecycler(animalAdapter);
                Toast.makeText(getApplicationContext(),
                        R.string.ElementoNoBorrado, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"entrado en el onStart");
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
}
