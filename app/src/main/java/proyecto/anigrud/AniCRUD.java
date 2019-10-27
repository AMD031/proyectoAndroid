package proyecto.anigrud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import proyecto.anigrud.views.ListadoActivity;

public class AniCRUD extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
