package proyecto.anigrud.presenters;

import android.util.Log;

import java.util.ArrayList;

import proyecto.anigrud.interfaces.ListadoInterface;
import proyecto.anigrud.models.Animal;
import proyecto.anigrud.models.AnimalModelo;
import proyecto.anigrud.views.AnimalAdapter;

public class ListadoPresenter implements ListadoInterface.Presenter{

    private ListadoInterface.View view;

    private AnimalModelo animal;

 public ListadoPresenter(ListadoInterface.View view){
     this.view = view;
     this.animal =  AnimalModelo.getInstance();
 }

    @Override
    public void ejecutarBorrado(int position, ArrayList<Animal> items,AnimalAdapter animalAdapter) {
         Animal mRecentlyDeletedItem = items.get(position);
         //int mRecentlyDeletedItemPosition = position;
         items.remove(position);
         animal.eliminarAnimal(mRecentlyDeletedItem.getId());
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
        return  animal.getAllanimal();
    }

    @Override
    public void repintarRecycler(AnimalAdapter animalAdapter) {
        animalAdapter.notifyDataSetChanged();
    }

    @Override
    public void Actulizarlista(ArrayList<Animal> items, AnimalAdapter adaptador) {
        items.clear();
        items.addAll(getAllAnimal());
        adaptador.notifyDataSetChanged();
        view.actualizaContador();
    }

}
