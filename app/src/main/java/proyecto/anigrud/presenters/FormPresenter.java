package proyecto.anigrud.presenters;

import android.widget.TextView;

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
    public void checkDate(String fecha, TextView tv) {
        view.errorFecha(Validar.validarFecha(fecha),tv);
    }


}
