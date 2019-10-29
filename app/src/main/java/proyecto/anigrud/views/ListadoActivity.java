package proyecto.anigrud.views;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import proyecto.anigrud.R;
import proyecto.anigrud.interfaces.ListadoInterface;
import proyecto.anigrud.presenters.ListadoPresenter;

public class ListadoActivity extends AppCompatActivity implements ListadoInterface.View {

    String TAG = "aniCRUD/ListadoActividado";
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

    @Override
    public void lanzarFormulario() {
        Intent intent = new Intent(ListadoActivity.this,
                FormJavaActivity.class);
        startActivity(intent);
    }












}
