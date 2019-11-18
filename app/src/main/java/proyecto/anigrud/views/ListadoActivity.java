package proyecto.anigrud.views;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import proyecto.anigrud.R;
import proyecto.anigrud.interfaces.ListadoInterface;
import proyecto.anigrud.presenters.ListadoPresenter;

public class ListadoActivity extends AppCompatActivity implements ListadoInterface.View {

    String TAG = "aniCRUD/Listado";
    private ListadoInterface.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        presenter = new ListadoPresenter(this);

        FloatingActionButton fab = findViewById(R.id.listadofab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Pulsando boton flotante");
                presenter.onClickAdd();

            }
        });
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


    @Override
    public void lanzarFormulario() {
        Intent intent = new Intent(ListadoActivity.this,
                FormJavaActivity.class);
        startActivity(intent);
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









}
