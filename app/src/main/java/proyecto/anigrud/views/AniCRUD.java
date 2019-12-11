package proyecto.anigrud.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import proyecto.anigrud.R;
import proyecto.anigrud.Utilidades.ListaSpinner;

public class AniCRUD extends Activity {
    String TAG = "aniGRUD/AniCRUD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.i(TAG,"entrado en el oncreate");
        setContentView(R.layout.activity_ani_crud);


        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(AniCRUD.this, ListadoActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },5000

        );

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
