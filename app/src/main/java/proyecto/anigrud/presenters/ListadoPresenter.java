package proyecto.anigrud.presenters;

import android.util.Log;

import java.util.ArrayList;

import proyecto.anigrud.interfaces.ListadoInterface;
import proyecto.anigrud.models.Animal;
import proyecto.anigrud.models.AnimalModelo;
import proyecto.anigrud.views.AnimalAdapter;

public class ListadoPresenter implements ListadoInterface.Presenter{

    private ListadoInterface.View view;

    private AnimalModelo modelo;

 public ListadoPresenter(ListadoInterface.View view){
     this.view = view;
     this.modelo =  AnimalModelo.getInstance();
 }

    @Override
    public void ejecutarBorrado(int position, ArrayList<Animal> items,AnimalAdapter animalAdapter) {
         Animal mRecentlyDeletedItem = items.get(position);
         //int mRecentlyDeletedItemPosition = position;
         items.remove(position);
         modelo.eliminarAnimal(mRecentlyDeletedItem.getId());
         Log.i("tam",mRecentlyDeletedItem.toString());
         animalAdapter.notifyItemRemoved(position);
         view.actualizaContador();
    }

    public void swipeBorrado(int position, ArrayList<Animal> items, AnimalAdapter animalAdapter) {
        view.lanzarDialog(position,items,animalAdapter);
    }

    public void onClickAdd(){

 }


    public void onClicckSearch() {
        view.lanzarBuscar();
    }

    @Override
    public void onClickRecyclerView(int id, boolean mostraEliminar) {
        view.lanzarFormulario(id, mostraEliminar);
    }

    public void onClickAbout(){ view.lanzarSobre();}

    public ArrayList<Animal>getAllAnimal(){
        return  modelo.getAllanimal();
    }

    @Override
    public void repintarRecycler(AnimalAdapter animalAdapter) {
        animalAdapter.notifyDataSetChanged();
    }

    @Override
    public void Actulizarlista(ArrayList<Animal> items, AnimalAdapter adaptador,
                               String nombreAnimal, String tipo,String fecha ) {

        items.clear();
        items.addAll(modelo.obtenerAnimalporCriterio(nombreAnimal,tipo,fecha));
        adaptador.notifyDataSetChanged();
        view.actualizaContador();

    }

    @Override
    public void mostrasAyuda() {
        view.lanzarAyuda();
    }

    /*@Override
    public void ActulizarlistaCriterios(ArrayList<Animal> items, AnimalAdapter adaptador, ArrayList<String> argumentos) {
        items.clear();
        Log.d("actualizar",argumentos.get(0)+" "+argumentos.get(1)+" "+argumentos.get(2));

        items.addAll(modelo.obtenerAnimalporCriterio(argumentos.get(0),argumentos.get(1),argumentos.get(2)));
        adaptador.notifyDataSetChanged();
        view.actualizaContador();
    }*/

}
