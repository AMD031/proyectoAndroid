package proyecto.anigrud.presenters;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import proyecto.anigrud.Utilidades.Image;
import proyecto.anigrud.Utilidades.Validar;
import proyecto.anigrud.interfaces.FormInterface;
import proyecto.anigrud.models.Animal;
import proyecto.anigrud.models.AnimalModelo;

public class FormPresenter implements FormInterface.Presenter  {

    private FormInterface.View view;
    private AnimalModelo model;


    public FormPresenter(FormInterface.View view){
        this.view = view;
        model = AnimalModelo.getInstance();
    }

    @Override
    public void onClickSave(Animal animal,boolean valido){
        if( valido ){
           if( model.addNewAnimal(animal)){
               view.existoGuardado();
               view.finalizaViewAnimal();
           }

       }else{
         view.errorGuardado();
       }
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


        } else {
            Log.d("permiso","SI TENGO PERMISOS");
            view.abrirGaleria();
        }

    }

    @Override
    public void resultPermission(int result) {
        if (result == PackageManager.PERMISSION_GRANTED) {
            Log.d("aniGRUD","permiso aceptado");

            view.abrirGaleria( );
        } else {
            Log.d("aniGRUD","permiso rechazado");
            view.lanzarSnackbar();
        }

    }

    @Override
    public void mostarOkCancelT() {
        view.okCancelT();
    }

    @Override
    public void clicSiElimnar(Integer id) {
        if(model.eliminarAnimal(id)>=1){
            view.lanzarEliminado();
        }

    }

    @Override
    public void errorSegundaVerificacion(boolean correcto, TextView tv) {
        view.errorCampo(correcto,tv);
        view.errorFecha(correcto,tv);
    }

    @Override
    public void ocultarMostarbtnEliminar(boolean mostarbtnEliminar) {
         view.ocultarMostarbtnEliminar(mostarbtnEliminar);
    }

    @Override
    public void recuperarDatos(int id) {
       Animal animal = model.obtenerAnimal(id);
       view.recuperDatosAnimal(animal);
    }

    @Override
    public void updateAnimal(Animal animalDatos, boolean valido) {
        if( valido ){
           if(model.guardarCambios(animalDatos)>=1){
               view.existoGuardado();
               view.finalizaViewAnimal();
           }

        }else {
            view.errorGuardado();

        }
    }

    @Override
    public ArrayList<String> ObtenerTipos() {
        ArrayList <String> tipos = AnimalModelo.getInstance().getTipos();
        return tipos;
    }

    @Override
    public void borrarTipo(int indice) {
        model.getTipos().remove(indice);
    }

    @Override
    public void agregarTipo(String m_text) {
        model.getTipos().add(m_text);
    }

    @Override
    public void borrarArrayTipos() {
        model.borrarTipos();
    }

    @Override
    public void mostrasAyuda() {
        view.lanzarAyuda();
    }


    @Override
    public void checkDate(String fecha, TextView tv) {
        view.errorFecha(Validar.validarFecha(fecha),tv);
    }


}
