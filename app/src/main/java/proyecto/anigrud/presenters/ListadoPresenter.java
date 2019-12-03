package proyecto.anigrud.presenters;

import java.util.ArrayList;

import proyecto.anigrud.interfaces.ListadoInterface;
import proyecto.anigrud.models.Animal;
import proyecto.anigrud.models.AnimalModelo;

public class ListadoPresenter implements ListadoInterface.Presenter{

    private ListadoInterface.View view;

    private AnimalModelo animal;

 public ListadoPresenter(ListadoInterface.View view){
     this.view = view;
     this.animal = new AnimalModelo();
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

}
