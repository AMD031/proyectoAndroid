package proyecto.anigrud.presenters;

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
     this.animal = new AnimalModelo();
 }

    @Override
    public void ejecutarBorrado(int position, ArrayList<Animal> items,AnimalAdapter animalAdapter) {
         Animal mRecentlyDeletedItem = items.get(position);
         int mRecentlyDeletedItemPosition = position;
         items.remove(position);
         animalAdapter.notifyItemRemoved(position);

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
    public void onClickRecyclerView(int id) {
        view.lanzarFormulario(id);
    }


    public void onClickAbout(){ view.lanzarSobre();}






    public ArrayList<Animal>getAllAnimal(){
        return  animal.getAllanimal();
    }

    @Override
    public void repintarRecycler(AnimalAdapter animalAdapter) {
        animalAdapter.notifyDataSetChanged();
    }

}
