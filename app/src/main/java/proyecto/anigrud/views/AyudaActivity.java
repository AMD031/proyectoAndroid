package proyecto.anigrud.views;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import proyecto.anigrud.R;

public class AyudaActivity extends AppCompatActivity {

    private String ayuda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.ayuda ="";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.ayuda = getIntent().getStringExtra("ayuda");
        Log.i("buscar", ayuda);






    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }




}
