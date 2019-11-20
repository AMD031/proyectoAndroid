package proyecto.anigrud.views;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import proyecto.anigrud.R;
import proyecto.anigrud.Utilidades.Calendario;
import proyecto.anigrud.interfaces.BuscarInterface;
import proyecto.anigrud.presenters.BuscarPresenter;

public class BuscarActivity extends AppCompatActivity implements View.OnClickListener, BuscarInterface.View {
    private ImageButton btnFecha;
    private EditText etFecha;
    private Button btnGuardar;
    private BuscarInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        presenter = new BuscarPresenter(this);
       btnFecha = findViewById(R.id.btnFecha);
       etFecha =  findViewById(R.id.etFecha);
       btnGuardar = findViewById(R.id.btnGuardar);
       etFecha.setEnabled(false);
       btnFecha.setOnClickListener(this);
       btnGuardar.setOnClickListener(this);

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
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }



}
