package proyecto.anigrud.views;

import android.app.DatePickerDialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;


import java.util.Calendar;

import proyecto.anigrud.R;
import proyecto.anigrud.interfaces.BuscarInterface;
import proyecto.anigrud.presenters.BuscarPresenter;

public class BuscarActivity extends AppCompatActivity implements View.OnClickListener, BuscarInterface.View {
    private ImageButton btnFecha;
    private EditText etFecha;
    private int dia, mes, agno;
    private BuscarInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new BuscarPresenter(this);

       btnFecha = findViewById(R.id.btnFecha);
       etFecha =  findViewById(R.id.etFecha);
       etFecha.setEnabled(false);
       btnFecha.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        if(v==btnFecha){
            final Calendar c= Calendar.getInstance();
            this.dia = c.get(Calendar.DAY_OF_MONTH);
            this.mes = c.get(Calendar.MONTH);
            this.agno = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etFecha.setText(dayOfMonth+"/"+month+"/"+year);
                }
            },agno,mes,dia);
            datePickerDialog.show();
        }
    }

    @Override
    public void lanzarGuardado( ) {
        finish();
    }
}
