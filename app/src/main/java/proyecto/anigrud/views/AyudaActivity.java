package proyecto.anigrud.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import proyecto.anigrud.R;
import proyecto.anigrud.interfaces.AyudaInterface;
import proyecto.anigrud.presenters.AyudaPresenter;

public class AyudaActivity extends AppCompatActivity implements AyudaInterface.View {
    private WebView mWebview ;
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


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            // Si hay conexión a Internet en este momento

       mWebview  = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });


       switch (this.ayuda){
            case "listado":
                mWebview .loadUrl("https://amd031.github.io/ayudaAniCrud/ayudas/ayudalistado.html");
                setContentView(mWebview );
                break;
            case "buscar":
                mWebview .loadUrl("https://amd031.github.io/ayudaAniCrud/ayudas/ayudabuscar.html");
                setContentView(mWebview );
                break;
            case "formulario":
                mWebview .loadUrl("https://amd031.github.io/ayudaAniCrud/ayudas/ayudaformulario.html");
                setContentView(mWebview );
                break;
        }


        } else {
            AyudaPresenter.ErrorConexion();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


    @Override
    public void mostrarErrorConexion() {
        Toast toast1 =
                Toast.makeText(getApplicationContext(),
                        "Fallo de conexión", Toast.LENGTH_SHORT);
        toast1.show();
    }
}
