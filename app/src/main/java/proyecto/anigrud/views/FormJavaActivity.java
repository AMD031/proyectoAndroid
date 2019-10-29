package proyecto.anigrud.views;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import proyecto.anigrud.R;

public class FormJavaActivity extends AppCompatActivity {
    String TAG = "aniGRUD/Formulario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_java);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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



}
