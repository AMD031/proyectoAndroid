package proyecto.anigrud.presenters;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import proyecto.anigrud.Utilidades.Validar;
import proyecto.anigrud.interfaces.FormInterface;

public class FormPresenter implements FormInterface.Presenter {

    private FormInterface.View view;

    public FormPresenter(FormInterface.View view){
        this.view = view;
    }

    @Override
    public void onClickSave(){
        view.lanzarGuardado();
    }

    @Override
    public void checkField(TextView campoFormulario,TextView campoError) {
        view.errorCampo(Validar.compruebaCampo(campoFormulario),campoError);
    }

    @Override
    public void onclickImagen(Context myContext) {
        int ReadPermission = ContextCompat.checkSelfPermission(myContext, Manifest.permission.READ_EXTERNAL_STORAGE);


        if (ReadPermission != PackageManager.PERMISSION_GRANTED) {
            Log.d("permiso","NO TENGO PERMISOS");
            view.requestPermission();
            view.lanzarSnackbar();

        } else {
            Log.d("permiso","SI TENGO PERMISOS");
        }

    }

    @Override
    public void resultPermission(int result) {

        if (result == PackageManager.PERMISSION_GRANTED) {
            Log.d("aniGRUD","permiso aceptado");
        } else {
            Log.d("aniGRUD","permiso rechazado");
        }

    }


    @Override
    public void checkDate(String fecha, TextView tv) {
        view.errorFecha(Validar.validarFecha(fecha),tv);
    }


}
