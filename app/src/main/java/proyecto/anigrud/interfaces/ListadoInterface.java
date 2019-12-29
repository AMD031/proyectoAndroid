package proyecto.anigrud.interfaces;

import java.util.ArrayList;

import proyecto.anigrud.models.Animal;
import proyecto.anigrud.views.AnimalAdapter;

public interface ListadoInterface {
    public interface View{

      void lanzarFormulario(int id,boolean mostraElimanar);
      void lanzarSobre();
      void lanzarBuscar();
      void lanzarDialog(int position, ArrayList<Animal> items, AnimalAdapter animalAdapter);
      void actualizaContador();


    }

    public interface Presenter
    {
        void ejecutarBorrado(int postion,ArrayList<Animal>items, AnimalAdapter animalAdapter);
        void swipeBorrado(int position, ArrayList<Animal> items, AnimalAdapter animalAdapter);
        void onClickAbout();
        void onClickAdd();
        void onClicckSearch();
        void onClickRecyclerView(int id,boolean mostraElimanar);
        ArrayList<Animal> getAllAnimal();
        void repintarRecycler(AnimalAdapter animalAdapter);
        void Actulizarlista(ArrayList<Animal> items, AnimalAdapter adaptador);
    }

}
